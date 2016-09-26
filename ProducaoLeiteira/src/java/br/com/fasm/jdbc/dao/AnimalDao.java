package br.com.fasm.jdbc.dao;

import java.sql.Connection;
import br.com.fasm.modelo.Animal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AnimalDao {

    // conexão com o banco de dados
    private Connection connection;

    public AnimalDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    // insere um registro de animal no banco de dados
    public void adiciona(Animal animal) {
        String sql = "insert into animal "
                + "(nome, numeracao_brinco, data_nascimento)"
                + " values (?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getNumeracao_brinco());
            stmt.setDate(3, new Date(animal.getData_nascimento().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Animal> getLista() { // importa a classe java.util.List
        try {
            List<Animal> animais = new ArrayList<>(); // importa a classe java.util.ArrayList
            PreparedStatement stmt = this.connection.prepareStatement("select * from animal order by nome, numeracao_brinco");
            ResultSet rs = stmt.executeQuery(); // importa java.sql.ResultSet;

            while (rs.next()) { // enquanto existir um próximo registro
                // crian o objeto Animal
                Animal animal = new Animal();
                animal.setAnimal_id(rs.getInt("animal_id"));
                animal.setNome(rs.getString("nome"));
                animal.setNumeracao_brinco(rs.getInt("numeracao_brinco"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_nascimento"));
                animal.setData_nascimento(data);

                // adiciona o objeto à lista
                animais.add(animal);
            }
            rs.close();
            stmt.close();
            return animais;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Animal animal) {
        String sql = "update animal set nome=?, numeracao_brinco=?, data_nascimento=? where animal_id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getNumeracao_brinco());
            stmt.setDate(3, new Date(animal.getData_nascimento().getTimeInMillis()));
            stmt.setInt(4, animal.getAnimal_id());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Animal animal) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from animal where animal_id=?");
            stmt.setInt(1, animal.getAnimal_id());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}