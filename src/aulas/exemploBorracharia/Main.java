package exemploBorracharia;

public class Main {

    public static void main(String[] args) {

        try {

            ClienteBorracharia cliente = new ClienteBorracharia(
                "Carlos Silva",
                "1199999999",
                80.00
            );

            cliente.setVisible(true);

            cliente.alterarValorComTexto("-50.00");

        } catch (ValorInvalidoException e) {

            System.out.println(
                "Erro ao cadastrar serviço: " + e.getMessage()
            );
        }
    }
}