package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class RentingMoviesCartInterface {
    Insets insets;

    public RentingMoviesCartInterface(JTabbedPane tabbedPaneIn) {
//        Create parent JPanel and set a layout for it
        JPanel rentingMoviesCartPane = new JPanel();
        rentingMoviesCartPane.setLayout(new FlowLayout());

//        Create left and right JPanels and fill them with data
        FillLeftPane fillLeftPanel;
        FillRightPane fillRightPanel = null;
        fillRightPanel = new FillRightPane(rentingMoviesCartPane);
        fillLeftPanel = new FillLeftPane(rentingMoviesCartPane, this, fillRightPanel);

        tabbedPaneIn.add(rentingMoviesCartPane, "Dodawanie do koszyka");
    }
}
