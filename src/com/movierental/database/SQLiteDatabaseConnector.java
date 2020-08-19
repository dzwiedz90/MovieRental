package com.movierental.database;

import java.sql.*;


public class SQLiteDatabaseConnector {
    /**
     * Method that creates and return a connection to the datatbase
     */
    public static Connection connectSQLiteDatabase() throws ClassNotFoundException {
        String url = "jdbc:sqlite:C:\\Users\\upaci\\JavaProjects\\MovieRental\\movies.db";
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
