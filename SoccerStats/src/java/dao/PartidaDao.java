//ALTER TABLE `estatisticas_jogador`.`partida`  CHANGE COLUMN `data_partida` `data_partida` DATE NOT NULL ;
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelo.Partida;

public class PartidaDao {
    // conexão com o banco de dados
    private Connection connection;

    public PartidaDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de partida no banco de dados
    public void adiciona(Partida partida) {
        String sql = "insert into partida (jogador_id, distancia_percorrida, gols_feitos, "
                + "faltas_sofridas, faltas_feitas, impedimentos, assistencias, cartao_amarelo, "
                + "cartao_vermelho, data_partida, escalado) "
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, partida.getJogadorId());
            stmt.setDouble(2, partida.getDistanciaPercorrida());
            stmt.setInt(3, partida.getGolsFeitos());
            stmt.setInt(4, partida.getFaltasSofridas());
            stmt.setInt(5, partida.getFaltasFeitas());
            stmt.setInt(6, partida.getImpedimentos());
            stmt.setInt(7, partida.getAssistencias());
            stmt.setInt(8, partida.getCartaoAmarelo());
            stmt.setInt(9, partida.getCartaoVermelho());
            stmt.setDate(10, new Date(partida.getDataPartida().getTimeInMillis()));
            stmt.setBoolean(11, partida.isEscalado());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Partida> getLista() { // importa a classe java.util.List
        try {
            List<Partida> partidas = new ArrayList<>(); // importa a classe java.util.ArrayList
            PreparedStatement stmt = this.connection.prepareStatement(
                "select j.nome as jogador, p.* " +
                "from partida p " +
                "inner join jogador j on j.jogador_id = p.jogador_id"
            );
            ResultSet rs = stmt.executeQuery(); // importa java.sql.ResultSet;

            while (rs.next()) { // enquanto existir um próximo registro
                // crian o objeto Partida
                Partida partida = new Partida();
                partida.setPartidaId(rs.getInt("partida_id"));
                partida.setJogadorId(rs.getInt("jogador_id"));
                partida.setJogador(rs.getString("jogador"));
                partida.setDistanciaPercorrida(rs.getDouble("distancia_percorrida"));
                partida.setGolsFeitos(rs.getInt("gols_feitos"));
                partida.setFaltasSofridas(rs.getInt("faltas_sofridas"));
                partida.setFaltasFeitas(rs.getInt("faltas_feitas"));
                partida.setImpedimentos(rs.getInt("impedimentos"));
                partida.setAssistencias(rs.getInt("assistencias"));
                partida.setCartaoAmarelo(rs.getInt("cartao_amarelo"));
                partida.setCartaoVermelho(rs.getInt("cartao_vermelho"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_partida"));
                partida.setDataPartida(data);
                partida.setEscalado(rs.getBoolean("escalado"));

                // adiciona o objeto à lista
                partidas.add(partida);
            }
            rs.close();
            stmt.close();
            return partidas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // lista um único registro de partida
    public Partida getPartida(int partidaId) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement(
                "select * from partida where partida_id = ?"
            );
            stmt.setInt(1, partidaId);
            ResultSet rs = stmt.executeQuery();

            Partida partida = new Partida();

            while (rs.next()) {
                partida.setPartidaId(rs.getInt("partida_id"));
                partida.setJogadorId(rs.getInt("jogador_id"));
                partida.setDistanciaPercorrida(rs.getDouble("distancia_percorrida"));
                partida.setGolsFeitos(rs.getInt("gols_feitos"));
                partida.setFaltasSofridas(rs.getInt("faltas_sofridas"));
                partida.setFaltasFeitas(rs.getInt("faltas_feitas"));
                partida.setImpedimentos(rs.getInt("impedimentos"));
                partida.setAssistencias(rs.getInt("assistencias"));
                partida.setCartaoAmarelo(rs.getInt("cartao_amarelo"));
                partida.setCartaoVermelho(rs.getInt("cartao_vermelho"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_partida"));
                partida.setDataPartida(data);
                partida.setEscalado(rs.getBoolean("escalado"));
            }

            rs.close();
            stmt.close();
            return partida;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Partida partida) {
        String sql = "update partida set jogador_id=?, distancia_percorrida=?, gols_feitos=?, "
                + "faltas_sofridas=?, faltas_feitas=?, impedimentos=?, assistencias=?, "
                + "cartao_amarelo=?, cartao_vermelho=?, data_partida=?, escalado=? where partida_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, partida.getJogadorId());
            stmt.setDouble(2, partida.getDistanciaPercorrida());
            stmt.setInt(3, partida.getGolsFeitos());
            stmt.setInt(4, partida.getFaltasSofridas());
            stmt.setInt(5, partida.getFaltasFeitas());
            stmt.setInt(6, partida.getImpedimentos());
            stmt.setInt(7, partida.getAssistencias());
            stmt.setInt(8, partida.getCartaoAmarelo());
            stmt.setInt(9, partida.getCartaoVermelho());
            stmt.setDate(10, new Date(partida.getDataPartida().getTimeInMillis()));
            stmt.setBoolean(11, partida.isEscalado());
            stmt.setInt(12, partida.getPartidaId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Partida partida) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                "delete from partida where partida_id=?"
            );
            stmt.setInt(1, partida.getPartidaId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
