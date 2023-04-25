package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database database;
    private static final String URL =
            "jdbc:postgresql://localhost:5432/lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "b4";
    private static Connection connection = null;

    private Database() {
        createConnection();
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
    public static Connection getConnection() {
        return connection;
    }

    private static void createConnection() {
        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}