package br.com.fasm.jdbc.dao;

import br.com.fasm.jdbc.modelo.Contato;
import br.com.fasm.jdbc.modelo.participante_evento;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;

public class participante_eventoDAO {

    //armazena uma conexão ativa com o banco de dados
    private Connection connection;

    //método construtor inicializa conexão com banco de dados
    public participante_eventoDAO() {
        try {
            ConnectionFactory con = new ConnectionFactory();
            this.connection = con.getConnection();
        } catch (Exception e) {
        }
    }

    //insere um registro de contato no banco de dados
    public void adiciona(participante_evento participante) {
        String sql = "insert into participante_evento (nome, data_nascimento, telefone, email, instituicao) values (?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, participante.getNome());
            stmt.setDate(2, new Date(participante.getData_nascimento().getTimeInMillis()));
            stmt.setString(3, participante.getTelefone());
            stmt.setString(4, participante.getEmail());
            stmt.setString(5, participante.getInstituicao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<participante_evento> getLista() {
        try {

            List<participante_evento> participantes = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from participante_evento");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                participante_evento participante = new participante_evento();
                participante.setParticipante_evento_id(rs.getInt("participante_evento_id"));
                participante.setNome(rs.getString("nome"));
                participante.setEmail(rs.getString("email"));
                participante.setInstituicao(rs.getString("instituicao"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_nascimento"));
                participante.setData_nascimento(data);

                participantes.add(participante);
            }

            rs.close();
            stmt.close();
            return participantes;

        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }

    
}
