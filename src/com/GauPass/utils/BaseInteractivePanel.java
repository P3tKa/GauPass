package com.GauPass.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_size;

public abstract class BaseInteractivePanel extends JPanel {

    protected BufferedImage defaultImage;
    protected BufferedImage hoverImage;
    protected BufferedImage onClickImage;

    protected boolean mousePressed;
    protected boolean isHovered;

    private final Color BORDER_COLOR = UI_color.PALATINATE_PURPLE;
    private final Color BASE_COLOR = UI_color.BLACK;

    private final int BORDER_SIZE = UI_size.APP_BORDER_THICKNESS;

    protected JLabel textLabel = new JLabel();

    public BaseInteractivePanel(String text, String fontPath, float fontSize, int height) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER_SIZE));

        addTextLabel(text, fontPath, fontSize);
        addListeners();
        new ChangeCursorOnHover(this);
        setPreferredSize(new Dimension(getPreferredSize().width, height));
    }

    private void addListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
                onMousePressed();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                onMouseReleased();
                repaint();
            }
        });
    }

    private void addTextLabel(String text, String fontPath, float fontSize) {
        textLabel.setText(text);
        textLabel.setForeground(BASE_COLOR);
        LoadFont.setFont(textLabel, fontPath, fontSize);
        add(textLabel);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;

        add(textLabel, c);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (mousePressed && onClickImage != null) {
            g.drawImage(onClickImage, 0, 0, getWidth(), getHeight(), null);
        } else if (isHovered) {
            g.drawImage(hoverImage, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.drawImage(defaultImage, 0, 0, getWidth(), getHeight(), null);
        }
    }

    protected abstract void onMousePressed();

    protected abstract void onMouseReleased();
}

