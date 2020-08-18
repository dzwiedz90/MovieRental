package com.movieRental.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.movieRental.movies.Movie;


class ParseMovieData {
    public static ArrayList<Movie> parseMovieData(ResultSet movieDataFromDatabase) throws SQLException {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
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
            movieList.add(movie);
        }

        return movieList;
    }
}
