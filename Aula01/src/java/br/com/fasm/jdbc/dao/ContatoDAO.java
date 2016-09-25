package br.com.fasm.jdbc.dao;

import br.com.fasm.jdbc.modelo.Contato;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;

public class ContatoDAO {

    //armazena uma conexão ativa com o banco de dados
    private Connection connection;

    //método construtor inicializa conexão com banco de dados
    public ContatoDAO() {
        try {
            ConnectionFactory con = new ConnectionFactory();
            this.connection = con.getConnection();
        } catch (Exception e) {
        }
    }

    //insere um registro de contato no banco de dados
    public void adiciona(Contato contato) {
        String sql = "insert into contato (nome, email, endereco, data_nascimento) values (?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            //seta os valores dos atributos da query (?)
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            //executa a query da inserção de registro
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //retorna uma lista de objetos contato
    public List<Contato> getLista() {
        try {

            List<Contato> contatos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contato");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("contato_id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_nascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }

            rs.close();
            stmt.close();
            return contatos;

        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }

    //altere um registro de contato no banco de dados
    public void altera(Contato contato) {
        String sql = "update contato set nome = ?, email = ?, endereco = ?, data_nascimento = ? where contato_id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            //seta os valores dos atributos da query (?)
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());
            //executa a query da inserção de registro
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato) {
        String sql = "delete from contato  where contato_id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            //seta os valores dos atributos da query (?)
            stmt.setLong(1, contato.getId());
            //executa a query da inserção de registro
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
