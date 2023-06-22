package com.GauPass.components.SettingsTab;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.GauPass.constants.APP_settings;
import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.utils.IconSizeChanger;
import com.GauPass.utils.LoadFont;

public class SettingsTab {
    private final double CHECKBOX_FIELD_SIZE = 0.6;
    private final double SLIDER_FIELD_SIZE = 0.4;
    private final int CHECKBOX_FIELD_SIDE_MARGINS = 50;
    private final int CHECKBOX_TOP_MARGIN = 30;

    private final float SLIDER_LABEL_TEXT_SIZE = 20f;
    private final float CURRENT_LENGTH_LABEL_TEXT_SIZE = 15f;

    private final int SLIDER_WIDTH = 300;
    private final int SLIDER_HEIGHT = 50;

    private final int SLIDER_MAX_VALUE = APP_settings.MAX_PASSWORD_LENGTH;
    private final int SLIDER_MIN_VALUE = APP_settings.MIN_PASSWORD_LENGTH;
    private final int SLIDER_DEFAULT_VALUE = 14;

    private JSlider sizeSlider;

    private JLabel lengthField = new JLabel("" + SLIDER_DEFAULT_VALUE);

    private static final String SLIDER_THUMB = UI_icon_path.SLIDER_THUMB_ICON;

    public SettingsTab() {
    }

    public JPanel createSettingsTab() {
        JPanel settingsTab = new JPanel(new GridBagLayout());
        settingsTab.setBackground(UI_color.FOG);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridy = 0;
        c.weighty = CHECKBOX_FIELD_SIZE;

        settingsTab.add(createCheckboxField(), c);

        c.gridy = 1;
        c.weighty = SLIDER_FIELD_SIZE;
        settingsTab.add(createSliderField(), c);

        return settingsTab;
    }

    private JPanel createCheckboxField() {
        JPanel checkboxField = new JPanel(new GridBagLayout());
        checkboxField.setBorder(
                BorderFactory.createEmptyBorder(0, CHECKBOX_FIELD_SIDE_MARGINS, 0, CHECKBOX_FIELD_SIDE_MARGINS));
        checkboxField.setBackground(UI_color.FOG);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.insets = new Insets(CHECKBOX_TOP_MARGIN, 0, 0, 0);

        String[] data = new CheckboxData().getCheckboxData();
        for (int i = 0; i < data.length; ++i) {
            c.gridy = i;

            checkboxField.add(new SettingsCheckbox(data[i], data[i]), c);
        }

        return checkboxField;
    }

    public JPanel createSliderField() {
        JPanel sliderField = new JPanel(new GridBagLayout());
        sliderField.setBackground(UI_color.FOG);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;

        c.weighty = 0.2;
        sliderField.add(createSliderLabelField(), c);

        c.gridy = 2;
        c.weighty = 0.2;
        sliderField.add(createLengthTextContainer(), c);

        c.gridy = 1;
        c.weighty = 0.6;
        sliderField.add(createSliderPanel(), c);

        return sliderField;
    }

    public JPanel createLengthTextContainer() {
        JPanel lengthTextContainer = new JPanel();
        lengthTextContainer.setBackground(UI_color.FOG);

        JLabel length = new JLabel(UI_locale.SLIDER_CURRENT_LENGTH_TEXT);
        length.setForeground(UI_color.BLACK);
        LoadFont.setFont(length, UI_font_path.RUSSOONE_REGULAR, CURRENT_LENGTH_LABEL_TEXT_SIZE);

        LoadFont.setFont(lengthField, UI_font_path.RUSSOONE_REGULAR, CURRENT_LENGTH_LABEL_TEXT_SIZE);
        lengthField.setForeground(UI_color.BLACK);
        lengthField.setBackground(UI_color.ELECTRIC_BLUE);
        lengthField.setBorder(new CompoundBorder(new LineBorder(UI_color.BLACK, 2), new EmptyBorder(0, 5, 0, 5)));
        lengthField.setOpaque(true);

        lengthTextContainer.add(length);
        lengthTextContainer.add(lengthField);

        return lengthTextContainer;
    }

    public JLabel createSliderLabelField() {
        JLabel labelField = new JLabel(UI_locale.SLIDER_PANEL_LABEL);
        labelField.setForeground(UI_color.BLACK);
        LoadFont.setFont(labelField, UI_font_path.RUSSOONE_REGULAR, SLIDER_LABEL_TEXT_SIZE);

        return labelField;
    }

    public JSlider createSliderPanel() {
        JPanel sliderPanel = new JPanel();
        sliderPanel.setBackground(UI_color.FOG);

        sizeSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, SLIDER_DEFAULT_VALUE);
        sizeSlider.setUI(
                new CustomSliderUI(sizeSlider, SLIDER_THUMB, lengthField, UI_color.ELECTRIC_BLUE, UI_color.AMARANTH));

        sizeSlider.setPreferredSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));
        sizeSlider.setBackground(UI_color.FOG);

        return sizeSlider;
    }

    public int getSliderValue() {
        return sizeSlider.getValue();
    }
}