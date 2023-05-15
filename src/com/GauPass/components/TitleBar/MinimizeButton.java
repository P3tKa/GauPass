package com.GauPass.components.TitleBar;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnHover;
import com.GauPass.utils.IconSizeChanger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MinimizeButton {

    public JButton createMinimizeButton(JFrame frame) {
        JButton minimizeButton = new JButton();
        
        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.MINIMIZE_ICON), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onHoverIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.MINIMIZE_HOVER_ICON), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);

        minimizeButton.setIcon(mainIcon);

        new ChangeIconOnHover(minimizeButton, mainIcon, onHoverIcon);
        new ChangeCursorOnHover(minimizeButton);

        minimizeButton.setBorder(BorderFactory.createEmptyBorder());

        minimizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });
        return minimizeButton;
    }

}
