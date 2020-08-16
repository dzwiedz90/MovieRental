package com.movieRental;

import com.movieRental.database.SQLiteDatabaseConnector;
import com.movieRental.movies.Movie;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arguments) {
        SQLiteDatabaseConnector sql = new SQLiteDatabaseConnector();
        ArrayList<Movie> list = sql.getAllMoviesData();

        for (Movie movie : list){
            System.out.println(movie.getId());
            System.out.println(movie.getName());
            System.out.println(movie.getRentalPrice());
            System.out.println(movie.getPriority());
            System.out.println(movie.getDescription());
            System.out.println(movie.getDirector());
            System.out.println(movie.getGenre());
            System.out.println(movie.getIsRented());
            System.out.println(movie.getProductionYear());
            System.out.println();
        }
    }
}
