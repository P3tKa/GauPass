package com.GauPass.components.SettingsTab;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.utils.BaseInteractivePanel;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.LoadBackgroundImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SettingsCheckbox extends BaseInteractivePanel {

    private static HashMap<String, SettingsCheckbox> checkboxMap = new HashMap<>();

    private static final String UNSELECTED_DEFAULT = UI_icon_path.CHECKBOX_UNSELECTED_DEFAULT;
    private static final String UNSELECTED_HOVER = UI_icon_path.CHECKBOX_UNSELECTED_HOVER;
    private static final String ONCLICK = UI_icon_path.CHECKBOX_ONCLICK;
    private static final String SELECTED_DEFAULT = UI_icon_path.CHECKBOX_SELECTED_DEFAULT;
    private static final String SELECTED_HOVER = UI_icon_path.CHECKBOX_SELECTED_HOVER;

    private final static Color TEXT_COLOR = UI_color.BLACK;
    private final static Color CHECKED_COLOR = UI_color.ELECTRIC_BLUE;
    private final static Color CLICK_COLOR = UI_color.ELECTRIC_BLUE;

    private final static float FONT_SIZE = 15f;
    private final static String FONT_PATH = UI_font_path.RUSSOONE_REGULAR;

    private final static int HEIGHT = 30;

    private static BufferedImage selectedDefaultImage;
    private static BufferedImage selectedHoverImage;
    
    private boolean isChecked;

    public SettingsCheckbox(String text, String id) {
        super(text, FONT_PATH, FONT_SIZE, HEIGHT);

        loadImages();
        new ChangeCursorOnHover(this);

        checkboxMap.put(id, this);
    }

    @Override
    protected void onMousePressed() {
        textLabel.setForeground(CLICK_COLOR);
    }

    @Override
    protected void onMouseReleased() {
        if(!isChecked) {
            textLabel.setForeground(CHECKED_COLOR);
        } else {
            textLabel.setForeground(TEXT_COLOR);
        }
        setChecked(!isChecked);
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }
    
    public boolean isChecked() {
        return isChecked;
    }

    public static SettingsCheckbox getCheckboxById(String id) {
        return checkboxMap.get(id);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(isChecked) {
            if(isHovered && selectedHoverImage != null) {
                g.drawImage(selectedHoverImage, 0, 0, getWidth(), getHeight(), null);
            } else {
                g.drawImage(selectedDefaultImage, 0, 0, getWidth(), getHeight(), null);
            }
        }
    }

    protected void loadImages() {
        LoadBackgroundImage imageLoader = new LoadBackgroundImage();
        defaultImage = imageLoader.loadImage(UNSELECTED_DEFAULT);
        hoverImage = imageLoader.loadImage(UNSELECTED_HOVER);
        onClickImage = imageLoader.loadImage(ONCLICK);
        selectedDefaultImage = imageLoader.loadImage(SELECTED_DEFAULT);
        selectedHoverImage = imageLoader.loadImage(SELECTED_HOVER);
    }
}
