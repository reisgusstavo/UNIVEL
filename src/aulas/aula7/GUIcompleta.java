
package Aula7;

import javax.swing.*;
import java.awt.*;

public class GUIcompleta {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exemplo de GUI");
        frame.setSize(480, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Digite seu nome");
        lblNome.setBounds(20, 20, 150, 25);
        frame.add(lblNome);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 20, 200, 25);
        frame.add(txtNome);

        JRadioButton rbtnMasculino = new JRadioButton("Masculino");
        rbtnMasculino.setBounds(20, 60, 100, 25);
        JRadioButton rbtnFeminino = new JRadioButton("Feminino");
        rbtnFeminino.setBounds(130, 60, 100, 25);
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbtnMasculino);
        grupoSexo.add(rbtnFeminino);
        frame.add(rbtnMasculino);
        frame.add(rbtnFeminino);

        JCheckBox chkProgramador = new JCheckBox("Programador");
        chkProgramador.setBounds(20, 100, 120, 25);
        JCheckBox chkProfessor = new JCheckBox("Professor");
        chkProfessor.setBounds(200, 100, 120, 25);
        frame.add(chkProgramador);
        frame.add(chkProfessor);

        String[] cores = {"Vermelho", "Verde", "Azul"};
        JComboBox<String> cbxCores = new JComboBox<>(cores);
        cbxCores.setBounds(20, 140, 100, 25);
        frame.add(cbxCores);
        String[] frutas = {"Maça", "Banana", "Laranja"};
        JList<String> lstFrutas = new JList<>(frutas);
        lstFrutas.setBounds(200, 140, 100, 60);
        frame.add(lstFrutas);

        JSlider slider = new JSlider(0, 100, 50);
        slider.setBounds(20, 210, 200, 50);
        frame.add(slider);
        ImageIcon icon = new ImageIcon("resources/imagem/doce.jpg");
        JLabel lblIcone = new JLabel(icon);
        lblIcone.setBounds(250, 180, 200, 150);
        frame.add(lblIcone);

        JTextArea jObservacao = new JTextArea();
        jObservacao.setEditable(true);
        jObservacao.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(jObservacao);
        scrollPane.setBounds(20, 270, 400, 100);
        frame.add(scrollPane);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(20, 390, 100, 30);
        frame.add(btnEnviar);

        btnEnviar.addActionListener(e -> {
            String nome = txtNome.getText();
            String sexo = rbtnMasculino.isSelected() ? "Masculino" :
                          rbtnFeminino.isSelected() ? "Feminino" :
                          "Não selecionado";

            String programador = chkProgramador.isSelected() ? "Sim" : "Não";
            String professor = chkProfessor.isSelected() ? "Sim" : "Não";

            JOptionPane.showMessageDialog(frame,
                    "Nome: " + nome +
                    "\nSexo: " + sexo +
                    "\nProgramador: " + programador +
                    "\nProfessor: " + professor);

        });

        frame.setVisible(true);
    }

}
