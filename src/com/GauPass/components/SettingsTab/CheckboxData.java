package com.GauPass.components.SettingsTab;

import java.util.ArrayList;

public class CheckboxData {
    private static ArrayList<CheckboxData> checkboxDataList = new ArrayList<>();

    private String text;
    private boolean checked;
    private int id;

    public CheckboxData(String text, boolean checked, int id) {
        this.text = text;
        this.checked = checked;
        this.id = id;
        checkboxDataList.add(this);
    }

    public String getText() {
        return text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<CheckboxData> getCheckboxDataList() {
        return checkboxDataList;
    }
}

