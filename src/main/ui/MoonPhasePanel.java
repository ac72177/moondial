package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoonPhasePanel extends SkyPanel implements ActionListener {
    private JRadioButton newMButton;
    private JRadioButton waxCrButton;
    private JRadioButton firstQButton;
    private JRadioButton waxGibButton;
    private JRadioButton fullMButton;
    private JRadioButton wanGibButton;
    private JRadioButton thirdQButton;
    private JRadioButton wanCrButton;

    protected ImageIcon icon;


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

    @Override
    public void actionPerformed(ActionEvent e) {
        String moonPhase = e.getActionCommand();
        moondialGUI.setMoonPhase(moonPhase);
        moondialGUI.ep.moonStatusLabel.setText("Selected Phase: " + moondialGUI.moonPhase);
        setAngleIcon(moonPhase);
        updateAnglePanelButtonIcon(moondialGUI.icon);
    }

    private void setAngleIcon(String moonPhase) {
        if (moonPhase.equals("New Moon")) {
            moondialGUI.icon = newMoonImage;
        } else if (moonPhase.equals("Waxing Crescent")) {
            moondialGUI.icon = waxCrImage;
        } else if (moonPhase.equals("First Quarter")) {
            moondialGUI.icon = firstQImage;
        } else if (moonPhase.equals("Waxing Gibbous")) {
            moondialGUI.icon = waxGibImage;
        } else if (moonPhase.equals("Full Moon")) {
            moondialGUI.icon = fullMImage;
        } else if (moonPhase.equals("Waning Gibbous")) {
            moondialGUI.icon = wanGibImage;
        } else if (moonPhase.equals("Third Quarter")) {
            moondialGUI.icon = thirdQImage;
        } else if (moonPhase.equals("Waning Crescent")) {
            moondialGUI.icon = wanCrImage;
        } else {
            moondialGUI.icon = blankImage;
        }
    }

    private void updateAnglePanelButtonIcon(ImageIcon icon) {
        moondialGUI.anglePanel.zeroButton.setIcon(icon);
        moondialGUI.anglePanel.fortyFiveButton.setIcon(icon);
        moondialGUI.anglePanel.ninetyButton.setIcon(icon);
        moondialGUI.anglePanel.hundredThirtyFiveButton.setIcon(icon);
        moondialGUI.anglePanel.hundredEightyButton.setIcon(icon);
    }
}
