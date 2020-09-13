package com.movierental.ui.interfaces.tabbedinterfaces.movies;

import javax.swing.*;
import java.awt.*;

public class MovieDatabaseInterface {

    public MovieDatabaseInterface(JTabbedPane tabbedPaneIn) {
        addMovieDatabaseTab(tabbedPaneIn);
    }

    private void addMovieDatabaseTab(JTabbedPane tabbedPaneIn) {
        JPanel movieDatabasePane = new JPanel();
        tabbedPaneIn.add(movieDatabasePane, "Baza filmów");
        movieDatabasePane.setLayout(new BorderLayout());
        JPanel topMovieDatabasePanel = new JPanel();
        JPanel bottomMovieDatabasePanel = new JPanel();

        topPanel(topMovieDatabasePanel);
        bottomPanel(JPanel bottomMovieDatabasePanel);

        movieDatabasePane.add(topMovieDatabasePanel, BorderLayout.NORTH);
        movieDatabasePane.add(bottomMovieDatabasePanel, BorderLayout.CENTER);
        tabbedPaneIn.add(movieDatabasePane);
    }

    private void topPanel(JPanel topMovieDatabasePanelIn) {
        JPanel buttonPanel = new JPanel();
    }

    private void bottomPanel(JPanel bottomMovieDatabasePanelIn) {

    }
}
