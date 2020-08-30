package com.movierental.ui.interfaces.tabbedinterfaces;

import javax.swing.*;

public class CustomersEditingInterface {

    public CustomersEditingInterface(JTabbedPane tabbedPaneIn) {
        JPanel customersMainPane = new JPanel();
        tabbedPaneIn.add(customersMainPane, "Klienci");
    }
}
