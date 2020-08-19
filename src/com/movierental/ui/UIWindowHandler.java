package com.movierental.ui;

import javax.swing.*;
import java.awt.*;

public class UIWindowHandler {
    public static void centerWindowOnScreen(JFrame windowIn) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        windowIn.setLocation(dim.width / 2 - windowIn.getSize().width / 2, dim.height / 2 - windowIn.getSize().height / 2);
    }

    public static void clearWindow() {

    }

    public static void refreshWindow() {

    }

    public static void destroyWindow(JPanel panelToDestroyPanelIn, JFrame mainWindowIn) {
        panelToDestroyPanelIn.remove(panelToDestroyPanelIn);
        MainWindow.repaintMainWindow(mainWindowIn);
    }
}
