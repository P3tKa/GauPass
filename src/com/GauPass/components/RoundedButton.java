package com.GauPass.components;

import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton {

    private int arcWidht;
    private int archHeight;
    private Color onClickColor;

    public RoundedButton(String label, int arcWidht, int archHeight, Color onClickColor) {
        super(label);

        this.arcWidht = arcWidht;
        this.archHeight = archHeight;
        this.onClickColor = onClickColor;

        setContentAreaFilled(false);
        setFocusable(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(onClickColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, arcWidht, archHeight);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getSize().width-1, getSize().height-1, arcWidht, archHeight);
    }
}

