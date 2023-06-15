package com.GauPass.components.KeywordsTab;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.text.PlainDocument;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.CustomEvent;
import com.GauPass.utils.LineFilter;
import com.GauPass.utils.LoadFont;
import com.GauPass.MainFrame;

public class KeywordsTab {
    private final float DEFAULT_LABEL_TEXT_SIZE = 12f;

    private final double FIRST_ROW_SIZE = 0.2;
    private final double SECOND_ROW_SIZE = 0.01;
    private final double THIRD_ROW_SIZE = 0.79;

    private MainFrame mainFrame;
    private JTextArea inputField;

    public KeywordsTab(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel createKeywordsTab() {
        JPanel keywordsTab = new JPanel(new GridBagLayout());
        keywordsTab.setBackground(UI_color.FOG);

        this.inputField = createInputField();
        JPanel buttonContainer = createButtonContainer();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = FIRST_ROW_SIZE;
        keywordsTab.add(inputField, c);

        c.gridy = 1;
        c.weighty = SECOND_ROW_SIZE;
        keywordsTab.add(createHorizontalButtonsPanel(), c);

        c.gridwidth = 1;
        c.weighty = THIRD_ROW_SIZE;
        c.gridy = 2;
        keywordsTab.add(buttonContainer, c);

        return keywordsTab;
    }

    private JTextArea createInputField() {
        inputField = new JTextArea(UI_locale.KEYWORDS_DEFAULT_TEXT);
        inputField.setBorder(BorderFactory.createEmptyBorder(5, 5, -100, 0));
        inputField.setBackground(UI_color.FOG);
        inputField.setLineWrap(true);
        LoadFont.setFont(inputField, UI_font_path.RUSSOONE_REGULAR, DEFAULT_LABEL_TEXT_SIZE);

        ((PlainDocument) inputField.getDocument()).setDocumentFilter(new LineFilter(inputField, 3));

        inputField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextArea source = (JTextArea) e.getComponent();
                source.setText("");
            }
        });

        return inputField;
    }

    public void restoreDefaultText() {
        if (inputField.getText().trim().isEmpty()) {
            inputField.setText(UI_locale.KEYWORDS_DEFAULT_TEXT);
            mainFrame.requestFocusInWindow();
        }
    }

    private JPanel createButtonContainer() {

        JPanel buttonContainer = new JPanel(new GridBagLayout());
        buttonContainer.setBackground(UI_color.FOG);
        buttonContainer.add(createGenerateButton());

        return buttonContainer;
    }

    public JButton createGenerateButton() {
        CustomEvent customEvent = () -> mainFrame.handleGenerateButton(inputField.getText());
        GenerateButton generateButton = new GenerateButton(customEvent);
    
        return generateButton;
    }

    private JPanel createHorizontalButtonsPanel() {
        JPanel buttonsContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsContainer.setBackground(UI_color.FOG);
        buttonsContainer.setBorder(BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, 0, 0, 0, UI_color.BLACK));

        buttonsContainer.add(createClearButton());

        return buttonsContainer;
    }

    public CustomButton createClearButton() {
        CustomEvent customEvent = () -> inputField.setText("");
        CustomButton clearKeywordsButton = new CustomButton(UI_locale.CLEAR_KEYWORDS, customEvent);

        return clearKeywordsButton;
    }

}
