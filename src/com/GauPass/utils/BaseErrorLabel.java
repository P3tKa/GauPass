package com.GauPass.utils;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import com.GauPass.constants.UI_color;

public class BaseErrorLabel extends JLabel {

    public BaseErrorLabel(String label) {
        setText(label);
        setOpaque(true);

        Border dottedBorder = new DottedBorder(UI_color.BLACK, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(dottedBorder, emptyBorder);

        setBorder(compoundBorder);
        setBackground(UI_color.AMARANTH);
        setForeground(UI_color.BLACK);
    }
}
