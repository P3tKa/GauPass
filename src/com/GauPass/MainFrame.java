package com.GauPass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import com.GauPass.utils.ScreenSizeCalculator;
import com.GauPass.components.KeywordsTab.KeywordsTab;
import com.GauPass.components.OutputTab.ClipboardButton;
import com.GauPass.components.OutputTab.DeleteButton;
import com.GauPass.components.OutputTab.MaxLengthLabel;
import com.GauPass.components.OutputTab.OutputTab;
import com.GauPass.components.OutputTab.ScrollableOutputArea;
import com.GauPass.components.SettingsTab.CheckboxData;
import com.GauPass.components.SettingsTab.SettingsTab;
import com.GauPass.components.TitleBar.TitleBar;
import com.GauPass.constants.*;

public class MainFrame extends JFrame {

    private OutputTab outputTabObject;
    private ScrollableOutputArea scrollableOutputArea;
    private SettingsTab settingsTabObject;

    public void initialize() {
        setUndecorated(true);

        setScreenSize(UI_size.APP_WIDTH_PERCENTAGE, UI_size.APP_HEIGHT_PERCENTAGE);
        setLocationRelativeTo(null);

        JPanel contentPane = createContentPane();
        setContentPane(contentPane);
        setVisible(true);
        this.pack();
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

        outputTabObject = new OutputTab();
        JPanel outputTab = outputTabObject.createOutputTab();

        /* Add scrollable Output Area */
        scrollableOutputArea = new ScrollableOutputArea();
        scrollableOutputArea.setLayout(new BoxLayout(scrollableOutputArea, BoxLayout.Y_AXIS));
        outputTab.add(scrollableOutputArea);

        contentGrid.add(settingsTab);
        contentGrid.add(keywordsTab);
        contentGrid.add(outputTab);

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

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        /* Set the maximum label length */
        // MaxLengthLabel outputPassword = new MaxLengthLabel(24);
        JLabel outputPassword = new JLabel();
        outputPassword.setText(gen.getPassword());

        /* Create clipboard button */
        JButton clipboardButton = new ClipboardButton().createClipboardButton(gen.getPassword());

        /* Create delete button */
        JButton deleteButton = new DeleteButton().createDeleteButton(scrollableOutputArea, passwordPanel);

        passwordPanel.add(outputPassword);
        passwordPanel.add(clipboardButton);
        passwordPanel.add(deleteButton);
        passwordPanel.setBackground(UI_color.MAUVE);

        scrollableOutputArea.addComponent(passwordPanel);
    }
}