package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.EntryListPanel.LBL_WIDTH;

public class MoonPhasePanel extends JPanel implements ActionListener {
    private final JPanel moonPhasePanel;
    private String moonPhase;
    private JRadioButton newMButton;
    private JRadioButton waxCrButton;
    private JRadioButton firstQButton;
    private JRadioButton waxGibButton;
    private JRadioButton fullMButton;
    private JRadioButton wanGibButton;
    private JRadioButton thirdQButton;
    private JRadioButton wanCrButton;
    private GridBagConstraints gbc;

    public MoonPhasePanel() {
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        moonPhasePanel = new JPanel();

        initializePhaseButtons();
        addMoonPhaseButtonToPanel();
    }



    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio moon phase buttons
    private void initializePhaseButtons() {
        newMButton = new JRadioButton("New Moon");
        newMButton.setActionCommand("New Moon");
        waxCrButton = new JRadioButton("Waxing Crescent");
        waxCrButton.setActionCommand("Waxing Crescent");
        firstQButton = new JRadioButton("First Quarter");
        firstQButton.setActionCommand("First Quarter");
        waxGibButton = new JRadioButton("Waxing Gibbous");
        waxGibButton.setActionCommand("Waxing Gibbous");
        fullMButton = new JRadioButton("Full Moon");
        fullMButton.setActionCommand("Full Moon");
        wanGibButton = new JRadioButton("Waning Gibbous");
        wanGibButton.setActionCommand("Waning Gibbous");
        thirdQButton = new JRadioButton("Third Quarter");
        thirdQButton.setActionCommand("Third Quarter");
        wanCrButton = new JRadioButton("Waning Crescent");
        wanCrButton.setActionCommand("Waning Crescent");

        ButtonGroup group = new ButtonGroup();
        group.add(newMButton);
        group.add(waxCrButton);
        group.add(firstQButton);
        group.add(waxGibButton);
        group.add(fullMButton);
        group.add(wanGibButton);
        group.add(thirdQButton);
        group.add(wanCrButton);

        newMButton.addActionListener(this);
        waxCrButton.addActionListener(this);
        firstQButton.addActionListener(this);
        waxGibButton.addActionListener(this);
        fullMButton.addActionListener(this);
        wanGibButton.addActionListener(this);
        thirdQButton.addActionListener(this);
        wanGibButton.addActionListener(this);
    }

    private void addMoonPhaseButtonToPanel() {
        gbc.insets = new Insets(0, 15, 0, 15);
        gbc.gridx = 1;
        this.add(newMButton, gbc);
        gbc.gridx = 2;
        this.add(waxCrButton, gbc);
        gbc.gridx = 3;
        this.add(firstQButton, gbc);
        gbc.gridx = 4;
        this.add(waxGibButton, gbc);
        gbc.gridx = 5;
        this.add(fullMButton, gbc);
        gbc.gridx = 6;
        this.add(wanGibButton, gbc);
        gbc.gridx = 7;
        this.add(thirdQButton, gbc);
        gbc.gridx = 8;
        this.add(wanGibButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moonPhase = e.getActionCommand(); // todo maybe some issues here
        moonPhasePanel.setVisible(false);

    }

}
