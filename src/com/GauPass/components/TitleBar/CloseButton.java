package com.GauPass.components.TitleBar;

import com.GauPass.constants.*;
import com.GauPass.utils.HoverButtonIcon;
import com.GauPass.utils.IconSizeChanger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class CloseButton {
    public JButton createCloseButton(JFrame frame) {
        ImageIcon defaultIcon = new ImageIcon(UI_icon_path.CLOSE_ICON);
        ImageIcon hoverIcon = new ImageIcon(UI_icon_path.CLOSE_HOVER_ICON);
        
        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(defaultIcon, UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onHoverIcon = new IconSizeChanger().ChangeIconSize(hoverIcon, UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);

        HoverButtonIcon closeButton = new HoverButtonIcon(mainIcon, onHoverIcon);

        closeButton.setBorder(BorderFactory.createEmptyBorder());

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        return closeButton;
    }
}
