package com.GauPass.utils;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoadFont {
    private static Map<String, Font> fontMap = new HashMap<>();

    public static void loadFont(String fontPath) {
        if (!fontMap.containsKey(fontPath)) {
            try {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
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
