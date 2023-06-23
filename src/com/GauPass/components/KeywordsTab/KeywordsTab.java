package com.GauPass.components.KeywordsTab;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.CustomEvent;
import com.GauPass.utils.LineFilter;
import com.GauPass.utils.LoadFont;

import com.GauPass.utils.BaseErrorLabel;
import com.GauPass.MainFrame;
import com.GauPass.components.OutputTab.ScrollableOutputArea;

public class KeywordsTab {
    private final float DEFAULT_LABEL_TEXT_SIZE = 12f;

    private final double FIRST_ROW_SIZE = 0.32;
    private final double SECOND_ROW_SIZE = 0.03;
    private final double THIRD_ROW_SIZE = 0.03;
    private final double FOURTH_ROW_SIZE = 0.03;
    private final double FIFTH_ROW_SIZE = 0.4;

    private final float STRENGTH_BOX_FONT_SIZE = 15f;

    private MainFrame mainFrame;
    private JTextArea inputField;
    private JPanel buttonsContainer, labelsContainer;
    private JLabel[] ErrorLabels;
    private JLabel strengthNumberField, keywordLengthError;
    private ScrollableOutputArea scrollableOutputArea;

    public KeywordsTab(MainFrame mainFrame, ScrollableOutputArea scrollableOutputArea) {
        this.mainFrame = mainFrame;
        this.scrollableOutputArea = scrollableOutputArea;
    }

    public JPanel createKeywordsTab() {
        JPanel keywordsTab = new JPanel(new GridBagLayout());
        keywordsTab.setBackground(UI_color.FOG);

        this.inputField = createInputField();
        JPanel buttonContainer = createButtonContainer();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = FIRST_ROW_SIZE;
        keywordsTab.add(inputField, c);

        c.gridy = 1;
        c.weighty = SECOND_ROW_SIZE;
        keywordsTab.add(createHorizontalButtonsPanel(), c);

        c.gridy = 2;
        c.weighty = THIRD_ROW_SIZE;
        keywordsTab.add(createStrengthPanel(), c);

        c.gridy = 3;
        c.weighty = FOURTH_ROW_SIZE;
        keywordsTab.add(createErorrPanel(), c);

        c.gridwidth = 1;
        c.weighty = FIFTH_ROW_SIZE;
        c.gridy = 4;
        keywordsTab.add(buttonContainer, c);
        return keywordsTab;
    }

