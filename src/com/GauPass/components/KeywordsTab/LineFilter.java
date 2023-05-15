package com.GauPass.components.KeywordsTab;

import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

class LineFilter extends DocumentFilter {

    private JTextArea textField;

    public LineFilter(JTextArea textField) {
        this.textField = textField;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {

        if (textField.getLineCount() < 3 || !string.contains("\n"))
            super.insertString(fb, offset, string, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {

        if (textField.getLineCount() < 3 || !text.contains("\n"))
            super.replace(fb, offset, length, text, attrs);
    }
}