package view;

import dao.ProdutoDAO;
import java.awt.*;
import javax.swing.*;
import model.Produto;

public class TelaCadastroProduto extends JDialog {

    private JTextField txtNome, txtPreco, txtMarca;
    private JButton btnSalvar;

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private Produto produto;
    private CRUDProduto parent;

    public TelaCadastroProduto(CRUDProduto parent, Produto produto) {
        super(parent, true);

        this.parent = parent;
        this.produto = produto;

        setTitle(produto == null ? "Novo Produto" : "Editar Produto");

        setSize(350, 250);

        setLayout(new GridLayout(4, 2, 10, 10));

        setLocationRelativeTo(parent);

        // Nome
        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        // Preço
        add(new JLabel("Preço (R$):"));
        txtPreco = new JTextField();
        add(txtPreco);

        // Marca
        add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        add(txtMarca);

        // Botao salvar
        add(new JLabel());

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        // Preencher dados para edicao
        if (produto != null) {
            txtNome.setText(produto.getNome());
            txtPreco.setText(String.format("%.2f", produto.getPreco()).replace(".", ","));
            txtMarca.setText(produto.getMarca());
        }

        btnSalvar.addActionListener(e -> salvarProduto());
    }

    private void salvarProduto() {

        try {

            String nome = txtNome.getText().trim();
            String precoTexto = txtPreco.getText().trim();
            String marca = txtMarca.getText().trim();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome é obrigatório!");
                return;
            }

            if (precoTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O preço é obrigatório!");
                return;
            }

            double preco;
            try {
                // aceita vírgula ou ponto como separador decimal
                preco = Double.parseDouble(precoTexto.replace(",", "."));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preço inválido! Use o formato 99,90");
                return;
            }

            if (preco <= 0) {
                JOptionPane.showMessageDialog(this, "O preço deve ser maior que zero!");
                return;
            }

            if (produto == null) {

                Produto p = new Produto();

                p.setNome(nome);
                p.setPreco(preco);
                p.setMarca(marca);

                produtoDAO.inserir(p);

            } else {

                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setMarca(marca);

                produtoDAO.gravar(produto);
            }

            parent.carregarProdutos();

            dispose();

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                this,
                "Erro ao salvar produto: " + ex.getMessage()
            );
        }
    }
}
