package exemploBorracharia;

import javax.swing.JOptionPane;

public class ClienteBorracharia extends Pessoa {

    private double valorServico;

    public ClienteBorracharia(String nome, String telefone, double valorServico) {
        super(nome, telefone);

        setTitle("Borracharia - Cadastro de Cliente");

        setValorServico(valorServico);
    }

    public void setValorServico(double valorServico) {

        if (valorServico < 0) {
            throw new ValorInvalidoException(
                "O valor do serviço não pode ser negativo!"
            );
        }

        this.valorServico = valorServico;
    }

    public void alterarValorComTexto(String texto) {

        try {

            double novoValor = Double.parseDouble(texto);

            setValorServico(novoValor);

            JOptionPane.showMessageDialog(
                this,
                "Novo valor do serviço: R$ " + novoValor,
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Digite apenas números válidos!",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (ValorInvalidoException e) {

            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Valor inválido",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}