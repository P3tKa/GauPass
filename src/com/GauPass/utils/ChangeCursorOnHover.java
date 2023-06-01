package com.GauPass.utils;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeCursorOnHover {
    
    public ChangeCursorOnHover(Component c) {
        
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                c.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                c.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
}
