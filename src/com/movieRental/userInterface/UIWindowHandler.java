package com.movieRental.userInterface;

import javax.swing.*;
import java.awt.*;

public class UIWindowHandler {
    public static void centerWindowOnScreen(JFrame window) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
    }
}
