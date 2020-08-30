package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import com.movierental.database.movie.MovieDataHandler;
import com.movierental.database.user.UserDataHandler;
import com.movierental.users.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class DownloadUserDataFromDatabase {
    private User userData;
    String id;

    public DownloadUserDataFromDatabase(JPanel paneIn, String idIn) {
        this.id = idIn;
        getUserData();
        fillPaneWithUserData(paneIn);
    }

    private void getUserData() {
        try {
            userData = UserDataHandler.getUserData(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillPaneWithUserData(JPanel paneIn) {
        paneIn.setLayout(new BoxLayout(paneIn, BoxLayout.PAGE_AXIS));

        JPanel nameSurnamePane = new JPanel();
        JLabel idLabel = new JLabel(userData.getId());
        JLabel nameLabel = new JLabel(userData.getName());
        JLabel surnameLabel = new JLabel(userData.getSurname());
        nameSurnamePane.add(idLabel);
        nameSurnamePane.add(nameLabel);
        nameSurnamePane.add(surnameLabel);

        JPanel phonePane = new JPanel();
        JLabel phoneLabel = new JLabel(userData.getPhone());
        phonePane.add(phoneLabel);

        JPanel addressPane = new JPanel();
        JLabel addressLabel = new JLabel(userData.getAddress());
        JLabel cityLabel = new JLabel(userData.getCity());
        addressPane.add(addressLabel);
        addressPane.add(cityLabel);

        JPanel buttonPanel = new JPanel();
        JButton removeUserButton = new JButton("Usuń klienta");
        buttonPanel.add(removeUserButton);

        paneIn.add(nameSurnamePane);
        paneIn.add(phonePane);
        paneIn.add(addressPane);
        paneIn.add(buttonPanel);
    }
}
