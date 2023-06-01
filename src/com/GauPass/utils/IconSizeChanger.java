package com.GauPass.utils;

import java.awt.Image;
import javax.swing.ImageIcon;

public class IconSizeChanger {
    
    public ImageIcon ChangeIconSize(ImageIcon icon, int width, int height) {
        Image newImg = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);

        return newIcon;
    }
}
