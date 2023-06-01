package com.GauPass.components.OutputTab;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_size;

import java.awt.*;

public class ScrollableOutputArea extends JPanel {

    private JScrollPane scrollPane;
    private JPanel contentPanel;

    public ScrollableOutputArea() {
        setLayout(new BorderLayout());
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(UI_color.MAUVE);
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        JScrollBar vertiScrollBar = scrollPane.getVerticalScrollBar();
        vertiScrollBar.setUI(new CustomScrollBarUI());
        Border matteBorder = BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, UI_size.APP_BORDER_THICKNESS,
                UI_size.APP_BORDER_THICKNESS, UI_size.APP_BORDER_THICKNESS, UI_color.BLACK);
        Border colorBorder = BorderFactory.createLineBorder(UI_color.MAUVE, 1);
        Border compoundBorder = BorderFactory.createCompoundBorder(matteBorder, colorBorder);
        vertiScrollBar.setBorder(compoundBorder);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void addComponent(Component component) {
        contentPanel.add(component);
        revalidate();
    }

    public void removeComponent(Component component) {
        contentPanel.remove(component);
        revalidate();
    }

    public void removeAllComponents() {
        contentPanel.removeAll();
        revalidate();
    }

    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 16; // Adjust the value according to your requirements
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return visibleRect.height; // Adjust the value according to your requirements
    }

    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    // public static void main(String[] args) {
    // SwingUtilities.invokeLater(() -> {
    // JFrame frame = new JFrame("ScrollablePanel Example");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setSize(300, 400);

    // ScrollableOutputArea scrollableOutputArea = new ScrollableOutputArea();
    // scrollableOutputArea.setLayout(new BoxLayout(scrollableOutputArea,
    // BoxLayout.Y_AXIS));

    // for (int i = 0; i < 20; i++) {
    // JLabel label = new JLabel("Label " + (i + 1));
    // scrollableOutputArea.addComponent(label);
    // }

    // frame.add(scrollableOutputArea);
    // frame.setVisible(true);
    // });
    // }
}
