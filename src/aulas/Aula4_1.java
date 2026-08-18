import javax.swing.*; // impor componentes gráficos básicos;
import java.awt.*;  // importa classes para controle de layout
import java.awt.event.*; // importa classes para tratamento de eventos



public class Aula4_1  extends JFrame{

    private JTextField campoNome;  // campo de texto
    private JButton botaoSaudar; // Botão aciona a saudação
    private JLabel labelMensagem; // mensagem exibida

    public Aula4_1() {
    setTitle("Progama de saudação");

    setSize(350,150);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLocationRelativeTo(null);

    JPanel painel = new JPanel();
    painel.setLayout(new FlowLayout());

    campoNome = new JTextField(20);

    botaoSaudar = new JButton ("Saudar");

    labelMensagem = new JLabel("Digite seu nome e clique em Saudar");

    painel.add( new JLabel("Nome"));
    painel.add(campoNome);
    painel.add(botaoSaudar);
    painel.add(labelMensagem);

  botaoSaudar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = campoNome.getText().trim();

        if (nome.isEmpty()) {
            labelMensagem.setText("Por favor, digite seu nome!");
        } else {
            labelMensagem.setText("Olá, " + nome + " Seja bem-vindo(a)");
        }
    }
});
    add(painel);
}

public static void main(String [] args){
    SwingUtilities.invokeLater(() ->{
        Aula4_1 janela = new Aula4_1();
        janela.setVisible(true);
    });
}
    
}
