package com.movie_rental.database.movie_data_handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.movie_rental.database.SQLiteDatabaseConnector;
import com.movie_rental.movies.Movie;

public class MovieDataHandler {
    ArrayList<Movie> movieList;

    /**
     * Method that connects to the database, SELECTs all movies data, uses parser to create Movie objects from selected data and returns ArrayList filled with Movie objects created with data from database
     */
    public ArrayList<Movie> getAllMoviesData() {
        // Create connection to the database
        // Create a query
        String sql = "select m.movie_id, m.movie_name, m.movie_rental_price, m.movie_priority, m.movie_description, m.movie_director, g.genre, m.is_rented, m.movie_production_year from movies as m join genres as g on m.genre_id = g.genre_id;";

        try (Connection conn = SQLiteDatabaseConnector.connectSQLiteDatabase();
             Statement stmt = conn.createStatement();
             //Create ResultSet with data SELECTed from database using String sql as a query
             ResultSet movieDataFromDatabase = stmt.executeQuery(sql)) {

            // Get ArrayList of Movie objects from parser
            movieList = ParseMovieData.parseMovieData(movieDataFromDatabase);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        return movieList;
    }
}
