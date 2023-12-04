package com.hei.wallet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection dbConnection;

    static {
        try {
            String dbUrl = System.getenv("db_url");
            String dbUsername = System.getenv("db_username");
            String dbPassword = System.getenv("db_password");

            dbConnection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            System.out.println("Error while initializing connection: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return dbConnection;
    }

}