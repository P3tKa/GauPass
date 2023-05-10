package com.GauPass.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSizeCalculator {
    public static Dimension calculateScreenSize(double widthPercentage, double heightPercentage) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        int width = (int) (screenSize.width * widthPercentage);
        int height = (int) (screenSize.height * heightPercentage);

        return new Dimension(width, height);
    }
}