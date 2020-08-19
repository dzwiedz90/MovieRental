package com.movierental.database.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.movierental.movies.Movie;


class ParseMovieData {

    /**
     * Static method that takes ResultSet as an argument which contains movie data from database and returns ArrayList filled with Movie objects created from data from ResultSet
     * @param movieDataFromDatabase ResultSet with movie data selected from database
     */
    public static ArrayList<Movie> parseMovieData(ResultSet movieDataFromDatabase) throws SQLException {
        // Empty array for Movie objects created from ResultSet with movie data
        ArrayList<Movie> movieListArray = new ArrayList<Movie>();

        // Iterates trough ResultSet with movie data, create Movie objects and add them to movieList ArrayList
        while (movieDataFromDatabase.next()) {
            Movie movie = new Movie();
            movie.setId(String.valueOf(movieDataFromDatabase.getInt("movie_id")));
            movie.setName(movieDataFromDatabase.getString("movie_name"));
            movie.setRentalPrice(String.valueOf(movieDataFromDatabase.getDouble("movie_rental_price")));
            movie.setPriority(String.valueOf(movieDataFromDatabase.getInt("movie_priority")));
            movie.setDescription(movieDataFromDatabase.getString("movie_description"));
            movie.setDirector(movieDataFromDatabase.getString("movie_director"));
            movie.setGenre(movieDataFromDatabase.getString("genre"));
            movie.setIsRented(String.valueOf(movieDataFromDatabase.getInt("is_rented")));
            movie.setProductionYear(String.valueOf(movieDataFromDatabase.getInt("movie_production_year")));
            movieListArray.add(movie);
        }

        return movieListArray;
    }
}
