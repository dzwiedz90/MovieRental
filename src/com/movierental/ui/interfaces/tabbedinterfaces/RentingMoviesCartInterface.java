package com.movierental.ui.interfaces.tabbedinterfaces;

import com.movierental.ui.UIWindowHandler;

import javax.swing.*;
import java.awt.*;


public class RentingMoviesCartInterface {

    public RentingMoviesCartInterface(JTabbedPane tabbedPaneIn){
//        Create parent JPanel and set a layout for it
        JPanel rentingMoviesCartPane = new JPanel();
        rentingMoviesCartPane.setLayout(new FlowLayout());

//        Create left and right JPanels and fill them with data
        JPanel leftRentingMoviesCartPane = new JPanel();
        fillLeftPanel(leftRentingMoviesCartPane);
        JPanel rightRentingMoviesCartPane = new JPanel();
        fillRightPanel(rightRentingMoviesCartPane);
//        Set border to left Panel
        UIWindowHandler.setBorder(leftRentingMoviesCartPane);

//        Add left and right Panels to parent Panel and add parent Panel to tabbedPane
        rentingMoviesCartPane.add(leftRentingMoviesCartPane);
        rentingMoviesCartPane.add(rightRentingMoviesCartPane);
        tabbedPaneIn.add(rentingMoviesCartPane, "Dodawanie do koszyka");
    }

    private void fillLeftPanel(JPanel leftPaneIn){
        JLabel getUserIdLabel = new JLabel("ID użytkownika");
        getUserIdLabel.setBounds(100,100,100,100);
        JTextField getUserIdTextField = new JTextField(10);
        getUserIdLabel.setLabelFor(getUserIdTextField);

        leftPaneIn.add(getUserIdLabel);
        leftPaneIn.add(getUserIdTextField);
    }

    private void fillRightPanel(JPanel rightPaneIn){
        rightPaneIn.setLayout(new BoxLayout(rightPaneIn, BoxLayout.PAGE_AXIS));
//        Create JPanels top and bottom and set sizes
        JPanel topPane = new JPanel();
        JPanel bottomPane = new JPanel();
//        Set border to JPanels
        UIWindowHandler.setBorder(topPane);
        UIWindowHandler.setBorder(bottomPane);


//        Add JPanels to parent Panel
        rightPaneIn.add(topPane);
        rightPaneIn.add(bottomPane);
    }
}
