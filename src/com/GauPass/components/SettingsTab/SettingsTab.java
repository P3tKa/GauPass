package com.GauPass.components.SettingsTab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_size;


public class SettingsTab {

    public JPanel createSettingsTab() {
        JPanel settingsTab = new JPanel(new GridBagLayout());
        settingsTab.setBackground(UI_color.FOG);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridy = 0;
        c.weighty = UI_size.SETTINGS_FIRST_ROW_SIZE;

        settingsTab.add(createCheckboxField(), c);
        
        c.gridy = 1;
        c.weighty = UI_size.SETTINGS_SECOND_ROW_SIZE;
        settingsTab.add(createSliderField(), c);

        return settingsTab;
    }

    private JPanel createCheckboxField() {
        JPanel checkboxField = new JPanel(new GridBagLayout());
        checkboxField.setBorder(BorderFactory.createEmptyBorder(0, UI_size.SETTINGS_CHECKBOX_FIELD_SIDE_MARGINS, 0, UI_size.SETTINGS_CHECKBOX_FIELD_SIDE_MARGINS));
        checkboxField.setBackground(UI_color.FOG);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.insets = new Insets(UI_size.CHECKBOX_TOP_MARGIN, 0, 0, 0);

        storeCheckboxData();
        ArrayList<CheckboxData> checkboxDataList = CheckboxData.getCheckboxDataList();
    
        for(int i = 0; i < checkboxDataList.size(); ++i) {
            c.gridy = i;
    
            CheckboxData checkboxData = checkboxDataList.get(i);
            checkboxField.add(new SettingsCheckbox(checkboxData.getText(), UI_font_path.RUSSOONE_REGULAR, UI_size.CHECKBOX_FONT_SIZE, UI_size.CHECKBOX_HEIGHT, checkboxData.getId()), c);
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

        return sliderField;
    }
}