package com.movierental.ui.interfaces;

import javax.swing.*;

import com.movierental.ui.UIWindowHandler;
import com.movierental.ui.interfaces.tabbedinterfaces.customers.CustomersEditingInterface;
import com.movierental.ui.interfaces.tabbedinterfaces.movies.MovieDatabaseInterface;
import com.movierental.ui.interfaces.tabbedinterfaces.renting.RentingMoviesCartInterface;
import com.movierental.ui.interfaces.tabbedinterfaces.rented.RentedMoviesInterface;
import com.movierental.ui.interfaces.tabbedinterfaces.users.UsersEditingInterface;


public class MainInterface {
//    Kasowanie/Dodawanie do koszyka   |   Baza filmów(można wejść w filmy i edytować dane, dodawanie filmu w nowym oknie)   |   Wypozyczenia(z opcją
//    filtrowania np po przedawnieniach)   |   Uzytkownicy(dodawanie/archiwizowanie/edytowanie/filtracja)   |

    public MainInterface(JFrame mainFrameIn) {
        JTabbedPane tabbedPane = new JTabbedPane();

        RentingMoviesCartInterface cartInterfaceTab = new RentingMoviesCartInterface(tabbedPane);
        MovieDatabaseInterface movieDatabaseInterfaceTab = new MovieDatabaseInterface(tabbedPane);
        RentedMoviesInterface rentedMoviesInterfaceTab = new RentedMoviesInterface(tabbedPane);
        UsersEditingInterface usersEditingInterfaceTab = new UsersEditingInterface(tabbedPane);
        CustomersEditingInterface customersEditingInterfaceTab = new CustomersEditingInterface(tabbedPane);

        mainFrameIn.add(tabbedPane);
        UIWindowHandler.repaintWindow(mainFrameIn);
    }
}