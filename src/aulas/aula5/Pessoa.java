
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pessoa extends JFrame {

    protected String nome;
    protected String telefone;

    protected JButton btnIncluir;
    protected JButton btnGravar;
    protected JButton btnExcluir;
    protected JButton btnSair;
    protected JPanel painelBotoes;

    public Pessoa() {
        setTitle("Cadastro Pessoa");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnIncluir = new JButton("Incluir");
        btnGravar = new JButton("Gravar");
        btnExcluir = new JButton("Excluir");
        painelBotoes = new JPanel(new FlowLayout());

        painelBotoes.add(btnIncluir);
        painelBotoes.add(btnGravar);

        add(painelBotoes, "South");
        btnSair.addActionListener(e -> System.exit(status: 0));
    }

    public Pessoa(String nome, String telefone) {
        this();
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() { return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) { this.telefone = telefone;}
}