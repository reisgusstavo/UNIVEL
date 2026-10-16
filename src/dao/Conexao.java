package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "";

    private static final String USER = "root";
    private static final String PASSWORD = "univel";

    public static Connection conectar() {
        Connection conexao = null;
        try{
            Class.forName("COM.MYSQL.CJ.JDBC.dRIVER");

            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado com sucesso ao MySql");

        }catch (ClassNotFoundException e) {

            System.out.println("Driver JDBC do MySQL nao encontrado: " + e.getMessage());
        }catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return conexao;
    }

    
}
