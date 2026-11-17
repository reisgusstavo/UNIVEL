package view;

import dao.UsuarioDAO;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.swing.*;
import model.Usuario;

public class TelaCadastroUsuario extends JDialog {

    private JTextField txtLogin, txtEmail;
    private JPasswordField txtSenha;
    private JComboBox<String> cbTipo, cbAtivo;
    private JButton btnSalvar;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario;
    private CRUDUsuario parent;

    public TelaCadastroUsuario(CRUDUsuario parent, Usuario usuario) {
        super(parent, true);

        this.parent = parent;
        this.usuario = usuario;

        setTitle(usuario == null ? "Novo Usuário" : "Editar Usuário");

        setSize(380, usuario == null ? 340 : 290);

        setLayout(new GridLayout(usuario == null ? 6 : 5, 2, 10, 10));

        setLocationRelativeTo(parent);

        // Login
        add(new JLabel("Login:"));
        txtLogin = new JTextField();
        add(txtLogin);

        // Senha (somente para novo usuário)
        if (usuario == null) {
            add(new JLabel("Senha:"));
            txtSenha = new JPasswordField();
            add(txtSenha);
        }

        // Email
        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        // Tipo
        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[] { "Usuário", "Administrador" });
        add(cbTipo);

        // Ativo
        add(new JLabel("Situação:"));
        cbAtivo = new JComboBox<>(new String[] { "Ativo", "Inativo" });
        add(cbAtivo);

        // Botão salvar
        add(new JLabel());

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        // Preencher dados para edição
        if (usuario != null) {
            txtLogin.setText(usuario.getLogin());
            txtEmail.setText(usuario.getEmail());

            cbTipo.setSelectedItem("admin".equals(usuario.getTipo()) ? "Administrador" : "Usuário");
            cbAtivo.setSelectedItem("S".equals(usuario.getAtivo()) ? "Ativo" : "Inativo");
        }

        btnSalvar.addActionListener(e -> salvarUsuario());
    }

    private void salvarUsuario() {

        try {

            String login = txtLogin.getText().trim();
            String email = txtEmail.getText().trim();

            if (login.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O login é obrigatório!");
                return;
            }

            // Valores iguais aos gravados no banco (dbUnivel)
            String tipo = "Administrador".equals(cbTipo.getSelectedItem()) ? "admin" : "comum";
            String ativo = "Ativo".equals(cbAtivo.getSelectedItem()) ? "S" : "N";

            if (usuario == null) {

                String senha = new String(txtSenha.getPassword()).trim();

                if (senha.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Senha obrigatória!");
                    return;
                }

                Usuario u = new Usuario();

                u.setLogin(login);
                u.setSenha(gerarHashSHA256(senha));
                u.setEmail(email);
                u.setTipo(tipo);
                u.setAtivo(ativo);

                usuarioDAO.inserir(u);

            } else {

                usuario.setLogin(login);
                usuario.setEmail(email);
                usuario.setTipo(tipo);
                usuario.setAtivo(ativo);

                usuarioDAO.gravar(usuario);
            }

            parent.carregarUsuarios();

            dispose();

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(this, "Erro ao salvar usuário: " + ex.getMessage());
        }
    }

    // Gerar hash SHA-256 da senha
    private String gerarHashSHA256(String senha) throws Exception {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] hash = digest.digest(senha.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {

            String hex = Integer.toHexString(0xff & b);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }
}
