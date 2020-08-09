package ui.panels;

import ui.MoondialGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A panel with moon phase options to select
public class MoonPhasePanel extends SkyPanel implements ActionListener {
    private JRadioButton newMButton;
    private JRadioButton waxCrButton;
    private JRadioButton firstQButton;
    private JRadioButton waxGibButton;
    private JRadioButton fullMButton;
    private JRadioButton wanGibButton;
    private JRadioButton thirdQButton;
    private JRadioButton wanCrButton;

    // EFFECTS: constructs a moonPhasePanel to be added onto a panel
    public MoonPhasePanel(MoondialGUI moondialGUI) {
        super(moondialGUI);
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio moon phase buttons
    @Override
    public void initializeButtons() {
        loadImages();
        makeButtons();
        addActionListenerToButtons();
        addButtonsToButtonGroup();
    }

    // EFFECTS: helper method that makes the buttons
    private void makeButtons() {
        newMButton = new JRadioButton("New Moon", newMoonImage);
        setButtonFeatures(newMButton, "New Moon");

        waxCrButton = new JRadioButton("Waxing Crescent", waxCrImage);
        setButtonFeatures(waxCrButton, "Waxing Crescent");

        firstQButton = new JRadioButton("First Quarter", firstQImage);
        setButtonFeatures(firstQButton, "First Quarter");


        waxGibButton = new JRadioButton("Waxing Gibbous", waxGibImage);
        setButtonFeatures(waxGibButton, "Waxing Gibbous");


        fullMButton = new JRadioButton("Full Moon", fullMImage);
        setButtonFeatures(fullMButton, "Full Moon");


        wanGibButton = new JRadioButton("Waning Gibbous", wanGibImage);
        setButtonFeatures(wanGibButton, "Waning Gibbous");


        thirdQButton = new JRadioButton("Third Quarter", thirdQImage);
        setButtonFeatures(thirdQButton, "Third Quarter");

        wanCrButton = new JRadioButton("Waning Crescent", wanCrImage);
        setButtonFeatures(wanCrButton, "Waning Crescent");
    }

    // EFFECTS: helper method that adds an action listener to the buttons
    private void addActionListenerToButtons() {
        newMButton.addActionListener(this);
        waxCrButton.addActionListener(this);
        firstQButton.addActionListener(this);
        waxGibButton.addActionListener(this);
        fullMButton.addActionListener(this);
        wanGibButton.addActionListener(this);
        thirdQButton.addActionListener(this);
        wanCrButton.addActionListener(this);
    }

    // EFFECTS: helper method that adds buttons to a button group
    private void addButtonsToButtonGroup() {
        ButtonGroup group = new ButtonGroup();
        group.add(newMButton);
        group.add(waxCrButton);
        group.add(firstQButton);
        group.add(waxGibButton);
        group.add(fullMButton);
        group.add(wanGibButton);
        group.add(thirdQButton);
        group.add(wanCrButton);
    }



    // MODIFIES: this
    // EFFECTS: helper method that adds all buttons to panel
    @Override
    public void addButtonsToPanel() {
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        setGbcCoordinates(0,0);
        this.add(newMButton, gbc);
        setGbcCoordinates(0,1);
        this.add(waxCrButton, gbc);
        setGbcCoordinates(0,2);
        this.add(firstQButton, gbc);
        setGbcCoordinates(0,3);
        this.add(waxGibButton, gbc);
        setGbcCoordinates(0,4);
        this.add(fullMButton, gbc);
        setGbcCoordinates(0,5);
        this.add(wanGibButton, gbc);
        setGbcCoordinates(0,6);
        this.add(thirdQButton, gbc);
        setGbcCoordinates(0,7);
        this.add(wanCrButton, gbc);
    }

    // MODIFIES: moondialGUI
    // EFFECTS: helper method that sets the icon variable to the selected moon phase's icon
    private void setAngleIcon(String moonPhase) {
        if (moonPhase.equals("New Moon")) {
            moondialGUI.angleIcon = newMoonImage;
        } else if (moonPhase.equals("Waxing Crescent")) {
            moondialGUI.angleIcon = waxCrImage;
        } else if (moonPhase.equals("First Quarter")) {
            moondialGUI.angleIcon = firstQImage;
        } else if (moonPhase.equals("Waxing Gibbous")) {
            moondialGUI.angleIcon = waxGibImage;
        } else if (moonPhase.equals("Full Moon")) {
            moondialGUI.angleIcon = fullMImage;
        } else if (moonPhase.equals("Waning Gibbous")) {
            moondialGUI.angleIcon = wanGibImage;
        } else if (moonPhase.equals("Third Quarter")) {
            moondialGUI.angleIcon = thirdQImage;
        } else if (moonPhase.equals("Waning Crescent")) {
            moondialGUI.angleIcon = wanCrImage;
        } else {
            moondialGUI.angleIcon = blankImage;
        }
    }

    // MODIFIES: moondialGUI
    // effects: updates the angle icon with the moonPhase icon
    private void updateAnglePanelButtonIcon(ImageIcon icon) {
        moondialGUI.anglePanel.zeroButton.setIcon(icon);
        moondialGUI.anglePanel.fortyFiveButton.setIcon(icon);
        moondialGUI.anglePanel.ninetyButton.setIcon(icon);
        moondialGUI.anglePanel.hundredThirtyFiveButton.setIcon(icon);
        moondialGUI.anglePanel.hundredEightyButton.setIcon(icon);
    }

    // MODIFIES: moondialGUI
    // EFFECTS: sets the moonphase status in display panel to selected moonphase and updates the angle icon with
    //          the icon of the selected moon phase
    @Override
    public void actionPerformed(ActionEvent e) {
        String moonPhase = e.getActionCommand();
        moondialGUI.setMoonPhase(moonPhase);
        moondialGUI.dp.moonStatusLabel.setText("Selected Phase: " + moondialGUI.moonPhase);
        setAngleIcon(moonPhase);
        updateAnglePanelButtonIcon(moondialGUI.angleIcon);
    }
}
