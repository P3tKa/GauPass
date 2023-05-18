package com.GauPass.components.OutputTab;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.GauPass.constants.UI_color;

public class OutputTab {
    public JPanel createOutputTab() {
        JPanel outputTab = new JPanel(new GridBagLayout());
        outputTab.setBackground(UI_color.MAUVE);

        return outputTab;
    }
}
