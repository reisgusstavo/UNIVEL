package aulas.aula10;

public class Aluno1 {
    String nome;
    int codigo;

@Override 
public String toString() {
    return "Código: " + codigo + " Home: " + nome;
}
}

public class Main {
    public static void main(String[] args) {
        Aluno1 a1 = new Aluno1();

        a1.nome = "Maria";
        a1.codigo = 10;

        System.out.println(a1);
    }
}
