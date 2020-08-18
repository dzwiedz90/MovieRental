package com.movieRental.database;

import java.sql.*;


class SQLiteDatabaseConnector {
    Connection connect() throws ClassNotFoundException {
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
