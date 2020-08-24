package com.movierental.ui.interfaces.tabbedinterfaces;

import javax.swing.*;

public class RentingMoviesCartInterface {

    public RentingMoviesCartInterface(JTabbedPane tabbedPaneIn){
        addRentingMoviesCartTab(tabbedPaneIn);
    }

    private void addRentingMoviesCartTab(JTabbedPane tabbedPaneIn){
        JPanel rentingMoviesCartPane = new JPanel();
        tabbedPaneIn.add(rentingMoviesCartPane, "Dodawanie do koszyka");
    }
}
