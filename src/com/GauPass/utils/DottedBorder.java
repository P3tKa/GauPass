package com.GauPass.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.AbstractBorder;

public class DottedBorder extends AbstractBorder {
    private Color color;
    private int thickness;

    public DottedBorder(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the color and stroke for the dotted line
        g2d.setColor(color);
        g2d.setStroke(
                new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[] { 1 }, 0));

        // Draw the dotted line
        g2d.drawRect(x, y, width - 1, height - 1);

        g2d.dispose();
    }
}