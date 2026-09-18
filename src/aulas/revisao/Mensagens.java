package aulas.revisao;
import javax.swing.JOptionPane;
public class Mensagens{

    public static void main(String[] args) {

    JOptionPane.showMessageDialog(
        null,
        "Esta é uma mensagem de informação",
        "Informação",
        JOptionPane.INFORMATION_MESSAGE);

    JOptionPane.showMessageDialog(
           null,
           "Cuidado!, Estaé uma mensagem de aviso.",
           "Aviso",
        JOptionPane.WARNING_MESSAGE
    );

    
    JOptionPane.showMessageDialog(
        null,
        "Ocorreu um erro!",
        "Erro",
        JOptionPane.ERROR_MESSAGE 
    );

    JOptionPane.showMessageDialog(
        null,
        "Está é uma pergunta.",
        "Pergunta",
        JOptionPane.QUESTION_MESSAGE

    );

    JOptionPane.showMessageDialog(
        null,
        "Esta mensagem não possui icone.",
        "PErgunta simples",
        JOptionPane.PLAIN_MESSAGE
    );

    int resposta = JOptionPane.showConfirmDialog(null,
        "Você gosta de Java?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null,
            "Você respondeu sim"
        );

    }else {
        JOptionPane.showMessageDialog(null,
            "Você respondeu Não"
        );
    }

    String nome = JOptionPane.showInputDialog(
        null,
        "Digite seu nome"
    );

    JOptionPane.showMessageDialog(null,
        "Olá" + nome + "!"
    );

    String[] opcoes = {"Java", "Python", "C++"};
    int escolha = JOptionPane.showOptionDialog(null,
        "Qual linguagem você prefere?",
        "Escolha uma linguagem",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opcoes,
        opcoes[0]
    );
    
    if (escolha >= 0) {
        JOptionPane.showMessageDialog(null,
            "Você escolheu" + opcoes[escolha]
        );
    }

    JOptionPane.showMessageDialog(
        null,
        "Demonstração finalizada",
        "Fim",
        JOptionPane.INFORMATION_MESSAGE

    );


};}