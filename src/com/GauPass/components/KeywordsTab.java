package com.GauPass.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.GauPass.constants.UI_color;

public class KeywordsTab {
    
    public JPanel createKeywordsTab() {
        JPanel keywordsTab = new JPanel(new GridBagLayout());
        keywordsTab.setBackground(UI_color.FOG);

        JLabel tabLabel = new JLabel("Input keywords to be used");
        tabLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tabLabel.setBackground(Color.RED);
        tabLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        // tabLabel.setPreferredSize(new Dimension(200, 100));

        Dimension size = new Dimension(keywordsTab.getWidth(), tabLabel.getPreferredSize().height);
        tabLabel.setPreferredSize(size);





        JTextField keywordInputPane = new JTextField("Leave empty to not use any specific keywords");
        // keywordInputPane.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 0, Color.BLACK));
        keywordInputPane.setBackground(Color.GREEN);

        
        JPanel buttonContainer = new JPanel();
        buttonContainer.setBackground(Color.YELLOW);

        
        GridBagConstraints c = new GridBagConstraints();
        
        // Set the size of the first row to 20% and the second row to 80%
        c.weighty = 0.3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(0, 0, 0, 0);
        keywordsTab.add(tabLabel, c);

        c.gridy = 1;
        c.weighty = 0.3;
        keywordsTab.add(keywordInputPane, c);
        
        c.weighty = 0.6;
        c.gridy = 2;
        keywordsTab.add(buttonContainer, c);

        return keywordsTab;
    }
}
