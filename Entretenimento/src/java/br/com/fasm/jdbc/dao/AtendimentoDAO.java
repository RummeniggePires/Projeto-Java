package br.com.fasm.jdbc.dao;

import br.com.fasm.jdbc.modelo.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO {

        // conexão com o banco de dados
        private final Connection connection;

        public AtendimentoDAO() throws ClassNotFoundException {
            this.connection = new ConnectionFactory().getConnection();
        }

        // insere um registro de atendimento no banco de dados
        public void adiciona(Atendimento atendimento) {
            String sql = "insert into ATENDIMENTO (codAtendimento, fk_codCliente, fk_codFunc, fk_codServ) values (?, ?, ?, ?)";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                // seta os valores
                stmt.setInt(1, atendimento.getCodAtendimento());
                stmt.setInt(2, atendimento.getFk_codCliente());
                stmt.setInt(3, atendimento.getFk_codFunc());
                stmt.setInt(4, atendimento.getFk_codServ());

                // executa
                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public List<Atendimento> getLista() { // importa a classe java.util.List
            try {
                List<Atendimento> atendimentos = new ArrayList<>(); // importa a classe java.util.ArrayList
                try (PreparedStatement stmt = this.connection.prepareStatement("select * from ATENDIMENTO order by codAtendimento");
                        ResultSet rs = stmt.executeQuery() // importa java.sql.ResultSet;
                        ) {

                    while (rs.next()) { // enquanto existir um próximo registro
                        // crian o objeto Atendimento
                        Atendimento atendimento = new Atendimento();
                        atendimento.setCodAtendimento(rs.getInt("codAtendimento"));
                        atendimento.setFk_codCliente(rs.getInt("fk_codCliente"));
                        atendimento.setFk_codFunc(rs.getInt("fk_codFunc"));
                        atendimento.setFk_codServ(rs.getInt("fk_codServ"));

                        // adiciona o objeto à lista
                        atendimentos.add(atendimento);
                    }
                } // importa java.sql.ResultSet;
                // importa java.sql.ResultSet;
                return atendimentos;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void altera(Atendimento atendimento) {
            String sql = "update ATENDIMENTO set fk_codCliente=?, fk_codFunc=?, fk_codServ=? where codAtendimento=?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, atendimento.getCodAtendimento());
                stmt.setInt(2, atendimento.getFk_codCliente());
                stmt.setInt(3, atendimento.getFk_codFunc());
                stmt.setInt(4, atendimento.getFk_codServ());

                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void remove(Atendimento atendimento) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "delete from ATENDIMENTO where codAtendimento=?")) {
                stmt.setInt(1, atendimento.getCodAtendimento());
                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
