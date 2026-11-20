package util.view;

import controller UsuarioController;
import model Usuario;
imort util Mensagem;
import javax.swing.*;
import java.awt.*;


public class TelaLogin extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar;

    private final UsuarioController controller = new UsuarioController();

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Usuário:"));
        txtLogin = new JTextField();
        add(txtLogin);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");
      

        btnEntrar.addActionListener(e -> {
            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());
            if (controller.login(login, senha)) {
                Mensagem.info("Login bem-sucedido!");
                Usuario usuario = new Usuario();
                Usuario.setLogin(login);

                dispose();
                new TelaMenu(usuario).setVisible(true);

            } else {
                Mensagem.erro("Login ou senha incorretos.");
            }
        });
    }
}