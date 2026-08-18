import java.util.Scanner;

public class Aula2_2 {
    public static void main(String [] args){

        Scanner entrada = new Scanner(System.in);
        String nome;
        int idade;
        double altura;

        System.out.println("Digite seu nome: ");
        nome = entrada.nextLine();

        System.out.println("Digite sua idade: ");
        idade = entrada.nextInt();

        System.out.println("Digite sua Altura: ");
        altura = entrada.nextDouble();

        System.out.println("\n ====DADOS INFORMADOS =====");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura + "metros");

     entrada.close();
    }
    
}
