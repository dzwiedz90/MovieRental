package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import com.movierental.ui.UIWindowHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FillLeftPane implements ActionListener {
    JButton addUserButton;
    JButton addMovieButton;
    JTextField getUserIdTextField;
    JTextField getMovieIdTextField;
    RentingMoviesCartInterface rentingInterface;
    FillRightPane rightPane;

    public FillLeftPane(JPanel paneIn, RentingMoviesCartInterface rentingInterfaceIn, FillRightPane rightPaneIn) {
        this.rentingInterface = rentingInterfaceIn;
        this.rightPane = rightPaneIn;
        // Create main left pane
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new EmptyBorder(200, 350, 0, 0));
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
        addUserButton.addActionListener(this);

        topPanel.add(getUserIdLabel);
        topPanel.add(getUserIdTextField);
        topPanel.add(addUserButton);

        // Create bottom left pane that will allow movies to be handled
        JPanel bottomPanel = new JPanel();
        JLabel getMovieIdLabel = new JLabel("ID filmu");
        getMovieIdTextField = new JTextField(10);
        getMovieIdLabel.setLabelFor(getMovieIdTextField);
        addMovieButton = new JButton("Dodaj");
        addMovieButton.addActionListener(this);

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
            addUserButton.setEnabled(false);
            rightPane.getUserData(getUserIdTextField.getText());
        }
        if (source == addMovieButton) {
            rightPane.addMovieToBottomPane(getMovieIdTextField.getText());
        }
    }

    protected void enableCustomerButton() {
        addUserButton.setEnabled(true);
    }
}
