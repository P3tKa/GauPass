package com.GauPass;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.util.ArrayList;

import com.GauPass.utils.ScreenSizeCalculator;
import com.GauPass.components.KeywordsTab.KeywordsTab;
import com.GauPass.components.OutputTab.ClipboardButton;
import com.GauPass.components.OutputTab.DeleteButton;
import com.GauPass.components.OutputTab.PasswordRowBlock;
import com.GauPass.components.OutputTab.ScrollableOutputArea;
import com.GauPass.components.SettingsTab.CheckboxData;
import com.GauPass.components.SettingsTab.SettingsTab;
import com.GauPass.components.TitleBar.TitleBar;
import com.GauPass.constants.*;

public class MainFrame extends JFrame {

    private ScrollableOutputArea scrollableOutputArea;
    private SettingsTab settingsTabObject;

    public void initialize() {
        setUndecorated(true);

        setScreenSize(UI_size.APP_WIDTH_PERCENTAGE, UI_size.APP_HEIGHT_PERCENTAGE);
        setLocationRelativeTo(null);

        JPanel contentPane = createContentPane();
        setContentPane(contentPane);
        setVisible(true);
        // this.pack();
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

        KeywordsTab keywordsTabObject = new KeywordsTab(this);
        JPanel keywordsTab = keywordsTabObject.createKeywordsTab();
        keywordsTab.setBorder(BorderFactory.createMatteBorder(0, UI_size.APP_BORDER_THICKNESS, 0,
                UI_size.APP_BORDER_THICKNESS, UI_color.BLACK));

        /* Add scrollable Output Area */
        scrollableOutputArea = new ScrollableOutputArea();

        contentGrid.add(settingsTab);
        contentGrid.add(keywordsTab);
        contentGrid.add(scrollableOutputArea);

        return contentGrid;
    }

    public void handleGenerateButton(String Keywords) {
        // Handle the button press event in MainFrame
        System.out.println(Keywords);

        int value = settingsTabObject.getSliderValue();
        System.out.println(value);

        PasswordGenerator gen = new PasswordGenerator();
        gen.checkIfKeywordsUsed(Keywords, value);

        boolean includeNumbers = false,
                includeSpecialChars = false,
                includeCapitalLetters = false;

        ArrayList<CheckboxData> dataList = CheckboxData.getCheckboxDataList();
        includeNumbers = dataList.get(0).isChecked();
        includeSpecialChars = dataList.get(1).isChecked();
        includeCapitalLetters = dataList.get(2).isChecked();

        System.out.println("includeNumbers: " + includeNumbers +
                "\nincludeSpecialChars: " + includeSpecialChars +
                "\nincludeCapitalLetters: " + includeCapitalLetters);

        PasswordRowBlock passwordBlock = new PasswordRowBlock(gen, scrollableOutputArea);
        scrollableOutputArea.addComponent(passwordBlock);
    }
}