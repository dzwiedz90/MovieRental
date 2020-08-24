package com.movierental.ui.interfaces.tabbedinterfaces;

import javax.swing.*;

public class RentingMoviesInterface {

    public RentingMoviesInterface(JTabbedPane tabbedPaneIn){
        addRentingMoviesTab(tabbedPaneIn);
    }

    private void addRentingMoviesTab(JTabbedPane tabbedPaneIn){
        JPanel rentingMoviesPane = new JPanel();
        tabbedPaneIn.add(rentingMoviesPane, "Wypożyczenia");
    }
}
