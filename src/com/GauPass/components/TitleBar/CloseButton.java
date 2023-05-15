package com.GauPass.components.TitleBar;

import com.GauPass.constants.*;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnHover;
import com.GauPass.utils.IconSizeChanger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class CloseButton {
    public JButton createCloseButton(JFrame frame) {
        JButton closeButton = new JButton();
        
        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.CLOSE_ICON), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onHoverIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.CLOSE_HOVER_ICON), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);

        closeButton.setIcon(mainIcon);

        new ChangeIconOnHover(closeButton, mainIcon, onHoverIcon);
        new ChangeCursorOnHover(closeButton);

        closeButton.setBorder(BorderFactory.createEmptyBorder());

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        return closeButton;
    }
}
