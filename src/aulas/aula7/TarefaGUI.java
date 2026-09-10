
package Aula7;
import javax.swing.*;

public class TarefaGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cadastro");

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Digite seu nome:");  // Mostrar o texto
        lblNome.setBounds(30, 30, 120, 25);
        frame.add(lblNome);

        JTextField txtNome = new JTextField();                 // Digitar o Texto
        txtNome.setBounds(150, 30, 180, 25);
        frame.add(txtNome);

        JButton btnEnviar = new JButton("Enviar");        // Botão pra enviar
        btnEnviar.setBounds(150, 80, 100, 30);
        frame.add(btnEnviar);

        btnEnviar.addActionListener(e -> {

            String nome = txtNome.getText();

            JOptionPane.showMessageDialog(frame,
                    "Olá, " + nome + "!");

        });

        frame.setVisible(true);
    }
}
