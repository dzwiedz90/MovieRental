package com.movierental.ui.interfaces.tabbedinterfaces.renting;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import com.movierental.database.movie.MovieDataHandler;
import com.movierental.database.user.UserDataHandler;
import com.movierental.movies.Movie;
import com.movierental.ui.UIWindowHandler;
import com.movierental.users.User;


public class FillRightPane {
    JPanel bottomPanel;
    JPanel bottomBottomPanel;
    RentingMoviesCartInterface rentingMoviesCartInterface;
    User user;

    public FillRightPane(JPanel paneIn, RentingMoviesCartInterface rentingMoviesCartInterfaceIn) {
        this.rentingMoviesCartInterface = rentingMoviesCartInterfaceIn;
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
        bottomBottomPanel = new JPanel();
        JScrollPane bottomScrollPane = new JScrollPane(bottomBottomPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bottomBottomPanel.setLayout(new BoxLayout(bottomBottomPanel, BoxLayout.PAGE_AXIS));
        bottomBottomPanel.setBackground(Color.GREEN);
        bottomPanel.setBackground(Color.RED);

        JLabel label2 = new JLabel("Filmy w koszyku");

        bottomBottomPanel.add(label2);

        paneIn.add(bottomScrollPane);
    }

    public void addMovieToBottomPane(String movieIdIn) {
        Movie movieData = null;
        try {
            movieData = MovieDataHandler.getOneMovieData(movieIdIn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.PAGE_AXIS));
        assert movieData != null;
        JLabel movieIdLabel = new JLabel(movieData.getId());
        JLabel movieNameLabel = new JLabel(movieData.getName());
        JButton removeMovieButton = new JButton("Usuń");

        moviePanel.add(movieIdLabel);
        moviePanel.add(movieNameLabel);
        moviePanel.add(removeMovieButton);
        bottomBottomPanel.add(moviePanel);
        bottomBottomPanel.getTopLevelAncestor().validate();
        bottomBottomPanel.getTopLevelAncestor().repaint();
    }

    public void getUserData(String userIdIn) {
        DownloadUserDataFromDatabase fillPanelWithUserData = new DownloadUserDataFromDatabase(bottomPanel, userIdIn, rentingMoviesCartInterface);
        UIWindowHandler.repaintWindow(bottomPanel);
        bottomPanel.getTopLevelAncestor().validate();
        user = fillPanelWithUserData.getUser();
    }
}
