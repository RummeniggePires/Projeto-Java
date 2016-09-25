package br.com.fasm.jdbc.dao;

import br.com.fasm.jdbc.modelo.Bilhete;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class BilheteDAO {

    private Connection connection;

    public BilheteDAO() {
        try {
            ConnectionFactory con = new ConnectionFactory();
            this.connection = con.getConnection();
        } catch (Exception e) {
        }
    }

    public void adiciona(Bilhete bilhete) {
        String sql = "insert into sessao (bilhete_id, filme, horario_sessao, cliente) values (?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, bilhete.getBilhete());
            stmt.setString(2, bilhete.getFilme());
            stmt.setString(3, bilhete.getHorario());
            stmt.setString(4, bilhete.getCliente());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Bilhete> getLista() {
        try {

            List<Bilhete> bilhetes = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from sessao");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Bilhete bilhete = new Bilhete();

                bilhete.setBilhete(rs.getInt("bilhete_id"));
                bilhete.setFilme(rs.getString("filme"));
                bilhete.setHorario(rs.getString("horario_filme"));
                bilhete.setCliente(rs.getString("cliente"));

                this.adiciona(bilhete);
            }

            rs.close();
            stmt.close();
            return bilhetes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Bilhete bilhete) {
        String sql = "update sessao set filme = ?, horario_sessao = ?, cliente = ? where bilhete_id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, bilhete.getFilme());
            stmt.setString(2, bilhete.getHorario());
            stmt.setString(3, bilhete.getCliente());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Bilhete bilhete) {
        String sql = "delete from sessao  where contato_id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            //seta os valores dos atributos da query (?)
            stmt.setInt(1, bilhete.getBilhete());
            //executa a query da inserção de registro
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
