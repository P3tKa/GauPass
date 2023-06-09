package com.GauPass.components.OutputTab;

import javax.swing.JLabel;
import java.awt.Graphics;

public class MaxLengthLabel extends JLabel {
    private int maxLength;

    public MaxLengthLabel(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String text = getText();
        if (text.length() > maxLength) {
            text = text.substring(0, maxLength) + "...";
        }
        super.setText(text);
        super.paintComponent(g);
    }
}
