package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.ResultadoCadastro;

public class ProdutoDAO {
    public ResultadoCadastro inserir (Produto produto) {
        if (existeProduto(produto.getNome())) {
            return ResultadoCadastro.JA_EXISTE;
        }
        String sql = "INSERT INTO produtos " +
                     "(nome, preco, marca) " +
                     "VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setDouble(2, produto.getPreco());
                stmt.setString(3, produto.getMarca());
                stmt.executeUpdate();
                return ResultadoCadastro.SUCESSO;
                
             } catch (SQLException e) {
                System.out.println("Erro ao inserir produto: " +
                e.getMessage());
                return ResultadoCadastro.ERRO_BANCO;
             }             
    }
    public boolean existeProduto(String nomeProduto) {
        String sql = "SELECT 1 FROM produtos WHERE nome = ?";

        try(Connection conn = Conexão.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,nomeProduto);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e){
            System.out.println("Erro ao verificar produto: " + e.getMessage);
            return false;
        }
    }
}

}
