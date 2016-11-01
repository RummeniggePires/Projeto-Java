package br.com.fasm.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fasm.jdbc.modelo.Servicos;

public class ServicoDAO {

    // conexão com o banco de dados
    private Connection connection;

    public ServicoDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de servico no banco de dados
    public void adiciona(Servicos servicos) {
        String sql = "insert into SERVICOS ( codServico, nomeServ, preco, "
                + "descricao) "
                + " values (?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, servicos.getCodServico());
            stmt.setString(2, servicos.getNomeServ());
            stmt.setDouble(3, servicos.getPreco());
            stmt.setString(4, servicos.getDescricao());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Servicos> getLista() { // importa a classe java.util.List
        try {
            List<Servicos> serv = new ArrayList<>(); // importa a classe java.util.ArrayList
            PreparedStatement stmt = this.connection.prepareStatement("select * from SERVICOS order by nomeServ");
            ResultSet rs = stmt.executeQuery(); // importa java.sql.ResultSet;

            while (rs.next()) { // enquanto existir um próximo registro
                // crian o objeto Servico
                Servicos servicos = new Servicos();
                servicos.setCodServico(rs.getInt("codServico"));
                servicos.setNomeServ(rs.getString("nomeServ"));
                servicos.setPreco(rs.getFloat("preco"));
                servicos.setDescricao(rs.getString("descricao"));

                // adiciona o objeto à lista
                serv.add(servicos);
            }
            rs.close();
            stmt.close();
            return serv;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // lista um único registro de servico
    public Servicos getServico(int servicoId) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement(
                    "select * from SERVICOS where codServico = ?"
            );
            stmt.setInt(1, servicoId);
            ResultSet rs = stmt.executeQuery();

            Servicos servicos = new Servicos();

            while (rs.next()) {

                servicos.setCodServico(rs.getInt("codServico"));
                servicos.setNomeServ(rs.getString("nomeServ"));
                servicos.setDescricao(rs.getString("descricao"));
                servicos.setPreco(rs.getFloat("preco"));

            }

            rs.close();
            stmt.close();
            return servicos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Servicos servicos) {
        String sql = "update SERVICOS set nomeServ=?, descricao=?, preco=? where codServ=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, servicos.getCodServico());
            stmt.setString(2, servicos.getNomeServ());
            stmt.setString(3, servicos.getDescricao());
            stmt.setFloat(4, servicos.getPreco());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Servicos servicos) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "delete from SERVICOS where codServ=?")) {
            stmt.setInt(1, servicos.getCodServico());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
