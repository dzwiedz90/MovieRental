package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import com.movierental.ui.UIWindowHandler;

import javax.swing.*;
import java.awt.*;

public class FillRightPane {
    JPanel bottomPanel;

    public FillRightPane(JPanel paneIn) {
        JPanel mainRightPane = new JPanel();
        UIWindowHandler.setBorder(mainRightPane);
        mainRightPane.setLayout(new BoxLayout(mainRightPane, BoxLayout.PAGE_AXIS));

        fillRightTopPane(mainRightPane);
        fillRightBottomPane(mainRightPane);

        paneIn.add(mainRightPane);
    }

    private void fillRightTopPane(JPanel paneIn) {
        // Create main pane that will hold rest of panels
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        // Create panel that will be at top with label describing
        JPanel topPanel = new JPanel();
        JLabel label1 = new JLabel("Dane użytkownika");
        UIWindowHandler.setBorder(label1);
        topPanel.add(label1);
        mainPanel.add(topPanel);

        // Get user data from database and put it into panel
        bottomPanel = new JPanel();
        mainPanel.add(bottomPanel);

        paneIn.add(mainPanel);
    }

    private void fillRightBottomPane(JPanel paneIn) {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.RED);

        JLabel label2 = new JLabel("bottom panel");

        bottomPanel.add(label2);
        paneIn.add(bottomPanel);
    }

    public void getUserData(String userId){
        DownloadUserDataFromDatabase fillPanelWithUserData = new DownloadUserDataFromDatabase(bottomPanel, userId);
        UIWindowHandler.repaintWindow(bottomPanel);
        bottomPanel.getTopLevelAncestor().validate();
    }

}
