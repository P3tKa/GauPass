package com.GauPass.components.OutputTab;

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

// change this button to be like close/min
public class ClipboardButton {
    public JButton createClipboardButton(String outputText) {
        JButton clipboardButton = new JButton();

        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.CLIPBOARD_ICON),
               40, 50);
        ImageIcon onClickIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(UI_icon_path.MINIMIZE_ICON),
                40, 50);

        clipboardButton.setIcon(mainIcon);
        new ChangeIconOnClick(clipboardButton, mainIcon, onClickIcon);
        new ChangeCursorOnHover(clipboardButton);

        clipboardButton.setContentAreaFilled(false);
        clipboardButton.setFocusPainted(false);
        clipboardButton.setBorderPainted(false);

        clipboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyToClipboard(outputText);
            }
        });

        return clipboardButton;
    }

    private static void copyToClipboard(String text) {
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new java.awt.datatransfer.StringSelection(text), null);
    }
}