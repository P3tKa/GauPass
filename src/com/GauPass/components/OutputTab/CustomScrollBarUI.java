package com.GauPass.components.OutputTab;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import com.GauPass.constants.UI_color;

import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {

    private Color thumbColor = UI_color.DEEP_LILAC;
    private Color trackColor = UI_color.MAUVE;

    @Override
    protected void configureScrollBarColors() {
        thumbColor = UI_color.DEEP_LILAC;
        trackColor = UI_color.MAUVE;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (!thumbBounds.isEmpty() && this.scrollbar.isEnabled()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(thumbColor);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 7, 7);
            g2.dispose();
        }
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        if (!trackBounds.isEmpty() && this.scrollbar.isEnabled()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(trackColor);
            g2.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, 0, 0);
            g2.dispose();
        }
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
    }
}
