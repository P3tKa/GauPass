package com.GauPass.components.TitleBar;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.HoverButtonIcon;
import com.GauPass.utils.IconSizeChanger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MinimizeButton {

    public JButton createMinimizeButton(JFrame frame) {
        ImageIcon defaultIcon = new ImageIcon(UI_icon_path.MINIMIZE_ICON);
        ImageIcon hoverIcon = new ImageIcon(UI_icon_path.MINIMIZE_HOVER_ICON);
        
        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(defaultIcon, UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onHoverIcon = new IconSizeChanger().ChangeIconSize(hoverIcon, UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);

        HoverButtonIcon minimizeButton = new HoverButtonIcon(mainIcon, onHoverIcon);

        minimizeButton.setBorder(BorderFactory.createEmptyBorder());

        minimizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });
        return minimizeButton;
    }

}
