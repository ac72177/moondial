package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.EntryListPanel.LBL_WIDTH;

public class AnglePanel extends MoonPhasePanel implements ActionListener {
    private int angleFromEast;
    private static final int ANGLE_PANEL_HEIGHT = 400;
    private JRadioButton zeroButton;
    private JRadioButton fortyFiveButton;
    private JRadioButton ninetyButton;
    private JRadioButton hundredThirtyFiveButton;
    private JRadioButton hundredEightyButton;



    // EFFECTS: Constructs anglePanel to be placed on another panel
    public AnglePanel() {

    }



    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio angle buttons
    @Override
    public void initializeButtons() {
        zeroButton = new JRadioButton("0", super.icon);
        zeroButton.setActionCommand("0");
        fortyFiveButton = new JRadioButton("45", super.icon);
        fortyFiveButton.setActionCommand("45");
        ninetyButton = new JRadioButton("90", super.icon);
        ninetyButton.setActionCommand("90");
        hundredThirtyFiveButton = new JRadioButton("135", super.icon);
        hundredThirtyFiveButton.setActionCommand("135");
        hundredEightyButton = new JRadioButton("180", super.icon);
        hundredEightyButton.setActionCommand("180");


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
    // EFFECTS: helper method to add buttons to the panel
    @Override
    public void addButtonsToPanel() {
        gbc.insets = new Insets(40,60,40,60);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(zeroButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(fortyFiveButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(ninetyButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        this.add(hundredThirtyFiveButton, gbc);
        gbc.gridx = 4;
        gbc.gridy = 3;
        this.add(hundredEightyButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angleFromEast = Integer.parseInt(e.getActionCommand());
    }

}
