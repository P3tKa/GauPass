package com.GauPass.components.KeywordsTab;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.ChangeForegroundOnPress;
import com.GauPass.utils.LoadFont;
import com.GauPass.utils.RoundedButton;


public class SubmitButton {
    
    public JButton createSubmitButton(JPanel parentContainer, JTextArea keywordField) {
        JButton button = new RoundedButton(UI_locale.SUBMIT_BUTTON_TEXT, UI_size.SUBMIT_BUTTON_ARC_WIDTH, UI_size.SUBMIT_BUTTON_ARC_HEIGHT, UI_color.VENETIAN_RED);
        button.setBackground(UI_color.AMARANTH);
        new LoadFont(button, UI_font_path.RUSSOONE_REGULAR, UI_size.SUBMIT_BUTTON_FONT_SIZE);
        new ChangeForegroundOnPress().ChangeForeground(button, Color.WHITE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(keywordField.getText());
                keywordField.setText("");

            }
        });

        return button;
    }
}
