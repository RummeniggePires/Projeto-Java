package dao;

import java.sql.Connection;
import modelo.Jogador;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDao {

    // conexão com o banco de dados
    private Connection connection;

    public JogadorDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de jogador no banco de dados
    public void adiciona(Jogador jogador) {
        String sql = "insert into jogador "
                + "(nome, idade, clube, posicao)"
                + " values (?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, jogador.getNome());
            stmt.setInt(2, jogador.getIdade());
            stmt.setString(3, jogador.getClube());
            stmt.setString(4, jogador.getPosicao());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Jogador> getLista() { // importa a classe java.util.List
        try {
            List<Jogador> jogadores = new ArrayList<>(); // importa a classe java.util.ArrayList
            PreparedStatement stmt = this.connection.prepareStatement("select * from jogador order by nome, clube");
            ResultSet rs = stmt.executeQuery(); // importa java.sql.ResultSet;

            while (rs.next()) { // enquanto existir um próximo registro
                // crian o objeto Jogador
                Jogador jogador = new Jogador();
                jogador.setJogadorId(rs.getInt("jogador_id"));
                jogador.setNome(rs.getString("nome"));
                jogador.setIdade(rs.getInt("idade"));
                jogador.setClube(rs.getString("clube"));
                jogador.setPosicao(rs.getString("posicao"));

                // adiciona o objeto à lista
                jogadores.add(jogador);
            }
            rs.close();
            stmt.close();
            return jogadores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Jogador jogador) {
        String sql = "update jogador set nome=?, idade=?, clube=?,"
                + "posicao=? where jogador_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, jogador.getNome());
            stmt.setInt(2, jogador.getIdade());
            stmt.setString(3, jogador.getClube());
            stmt.setString(4, jogador.getPosicao());
            stmt.setInt(5, jogador.getJogadorId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Jogador jogador) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                "delete from jogador where jogador_id=?");
            stmt.setInt(1, jogador.getJogadorId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
