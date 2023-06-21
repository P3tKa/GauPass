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
    private JPanel passwordContainer;
    private JTextArea outputPassword;

    private static PasswordRowBlock coloredBlock;

    public PasswordRowBlock(PasswordGenerator gen, ScrollableOutputArea scrollableOutputArea) {

        this.gen = gen;
        this.scrollableOutputArea = scrollableOutputArea;

        setBorder(new MatteBorder(0, 0, UI_size.APP_BORDER_THICKNESS, 0, UI_color.BLACK));
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
        CustomEvent copy = () -> ctc.copy();
        CustomEvent changeBackgroundColor = () -> changePasswordContainerColor();
        ClipboardButton clipboardButton = new ClipboardButton(copy, changeBackgroundColor);

        return clipboardButton;
    }

    public JButton createDeleteButton() {
        CustomEvent customEvent = () -> scrollableOutputArea.removeComponent(this);
        DeleteButton deleteButton = new DeleteButton(customEvent);

        return deleteButton;
    }

    public JPanel createPasswordPanel() {
        passwordContainer = new JPanel(new GridBagLayout());
        passwordContainer.setBackground(UI_color.MAUVE);
        passwordContainer.setBorder(new MatteBorder(0, 0, 0, UI_size.APP_BORDER_THICKNESS, UI_color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        passwordContainer.add(createOutputPassword(), gbc);

        return passwordContainer;
    }

    public void changePasswordContainerColor() {
        if (coloredBlock != null) {
            coloredBlock.resetPasswordContainerColor();
        }
        passwordContainer.setBackground(UI_color.ELECTRIC_BLUE);
        outputPassword.setBackground(UI_color.ELECTRIC_BLUE);
        coloredBlock = this;
    }

    public void resetPasswordContainerColor() {
        passwordContainer.setBackground(UI_color.MAUVE);
        outputPassword.setBackground(UI_color.MAUVE);
    }

    public void resetColoredBlock() {
        if (this == coloredBlock) {
            coloredBlock = null;
        }
    }

    public JTextArea createOutputPassword() {
        outputPassword = new JTextArea(gen.getPassword());

        outputPassword.setEditable(false);
        outputPassword.setLineWrap(true);
        outputPassword.setBackground(UI_color.MAUVE);
        outputPassword.setBorder(new EmptyBorder(0, 5, 0, 5));

        return outputPassword;
    }
}
