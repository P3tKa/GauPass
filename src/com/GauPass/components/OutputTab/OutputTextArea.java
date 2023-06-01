package com.GauPass.components.OutputTab;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.utils.LoadFont;

public class OutputTextArea {
    private final float DEFAULT_LABEL_TEXT_SIZE = 12f;

    public JTextArea createOutputField() {
        JTextArea outputTextArea = new JTextArea(UI_locale.KEYWORDS_DEFAULT_TEXT);
        outputTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, -100, 0));
        outputTextArea.setBackground(UI_color.FOG);
        new LoadFont(outputTextArea, UI_font_path.RUSSOONE_REGULAR, DEFAULT_LABEL_TEXT_SIZE);
        outputTextArea.setEditable(false); // To make the text area read-only

        return outputTextArea;
    }

}
