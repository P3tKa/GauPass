package com.GauPass.components.KeywordsTab;

import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.text.PlainDocument;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_font_path;
import com.GauPass.constants.UI_locale;
import com.GauPass.constants.UI_size;
import com.GauPass.utils.CustomEvent;
import com.GauPass.utils.LineFilter;
import com.GauPass.utils.LoadFont;

import com.GauPass.utils.BaseLabel;
import com.GauPass.utils.BaseErrorLabel;
import com.GauPass.MainFrame;

public class KeywordsTab {
    private final float DEFAULT_LABEL_TEXT_SIZE = 12f;

    private final double FIRST_ROW_SIZE = 0.32;
    private final double SECOND_ROW_SIZE = 0.03;
    private final double THIRD_ROW_SIZE = 0.25;
    private final double FOURTH_ROW_SIZE = 0.4;

    private MainFrame mainFrame;
    private JTextArea inputField;
    private JPanel buttonsContainer, labelsContainer;
    private JLabel[] StrengthLabel, ErrorLabels;

    public KeywordsTab(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
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
        keywordsTab.add(createHorizontalLabelspanel(), c);

        c.gridwidth = 1;
        c.weighty = FOURTH_ROW_SIZE;
        c.gridy = 3;
        keywordsTab.add(buttonContainer, c);
        return keywordsTab;
    }

    private JTextArea createInputField() {
        inputField = new JTextArea(UI_locale.KEYWORDS_DEFAULT_TEXT);
        inputField.setBorder(BorderFactory.createEmptyBorder(5, 5, -100, 0));
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
        buttonsContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsContainer.setBackground(UI_color.FOG);

        // Create line border
        Border lineBoarder = BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, 0, 0, 0, UI_color.BLACK);

        // Create an empty border
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);

        // Combine the empty border and dotted border
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBoarder, emptyBorder);
        buttonsContainer.setBorder(compoundBorder);

        StrengthLabel = createPasswordStrengthLabel();
        for (JLabel label : StrengthLabel) {
            buttonsContainer.add(label);
        }

        buttonsContainer.add(createCheckStrengthButton());
        buttonsContainer.add(createClearButton());

        return buttonsContainer;
    }

    private JPanel createHorizontalLabelspanel() {
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

        return labelsContainer;
    }

    public void showPasswordStrength(int strength) {
        if (strength < 35)
            StrengthLabel[0].setForeground(UI_color.VENETIAN_RED);
        else if (strength < 75)
            StrengthLabel[0].setForeground(UI_color.ORANGE_YELLOW);
        else
            StrengthLabel[0].setForeground(UI_color.GREEN);

        StrengthLabel[0].setText(Integer.toString(strength));

        StrengthLabel[0].setVisible(true);
        StrengthLabel[1].setVisible(true);
        StrengthLabel[2].setVisible(true);
    }

    public void hidePasswordStrength() {
        StrengthLabel[0].setVisible(false);
        StrengthLabel[1].setVisible(false);
        StrengthLabel[2].setVisible(false);
    }

    private JLabel[] createPasswordStrengthLabel() {
        JLabel[] StrengthLabels = new JLabel[3];
        // Set the font size and weight
        Font font = new Font("Arial", Font.BOLD, 22);

        StrengthLabels[0] = new BaseLabel("", font);
        StrengthLabels[0].setVisible(false);

        StrengthLabels[1] = new BaseLabel("/", font);
        StrengthLabels[1].setForeground(UI_color.PALATINATE_PURPLE);
        StrengthLabels[1].setVisible(false);

        StrengthLabels[2] = new BaseLabel("100", font);
        StrengthLabels[2].setForeground(UI_color.DEEP_LILAC);
        StrengthLabels[2].setVisible(false);

        return StrengthLabels;
    }

    private CustomButton createClearButton() {
        CustomEvent customEvent = () -> {
            inputField.setText("");
            hidePasswordStrength();
            resetLabels();
        };
        CustomButton clearKeywordsButton = new CustomButton(UI_locale.CLEAR_KEYWORDS, customEvent);
        return clearKeywordsButton;
    }

    private CustomButton createCheckStrengthButton() {
        CustomEvent customEvent = () -> mainFrame.handleCheckStrengthButton(inputField.getText());
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

    public static JLabel findLabelByText(JLabel[] labels, String searchText) {
        for (JLabel label : labels) {
            if (label.getText().equals(searchText)) {
                return label;
            }
        }
        return null;
    }
}
