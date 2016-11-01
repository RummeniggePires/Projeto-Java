package br.com.fasm.jdbc.dao;

import br.com.fasm.jdbc.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // conexão com o banco de dados
    private final Connection connection;

    public ClienteDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de cliente no banco de dados
    public void adiciona(Cliente cliente) {
        String sql = "insert into CLIENTE (codCliente, nomeCliente, cpf, idade) values (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            // seta os valores
            stmt.setInt(1, cliente.getCodCliente());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setInt(3, cliente.getCpf());
            stmt.setInt(4, cliente.getIdade());

            // executa
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getLista() { // importa a classe java.util.List
        try {
            List<Cliente> clientes = new ArrayList<>(); // importa a classe java.util.ArrayList
            try (PreparedStatement stmt = this.connection.prepareStatement("select * from CLIENTE order by nomeCliente");
                    ResultSet rs = stmt.executeQuery() // importa java.sql.ResultSet;
                    ) {

                while (rs.next()) { // enquanto existir um próximo registro
                    // crian o objeto Cliente
                    Cliente cliente = new Cliente();
                    cliente.setCodCliente(rs.getInt("codCliente"));
                    cliente.setNomeCliente(rs.getString("nomeCliente"));
                    cliente.setCpf(rs.getInt("cpf"));
                    cliente.setIdade(rs.getInt("idade"));

                    // adiciona o objeto à lista
                    clientes.add(cliente);
                }
            } // importa java.sql.ResultSet;
            // importa java.sql.ResultSet;
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Cliente cliente) {
        String sql = "update CLIENTE set nomeCliente=?, cpf=?, idade=? where codCliente=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getCodCliente());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setInt(3, cliente.getCpf());
            stmt.setInt(4, cliente.getIdade());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Cliente cliente) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "delete from CLIENTE where codCliente=?")) {
            stmt.setInt(1, cliente.getCodCliente());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
