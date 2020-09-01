package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import com.movierental.database.movie.MovieDataHandler;
import com.movierental.database.user.UserDataHandler;
import com.movierental.movies.Movie;
import com.movierental.ui.UIWindowHandler;
import com.movierental.users.User;


public class DownloadUserDataFromDatabase implements ActionListener {
    private User userData;
    private ArrayList<Movie> rentedMovieData;
    String userId;
    private JPanel parentPane;
    private JButton removeUserButton;
    RentingMoviesCartInterface rentingMoviesCartInterface;

    public DownloadUserDataFromDatabase(JPanel paneIn, String userIdIn, RentingMoviesCartInterface rentingMoviesCartInterfaceIn) {
        this.rentingMoviesCartInterface = rentingMoviesCartInterfaceIn;
        this.userId = userIdIn;
        this.parentPane = paneIn;
        getUserData();
        getUserRentedMovies();
        fillPaneWithUserData(paneIn);
    }

    private void getUserData() {
        try {
            userData = UserDataHandler.getUserData(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getUserRentedMovies() {
        try {
            rentedMovieData = MovieDataHandler.getRentedMoviesDataByCustomer(userId);
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

        JPanel rentedMoviesPane = new JPanel();
        rentedMoviesPane.setLayout(new BoxLayout(rentedMoviesPane, BoxLayout.PAGE_AXIS));
        JPanel rentedLabelPanel = new JPanel();
        JLabel label1 = new JLabel("Wypożyczone filmy:");
        UIWindowHandler.setBorder(label1);
        rentedLabelPanel.setBorder(new EmptyBorder(25, 0, 0, 0));
        rentedLabelPanel.add(label1);
        rentedMoviesPane.add(rentedLabelPanel);
        int i = 0;
        for (Movie movie : rentedMovieData) {
            if (i <= 4) {
                JPanel moviePanel = new JPanel();
                JLabel movieIdLabel = new JLabel(movie.getId());
                JLabel movieNameLabel = new JLabel(movie.getName());
                moviePanel.add(movieIdLabel);
                moviePanel.add(movieNameLabel);
                rentedMoviesPane.add(moviePanel);
            } else {
                JPanel dottedLabelPane = new JPanel();
                JLabel dottedLabel = new JLabel("...");
                dottedLabelPane.add(dottedLabel);
                rentedMoviesPane.add(dottedLabelPane);
            }
            i++;
        }

        JPanel buttonPanel = new JPanel();
        removeUserButton = new JButton("Usuń klienta");
        removeUserButton.addActionListener(this);
        buttonPanel.add(removeUserButton);

        paneIn.add(nameSurnamePane);
        paneIn.add(phonePane);
        paneIn.add(addressPane);
        paneIn.add(rentedMoviesPane);
        paneIn.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == removeUserButton){
            parentPane.removeAll();
            rentingMoviesCartInterface.enableAddUserButtonFromFillLeftPaneClass();
        }
    }
}
