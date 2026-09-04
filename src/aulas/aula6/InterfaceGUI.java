package aulas.Aula6;

import java.awt.*;
import javax.swing.*;

public class InterfaceGUI {

    public JTextField txtId;
    public JTextField txtNome;
    public JTextField txtIdade;

    public JComboBox<String> comboTipo;

    public JTextArea areaTexto;

    public JButton btnCadastrar;
    public JButton btnListar;
    public JButton btnRemover;

    public JFrame janela;

    public InterfaceGUI() {

        janela = new JFrame();

        janela.setTitle("Sistema POO - Java GUI");
        janela.setSize(700, 450);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        janela.setLayout(new BorderLayout(10, 10));

        criarInterface();
    }

    private void criarInterface() {

        JLabel titulo = new JLabel(
                "Sistema de Cadastro - POO",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        janela.add(titulo, BorderLayout.NORTH);

        JPanel painelFormulario = new JPanel();

        painelFormulario.setLayout(
                new GridLayout(4, 2, 10, 10)
        );

        painelFormulario.setBorder(
                BorderFactory.createTitledBorder("Cadastro")
        );

        painelFormulario.add(new JLabel("ID:"));

        txtId = new JTextField();
        painelFormulario.add(txtId);

        painelFormulario.add(new JLabel("Nome:"));

        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("Idade:"));

        txtIdade = new JTextField();
        painelFormulario.add(txtIdade);

        painelFormulario.add(new JLabel("Tipo:"));

        comboTipo = new JComboBox<>();

        comboTipo.addItem("Aluno");
        comboTipo.addItem("Professor");

        painelFormulario.add(comboTipo);

        janela.add(painelFormulario, BorderLayout.WEST);

        areaTexto = new JTextArea();

        areaTexto.setEditable(false);

        areaTexto.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        JScrollPane scroll = new JScrollPane(areaTexto);

        janela.add(scroll, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();

        btnCadastrar = new JButton("Cadastrar");
        btnListar = new JButton("Listar");
        btnRemover = new JButton("Remover");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnRemover);

        janela.add(painelBotoes, BorderLayout.SOUTH);
    }
}