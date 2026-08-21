import java.awt.*;
import javax.swing.*;

public class Aula4_2 extends JFrame{

    private JLabel labelMensagem;

    JButton btn1;
    JButton btn2;
    JButton btn3;

    public Aula4_2(){

        setTitle("Cadstro de Aluno");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        btn1 = new JButton("Botão 1");
        btn2 = new JButton("Botão 2");
        btn3 = new JButton("Botão 3");

        labelMensagem = new JLabel("Clique em um botão");
        labelMensagem.setText("flowlayout");

        painel.add(btn1);
        painel.add(btn2);
        painel.add(btn3);
        painel.add(labelMensagem);

        btn1.addActionListener(e-> {
            labelMensagem.setText("Botão 1");
        });

        btn2.addActionListener(e-> {
            labelMensagem.setText("Botão 2");
        });

        btn3.addActionListener(e-> {
            labelMensagem.setText("Botão 3");
        });

        add(painel);

}
public static void main (String [] args){
    new Aula4_2().setVisible(true);
}

}