package com.GauPass.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HoverButtonIcon extends JButton {

    ImageIcon defaultIcon;
    ImageIcon hoverIcon;

    public HoverButtonIcon(ImageIcon defaultIcon, ImageIcon hoverIcon) {
        super(defaultIcon);
        this.defaultIcon = defaultIcon;
        this.hoverIcon = hoverIcon;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(defaultIcon);
            }
        });
    }
}
