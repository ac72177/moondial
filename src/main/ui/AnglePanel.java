package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.EntryListPanel.LBL_WIDTH;

public class AnglePanel extends JPanel implements ActionListener {
    private JPanel anglePanel;
    private JPanel zeroDegrees;
    private JPanel fortyFiveDegrees;
    private JPanel ninetyDegrees;
    private JPanel hundredThirtyFiveDegrees;
    private JPanel hundredEightyDegrees;
    private int angleFromEast;
    private static final int ANGLE_PANEL_HEIGHT = 200;
    private JLabel angleInstruction;


    public AnglePanel() {
        anglePanel = new JPanel(new FlowLayout());
        anglePanel.setBackground(new Color(0xA00F32));
        anglePanel.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, ANGLE_PANEL_HEIGHT));
        angleInstruction = new JLabel("Please choose the angle the moon makes with the east.");
        anglePanel.add(angleInstruction);

       // initializeAngleButtonPanels();
       // initializeAngleButtons();  todo uncomment
    }

    private void initializeAngleButtonPanels() {
        zeroDegrees = new JPanel();
        fortyFiveDegrees = new JPanel();
        ninetyDegrees = new JPanel();
        hundredThirtyFiveDegrees = new JPanel();
        hundredEightyDegrees = new JPanel();

        anglePanel.add(zeroDegrees, FlowLayout.LEFT);
        anglePanel.add(fortyFiveDegrees, FlowLayout.CENTER);
        anglePanel.add(ninetyDegrees, FlowLayout.RIGHT);
        anglePanel.add(hundredThirtyFiveDegrees, FlowLayout.LEADING);
        anglePanel.add(hundredEightyDegrees, FlowLayout.TRAILING);
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio moon phase buttons
    private void initializeAngleButtons() {
        JRadioButton zeroButton = new JRadioButton("0");
        zeroButton.setActionCommand("0");
        JRadioButton fortyFiveButton = new JRadioButton("45");
        fortyFiveButton.setActionCommand("45");
        JRadioButton ninetyButton = new JRadioButton("90");
        ninetyButton.setActionCommand("90");
        JRadioButton hundredThirtyFiveButton = new JRadioButton("135");
        hundredThirtyFiveButton.setActionCommand("135");
        JRadioButton hundredEightyButton = new JRadioButton("180");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        angleFromEast = Integer.parseInt(e.getActionCommand());
        anglePanel.setVisible(false);
    }

}
