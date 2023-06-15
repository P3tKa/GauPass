package com.GauPass.components.OutputTab;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.GauPass.PasswordGenerator;
import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.CopyToClipboard;
import com.GauPass.utils.CustomEvent;

public class PasswordRowBlock extends JPanel {

    private PasswordGenerator gen;
    private ScrollableOutputArea scrollableOutputArea;
    private boolean borderVisible;
    
    public PasswordRowBlock(PasswordGenerator gen, ScrollableOutputArea scrollableOutputArea) {
        
        this.gen = gen;
        this.scrollableOutputArea = scrollableOutputArea;
        this.borderVisible = true;

        updateBorder();
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;


        add(createPasswordPanel(), gbc);
        add(createButtonPanel());
    }

    public JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(UI_color.MAUVE);

        buttonPanel.add(createClipboardButton());
        buttonPanel.add(createDeleteButton());

        return buttonPanel;
    }

    public JButton createClipboardButton() {
        CopyToClipboard ctc = new CopyToClipboard(gen.getPassword());
        CustomEvent customEvent = () -> ctc.copy();
        ClipboardButton clipboardButton = new ClipboardButton(customEvent);
        
        return clipboardButton;
    }

    public JButton createDeleteButton() {
        CustomEvent customEvent = () -> scrollableOutputArea.removeComponent(this);
        DeleteButton deleteButton = new DeleteButton(customEvent);
        
        return deleteButton;
    }

    public JPanel createPasswordPanel() {
        JPanel passwordContainer = new JPanel(new GridBagLayout());
        passwordContainer.setBackground(UI_color.MAUVE);
        passwordContainer.setBorder(new MatteBorder(0, 0, 0, UI_size.APP_BORDER_THICKNESS, UI_color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        passwordContainer.add(createOutputPassword(), gbc);

        return passwordContainer;
    }

    public JTextArea createOutputPassword() {
        JTextArea outputPassword = new JTextArea(gen.getPassword());

        outputPassword.setEditable(false);
        outputPassword.setLineWrap(true);
        outputPassword.setBackground(UI_color.MAUVE);
        outputPassword.setBorder(new EmptyBorder(0, 5, 0, 5));

        return outputPassword;
    }

    public void setBorderVisible(boolean visible) {
        this.borderVisible = visible;
        updateBorder();
    }

    private void updateBorder() {
        if (borderVisible) {
            setBorder(new MatteBorder(0, 0, UI_size.APP_BORDER_THICKNESS, 0, UI_color.BLACK));
        } else {
            setBorder(null);
        }
    }

}
