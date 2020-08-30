package com.movierental.database.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.movierental.database.SQLiteDatabaseConnector;
import com.movierental.movies.Movie;
import com.movierental.users.User;


public class UserDataHandler {
    private static String[] userDataFromDatabaseArray;
    private static ResultSet selectedUserDataFromDatabaseResultSet;

    /**
     * Method selects username and password for usernameIn passed in argument
     *
     * @param usernameIn User's username which will be used to 'where' in select query
     * @return Returns String[] array with username and password for user passed in argument
     * @throws SQLException
     */
    public static String[] getUsernameAndPasswordForProvidedUser(String usernameIn) throws SQLException {
        userDataFromDatabaseArray = new String[2];

        String sqlQuery = "select user_name, user_password from users where user_name='" + usernameIn + "';";

        Connection conn = null;
        try {
            // Creates connection to the database
            conn = SQLiteDatabaseConnector.connectSQLiteDatabase();
            // Creates statement from String sql
            Statement query = conn.createStatement();
            //Creates ResultSet with data selected from database using String sql as a query
            selectedUserDataFromDatabaseResultSet = query.executeQuery(sqlQuery);
            if (selectedUserDataFromDatabaseResultSet.isClosed()) {
                userDataFromDatabaseArray[0] = null;
                userDataFromDatabaseArray[1] = null;
                return userDataFromDatabaseArray;
            }
            insertDataIntoUserDataFromDatabaseArrayParser();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }

        return userDataFromDatabaseArray;
    }

    // This method will insert data from ResultSet into String array that will be returned
    private static void insertDataIntoUserDataFromDatabaseArrayParser() throws SQLException {
        userDataFromDatabaseArray[0] = selectedUserDataFromDatabaseResultSet.getString("user_name");
        userDataFromDatabaseArray[1] = selectedUserDataFromDatabaseResultSet.getString("user_password");
    }

    public static User getUserData(String userIdIn) throws SQLException {
        User user = null;
        String[] userDataResult = new String[6];
        String sqlQuery = "select * from customers join cities on customers_city = cities_id where customers_id='" + userIdIn + "';";

        Connection conn = null;
        try {
            // Creates connection to the database
            conn = SQLiteDatabaseConnector.connectSQLiteDatabase();
            // Creates statement from String sql
            Statement query = conn.createStatement();
            //Creates ResultSet with data selected from database using String sql as a query
            ResultSet userData = query.executeQuery(sqlQuery);
            // Creates User object
            user = ParseUserData.parseUserData(userData);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }

        return user;
    }
}
