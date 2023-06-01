package com.GauPass.components.TitleBar;

import com.GauPass.constants.*;
import com.GauPass.utils.ChangeCursorOnHover;
import com.GauPass.utils.ChangeIconOnHover;
import com.GauPass.utils.IconSizeChanger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class CloseButton extends JButton {
    
    private static final String DEFAULT_ICON_PATH = UI_icon_path.CLOSE_ICON;
    private static final String HOVER_ICON_PATH = UI_icon_path.CLOSE_HOVER_ICON;

    public  CloseButton(JFrame frame) {
        
        ImageIcon mainIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(DEFAULT_ICON_PATH), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        ImageIcon onHoverIcon = new IconSizeChanger().ChangeIconSize(new ImageIcon(HOVER_ICON_PATH), UI_size.TITLE_BAR_ICON_WIDTH, UI_size.TITLE_BAR_ICON_HEIGHT);
        setIcon(mainIcon);

        new ChangeIconOnHover(this, mainIcon, onHoverIcon);
        new ChangeCursorOnHover(this);
        setBorder(BorderFactory.createEmptyBorder());

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
