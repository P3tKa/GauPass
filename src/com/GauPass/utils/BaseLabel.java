package com.GauPass.utils;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class BaseLabel extends JLabel {

    public BaseLabel(String label, Font font) {

        /* Remove any border */
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        /* Set label text */
        setText(label);

        /* Set Font */
        setFont(font);
    }
}
