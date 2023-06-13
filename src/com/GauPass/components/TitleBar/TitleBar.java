package com.GauPass.components.TitleBar;

import javax.swing.*;

import com.GauPass.constants.*;
import com.GauPass.utils.LoadFont;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitleBar {
    private Point mouseDownCompCoords = null;
    private final int TITLE_BAR_WIDTH = 75;
    private final int TITLE_PADDING = 10;
    private final float TITLE_SIZE = 50f;

    public JPanel createTitleBar(JFrame frame) {
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setPreferredSize(new Dimension(frame.getWidth(), TITLE_BAR_WIDTH));
        titleBar.setBackground(UI_color.DEEP_LILAC);
        titleBar.setBorder(BorderFactory.createMatteBorder(0, 0, UI_size.APP_BORDER_THICKNESS, 0, UI_color.BLACK));

        addTitleBarDrag(frame, titleBar);
        addApplicationButtons(frame, titleBar);
        addTitleLabel(titleBar);


        return titleBar;
    }

    private void addApplicationButtons(JFrame frame, JPanel titleBar) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        buttonPanel.add(new MinimizeButton(frame));
        buttonPanel.add(new CloseButton(frame));

        titleBar.add(buttonPanel, BorderLayout.EAST);
    }

    private void addTitleBarDrag(JFrame frame, JPanel titleBar) {
        titleBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
        });
        titleBar.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentCoords = e.getLocationOnScreen();
                frame.setLocation(currentCoords.x - mouseDownCompCoords.x, currentCoords.y - mouseDownCompCoords.y);
            }
        });

    }

    private void addTitleLabel(JPanel titleBar) {
        JLabel titleLabel = new JLabel(UI_locale.TITLE_BAR_HEADER);
        titleLabel.setForeground(UI_color.BLACK);
        LoadFont.setFont(titleLabel, UI_font_path.RUSSOONE_REGULAR, TITLE_SIZE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, TITLE_PADDING, 0, 0));

        titleBar.add(titleLabel);
    }
}
