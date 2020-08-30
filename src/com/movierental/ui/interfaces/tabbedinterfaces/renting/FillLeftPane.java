package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FillLeftPane implements ActionListener {
    JButton addUserButton;
    JTextField getUserIdTextField;
    RentingMoviesCartInterface rentingInterface;
    FillRightPane rightPane;

    public FillLeftPane(JPanel paneIn, RentingMoviesCartInterface rentingInterfaceIn, FillRightPane rightPaneIn) {
        this.rentingInterface = rentingInterfaceIn;
        this.rightPane = rightPaneIn;
        // Create main left pane
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new EmptyBorder(230, 0, 0, 350));
        leftPanel.setBackground(Color.CYAN);
        leftPanel.setLayout(new FlowLayout());
        leftPanel.setBackground(Color.CYAN);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        // Create top left pane that will allow to choose user to handle
        JPanel topPanel = new JPanel();
        JLabel getUserIdLabel = new JLabel("ID użytkownika");
        getUserIdTextField = new JTextField(10);
        getUserIdLabel.setLabelFor(getUserIdTextField);
        addUserButton = new JButton("Wybierz");

        topPanel.add(getUserIdLabel);
        topPanel.add(getUserIdTextField);
        topPanel.add(addUserButton);

        // Create bottom left pane that will allow movies to be handled
        JPanel bottomPanel = new JPanel();
        JLabel getMovieIdLabel = new JLabel("ID użytkownika");
        JTextField getMovieIdTextField = new JTextField(10);
        getMovieIdLabel.setLabelFor(getMovieIdTextField);
        JButton addMovieButton = new JButton("Dodaj");

        bottomPanel.add(getMovieIdLabel);
        bottomPanel.add(getMovieIdTextField);
        bottomPanel.add(addMovieButton);


        leftPanel.add(topPanel);
        leftPanel.add(bottomPanel);
        paneIn.add(leftPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addUserButton) {
            rentingInterface.setGetUserIdTextFieldValue(getUserIdTextField.getText());
            addUserButton.setEnabled(false);
            rightPane.getUserData();
        }
    }

    protected void enableCustomerButton() {
        addUserButton.setEnabled(true);
    }
}
