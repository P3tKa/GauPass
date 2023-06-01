package com.GauPass.components.OutputTab;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

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

        // /* Add scrollable Output Area */
        // ScrollableOutputArea scrollableOutputArea = new ScrollableOutputArea();
        // scrollableOutputArea.setLayout(new BoxLayout(scrollableOutputArea,
        // BoxLayout.Y_AXIS));
        // for (int i = 0; i < 20; i++) {
        // JLabel label = new JLabel("Label " + (i + 1));
        // scrollableOutputArea.addComponent(label);
        // }

        // outputTab.add(scrollableOutputArea);
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
