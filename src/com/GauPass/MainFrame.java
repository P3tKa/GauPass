package com.GauPass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import com.GauPass.utils.LoadFont;
import com.GauPass.utils.ScreenSizeCalculator;
import com.GauPass.utils.IconSizeChanger;
import com.GauPass.components.KeywordsTab.KeywordsTab;
import com.GauPass.components.OutputTab.PasswordRowBlock;
import com.GauPass.components.OutputTab.ScrollableOutputArea;
import com.GauPass.components.SettingsTab.SettingsTab;
import com.GauPass.components.TitleBar.TitleBar;
import com.GauPass.constants.*;


public class MainFrame extends JFrame {

    private ScrollableOutputArea scrollableOutputArea;
    private SettingsTab settingsTabObject;
    private KeywordsTab keywordsTabObject;

    public void initialize() {
        // Set the title of the frame
        setTitle("GauPass - Password Manager");

        // Load the icon image
        ImageIcon appIcon = new ImageIcon(getClass().getResource(UI_icon_path.APP_ICON));

        /* Resize the icons if necessary */
        appIcon = new IconSizeChanger().ChangeIconSize(appIcon, 256, 256);

        // Set the icon image for the frame
        setIconImage(appIcon.getImage());

        setUndecorated(true);

        setScreenSize(UI_size.APP_WIDTH_PERCENTAGE, UI_size.APP_HEIGHT_PERCENTAGE);
        setLocationRelativeTo(null);
        LoadFont.loadFont(UI_font_path.RUSSOONE_REGULAR);

        JPanel contentPane = createContentPane();
        setContentPane(contentPane);
        setVisible(true);
    }

    public void setScreenSize(double widthPercentage, double heightPercentage) {
        Dimension screenSize = ScreenSizeCalculator.calculateScreenSize(widthPercentage, heightPercentage);
        setSize(screenSize);
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(UI_color.BLACK, UI_size.APP_BORDER_THICKNESS));

        fillContentPane(contentPane);

        return contentPane;
    }

    private void fillContentPane(JPanel contentPane) {
        JPanel titleBar = new TitleBar().createTitleBar(this);
        contentPane.add(titleBar, BorderLayout.NORTH);

        JPanel contentGrid = createContentGrid();
        contentPane.add(contentGrid);
    }

    private JPanel createContentGrid() {

        JPanel contentGrid = new JPanel(new GridLayout(1, 3));

        settingsTabObject = new SettingsTab();
        JPanel settingsTab = settingsTabObject.createSettingsTab();

        scrollableOutputArea = new ScrollableOutputArea();

        keywordsTabObject = new KeywordsTab(this, scrollableOutputArea);
        JPanel keywordsTab = keywordsTabObject.createKeywordsTab();
        keywordsTab.setBorder(BorderFactory.createMatteBorder(0, UI_size.APP_BORDER_THICKNESS, 0,
                UI_size.APP_BORDER_THICKNESS, UI_color.BLACK));


        contentGrid.add(settingsTab);
        contentGrid.add(keywordsTab);
        contentGrid.add(scrollableOutputArea);

        return contentGrid;
    }

    public void handleGenerateButton(String keywords) {
        int length = settingsTabObject.getSliderValue();

        PasswordGenerator gen = new PasswordGenerator(keywords, length);

        keywordsTabObject.restoreDefaultText();

        PasswordRowBlock passwordBlock = new PasswordRowBlock(gen, scrollableOutputArea);
        scrollableOutputArea.addComponent(passwordBlock);
    }

    public void handleCheckStrengthButton(String keywords) {
        keywordsTabObject.resetLabels();

        if (keywords.equals(UI_locale.KEYWORDS_DEFAULT_TEXT) || keywords.equals("")) {
            keywordsTabObject.showLabel(UI_locale.ERROR_EMPTY_FIELD);
            return;
        }
        PasswordStrengthChecker passwordStrengthChecker = new PasswordStrengthChecker();
        ArrayList<String> PasswordWeaknesses = new ArrayList<String>();
        PasswordWeaknesses = passwordStrengthChecker.checkStrength(keywords);
        for (String weakness : PasswordWeaknesses) {
            keywordsTabObject.showLabel(weakness);
        }
        keywordsTabObject.showPasswordStrength(passwordStrengthChecker.getPasswordScore());
    }
}