package com.GauPass.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_size;

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

    /*
     * Need to decribe outside createInputField class, so LineFilter can resolve it
     */
    public static JTextArea inputField;

    private JTextArea createInputField() {
        inputField = new JTextArea("Input keywords to be used,\n leave empty for no keywords", 0, 3);
        inputField.setBorder(BorderFactory.createEmptyBorder(5, 5, -100, 0));
        inputField.setBackground(UI_color.FOG);

        Font font = new Font("Arial", Font.ITALIC, UI_size.KEYWORD_DEFAULT_LABEL_TEXT_SIZE);
        inputField.setFont(font);
        ((PlainDocument) inputField.getDocument()).setDocumentFilter(new LineFilter());

        /* Clears default text on focus */
        inputField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextArea source = (JTextArea) e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });

        return inputField;
    }

    /* Disables growth of JTextArea after 3 rows */
    class LineFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {

            if (inputField.getLineCount() < 3 || !string.contains("\n"))
                super.insertString(fb, offset, string, attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {

            if (inputField.getLineCount() < 3 || !text.contains("\n"))
                super.replace(fb, offset, length, text, attrs);
        }
    }

    private JPanel createButtonContainer() {

        JPanel buttonContainer = new JPanel(new BorderLayout());
        buttonContainer.setBackground(UI_color.FOG);
        buttonContainer.setBorder(BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, 0, 0, 0, Color.BLACK));

        JPanel generateButton = new GenerateButton().createSubmitButton();
        buttonContainer.add(generateButton, BorderLayout.SOUTH);

        return buttonContainer;
    }
}
