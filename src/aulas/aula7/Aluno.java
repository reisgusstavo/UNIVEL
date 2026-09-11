package Aula7;

public class Aluno extends Pessoa {

    private double nota;

    public Aluno(String nome, double nota) {
        super(nome);
        this.nota = nota;
    }

    @Override 
    public String apresentar() {return "Aluno" + getNome()
     + "\nNota:" + nota;
    }
    
}
