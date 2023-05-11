package com.GauPass.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.ChangeClickedIcon;
import com.GauPass.utils.IconSizeChanger;

public class ClipboardButton {
    public JButton createClipboardButton() {
        ImageIcon defaultIcon = new ImageIcon(UI_icon_path.CLOSE_ICON);
        ImageIcon onHoverIcon = new ImageIcon(UI_icon_path.CLOSE_HOVER_ICON);
        ImageIcon onClickIcon = new ImageIcon(UI_icon_path.MINIMIZE_ICON);

        ImageIcon defaultIconFixedSize = new IconSizeChanger().ChangeIconSize(defaultIcon, UI_size.TITLE_BAR_ICON_WIDTH,
                UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onHoverIconFixedSize = new IconSizeChanger().ChangeIconSize(onHoverIcon, UI_size.TITLE_BAR_ICON_WIDTH,
                UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onClickIconFixedSize = new IconSizeChanger().ChangeIconSize(onClickIcon, UI_size.TITLE_BAR_ICON_WIDTH,
                UI_size.TITLE_BAR_ICON_HEIGHT);

        ChangeClickedIcon clipboardButton = new ChangeClickedIcon(defaultIconFixedSize,
                onHoverIconFixedSize, onClickIconFixedSize);

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