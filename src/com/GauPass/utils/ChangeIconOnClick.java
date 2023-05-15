package com.GauPass.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChangeIconOnClick {

    public ChangeIconOnClick(JButton c, ImageIcon defaultIcon, ImageIcon onClickIcon) {

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                c.setIcon(onClickIcon);
            }
      
            @Override
            public void mouseReleased(MouseEvent e) {
                c.setIcon(defaultIcon);
            }
        });
    }
}
