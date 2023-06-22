package com.GauPass.components.KeywordsTab;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.utils.ChangeBackgroundOnHover;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeForegroundOnPress;
import com.GauPass.utils.CustomEvent;
import com.GauPass.utils.LoadFont;
import com.GauPass.utils.RoundedButton;

public class GenerateButton extends RoundedButton {
    private final static int BUTTON_ARC_WIDTH = 10;
    private final static int BUTTON_ARC_HEIGHT = 10;
    private final static float BUTTON_FONT_SIZE = 30f;

    private final static String BUTTON_TEXT = UI_locale.SUBMIT_BUTTON_TEXT;

    private final static Color ON_CLICK_BACKGROUND = UI_color.VENETIAN_RED;
    private final static Color BACKGROUND_COLOR = UI_color.AMARANTH;
    private final static Color HOVER_BACKGROUND = UI_color.RED;
    private final static Color TEXT_COLOR = UI_color.BLACK;
    private final static Color ON_CLICK_TEXT_COLOR = UI_color.WHITE;

    private final static String FONT_PATH = UI_font_path.RUSSOONE_REGULAR;

    public GenerateButton(CustomEvent customEvent) {
        super(BUTTON_TEXT, BUTTON_ARC_WIDTH, BUTTON_ARC_HEIGHT, ON_CLICK_BACKGROUND);

        setBackground(BACKGROUND_COLOR);
        setForeground(TEXT_COLOR);
        LoadFont.setFont(this, FONT_PATH, BUTTON_FONT_SIZE);
        new ChangeForegroundOnPress(this, ON_CLICK_TEXT_COLOR);
        new ChangeCursorOnHover(this);
        new ChangeBackgroundOnHover(this, HOVER_BACKGROUND);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customEvent.perform();
            }
        });
    }
}
