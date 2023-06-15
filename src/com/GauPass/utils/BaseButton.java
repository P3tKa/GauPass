package com.GauPass.utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BaseButton extends JButton {

    public BaseButton(String mainIconPath, String hoverIconpath, int width, int height) {
        
        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(mainIconPath), width, height);
        ImageIcon onHoverIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(hoverIconpath), width, height);

        setIcon(mainIcon);

        new ChangeIconOnHover(this, mainIcon, onHoverIcon);
        new ChangeCursorOnHover(this);
    }
    
}
