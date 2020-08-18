package com.movie_rental.user_interface.login_ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginWindow implements ActionListener, KeyListener {
    public LoginWindow(JPanel paneIn) {

        JPanel loggingPane = new JPanel();
        loggingPane.setBorder(new EmptyBorder(200, 0, 0, 0));
        JTextField loginTextField = new JTextField(20);
        loginTextField.addKeyListener(this);
        JLabel loginLabel = new JLabel("Login: ");
        loginLabel.setLabelFor(loginTextField);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.addKeyListener(this);
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setLabelFor(passwordField);

        JButton logInButton = new JButton("Log in");
        logInButton.addKeyListener(this);
        logInButton.addActionListener(this);

        loggingPane.add(loginLabel);
        loggingPane.add(loginTextField);
        loggingPane.add(passwordLabel);
        loggingPane.add(passwordField);
        loggingPane.add(logInButton);


        paneIn.add(loggingPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object source = e.getKeyCode();
        if (source.equals(10)) {
            System.out.println("dupa");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
