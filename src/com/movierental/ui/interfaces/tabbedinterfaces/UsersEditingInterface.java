package com.movierental.ui.interfaces.tabbedinterfaces;

import javax.swing.*;

public class UsersEditingInterface {

    public UsersEditingInterface(JTabbedPane tabbedPaneIn){
        addUsersEditingTab(tabbedPaneIn);
    }

    private void addUsersEditingTab(JTabbedPane tabbedPaneIn){
        JPanel userEditingPane = new JPanel();
        tabbedPaneIn.add(userEditingPane, "Użytkownicy");
    }
}
