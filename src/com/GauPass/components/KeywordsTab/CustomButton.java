package com.GauPass.components.KeywordsTab;

import java.awt.Color;
import java.awt.Dimension;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.utils.BaseInteractivePanel;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.LoadBackgroundImage;

public class CustomButton extends BaseInteractivePanel  {

    private final static float FONT_SIZE = 11f;
    private final static String FONT_PATH = UI_font_path.RUSSOONE_REGULAR;

    private final static Color LABEL_TEXT_COLOR = UI_color.BLACK;
    private final static Color ON_CLICK_COLOR = UI_color.ELECTRIC_BLUE;

    private static final String MAIN_ICON_PATH = UI_icon_path.CHECKBOX_UNSELECTED_DEFAULT;
    private static final String HOVER_ICON_PATH = UI_icon_path.CHECKBOX_UNSELECTED_HOVER;
    private static final String ON_CLICK_ICON_PATH = UI_icon_path.CHECKBOX_ONCLICK;

    private static final int HEIGHT = 30;
    private static final int PADDING = 5;

    private CustomEvent customEvent;

    public CustomButton(String text, CustomEvent customEvent) {
        super(text, FONT_PATH, FONT_SIZE, HEIGHT);
        this.customEvent = customEvent;

        loadImages();
        new ChangeCursorOnHover(this);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        return new Dimension(preferredSize.width + PADDING, HEIGHT);
    }

    @Override
    protected void onMousePressed() {
        textLabel.setForeground(ON_CLICK_COLOR);
    }

    @Override
    protected void onMouseReleased() {
        textLabel.setForeground(LABEL_TEXT_COLOR);
        customEvent.perform();
    }

    private void loadImages() {
        defaultImage = new LoadBackgroundImage().loadImage(MAIN_ICON_PATH);
        hoverImage = new LoadBackgroundImage().loadImage(HOVER_ICON_PATH);
        onClickImage = new LoadBackgroundImage().loadImage(ON_CLICK_ICON_PATH);
    }
}
