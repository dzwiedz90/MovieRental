package com.movierental.ui.login;

import java.sql.SQLException;
import java.util.Arrays;

import com.movierental.database.user.UserDataHandler;


public class CheckUserCredentials {

    /**
     * Method downloads data from checkUserCredentials() method and compares it with data from argument String[] array
     * @param userDataIn String[] array with [0] username and [1] password
     * @return Returns boolean value of comparision of String[] array(with credentials entered by user) from argument and String[] array with data downloaded from database
     */
    public static boolean handleUserData(String[] userDataIn) {
        String[] userData = getUserCredentials(userDataIn[0]);
        return userDataIn[0].equals(userData[0]) && userDataIn[1].equals(userData[1]);
    }

    /**
     * Method cals UserDataHandler to download user's data from database
     * @param userNameIn String argument with username to pass to UserDataHandler to use in select where
     * @return Returns user data downloaded from database for argument's username
     */
    private static String[] getUserCredentials(String userNameIn) {
        String[] userData = new String[2];
        try {
            userData = UserDataHandler.getUsernameAndPasswordForProvidedUser(userNameIn);
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        return userData;
    }
}
