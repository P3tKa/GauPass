package com.GauPass.components.TitleBar;

import com.GauPass.constants.UI_icon_path;
import com.GauPass.utils.BaseButton;
import com.GauPass.utils.CustomEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;


public class MinimizeButton extends BaseButton {
    private static final String DEFAULT_ICON_PATH = UI_icon_path.MINIMIZE_ICON;
    private static final String HOVER_ICON_PATH = UI_icon_path.MINIMIZE_HOVER_ICON;
    
    public static final int ICON_WIDTH = 30;
    public static final int ICON_HEIGHT = 30;

    public MinimizeButton(CustomEvent customEvent) {
        super(DEFAULT_ICON_PATH, HOVER_ICON_PATH, ICON_WIDTH, ICON_HEIGHT);

        setBorder(BorderFactory.createEmptyBorder());

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customEvent.perform();
            }
        });
    }

}
