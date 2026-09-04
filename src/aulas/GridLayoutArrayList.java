package aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GridLayoutArrayList extends JFrame{

    private ArrayList<String> tarefas;

    private JTextField campoTarefa;
    private JTextArea areaTexto;
    private JButton botaoAdicionar;
    private JButton botaoLimpar;

    public GridLayoutArrayList() {
        tarefas = new ArrayList<>();

        setTitle("Gerenciador de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4,1,10,10));

        JPanel painelEntrada = new JPanel(new GridLayout(1, 2, 5, 5));
        JLabel labelTarefa = new JLabel("Nova Tarefa: ", SwingConstants.CENTER);
        campoTarefa = new JTextField();
        painelEntrada.add(labelTarefa);
        painelEntrada.add(campoTarefa);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 5, 5));
        botaoAdicionar = new JButton("Adicionar");
        botaoLimpar = new JButton("Limpar tudo");
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoLimpar);

        areaTexto = new JTextArea();

        areaTexto.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaTexto);

        add(painelEntrada);
        add(painelBotoes);
        add(scroll);

        botaoAdicionar.addActionListener(e ->{
            String tarefa = campoTarefa.getText();

            tarefa = tarefa.trim();

            if(!tarefa.isEmpty()) {

                tarefas.add(tarefa);
                mostrarTarefas();
                campoTarefa.setText("");
                campoTarefa.requestFocus();

            }else{
                JOptionPane.showMessageDialog(
                    this,
                    "Digite uma tarefa!"
                );
            }
        });

        botaoLimpar.addActionListener(e -> {
            tarefas.clear();
            mostrarTarefas();
        });
    }

    private void mostrarTarefas(){

        areaTexto.setText("");
        int numero = 1;

        for (String tarefa : tarefas) {
            areaTexto.append(
                numero + " - " + tarefa + "\n"
            );
            numero++;
        }
    }

    public static void main(String [] args) {
        SwingUtilities.invokeLater(() ->{
            GridLayoutArrayList janela =
            new GridLayoutArrayList();
            janela.setVisible(true);
        });
    }
}
