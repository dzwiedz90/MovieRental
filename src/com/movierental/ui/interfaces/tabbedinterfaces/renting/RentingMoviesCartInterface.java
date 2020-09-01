package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import javax.swing.*;
import java.awt.*;


public class RentingMoviesCartInterface {
    FillLeftPane fillLeftPanel;
    FillRightPane fillRightPanel;

    public RentingMoviesCartInterface(JTabbedPane tabbedPaneIn) {
//        Create parent JPanel and set a layout for it
        JPanel rentingMoviesCartPane = new JPanel();
        rentingMoviesCartPane.setLayout(new FlowLayout());

//        Create left and right JPanels and fill them with data
        FillRightPane fillRightPanel = new FillRightPane(rentingMoviesCartPane, this);
        fillLeftPanel = new FillLeftPane(rentingMoviesCartPane, this, fillRightPanel);

        tabbedPaneIn.add(rentingMoviesCartPane, "Dodawanie do koszyka");
    }

    public void enableAddUserButtonFromFillLeftPaneClass() {
        fillLeftPanel.enableCustomerButton();
    }
}
