package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoonPhasePanel extends SkyPanel implements ActionListener {
    private AnglePanel anglePanel = new AnglePanel(moondialGUI);
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
        newMButton.setActionCommand("New Moon");
        waxCrButton = new JRadioButton("Waxing Crescent", waxCrImage);
        waxCrButton.setActionCommand("Waxing Crescent");
        firstQButton = new JRadioButton("First Quarter", firstQImage);
        firstQButton.setActionCommand("First Quarter");
        waxGibButton = new JRadioButton("Waxing Gibbous", waxGibImage);
        waxGibButton.setActionCommand("Waxing Gibbous");
        fullMButton = new JRadioButton("Full Moon", fullMImage);
        fullMButton.setActionCommand("Full Moon");
        wanGibButton = new JRadioButton("Waning Gibbous", wanGibImage);
        wanGibButton.setActionCommand("Waning Gibbous");
        thirdQButton = new JRadioButton("Third Quarter", thirdQImage);
        thirdQButton.setActionCommand("Third Quarter");
        wanCrButton = new JRadioButton("Waning Crescent", wanCrImage);
        wanCrButton.setActionCommand("Waning Crescent");
    }


    // MODIFIES: this
    // EFFECTS: helper method that adds all buttons to panel
    @Override
    public void addButtonsToPanel() {
        gbc.insets = new Insets(15, 15, 15, 15);
        setGbcCoordinates(0,0);
        this.add(newMButton, gbc);
        setGbcCoordinates(1,0);
        this.add(waxCrButton, gbc);
        setGbcCoordinates(2,0);
        this.add(firstQButton, gbc);
        setGbcCoordinates(3,0);
        this.add(waxGibButton, gbc);
        setGbcCoordinates(0,1);
        this.add(fullMButton, gbc);
        setGbcCoordinates(1,1);
        this.add(wanGibButton, gbc);
        setGbcCoordinates(2,1);
        this.add(thirdQButton, gbc);
        setGbcCoordinates(3,1);
        this.add(wanCrButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String moonPhase = e.getActionCommand();
        moondialGUI.setMoonPhase(moonPhase);
        moondialGUI.ep.moonStatusLabel.setText("Selected Phase: " + moondialGUI.moonPhase);

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

        setAnglePanelButtonIcon(moondialGUI.icon);
    }

    private void setAnglePanelButtonIcon(ImageIcon icon) {
        moondialGUI.anglePanel.zeroButton.setIcon(icon);
        moondialGUI.anglePanel.fortyFiveButton.setIcon(icon);
        moondialGUI.anglePanel.ninetyButton.setIcon(icon);
        moondialGUI.anglePanel.hundredThirtyFiveButton.setIcon(icon);
        moondialGUI.anglePanel.hundredEightyButton.setIcon(icon);
    }
}
