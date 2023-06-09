package com.GauPass.components.OutputTab;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnClick;
import com.GauPass.utils.IconSizeChanger;

public class DeleteButton {
    public JButton createDeleteButton(ScrollableOutputArea scrollableOutputArea, Component passwordPanel) {
        JButton deleteButton = new JButton();

        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.DELETE_ICON),
                UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onClickIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.MINIMIZE_ICON),
                UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);

        deleteButton.setIcon(mainIcon);
        new ChangeIconOnClick(deleteButton, mainIcon, onClickIcon);
        new ChangeCursorOnHover(deleteButton);

        deleteButton.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(UI_size.APP_BORDER_THICKNESS, UI_size.APP_BORDER_THICKNESS,
                        0, 0, UI_color.BLACK),
                new EmptyBorder(10, 10, 10, 10)));

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollableOutputArea.removeComponent(passwordPanel);
            }
        });

        return deleteButton;
    }
}