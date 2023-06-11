package com.GauPass.components.SettingsTab;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.LoadBackgroundImage;
import com.GauPass.utils.LoadFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SettingsCheckbox extends JPanel {

    private static HashMap<String, SettingsCheckbox> checkboxMap = new HashMap<>();

    private static final String UNSELECTED_DEFAULT = UI_icon_path.CHECKBOX_UNSELECTED_DEFAULT;
    private static final String UNSELECTED_HOVER = UI_icon_path.CHECKBOX_UNSELECTED_HOVER;
    private static final String ONCLICK = UI_icon_path.CHECKBOX_ONCLICK;
    private static final String SELECTED_DEFAULT = UI_icon_path.CHECKBOX_SELECTED_DEFAULT;
    private static final String SELECTED_HOVER = UI_icon_path.CHECKBOX_SELECTED_HOVER;

    private final Color textColor = UI_color.BLACK;
    private final float FONT_SIZE = 15f;
    private final int HEIGHT = 30;

    private BufferedImage defaultImage;
    private BufferedImage hoverImage;
    private BufferedImage onClickImage;
    private BufferedImage selectedDefaultImage;
    private BufferedImage selectedHoverImage;

    private boolean mousePressed;
    private boolean isHovered;
    private boolean isChecked;

    private JLabel label;
    private String text;
    private String fontPath;

    public SettingsCheckbox(String text, String fontPath, String id) {
        this.text = text;
        this.fontPath = fontPath;
        this.isHovered = false;
        this.mousePressed = false;
        this.isChecked = false;

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(UI_color.PALATINATE_PURPLE, UI_size.APP_BORDER_THICKNESS));
        setPreferredSize(new Dimension(getPreferredSize().width, HEIGHT));

        loadImages();
        addTextLabel();
        addMouseEvents();

        checkboxMap.put(id, this);
    }

    private void addMouseEvents() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint(); 
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
                label.setForeground(UI_color.WHITE);
                repaint(); 
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                if(!isChecked) {
                    label.setForeground(UI_color.ELECTRIC_BLUE);
                } else {
                    label.setForeground(UI_color.BLACK);
                }
                setChecked(!isChecked);
                
                repaint(); 
            }
        });
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }
    
    public boolean isChecked() {
        return isChecked;
    }

    public static SettingsCheckbox getCheckboxById(String id) {
        return checkboxMap.get(id);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(isChecked && mousePressed && onClickImage  != null) {
            g.drawImage(onClickImage, 0, 0, getWidth(), getHeight(), null);
        } else if(isChecked && isHovered && selectedHoverImage != null) {
            g.drawImage(selectedHoverImage, 0, 0, getWidth(), getHeight(), null);
        } else if(isChecked && selectedDefaultImage != null) {
            g.drawImage(selectedDefaultImage, 0, 0, getWidth(), getHeight(), null);
        } else if (mousePressed && onClickImage != null) {
            g.drawImage(onClickImage, 0, 0, getWidth(), getHeight(), null);
        } else if (isHovered) {
            g.drawImage(hoverImage, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.drawImage(defaultImage, 0, 0, getWidth(), getHeight(), null);
        }
    }

    private void addTextLabel() {
        label = new JLabel(text);
        new LoadFont(label, fontPath, FONT_SIZE);
        label.setForeground(textColor);
        add(label);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
    
        add(label, c);
    }

    private void loadImages() {
        defaultImage = new LoadBackgroundImage().loadImage(UNSELECTED_DEFAULT);
        hoverImage = new LoadBackgroundImage().loadImage(UNSELECTED_HOVER);
        onClickImage = new LoadBackgroundImage().loadImage(ONCLICK);

        selectedDefaultImage = new LoadBackgroundImage().loadImage(SELECTED_DEFAULT);
        selectedHoverImage = new LoadBackgroundImage().loadImage(SELECTED_HOVER);
    }


}
