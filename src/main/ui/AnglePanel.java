package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.EntryListPanel.LBL_WIDTH;


public class AnglePanel extends SkyPanel implements ActionListener {

    public JRadioButton zeroButton;
    public JRadioButton fortyFiveButton;
    public JRadioButton ninetyButton;
    public JRadioButton hundredThirtyFiveButton;
    public JRadioButton hundredEightyButton;

    // EFFECTS: Constructs anglePanel to be placed on another panel
    public AnglePanel(MoondialGUI moondialGUI)  {

        super(moondialGUI);

    }


    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio angle buttons
    @Override
    public void initializeButtons() {
        makeAngleButtonsWithIcon(moondialGUI.icon);

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
    // EFFECTS: helper method to add buttons to the panel
    @Override
    public void addButtonsToPanel() {
        gbc.insets = new Insets(50,40,50,40);
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

        moondialGUI.setAngleFromEast(Integer.parseInt(e.getActionCommand()));
        moondialGUI.ep.angleStatusLabel.setText("Selected Angle: " + moondialGUI.angleFromEast);

    }
}
