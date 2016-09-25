package dao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConectaBanco {

    public Statement stm;
    public ResultSet rs;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String caminho = "jdbc:mysql://localhost:3306/locadora_veiculos";
    private final String usuario = "root";
    private final String senha = "172839";
    public Connection conn;

    // efetua conexão com o banco de dados
    public Connection conecte() {

        // determina o driver de conexao
        System.setProperty("jdbc.Drives", driver);

        conn = null;

        try {

            // efetua conexão
            conn = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n" + ex.getMessage());

        }

        // retorna a conexão para o trecho que invoca o método
        return conn;
    }

    // executa uma consulta SQL
    public void executeSQL(String sql) {
        try {
            // determina sentença
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);

            // Executa contulta
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta sql");
        }
    }
}
