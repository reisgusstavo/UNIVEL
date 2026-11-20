import view.TelaLogin; 

public class Main{

    public static void main(String[] args){
        javac.swing.SwingUtilities.invokeLater(() ->{
            new TelaLogin()>setVisible(true);
        });
    }
}