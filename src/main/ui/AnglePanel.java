package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.EntryListPanel.LBL_WIDTH;

public class AnglePanel extends JPanel implements ActionListener {
    private JPanel anglePanel;
    private GridBagConstraints gbc;
    private int angleFromEast;
    private static final int ANGLE_PANEL_HEIGHT = 400;
    private JLabel angleInstruction;
    private JRadioButton zeroButton;
    private JRadioButton fortyFiveButton;
    private JRadioButton ninetyButton;
    private JRadioButton hundredThirtyFiveButton;
    private JRadioButton hundredEightyButton;


    public AnglePanel() {
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        anglePanel = new JPanel();

        angleInstruction = new JLabel("Please choose the angle the moon makes with the east.");
        anglePanel.add(angleInstruction);

        initializeAngleButtons();
        addAngleButtonsToPanel();
    }



    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio moon phase buttons
    private void initializeAngleButtons() {
        zeroButton = new JRadioButton("0");
        zeroButton.setActionCommand("0");
        fortyFiveButton = new JRadioButton("45");
        fortyFiveButton.setActionCommand("45");
        ninetyButton = new JRadioButton("90");
        ninetyButton.setActionCommand("90");
        hundredThirtyFiveButton = new JRadioButton("135");
        hundredThirtyFiveButton.setActionCommand("135");
        hundredEightyButton = new JRadioButton("180");
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

    private void addAngleButtonsToPanel() {
        gbc.insets = new Insets(40,70,40,70);
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
        anglePanel.setVisible(false);
    }

}
