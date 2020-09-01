package com.movierental.database.user;

import com.movierental.movies.Movie;
import com.movierental.users.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParseUserData {

    protected static User parseUserData(ResultSet userDataFromDatabase) throws SQLException {
        // Empty array for Movie objects created from ResultSet with movie data
        User user = new User();

        // Iterates trough ResultSet with movie data, create Movie objects and add them to movieList ArrayList
        while (userDataFromDatabase.next()) {
            user.setId(String.valueOf(userDataFromDatabase.getInt("customers_id")));
            user.setName(userDataFromDatabase.getString("customers_name"));
            user.setSurname(String.valueOf(userDataFromDatabase.getDouble("customers_surname")));
            user.setPhone(String.valueOf(userDataFromDatabase.getInt("customers_phone")));
            user.setAddress(userDataFromDatabase.getString("customers_address"));
            user.setCity(userDataFromDatabase.getString("customers_city"));
        }

        return user;
    }
}
