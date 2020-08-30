package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import com.movierental.ui.UIWindowHandler;

import javax.swing.*;
import java.awt.*;

public class FillRightPane {
    String getUserIdTextFieldValue;
    JPanel bottomPanel;

    public FillRightPane(JPanel paneIn, String getUserIdTextFieldValueIn, FillLeftPane leftPane) {
        this.getUserIdTextFieldValue = getUserIdTextFieldValueIn;
        JPanel mainRightPane = new JPanel();
        mainRightPane.setLayout(new BoxLayout(mainRightPane, BoxLayout.PAGE_AXIS));

        fillRightTopPane(mainRightPane);
        fillRightBottomPane(mainRightPane);

        paneIn.add(mainRightPane);
    }

    private void fillRightTopPane(JPanel paneIn) {
        // Create main pane that will hold rest of panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        // Create panel that will be at top with label describing
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.GREEN);
        JLabel label1 = new JLabel("Dane użytkownika");
        topPanel.add(label1);
        mainPanel.add(topPanel);

        // Get user data from database and put it into panel
        bottomPanel = new JPanel();

        paneIn.add(mainPanel);
    }

    private void fillRightBottomPane(JPanel paneIn) {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.RED);

        JLabel label2 = new JLabel("dupa2");

        bottomPanel.add(label2);
        paneIn.add(bottomPanel);
    }

    public void getUserData(){
        DownloadUserDataFromDatabase fillPanelWithUserData = new DownloadUserDataFromDatabase(bottomPanel, getUserIdTextFieldValue);
        UIWindowHandler.repaintWindow(bottomPanel);
    }

}
