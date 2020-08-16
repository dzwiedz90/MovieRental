package com.movieRental.database;

import java.sql.*;
import java.util.*;

import com.movieRental.movies.Movie;


public class SQLiteDatabaseConnector {
    private Connection connect() throws ClassNotFoundException {
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

    ArrayList<Movie> movieList;

    public ArrayList<Movie> getAllMoviesData() {
        String sql = "select m.movie_id, m.movie_name, m.movie_rental_price, m.movie_priority, m.movie_description, m.movie_director, g.genre, m.is_rented, m.movie_production_year from movies as m join genres as g on m.genre_id = g.genre_id;";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet movieDataFromDatabase = stmt.executeQuery(sql)) {

            movieList = ParseMovieData.parseMovieData(movieDataFromDatabase);


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        return movieList;
    }
}
