package com.GauPass.utils;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class LoadFont {
    private Font customFont = null;
    
    public LoadFont(Component comp, String fontPath, float fontSize) {

        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        if (customFont != null) {
            comp.setFont(customFont);
        } else {
            comp.setFont(new Font("SansSerif", Font.BOLD, (int) fontSize));
        }
    }
    
}
