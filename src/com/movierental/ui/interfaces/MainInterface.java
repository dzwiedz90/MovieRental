package com.movierental.ui.interfaces;

import javax.swing.*;

import com.movierental.ui.UIWindowHandler;
import com.movierental.ui.interfaces.tabbedinterfaces.MovieDatabaseInterface;
import com.movierental.ui.interfaces.tabbedinterfaces.RentingMoviesCartInterface;
import com.movierental.ui.interfaces.tabbedinterfaces.RentingMoviesInterface;
import com.movierental.ui.interfaces.tabbedinterfaces.UsersEditingInterface;


public class MainInterface {
//    Kasowanie/Dodawanie do koszyka   |   Baza filmów(można wejść w filmy i edytować dane, dodawanie filmu w nowym oknie)   |   Wypozyczenia(z opcją
//    filtrowania np po przedawnieniach)   |   Uzytkownicy(dodawanie/archiwizowanie/edytowanie/filtracja)   |

    public MainInterface(JFrame mainFrameIn) {
        JTabbedPane tabbedPane = new JTabbedPane();

        RentingMoviesCartInterface cartInterfaceTab = new RentingMoviesCartInterface(tabbedPane);
        MovieDatabaseInterface movieDatabaseInterfaceTab = new MovieDatabaseInterface(tabbedPane);
        RentingMoviesInterface rentingMoviesInterfaceTab = new RentingMoviesInterface(tabbedPane);
        UsersEditingInterface usersEditingInterfaceTab = new UsersEditingInterface(tabbedPane);

        mainFrameIn.add(tabbedPane);
        UIWindowHandler.repaintWindow(mainFrameIn);
    }
}