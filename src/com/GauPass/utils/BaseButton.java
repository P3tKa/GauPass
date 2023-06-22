package com.GauPass.utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BaseButton extends JButton {

    public BaseButton(String mainIconPath, String hoverIconpath, int width, int height) {

        ImageIcon mainIcon = new ImageIcon(getClass().getResource(mainIconPath));
        ImageIcon onHoverIcon = new ImageIcon(getClass().getResource(hoverIconpath));

        /* Resize the icons if necessary */
        mainIcon = new IconSizeChanger().ChangeIconSize(mainIcon, width, height);
        onHoverIcon = new IconSizeChanger().ChangeIconSize(onHoverIcon, width, height);

        setIcon(mainIcon);

        new ChangeIconOnHover(this, mainIcon, onHoverIcon);
        new ChangeCursorOnHover(this);
    }

}
