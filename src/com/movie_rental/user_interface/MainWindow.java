package com.movie_rental.user_interface;

import javax.swing.*;

import com.movie_rental.user_interface.login_ui.LoginWindow;


public class MainWindow {
    protected JFrame mainWindow;

    public MainWindow() {
        super();
        mainWindow = new JFrame("MovieRental");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 600);

        JPanel loginPane = new JPanel();
        LoginWindow loginWindow = new LoginWindow(loginPane);

        mainWindow.add(loginPane);
        mainWindow.setVisible(true);
        UIWindowHandler.centerWindowOnScreen(this.mainWindow);
    }
}
