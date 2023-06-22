package com.GauPass.components.OutputTab;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_size;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScrollableOutputArea extends JPanel {

    private JScrollPane scrollPane;
    private JPanel contentPanel;
    private List<PasswordRowBlock> blockArray = new ArrayList<>();
    private JScrollBar verticalScrollbar;

    private final static int SCROLL_INC = 25;

    public ScrollableOutputArea() {
        setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JPanel contentPanelContainer = new JPanel(new BorderLayout());
        contentPanelContainer.setBackground(UI_color.MAUVE);
        contentPanelContainer.add(contentPanel, BorderLayout.NORTH);

        scrollPane = new JScrollPane(contentPanelContainer);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        verticalScrollbar = scrollPane.getVerticalScrollBar();
        verticalScrollbar.setUI(new CustomScrollBarUI());
        setScrollableUnitIncrement(SCROLL_INC);
        Border matteBorder = BorderFactory.createMatteBorder(0, UI_size.APP_BORDER_THICKNESS,
                0, 0, UI_color.BLACK);
        Border colorBorder = BorderFactory.createLineBorder(UI_color.MAUVE, 1);
        Border compoundBorder = BorderFactory.createCompoundBorder(matteBorder, colorBorder);
        verticalScrollbar.setBorder(compoundBorder);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addComponent(Component component) {
        blockArray.add((PasswordRowBlock) component);
        contentPanel.add(component);
        contentPanel.validate();
        repaint();
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setValue(verticalBar.getMaximum());
    }

    public void removeComponent(Component component) {
        blockArray.remove((PasswordRowBlock) component);
        contentPanel.remove(component);
        revalidate();
        repaint();
    }

    public void removeAllComponents() {
        for (PasswordRowBlock block : blockArray) {
            block.resetColoredBlock();
        }
        blockArray.clear();
        
        contentPanel.removeAll();
        revalidate();
        repaint();
    }

    private void setScrollableUnitIncrement(int value) {
        verticalScrollbar.setUnitIncrement(value);
    }
}
