package com.GauPass.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.GauPass.constants.UI_color;

public class KeywordsTab {
    
    public JPanel createKeywordsTab() {
        JPanel keywordsTab = new JPanel(new GridBagLayout());
        keywordsTab.setBackground(UI_color.FOG);
    
        JPanel keywordInputPane = new JPanel(new BorderLayout());
        keywordInputPane.setBackground(Color.RED);
        keywordInputPane.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        JTextField inputField = createInputField();

        keywordInputPane.add(inputField);
        keywordInputPane.add(inputField, BorderLayout.WEST);
    




        JPanel buttonContainer = new JPanel(new BorderLayout());
        buttonContainer.setBackground(UI_color.FOG);
        JPanel generateButton = new GenerateButton().createSubmitButton();
        buttonContainer.add(generateButton, BorderLayout.CENTER);
    
        GridBagConstraints c = new GridBagConstraints();
    
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        keywordsTab.add(keywordInputPane, c);
    
        c.gridwidth = 1;
        c.weighty = 0.5;
        c.gridy = 1;
        keywordsTab.add(buttonContainer, c);
    
        return keywordsTab;
    }

    private JTextField createInputField() {
        JTextField inputField = new JTextField("Leave empty to not use any specific keywords");
        return inputField;
    }
    
    
    
    
    
    
}
