package com.GauPass.components.OutputTab;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnClick;
import com.GauPass.utils.ChangeIconOnHover;
import com.GauPass.utils.IconSizeChanger;

public class DeleteButton {
    public JButton createDeleteButton(ScrollableOutputArea scrollableOutputArea, Component passwordPanel) {
        JButton deleteButton = new JButton();

        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.DELETE_ICON),
                40, 50);
        ImageIcon onHover = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.DELETE_ICON_HOVER),
                40, 50);

        deleteButton.setIcon(mainIcon);
        new ChangeIconOnHover(deleteButton, mainIcon, onHover);
        new ChangeCursorOnHover(deleteButton);

        deleteButton.setContentAreaFilled(false);
        deleteButton.setFocusPainted(false);
        deleteButton.setBorderPainted(false);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollableOutputArea.removeComponent(passwordPanel);
            }
        });

        return deleteButton;
    }
}