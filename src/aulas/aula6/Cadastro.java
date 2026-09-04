package aulas.Aula6;

import java.util.HashMap;

public class Cadastro {

    private HashMap<Integer, Pessoa> pessoas;

    public Cadastro() {
        pessoas = new HashMap<>();
    }

    public void cadastrar(int id, Pessoa pessoa) {
        pessoas.put(id, pessoa);
    }

    public boolean remover(int id) {
        if (pessoas.containsKey(id)) {
            pessoas.remove(id);
            return true;
        }

        return false;
    }

    public String listar() {

        if (pessoas.isEmpty()) {
            return "Nenhuma pessoa cadastrada.";
        }

        String texto = "";

        for (Integer id : pessoas.keySet()) {

            Pessoa pessoa = pessoas.get(id);

            texto += "ID: " + id + "\n";
            texto += pessoa.apresentar() + "\n";
            texto += "-----------------------------\n";
        }

        return texto;
    }
}