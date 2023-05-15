package com.GauPass.components;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.ChangeForegroundOnPress;
import com.GauPass.utils.LoadFont;


public class SubmitButton {
    
    public JButton createSubmitButton(JPanel parentContainer) {
        JButton button = new RoundedButton(UI_locale.SUBMIT_BUTTON_TEXT, UI_size.SUBMIT_BUTTON_ARC_WIDTH, UI_size.SUBMIT_BUTTON_ARC_HEIGHT, UI_color.VENETIAN_RED);
        button.setBackground(UI_color.AMARANTH);
        new LoadFont(button, UI_font_path.RUSSOONE_REGULAR, UI_size.SUBMIT_BUTTON_FONT_SIZE);
        new ChangeForegroundOnPress().ChangeForeground(button, Color.WHITE);

        return button;
    }
}
