package com.movierental.ui;

import javax.swing.*;

import com.movierental.ui.login.LoginWindow;


public class MainWindow {
    protected JFrame mainWindow;

    /**
     * This class creates application's main window frame
     */
    public MainWindow() {
        //Creates main window frame
        super();
        mainWindow = new JFrame("MovieRental");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setSize(1050, 600);

        // Creates pane with login and password fields and logIn button used for logging in
        JPanel loginPane = new JPanel();
        LoginWindow loginWindow = new LoginWindow(loginPane, mainWindow);
        mainWindow.add(loginPane);


        mainWindow.setVisible(true);
        UIWindowHandler.centerWindowOnScreen(this.mainWindow);
    }
}
