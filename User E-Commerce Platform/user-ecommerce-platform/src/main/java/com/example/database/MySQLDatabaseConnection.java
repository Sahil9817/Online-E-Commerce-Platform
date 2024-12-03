package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDatabaseConnection implements DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    @Override
    public Connection getConnection() throws Exception {
        try {
            // Load MySQL JDBC Driver (optional for modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish and return the connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new Exception("Failed to connect to the database", e);
        }
    }
}

