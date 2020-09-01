package com.movierental.database.movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.movierental.database.SQLiteDatabaseConnector;
import com.movierental.movies.Movie;

public class MovieDataHandler {

    /**
     * Method that connects to the database, SELECTs all movies data, uses parser to create Movie objects from selected data and returns ArrayList filled with Movie objects created with data from database
     */
    public static ArrayList<Movie> getAllMoviesData() throws SQLException {
        ArrayList<Movie> movieListArray = new ArrayList<>();
        // Creates a query
        String sqlQuery = "select m.movie_id, m.movie_name, m.movie_rental_price, m.movie_priority, m.movie_description, m.movie_director, g.genre, m.is_rented, m.movie_production_year from movies as m join genres as g on m.genre_id = g.genre_id;";

        Connection conn = null;
        try {
            // Creates connection to the database
            conn = SQLiteDatabaseConnector.connectSQLiteDatabase();
            // Creates statement from String sql
            Statement query = conn.createStatement();
            //Creates ResultSet with data selected from database using String sql as a query
            ResultSet movieDataFromDatabaseResultSet = query.executeQuery(sqlQuery);
            // Gets ArrayList of Movie objects from parser
            movieListArray = ParseMovieData.parseWholeMovieData(movieDataFromDatabaseResultSet);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        } finally {
            assert conn != null;
            conn.close();
        }
        return movieListArray;
    }

    public static ArrayList<Movie> getRentedMoviesDataByCustomer(String userIdIn) throws SQLException {
        ArrayList<Movie> movieDataResults = new ArrayList<>();

        // Creates a query
        String sqlQuery = "select movie_id, movie_name from rentals join movies on rental_movie=movie_id where rental_customer=" + userIdIn + ";";

        Connection conn = null;
        try {
            // Creates connection to the database
            conn = SQLiteDatabaseConnector.connectSQLiteDatabase();
            // Creates statement from String sql
            Statement query = conn.createStatement();
            //Creates ResultSet with data selected from database using String sql as a query
            ResultSet movieDataFromDatabaseResultSet = query.executeQuery(sqlQuery);
            // Gets ArrayList of Movie objects from parser
            movieDataResults = ParseMovieData.parseRentedMoviesDataByCustomer(movieDataFromDatabaseResultSet);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        } finally {
            assert conn != null;
            conn.close();
        }

        return movieDataResults;
    }
}
