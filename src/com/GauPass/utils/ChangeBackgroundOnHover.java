package com.GauPass.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeBackgroundOnHover {

    Color mainColor;
    
    public ChangeBackgroundOnHover(Component c, Color hoverColor) {
        mainColor = c.getBackground();
        
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                c.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                c.setBackground(mainColor);
            }
        });
    }
}
