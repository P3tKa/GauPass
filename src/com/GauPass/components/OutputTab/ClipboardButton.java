package com.GauPass.components.OutputTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnHover;
import com.GauPass.utils.IconSizeChanger;

public class ClipboardButton extends JButton {

    private static final int ICON_WIDTH = 35;
    private static final int ICON_HEIGHT = 40;

    private static final String MAIN_ICON_PATH = UI_icon_path.CLIPBOARD_ICON;
    private static final String HOVER_ICON_PATH = UI_icon_path.CLIPBOARD_ICON_HOVER;

    public ClipboardButton(String outputText) {

        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(MAIN_ICON_PATH),
               ICON_WIDTH, ICON_HEIGHT);
        ImageIcon onHover = new IconSizeChanger().ChangeIconSize(new ImageIcon(HOVER_ICON_PATH),
                ICON_WIDTH, ICON_HEIGHT);

        setIcon(mainIcon);
        new ChangeIconOnHover(this, mainIcon, onHover);
        new ChangeCursorOnHover(this);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyToClipboard(outputText);
            }
        });
    }

    private static void copyToClipboard(String text) {
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new java.awt.datatransfer.StringSelection(text), null);
    }
}