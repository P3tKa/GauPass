package com.GauPass.components.OutputTab;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnHover;
import com.GauPass.utils.IconSizeChanger;

public class DeleteButton extends JButton {

    private static final int ICON_WIDTH = 35;
    private static final int ICON_HEIGHT = 40;

    public DeleteButton(ScrollableOutputArea scrollableOutputArea, JPanel passwordPanel) {

        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.DELETE_ICON),
                 ICON_WIDTH, ICON_HEIGHT);
        ImageIcon onHover = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.DELETE_ICON_HOVER),
                 ICON_WIDTH, ICON_HEIGHT);

        setIcon(mainIcon);
        new ChangeIconOnHover(this, mainIcon, onHover);
        new ChangeCursorOnHover(this);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollableOutputArea.removeComponent(passwordPanel);
            }
        });
    }
}