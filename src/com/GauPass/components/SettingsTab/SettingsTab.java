package com.GauPass.components.SettingsTab;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.IconSizeChanger;


public class SettingsTab {
    private final double FIRST_ROW_SIZE = 0.6;
    private final double SECOND_ROW_SIZE = 0.4;
    private final int CHECKBOX_FIELD_SIDE_MARGINS = 50;
    private final int CHECKBOX_TOP_MARGIN = 30;

    private static final String SLIDER_THUMB = UI_icon_path.SLIDER_THUMB_ICON;

    public JPanel createSettingsTab() {
        JPanel settingsTab = new JPanel(new GridBagLayout());
        settingsTab.setBackground(UI_color.FOG);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridy = 0;
        c.weighty = FIRST_ROW_SIZE;

        settingsTab.add(createCheckboxField(), c);
        
        c.gridy = 1;
        c.weighty = SECOND_ROW_SIZE;
        settingsTab.add(createSliderField(), c);

        return settingsTab;
    }

    private JPanel createCheckboxField() {
        JPanel checkboxField = new JPanel(new GridBagLayout());
        checkboxField.setBorder(BorderFactory.createEmptyBorder(0, CHECKBOX_FIELD_SIDE_MARGINS, 0, CHECKBOX_FIELD_SIDE_MARGINS));
        checkboxField.setBackground(UI_color.FOG);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.insets = new Insets(CHECKBOX_TOP_MARGIN, 0, 0, 0);

        storeCheckboxData();
        ArrayList<CheckboxData> checkboxDataList = CheckboxData.getCheckboxDataList();
    
        for(int i = 0; i < checkboxDataList.size(); ++i) {
            c.gridy = i;
    
            CheckboxData checkboxData = checkboxDataList.get(i);
            checkboxField.add(new SettingsCheckbox(checkboxData.getText(), UI_font_path.RUSSOONE_REGULAR, checkboxData.getId()), c);
        }
    
        return checkboxField;
    }
    
    private void storeCheckboxData() {
        String[] fieldText = CheckboxLabelConst.getFieldText();
    
        for (int i = 0; i < fieldText.length; ++i) {
            new CheckboxData(fieldText[i], false, i);
        }
    }

    public JPanel createSliderField() {
        JPanel sliderField = new JPanel(new GridBagLayout());
        sliderField.setBackground(UI_color.FOG);
        JPanel sliderPanel = createSliderPanel();

        sliderField.add(sliderPanel);

        return sliderField;
    }

    public JPanel createSliderPanel() {
        JPanel sliderPanel = new JPanel();
        JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        sizeSlider.setPreferredSize(new Dimension(200, 50));
        sizeSlider.setBackground(UI_color.FOG);

        ImageIcon thumbIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(SLIDER_THUMB), 20, 20);

        sizeSlider.setUI(new CustomSliderUI(sizeSlider, thumbIcon, UI_color.ELECTRIC_BLUE, UI_color.AMARANTH));

        sliderPanel.add(sizeSlider);
        
        return sliderPanel;
    } 
}