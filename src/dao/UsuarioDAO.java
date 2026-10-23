package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.Usuario;
import util.Funcoes;
import util.ResultadoCadastro;

public class UsuarioDAO {

    public boolean autenticar(Usuario usuario) {
        String sql = "SELECT login, senha FROM usuarios WHERE login = ? AND senha = ?";

        try (Connection minhaConexao = Conexao.conectar();
             PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, Funcoes.gerarHashSHA256(usuario.getSenha()));

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

    public boolean existeUsuario(String nomeUsuario) {
        String sql = "SELECT 1 FROM usuarios WHERE login = ?";

        try (Connection minhaConexao = Conexao.conectar();
             PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {

            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar existência de usuario: " + e.getMessage());
            return false;
        }
    }

    public ResultadoCadastro inserir(Usuario dadosInformados) {
        if (existeUsuario(dadosInformados.getLogin())) {
            return ResultadoCadastro.JA_EXISTE;
        }

        String sql = "INSERT INTO usuarios (login, senha, data_criacao, tipo, ativo, email) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection minhaConexao = Conexao.conectar();
             PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {

            stmt.setString(1, dadosInformados.getLogin());
            stmt.setString(2, Funcoes.gerarHashSHA256(dadosInformados.getSenha()));
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setString(4, "U");
            stmt.setString(5, "S");
            stmt.setString(6, "");

            stmt.executeUpdate();
            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuario: " + e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        }
    }
}