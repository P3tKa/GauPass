package com.GauPass.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ContentGrid {

    public JPanel createContentGrid() {

        JPanel mainPanel = new JPanel(new GridLayout(1, 3));

        JPanel leftPanel = new JPanel(new BorderLayout());

        JPanel keywordsTab = new KeywordsTab().createKeywordsTab();
        keywordsTab.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.BLACK));



        JPanel rightPanel = new JPanel(new BorderLayout());

        mainPanel.add(leftPanel);
        mainPanel.add(keywordsTab);
        mainPanel.add(rightPanel);

        return mainPanel;
    }
}