    private JTextArea createInputField() {
        inputField = new JTextArea(UI_locale.KEYWORDS_DEFAULT_TEXT);
        inputField.setBorder(BorderFactory.createEmptyBorder(5, 5, -1000, 0));
        inputField.setBackground(UI_color.FOG);
        inputField.setLineWrap(true);
        LoadFont.setFont(inputField, UI_font_path.RUSSOONE_REGULAR, DEFAULT_LABEL_TEXT_SIZE);

        ((PlainDocument) inputField.getDocument()).setDocumentFilter(new LineFilter(inputField, 3));

        inputField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextArea source = (JTextArea) e.getComponent();
                source.setText("");
            }
        });

        return inputField;
    }

    public void restoreDefaultText() {
        if (inputField.getText().trim().isEmpty()) {
            inputField.setText(UI_locale.KEYWORDS_DEFAULT_TEXT);
            mainFrame.requestFocusInWindow();
        }
    }

    private JPanel createButtonContainer() {

        JPanel buttonContainer = new JPanel(new GridBagLayout());
        buttonContainer.setBackground(UI_color.FOG);
        buttonContainer.add(createGenerateButton());

        return buttonContainer;
    }

    private JButton createGenerateButton() {
        CustomEvent customEvent = () -> {
            mainFrame.handleGenerateButton(inputField.getText());
            hidePasswordStrength();
            resetLabels();
        };
        GenerateButton generateButton = new GenerateButton(customEvent);

        return generateButton;
    }

    private JPanel createHorizontalButtonsPanel() {
        buttonsContainer = new JPanel();
        buttonsContainer.setBackground(UI_color.FOG);

        Border lineBoarder = BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, 0, 0, 0, UI_color.BLACK);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBoarder, emptyBorder);
        buttonsContainer.setBorder(compoundBorder);

        buttonsContainer.add(createModifyKeywordButton());
        buttonsContainer.add(createGenFiveButton());
        buttonsContainer.add(createClearAllButton());
        buttonsContainer.add(createClearButton());

        return buttonsContainer;
    }

    private CustomButton createModifyKeywordButton() {
        CustomEvent customEvent = () -> {
            ModifyKeyword modifyKeywordObj = new ModifyKeyword(inputField.getText());
            inputField.setText(modifyKeywordObj.modifyKeyword());
            hidePasswordStrength();
            resetLabels();
            resetKeywordLengthError();
        };
        CustomButton modifyKeywordButton = new CustomButton(UI_locale.MODIFY_KEYWORD, customEvent);
        return modifyKeywordButton;
    }

    private CustomButton createGenFiveButton() {
        CustomEvent customEvent = () -> {
            for (int i = 0; i < 5; i++) {
                mainFrame.handleGenerateButton(inputField.getText());
            }
            hidePasswordStrength();
            resetLabels();
        };
        CustomButton genFiveButton = new CustomButton("Generate 5", customEvent);
        return genFiveButton;
    }

    private CustomButton createClearAllButton() {
        CustomEvent customEvent = () -> {
            scrollableOutputArea.removeAllComponents();
            hidePasswordStrength();
            resetLabels();
            resetKeywordLengthError();
        };
        CustomButton clearAllButton = new CustomButton("Clear passwords", customEvent);
        return clearAllButton;
    }

    private JPanel createStrengthPanel() {
        JPanel strengthPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        strengthPanel.setBackground(UI_color.FOG);

        strengthPanel.add(createPasswordStrengthBox());
        strengthPanel.add(createCheckStrengthButton());

        return strengthPanel;
    }

    private JPanel createErorrPanel() {
        labelsContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        labelsContainer.setBackground(UI_color.FOG);
        labelsContainer
                .setBorder(BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, 0, 0, 0, UI_color.BLACK));

        ErrorLabels = new BaseErrorLabel[5];

        ErrorLabels[0] = new BaseErrorLabel(UI_locale.ERROR_NO_LETTERS);
        ErrorLabels[0].setVisible(false);
        ErrorLabels[1] = new BaseErrorLabel(UI_locale.ERROR_NO_NUMBERS);
        ErrorLabels[1].setVisible(false);
        ErrorLabels[2] = new BaseErrorLabel(UI_locale.ERROR_NO_CHARS);
        ErrorLabels[2].setVisible(false);
        ErrorLabels[3] = new BaseErrorLabel(UI_locale.ERROR_NOT_ENOUGH_LENGTH);
        ErrorLabels[3].setVisible(false);
        ErrorLabels[4] = new BaseErrorLabel(UI_locale.ERROR_EMPTY_FIELD);
        ErrorLabels[4].setVisible(false);

        for (JLabel errorLabel : ErrorLabels) {
            labelsContainer.add(errorLabel);
        }

        createkeywordLengthError();

        return labelsContainer;
    }

    public void createkeywordLengthError() {
        keywordLengthError = new BaseErrorLabel(UI_locale.ERROR_KEYWORDS_LENGTH);
        keywordLengthError.setVisible(false);
        labelsContainer.add(keywordLengthError);
    }

    public void showPasswordStrength(int strength) {
        strengthNumberField.setVisible(true);
        if (strength < 35)
            strengthNumberField.setBackground(UI_color.VENETIAN_RED);
        else if (strength < 75)
            strengthNumberField.setBackground(UI_color.ORANGE_YELLOW);
        else
            strengthNumberField.setBackground(UI_color.GREEN);

        strengthNumberField.setText(Integer.toString(strength) + " / 100");

    }

    public JPanel createPasswordStrengthBox() {
        JPanel passwordStrengthBox = new JPanel();
        passwordStrengthBox.setBackground(UI_color.FOG);

        strengthNumberField = new JLabel();
        LoadFont.setFont(strengthNumberField, UI_font_path.RUSSOONE_REGULAR, STRENGTH_BOX_FONT_SIZE);

        strengthNumberField.setForeground(UI_color.BLACK);
        strengthNumberField
                .setBorder(new CompoundBorder(new LineBorder(UI_color.BLACK, 2), new EmptyBorder(0, 5, 0, 5)));
        strengthNumberField.setOpaque(true);
        strengthNumberField.setVisible(false);

        passwordStrengthBox.add(strengthNumberField);

        return passwordStrengthBox;
    }

    public void hidePasswordStrength() {
        strengthNumberField.setVisible(false);
    }

    private CustomButton createClearButton() {
        CustomEvent customEvent = () -> {
            inputField.setText("");
            hidePasswordStrength();
            resetLabels();
            resetKeywordLengthError();
        };
        CustomButton clearKeywordsButton = new CustomButton(UI_locale.CLEAR_KEYWORDS, customEvent);
        return clearKeywordsButton;
    }

    private CustomButton createCheckStrengthButton() {
        CustomEvent customEvent = () -> {
            if (inputField.getText().equals(UI_locale.EASTER_EGG_SENTENCE)) {
                mainFrame.startEasterEgg();
            } else {
                mainFrame.handleCheckStrengthButton(inputField.getText());
            }
        };
        CustomButton clearKeywordsButton = new CustomButton(UI_locale.CHECK_PASS_STRENGTH, customEvent);

        return clearKeywordsButton;
    }

    public void showLabel(String labelName) {
        JLabel foundLabel = findLabelByText(ErrorLabels, labelName);
        foundLabel.setVisible(true);
    }

    public void resetLabels() {
        for (JLabel errorLabel : ErrorLabels) {
            errorLabel.setVisible(false);
        }
    }

    public void resetKeywordLengthError() {
        keywordLengthError.setVisible(false);
    }

    public void showKeywordLengthError() {
        keywordLengthError.setVisible(true);
    }

    public static JLabel findLabelByText(JLabel[] labels, String searchText) {
        for (JLabel label : labels) {
            if (label.getText().equals(searchText)) {
                return label;
            }
        }
        return null;
    }
}
