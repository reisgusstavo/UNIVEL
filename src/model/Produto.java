package model;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String marca;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public double getpreco() {
        return preco;
    }

    public void setpreco(double preco) {
        this.preco = preco;
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }
    
}
