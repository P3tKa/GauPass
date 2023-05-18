package com.GauPass.components.SettingsTab;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CustomSliderUI extends BasicSliderUI {

    private ImageIcon thumbIcon;
    private Color leftColor;
    private Color rightColor;
    private static final int BORDER_THICKNESS = 2;

    public CustomSliderUI(JSlider slider, ImageIcon thumbIcon, Color leftColor, Color rightColor) {
        super(slider);
        this.thumbIcon = thumbIcon;
        this.leftColor = leftColor;
        this.rightColor = rightColor;
        
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider.repaint();
            }
        });
        
        slider.setFocusable(false);
    }

    @Override
    public void paintThumb(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle thumbBounds = thumbRect;

        // g2d.setColor(Color.BLACK);
        // g2d.setStroke(new BasicStroke(5));
        // g2d.draw(thumbBounds);

        if (thumbIcon != null) {
            int x = thumbBounds.x + (thumbBounds.width - thumbIcon.getIconWidth()) / 2;
            int y = thumbBounds.y + (thumbBounds.height - thumbIcon.getIconHeight()) / 2;
            thumbIcon.paintIcon(slider, g, x, y);
        } else {
            super.paintThumb(g);
        }
    }
    
    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle trackBounds = trackRect;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(BORDER_THICKNESS));
        g2d.draw(trackBounds);

        Rectangle2D leftTrack = new Rectangle2D.Double(trackRect.x, trackRect.y,
                thumbRect.x - trackRect.x, trackRect.height);
        Rectangle2D rightTrack = new Rectangle2D.Double(thumbRect.x + thumbRect.width, trackRect.y,
                trackRect.x + trackRect.width - (thumbRect.x + thumbRect.width), trackRect.height);

        g2d.setPaint(leftColor);
        g2d.fill(leftTrack);
        g2d.setPaint(rightColor);
        g2d.fill(rightTrack);

    }
}
