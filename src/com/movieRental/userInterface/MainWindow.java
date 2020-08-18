package com.movieRental.userInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    protected JFrame mainWindow;

    public MainWindow() {
        super();
        mainWindow = new JFrame("MovieRental");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 600);

        mainWindow.setVisible(true);
        UIWindowHandler.centerWindowOnScreen(this.mainWindow);
    }
}
