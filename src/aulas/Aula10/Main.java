package aulas.aula10;

public class Aluno {
    String nome;
    int codigo;
}

public class Main {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();

        a1.nome = "Maria";
        a1.codigo = 10;

        System.out.println(a1);

    }
}
