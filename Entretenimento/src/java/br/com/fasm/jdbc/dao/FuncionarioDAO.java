package br.com.fasm.jdbc.dao;

import br.com.fasm.jdbc.modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    // conexão com o banco de dados
    private final Connection connection;

    public FuncionarioDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de funcionario no banco de dados
    public void adiciona(Funcionario funcionario) {
        String sql = "insert into FUNCIONARIO (codFunc, nomeFunc,cpfFunc, endFunc, fk_codDep, idade) values (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            // seta os valores
            stmt.setInt(1, funcionario.getCodFunc());
            stmt.setString(2, funcionario.getNomeFunc());
            stmt.setInt(3, funcionario.getCpfFunc());
            stmt.setString(4, funcionario.getEndFunc());
            stmt.setInt(5, funcionario.getFk_codDep());
            stmt.setInt(6, funcionario.getIdade());

            // executa
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> getLista() { // importa a classe java.util.List
        try {
            List<Funcionario> funcionarios = new ArrayList<>(); // importa a classe java.util.ArrayList
            try (PreparedStatement stmt = this.connection.prepareStatement("select * from FUNCIONARIO order by nomeFunc");
                    ResultSet rs = stmt.executeQuery() // importa java.sql.ResultSet;
                    ) {

                while (rs.next()) { // enquanto existir um próximo registro
                    // crian o objeto Funcionario
                    Funcionario funcionario = new Funcionario();
                    funcionario.setCodFunc(rs.getInt("codFunc"));
                    funcionario.setNomeFunc(rs.getString("nomeFunc"));
                    funcionario.setCpfFunc(rs.getInt("cpfFunc"));
                    funcionario.setEndFunc(rs.getString("endFunc"));
                    funcionario.setFk_codDep(rs.getInt("fk_codDep"));
                    funcionario.setIdade(rs.getInt("idade"));

                    // adiciona o objeto à lista
                    funcionarios.add(funcionario);
                }
            } // importa java.sql.ResultSet;
            // importa java.sql.ResultSet;
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Funcionario funcionario) {
        String sql = "update FUNCIONARIO set nomeFunc=?, cpf=?,endFunc=?, fk_codFunc=?, idade=? where codFunc=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getCodFunc());
            stmt.setString(2, funcionario.getNomeFunc());
            stmt.setInt(3, funcionario.getCpfFunc());
            stmt.setString(4, funcionario.getEndFunc());
            stmt.setInt(5, funcionario.getFk_codDep());
            stmt.setInt(6, funcionario.getIdade());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Funcionario funcionario) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "delete from FUNCIONARIO where codFunc=?")) {
            stmt.setInt(1, funcionario.getCodFunc());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
