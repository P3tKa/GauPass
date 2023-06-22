package com.GauPass.utils;

import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class LineFilter extends DocumentFilter {

    private JTextArea textField;
    private int lineLimit;

    public LineFilter(JTextArea textField, int lineLimit) {
        this.textField = textField;
        this.lineLimit = lineLimit;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {

        if (textField.getLineCount() < lineLimit || !string.contains("\n"))
            super.insertString(fb, offset, string, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {

        if (textField.getLineCount() < lineLimit || !text.contains("\n"))
            super.replace(fb, offset, length, text, attrs);
    }
}