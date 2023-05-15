package com.GauPass.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChangeIconOnHover {

    public ChangeIconOnHover(JButton c, ImageIcon defaultIcon, ImageIcon hoverIcon) {
        
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                c.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                c.setIcon(defaultIcon);
            }
        });
    }
}
