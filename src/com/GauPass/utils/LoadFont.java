package com.GauPass.utils;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LoadFont {
    private static Map<String, Font> fontMap = new HashMap<>();

    public static void loadFont(String fontPath) {
        if (!fontMap.containsKey(fontPath)) {
            try {
                /* Jar supported font loading */
                InputStream is = LoadFont.class.getResourceAsStream(fontPath);
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, is);
                fontMap.put(fontPath, customFont);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setFont(Component comp, String fontPath, float fontSize) {
        if (fontMap.containsKey(fontPath)) {
            Font customFont = fontMap.get(fontPath);
            comp.setFont(customFont.deriveFont(fontSize));
        } else {
            comp.setFont(new Font("SansSerif", Font.BOLD, (int) fontSize));
        }
    }
}
