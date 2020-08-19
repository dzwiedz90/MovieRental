package com.movierental.ui.login;

import com.movierental.ui.UIWindowHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginWindow implements ActionListener, KeyListener, Runnable {
    // Creates fields to enter credentials
    private JTextField loginTextField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private boolean isUserDataCorrect;
    private JPanel pane;
    private JFrame mainFrame;

    /**
     * Class that creates pane with login and password fields and logIn button used to log into the main application.
     *
     * @param paneIn JPanel provided by calling class in which login, password fields and logIn button will be placed.
     */
    public LoginWindow(JPanel paneIn, JFrame mainFrameIn) {
        this.pane = paneIn;
        this.mainFrame = mainFrameIn;

        // Creates JPanel in which login, password fields and logIn button will be placed. This panel will be placed in panel from argument
        JPanel loggingPane = new JPanel();
        loggingPane.setBorder(new EmptyBorder(250, 0, 0, 0));

        // Creates field to enter login and its label and adds listeners
        loginTextField = new JTextField(20);
        loginTextField.addKeyListener(this);
        JLabel loginLabel = new JLabel("Login: ");
        loginLabel.setLabelFor(loginTextField);

        // Creates field to enter password and its label and adds listeners
        passwordField = new JPasswordField(20);
        passwordField.addKeyListener(this);
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setLabelFor(passwordField);

        // Creates logIn button and adds listeners
        logInButton = new JButton("Log in");
        logInButton.addKeyListener(this);
        logInButton.addActionListener(this);


        loggingPane.add(loginLabel);
        loggingPane.add(loginTextField);
        loggingPane.add(passwordLabel);
        loggingPane.add(passwordField);
        loggingPane.add(logInButton);


        pane.add(loggingPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == logInButton) {
            String[] dataFromUserAndPasswordFields = this.getDataFromUserAndPasswordFields();
            isUserDataCorrect = CheckUserCredentials.handleUserData(dataFromUserAndPasswordFields);
            System.out.println(isUserDataCorrect);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object source = e.getKeyCode();
        if (source.equals(10)) {
            String[] dataFromUserAndPasswordFields = this.getDataFromUserAndPasswordFields();
            isUserDataCorrect = CheckUserCredentials.handleUserData(dataFromUserAndPasswordFields);
            System.out.println(isUserDataCorrect);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * This method gets data entered from login, password fields
     *
     * @return Returns String[] array filled with username and password from fields
     */
    private String[] getDataFromUserAndPasswordFields() {
        String[] dataFromUserAndPasswordFields = new String[2];
        dataFromUserAndPasswordFields[0] = loginTextField.getText();
        dataFromUserAndPasswordFields[1] = String.valueOf(passwordField.getPassword());
        return dataFromUserAndPasswordFields;
    }

    @Override
    public void run() {
        while (true) {
            if(isUserDataCorrect) UIWindowHandler.destroyWindow(pane, mainFrame);
        }
    }
}
