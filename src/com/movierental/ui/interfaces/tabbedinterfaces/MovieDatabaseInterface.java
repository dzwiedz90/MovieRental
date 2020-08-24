package com.movierental.ui.interfaces.tabbedinterfaces;

import javax.swing.*;

public class MovieDatabaseInterface {

    public MovieDatabaseInterface(JTabbedPane tabbedPaneIn){
        addMovieDatabaseTab(tabbedPaneIn);
    }

    private void addMovieDatabaseTab(JTabbedPane tabbedPaneIn){
        JPanel movieDatabasePane = new JPanel();
        tabbedPaneIn.add(movieDatabasePane, "Baza filmów");
    }
}
