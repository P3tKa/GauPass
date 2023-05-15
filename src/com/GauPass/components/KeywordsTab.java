package com.GauPass.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.LoadFont;

public class KeywordsTab {
    
    public JPanel createKeywordsTab() {
        JPanel keywordsTab = new JPanel(new GridBagLayout());
        keywordsTab.setBackground(UI_color.FOG);

        JTextArea inputField = createInputField();
        JPanel buttonContainer = createButtonContainer();


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
    
        c.weightx = 1.0;
        c.weighty = UI_size.KEYWORD_FIRST_ROW_SIZE;
        keywordsTab.add(inputField, c);
    
        c.gridwidth = 1;
        c.weighty = UI_size.KEYWORD_SECOND_ROW_SIZE;
        c.gridy = 1;
        keywordsTab.add(buttonContainer, c);
    
        return keywordsTab;
    } 

    private JTextArea createInputField() {

        JTextArea inputField = new JTextArea(UI_locale.KEYWORDS_DEFAULT_TEXT);
        inputField.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
        inputField.setBackground(UI_color.FOG);
        new LoadFont(inputField, UI_font_path.RUSSOONE_REGULAR, UI_size.KEYWORD_DEFAULT_LABEL_TEXT_SIZE);

        return inputField;
    }

    private JPanel createButtonContainer() {

        JPanel buttonContainer = new JPanel(new GridBagLayout());
        buttonContainer.setBackground(UI_color.FOG);
        buttonContainer.setBorder(BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, 0, 0, 0, Color.BLACK));
        JButton generateButton = new SubmitButton().createSubmitButton(buttonContainer);
        buttonContainer.add(generateButton);

        return buttonContainer;
    }
}
