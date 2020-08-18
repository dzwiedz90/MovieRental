package com.movieRental.database;

import com.movieRental.movies.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieDataHandler {
    ArrayList<Movie> movieList;

    public ArrayList<Movie> getAllMoviesData() {
        SQLiteDatabaseConnector connector = new SQLiteDatabaseConnector();
        String sql = "select m.movie_id, m.movie_name, m.movie_rental_price, m.movie_priority, m.movie_description, m.movie_director, g.genre, m.is_rented, m.movie_production_year from movies as m join genres as g on m.genre_id = g.genre_id;";

        try (Connection conn = connector.connect();
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
