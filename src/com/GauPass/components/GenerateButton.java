package com.GauPass.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.GauPass.constants.UI_color;
import com.GauPass.constants.UI_size;

public class GenerateButton {

    public JPanel createSubmitButton() {
        JPanel buttonWrapper = new JPanel();
        buttonWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        buttonWrapper.setBackground(UI_color.FOG);

        JButton generateButton = new JButton("Generate");
        Font font = new Font("Arial", Font.BOLD, UI_size.GENERATE_BUTTON_LABEL_TEXT_SIZE);
        generateButton.setFont(font);
        Border border1 = BorderFactory.createMatteBorder(UI_size.APP_BORDER_THICKNESS, UI_size.APP_BORDER_THICKNESS,
                UI_size.APP_BORDER_THICKNESS, UI_size.APP_BORDER_THICKNESS, Color.RED);
        Border border2 = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(border1, border2);

        generateButton.setBorder(compoundBorder);
        generateButton.setBorderPainted(true);
        generateButton.setFocusPainted(false);
        generateButton.setContentAreaFilled(false);
        // Add an ActionListener to the JButton
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event
                System.out.println(KeywordsTab.inputField.getText());
                KeywordsTab.inputField.setText("");

            }
        });

        buttonWrapper.add(generateButton);
        return buttonWrapper;
    }
}
