package com.GauPass.components.OutputTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.utils.BaseButton;
import com.GauPass.utils.CustomEvent;

public class DeleteButton extends BaseButton {

    private static final int ICON_WIDTH = 35;
    private static final int ICON_HEIGHT = 40;

    private static final String DEFAULT_ICON_PATH = UI_icon_path.DELETE_ICON;
    private static final String HOVER_ICON_PATH = UI_icon_path.DELETE_ICON_HOVER;

    public DeleteButton(CustomEvent customEvent) {
        super(DEFAULT_ICON_PATH, HOVER_ICON_PATH, ICON_WIDTH, ICON_HEIGHT);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customEvent.perform();
            }
        });
    }
}