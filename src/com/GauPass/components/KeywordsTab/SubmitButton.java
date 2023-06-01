package com.GauPass.components.KeywordsTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.GauPass.MainFrame;
import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.utils.ChangeBackgroundOnHover;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeForegroundOnPress;
import com.GauPass.utils.LoadFont;
import com.GauPass.utils.RoundedButton;

public class SubmitButton {
    private final int BUTTON_ARC_WIDTH = 10;
    private final int BUTTON_ARC_HEIGHT = 10;
    private final float BUTTON_FONT_SIZE = 30f;

    public JButton createSubmitButton(JPanel parentContainer, JTextArea keywordField, MainFrame mainframe) {
        JButton button = new RoundedButton(UI_locale.SUBMIT_BUTTON_TEXT, BUTTON_ARC_WIDTH, BUTTON_ARC_HEIGHT,
                UI_color.VENETIAN_RED);
        button.setBackground(UI_color.AMARANTH);
        new LoadFont(button, UI_font_path.RUSSOONE_REGULAR, BUTTON_FONT_SIZE);
        new ChangeForegroundOnPress(button, UI_color.WHITE);
        new ChangeCursorOnHover(button);
        new ChangeBackgroundOnHover(button, UI_color.RED);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.handleGenerateButton(keywordField.getText());
                keywordField.setText("");
            }
        });

        return button;
    }

    public void addActionListener(KeywordsTab keywordsTab) {
    }
}
