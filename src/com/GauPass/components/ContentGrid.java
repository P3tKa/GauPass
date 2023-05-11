package com.GauPass.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ContentGrid {

    public JPanel createContentGrid() {

        JPanel mainPanel = new JPanel(new GridLayout(1, 3));

        // Create the left panel and add a border
        JPanel keywordsTab = new KeywordsTab().createKeywordsTab();

        // Create the middle panel and add a border
        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.BLACK));


        // Create the right panel and add a border
        JPanel rightPanel = new JPanel(new BorderLayout());

        // Add the three panels to the main panel
        mainPanel.add(keywordsTab);
        mainPanel.add(middlePanel);
        mainPanel.add(rightPanel);

        return mainPanel;
    }
}

