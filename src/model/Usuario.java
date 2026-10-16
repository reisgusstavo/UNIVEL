package model;

public class Usuario {

    private int id;
    private String login;
    private String senha;
    private String dataCriacao;
    private String ativo;
    private String tipo;
    private String email;

    public int getId() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

        public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

        public String getsenha() {
        return senha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }

    public String getdataCriacao() {
        return dataCriacao;
    }

    public void setdataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getativo() {
        return ativo;
    }

    public void setativo(String ativo) {
        this.ativo = ativo;
    }

        public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
}
