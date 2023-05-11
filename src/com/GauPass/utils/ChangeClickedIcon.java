package com.GauPass.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChangeClickedIcon extends JButton {

    public ChangeClickedIcon(ImageIcon defaultIcon, ImageIcon onHoverIcon, ImageIcon onClickIcon) {
        super(defaultIcon);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
                setIcon(onClickIcon);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(onHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(defaultIcon);
            }
        });
    }
}
