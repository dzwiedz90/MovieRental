package com.movierental.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
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

    public static void destroyWindow(JPanel childComponentToDestroyIn, JFrame parentComponentIn) {
        parentComponentIn.remove(childComponentToDestroyIn);
        repaintWindow(parentComponentIn);
    }

    public static void destroyWindow(JPanel childComponentToDestroyIn, JPanel parentComponentIn) {
        parentComponentIn.remove(childComponentToDestroyIn);
        repaintWindow(parentComponentIn);
    }

    public static void repaintWindow(JFrame componentIn) {
        componentIn.validate();
        componentIn.repaint();
    }

    public static void repaintWindow(JPanel componentIn) {
        componentIn.validate();
        componentIn.repaint();
    }

    public static void repaintWindow(JTabbedPane componentIn) {
        componentIn.validate();
        componentIn.repaint();
    }

    public static void setBorder(JPanel panelIn) {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panelIn.setBorder(blackline);
    }

    public static void setBorder(JLabel labelIn) {
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        labelIn.setBorder(border);
    }
}
