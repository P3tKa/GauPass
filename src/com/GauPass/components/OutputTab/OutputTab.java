package com.GauPass.components.OutputTab;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.GauPass.constants.UI_color;

public class OutputTab {
    private JTextArea outputTextArea;

    public OutputTab() {
        outputTextArea = new JTextArea("");
    }

    public void setOutputTextArea(String input) {
        outputTextArea.setText(input);
    }

    public JPanel createOutputTab() {
        JPanel outputTab = new JPanel(new BorderLayout());
        outputTab.setBackground(UI_color.MAUVE);

        outputTextArea.setEditable(false);
        outputTextArea.setBorder(BorderFactory.createEmptyBorder(75, 10, 0, 5));
        outputTextArea.setBackground(UI_color.MAUVE);
        outputTab.add(outputTextArea, BorderLayout.CENTER);

        JPanel clipboardButtonContainer = createClipboardButtonContainer(outputTextArea);
        clipboardButtonContainer.setBackground(UI_color.MAUVE);
        outputTab.add(clipboardButtonContainer, BorderLayout.PAGE_END);

        return outputTab;
    }

    private JPanel createClipboardButtonContainer(JTextArea outputTextArea) {

        // Create a panel with FlowLayout for right alignment
        JPanel clipboardButtonContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        clipboardButtonContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, -10, -10));
        JButton clipboardButton = new ClipboardButton().createClipboardButton(outputTextArea);
        clipboardButtonContainer.add(clipboardButton);
        return clipboardButtonContainer;
    }
}
