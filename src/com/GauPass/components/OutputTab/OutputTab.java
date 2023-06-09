package com.GauPass.components.OutputTab;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
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

        return outputTab;
    }
}
