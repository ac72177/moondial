package ui.panels;

import exceptions.IllegalListSize;
import model.Entry;
import ui.MoondialGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A panel displaying angle selection with an observation button
public class AnglePanel extends SkyPanel implements ActionListener {
    private static final Color BUTTON_BACKGRD_COLOR = new Color(0x084D4E);
    private static final Color FONT_COLOR = new Color(0xFFFFFF);

    public JRadioButton zeroButton;
    public JRadioButton fortyFiveButton;
    public JRadioButton ninetyButton;
    public JRadioButton hundredThirtyFiveButton;
    public JRadioButton hundredEightyButton;
    private JButton observationButton;


    // EFFECTS: Constructs a panel displaying angle selections and an observation button
    public AnglePanel(MoondialGUI moondialGUI)  {
        super(moondialGUI);
        makeObservationButton();
        addCardinalDirectionLabels();
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio angle buttons
    @Override
    public void makePanelComponents() {
        makeAngleButtonsWithIcon(moondialGUI.angleIcon);

        ButtonGroup group = new ButtonGroup();
        group.add(zeroButton);
        group.add(fortyFiveButton);
        group.add(ninetyButton);
        group.add(hundredThirtyFiveButton);
        group.add(hundredEightyButton);

        zeroButton.addActionListener(this);
        fortyFiveButton.addActionListener(this);
        ninetyButton.addActionListener(this);
        hundredThirtyFiveButton.addActionListener(this);
        hundredEightyButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: instantiates an observation and adds it at specified GridBagConstraint
    private void makeObservationButton() {
        gbc.insets = new Insets(0,35,20,35);
        gbc.gridx = 3;
        gbc.gridy = 4;
        observationButton = new JButton("OBSERVE");
        observationButton.addActionListener(this);
        observationButton.setBackground(BUTTON_BACKGRD_COLOR);
        observationButton.setForeground(FONT_COLOR);
        observationButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
        this.add(observationButton, gbc);
    }


    // EFFECTS: creates the angle buttons with given icon
    public void makeAngleButtonsWithIcon(ImageIcon icon) {

        zeroButton = new JRadioButton("0", icon);
        setButtonFeatures(zeroButton, "0");

        fortyFiveButton = new JRadioButton("45", icon);
        setButtonFeatures(fortyFiveButton, "45");

        ninetyButton = new JRadioButton("90", icon);
        setButtonFeatures(ninetyButton, "90");

        hundredThirtyFiveButton = new JRadioButton("135", icon);
        setButtonFeatures(hundredThirtyFiveButton, "135");

        hundredEightyButton = new JRadioButton("180", icon);
        setButtonFeatures(hundredEightyButton, "180");
    }

    // MODIFIES: this
    // EFFECTS: helper method to add buttons to the panel at specified GridBagConstraint
    @Override
    public void addButtonsToPanel() {
        gbc.insets = new Insets(50,35,50,35);
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(zeroButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(fortyFiveButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        this.add(ninetyButton, gbc);
        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(hundredThirtyFiveButton, gbc);
        gbc.gridx = 5;
        gbc.gridy = 3;
        this.add(hundredEightyButton, gbc);
    }

    // EFFECTS: helper method that constructs labels which instructs where East and West should be
    private void addCardinalDirectionLabels() {
        gbc.gridx = 1;
        gbc.gridy = 4;
        JLabel eastLabel = new JLabel("E");
        eastLabel.setForeground(FONT_COLOR);
        eastLabel.setFont(new Font("Serif", Font.PLAIN, 17));
        JPanel eastPanel = new JPanel();
        eastPanel.setOpaque(false);
        eastPanel.add(eastLabel);
        this.add(eastPanel, gbc);

        gbc.gridx = 5;
        gbc.gridy = 4;
        JLabel westLabel = new JLabel("W");
        westLabel.setForeground(FONT_COLOR);
        westLabel.setFont(new Font("Serif", Font.PLAIN, 17));
        JPanel westPanel = new JPanel();
        westPanel.setOpaque(false);
        westPanel.add(westLabel);
        this.add(westPanel, gbc);
    }

    // MODIFIES: moondialGUI
    // EFFECTS: adds an entry to the list and updates the panels in entryList and the display label in entryPanel
    public void addObservationToEntryListPanel() {
        Entry entry = new Entry(moondialGUI.moonPhase, moondialGUI.angleFromEast);
        moondialGUI.dp.entryLabel.setText("Observed Time: " + entry.getTime() + ".");

        try {
            moondialGUI.entryListFromGUI.addObservation(entry);
        } catch (IllegalListSize illegalListSize) {
            moondialGUI.dp.entryLabel.setText("Too many entries, delete one first.");
        }
        setEntryListPanelLabels();
        setSortedListPanelLabels();
    }

    // MODIFIES: moondialGUI
    // EFFECTS: helper method that sets EntryListPanel
    private void setEntryListPanelLabels() {
        moondialGUI.elp.makePanelComponents();
    }

    // MODIFIES: moondialGUI
    // EFFECTS: helper method that sets EntryListPanel
    private void setSortedListPanelLabels() {
        moondialGUI.slp.makePanelComponents();
    }

    // MODIFIES: moondialGUI
    // EFFECTS: adds an observation to the entry list or sets the angle to the selected one
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == observationButton) {
            addObservationToEntryListPanel();
        } else {
            moondialGUI.setAngleFromEast(Integer.parseInt(e.getActionCommand()));
            moondialGUI.dp.angleStatusLabel.setText("Selected Angle: " + moondialGUI.angleFromEast);
        }
    }
}
