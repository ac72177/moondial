package ui.panels;

import ui.MoondialGUI;

import javax.swing.*;
import java.awt.*;

// A Panel displaying information about the currently selected states, time, saved status, etc.
public class DisplayPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = new Color(0x102322);
    private static final Color FONT_COLOR = new Color(0xFFFFFF);
    private MoondialGUI moondialGUI;
    private GridBagConstraints gbc;
    private JPanel entryPanel;
    public JLabel entryLabel;
    private String labelText;
    public JLabel moonStatusLabel;
    public JLabel angleStatusLabel;

    // EFFECTS: constructs an EntryListPanel
    public DisplayPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        entryPanel = new JPanel();
        setBackground(BACKGROUND_COLOR);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        makeDisplayLabel();
        makeMoonPhaseStatusLabel();
        makeAngleStatusLabel();
    }

    // MODIFIES: this
    // EFFECTS: displays instructions / status
    private void makeDisplayLabel() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        JPanel entryLabelPanel = new JPanel();
        initializeText();
        entryLabel = new JLabel(labelText);
        entryLabel.setOpaque(true);
        entryLabel.setBackground(BACKGROUND_COLOR);
        entryLabel.setForeground(FONT_COLOR);
        entryLabel.setFont(new Font("DialogInput", Font.PLAIN, 16));

        entryLabelPanel.add(entryLabel);
        entryLabelPanel.setBackground(BACKGROUND_COLOR);
        this.add(entryLabelPanel, gbc);
        gbc.gridheight = 1;
    }

    // EFFECTS: helper method that initializes text with welcome message
    private void initializeText() {
        labelText = "Welcome to Moondial";
    }


    // MODIFIES: this
    // EFFECTS: displays currently selected moon phase
    public void makeMoonPhaseStatusLabel() {
        gbc.gridx = 1;
        gbc.gridy = 0;
        moonStatusLabel = new JLabel("Selected: " + moondialGUI.moonPhase);
        moonStatusLabel.setFont(new Font("DialogInput", Font.PLAIN, 12));
        moonStatusLabel.setForeground(FONT_COLOR);
        JPanel moonStatusPanel = new JPanel();
        moonStatusPanel.setBackground(BACKGROUND_COLOR);

        moonStatusPanel.add(moonStatusLabel);
        this.add(moonStatusPanel, gbc);
    }

    // MODIFIES: this
    // EFFECTS: displays currently selected angle
    public void makeAngleStatusLabel() {
        gbc.gridx = 1;
        gbc.gridy = 1;
        angleStatusLabel = new JLabel("Selected: " + moondialGUI.angleFromEast);
        angleStatusLabel.setFont(new Font("DialogInput", Font.PLAIN, 12));
        angleStatusLabel.setForeground(FONT_COLOR);
        JPanel angleStatusPanel = new JPanel();
        angleStatusPanel.setBackground(BACKGROUND_COLOR);
        angleStatusPanel.add(angleStatusLabel);
        this.add(angleStatusPanel, gbc);
    }
}


