package br.com.fasm.jdbc.dao;

import br.com.fasm.jdbc.modelo.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    
// conexão com o banco de dados
    private final Connection connection;

    public DepartamentoDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de cliente no banco de dados
    public void adiciona(Departamento cliente) {
        String sql = "insert into DEPARTAMENTO (codDepartamento, nomeDep, salario) values (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            // seta os valores
            stmt.setInt(1, cliente.getCodDepartamento());
            stmt.setString(2, cliente.getNomeDep());
            stmt.setFloat(3, cliente.getSalario());

            // executa
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Departamento> getLista() { // importa a classe java.util.List
        try {
            List<Departamento> departamentos = new ArrayList<>(); // importa a classe java.util.ArrayList
            try (PreparedStatement stmt = this.connection.prepareStatement("select * from DEPARTAMENTO order by nomeDep");
                    ResultSet rs = stmt.executeQuery() // importa java.sql.ResultSet;
                    ) {

                while (rs.next()) { // enquanto existir um próximo registro
                    // crian o objeto Departamento
                    Departamento departamento = new Departamento();
                    departamento.setCodDepartamento(rs.getInt("codDepartamento"));
                    departamento.setNomeDep(rs.getString("nomeDep"));
                    departamento.setSalario(rs.getFloat("salario"));

                    // adiciona o objeto à lista
                    departamentos.add(departamento);
                }
            } // importa java.sql.ResultSet;
            // importa java.sql.ResultSet;
            return departamentos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Departamento cliente) {
        String sql = "update DEPARTAMENTO set nomeDep=?, salario=? where codDepartamento=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getCodDepartamento());
            stmt.setString(2, cliente.getNomeDep());
            stmt.setFloat(3, cliente.getSalario());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Departamento cliente) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "delete from DEPARTAMENTO where codDepartamento=?")) {
            stmt.setInt(1, cliente.getCodDepartamento());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

