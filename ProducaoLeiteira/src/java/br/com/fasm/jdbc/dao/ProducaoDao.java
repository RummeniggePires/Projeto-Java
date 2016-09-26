package br.com.fasm.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fasm.modelo.Producao;


public class ProducaoDao {
    
    // conexão com o banco de dados
    private Connection connection;

    public ProducaoDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de producao no banco de dados
    public void adiciona(Producao producao) {
        String sql = "insert into producao (animal_id, kg_leite, teor_gordura, "
                + "acidez, data_registro ) "
                + " values (?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, producao.getAnimal_id());
            stmt.setDouble(2, producao.getKg_leite());
            stmt.setDouble(3, producao.getTeor_gordura());
            stmt.setDouble(4, producao.getAcidez());
            stmt.setDate(5, new Date(producao.getData_registro().getTimeInMillis()));
            
            
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producao> getLista() { // importa a classe java.util.List
        try {
            List<Producao> producoes = new ArrayList<>(); // importa a classe java.util.ArrayList
            PreparedStatement stmt = this.connection.prepareStatement(
                "select a.nome as animal, p.* " +
                "from producao p " +
                "inner join animal a on a.animal_id = p.animal_id"
            );
            ResultSet rs = stmt.executeQuery(); // importa java.sql.ResultSet;

            while (rs.next()) { // enquanto existir um próximo registro
                // crian o objeto Producao
                Producao producao = new Producao();
                producao.setProducao_id(rs.getInt("producao_id"));
                producao.setAnimal_id(rs.getInt("animal_id"));
                producao.setNome(rs.getString("nome"));
                producao.setKg_leite(rs.getFloat("kg_leite"));
                producao.setTeor_gordura(rs.getFloat("teor_gordura"));
                producao.setAcidez(rs.getFloat("acidez"));
                
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_registro"));
                producao.setData_registro(data);

                // adiciona o objeto à lista
                producoes.add(producao);
            }
            rs.close();
            stmt.close();
            return producoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // lista um único registro de producao
    public Producao getProducao(int producaoId) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement(
                "select * from producao where producao_id = ?"
            );
            stmt.setInt(1, producaoId);
            ResultSet rs = stmt.executeQuery();

            Producao producao = new Producao();

            while (rs.next()) {
                
                producao.setProducao_id(rs.getInt("producao_id"));
                producao.setAnimal_id(rs.getInt("animal_id"));
                producao.setNome(rs.getString("nome"));
                producao.setKg_leite(rs.getFloat("kg_leite"));
                producao.setTeor_gordura(rs.getFloat("teor_gordura"));
                producao.setAcidez(rs.getFloat("acidez"));
                
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_registro"));
                producao.setData_registro(data);
            }

            rs.close();
            stmt.close();
            return producao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Producao producao) {
        String sql = "update producao set animal_id=?, distancia_percorrida=?, gols_feitos=?, "
                + "faltas_sofridas=?, faltas_feitas=?, impedimentos=?, assistencias=?, "
                + "cartao_amarelo=?, cartao_vermelho=?, data_producao=?, escalado=? where producao_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
           
            stmt.setInt(1, producao.getAnimal_id());
            stmt.setDouble(2, producao.getKg_leite());
            stmt.setDouble(3, producao.getTeor_gordura());
            stmt.setDouble(4, producao.getAcidez());
            stmt.setDate(5, new Date(producao.getData_registro().getTimeInMillis()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Producao producao) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                "delete from producao where producao_id=?"
            );
            stmt.setInt(1, producao.getProducao_id());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}