import java.util.Scanner;

public class Aula3_1 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        int num = sc.nextInt();

        if (num > 0){
            System.out.println("O número é positivo ");
        }
        else if(num < 0){
            System.out.println("O número é negativo");

        }
        else{
            System.out.println("O número é igual a zero.");
        }

        int resto = num % 2;
        if( resto == 0 ) {
            System.out.println("O número é par");
        }
        else{
            System.out.println("O número é impar");
        }

        if ( resto != 1){
            System.out.println("O núemro é par");
        }
        else{
            System.out.println("O número é impar");
        }

        sc.close();
    }
    
}
