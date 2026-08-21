import java.awt.*;
import javax.swing.*;

public class Aula4_3 extends JFrame{

    private JLabel labelMensagem;

    JButton btn1;
    JButton btn2;
    JButton btn3;

    public Aula4_3(){

        setTitle("Cadstro de Aluno");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        btn1 = new JButton("Topo");
        btn2 = new JButton("Centro");
        btn3 = new JButton("Esquerda");

        labelMensagem = new JLabel("Clique em um botão");
        labelMensagem.setText("flowlayout");

        painel.add(btn1, BorderLayout.NORTH);
        painel.add(btn2, BorderLayout.CENTER);
        painel.add(btn3, BorderLayout.WEST);
        painel.add(labelMensagem);

        btn1.addActionListener(e-> {
            labelMensagem.setText("Clicou no topo");
        });

        btn2.addActionListener(e-> {
            labelMensagem.setText("Clicou no Centro");
        });

        btn3.addActionListener(e-> {
            labelMensagem.setText("Clicou em Baixo");
        });

        add(painel);

}
public static void main (String [] args){
    new Aula4_3().setVisible(true);
}

}