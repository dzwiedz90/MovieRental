package com.movierental.ui.interfaces.tabbedinterfaces.rented;

import javax.swing.*;

public class RentedMoviesInterface {

    public RentedMoviesInterface(JTabbedPane tabbedPaneIn){
        addRentingMoviesTab(tabbedPaneIn);
    }

    private void addRentingMoviesTab(JTabbedPane tabbedPaneIn){
        JPanel rentingMoviesPane = new JPanel();
        tabbedPaneIn.add(rentingMoviesPane, "Wypożyczenia");
    }
}
