package com.GauPass.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnClick;
import com.GauPass.utils.IconSizeChanger;

// change this button to be like close/min
public class ClipboardButton {
    public JButton createClipboardButton() {
        JButton clipboardButton = new JButton();

        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.CLOSE_ICON), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onClickIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.MINIMIZE_ICON), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);

        clipboardButton.setIcon(mainIcon);
        new ChangeIconOnClick(clipboardButton, mainIcon, onClickIcon);
        new ChangeCursorOnHover(clipboardButton);

        clipboardButton.setBorder(BorderFactory.createEmptyBorder());

        clipboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyToClipboard("Tests");
            }
        });

        return clipboardButton;

    }

    private static void copyToClipboard(String text) {
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new java.awt.datatransfer.StringSelection(text), null);
    }
}