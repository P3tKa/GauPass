package com.GauPass.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeForegroundOnPress {

    private Color foreground;
    
    public ChangeForegroundOnPress(Component c, Color color) {
        foreground = c.getForeground();

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                c.setForeground(color);
            }
      
            @Override
            public void mouseReleased(MouseEvent e) {

                c.setForeground(foreground);
            }
        });
    }
}
