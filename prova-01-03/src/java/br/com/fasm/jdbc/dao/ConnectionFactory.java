package br.com.fasm.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws ClassNotFoundException {
        try {

            //Registra no river do MySQL
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/cinema", "root", "1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}