package com.GauPass.components.SettingsTab;

import com.GauPass.constants.UI_locale;

public class CheckboxData {

    public static final String[] data = {
        UI_locale.CHECKBOX_INCLUDE_NUMBERS,
        UI_locale.CHECKBOX_INCLUDE_SPEC_CHAR,
        UI_locale.CHECKBOX_INCLUDE_CAP_LETTERS
    };
    
    public String[] getCheckboxData() {
        return data;
    }
}