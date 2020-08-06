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
    private ImageIcon newMoonImage;
    private ImageIcon waxCrImage;
    private ImageIcon firstQImage;
    private ImageIcon waxGibImage;
    private ImageIcon fullMImage;
    private ImageIcon wanGibImage;
    private ImageIcon thirdQImage;
    private ImageIcon wanCrImage;


    // EFFECTS: constructs a moonPhasePanel to be added onto a panel
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
        loadImages();
        newMButton = new JRadioButton("New Moon", newMoonImage);
        newMButton.setActionCommand("New Moon");
        waxCrButton = new JRadioButton("Waxing Crescent",waxCrImage);
        waxCrButton.setActionCommand("Waxing Crescent");
        firstQButton = new JRadioButton("First Quarter",firstQImage);
        firstQButton.setActionCommand("First Quarter");
        waxGibButton = new JRadioButton("Waxing Gibbous",waxGibImage);
        waxGibButton.setActionCommand("Waxing Gibbous");
        fullMButton = new JRadioButton("Full Moon", fullMImage);
        fullMButton.setActionCommand("Full Moon");
        wanGibButton = new JRadioButton("Waning Gibbous", wanGibImage);
        wanGibButton.setActionCommand("Waning Gibbous");
        thirdQButton = new JRadioButton("Third Quarter", thirdQImage);
        thirdQButton.setActionCommand("Third Quarter");
        wanCrButton = new JRadioButton("Waning Crescent", wanCrImage);
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

    // EFFECTS: loads all the images of the moon onto variables
    private void loadImages() {
        newMoonImage = new ImageIcon("./data/newMoon.jpeg");
        waxCrImage = new ImageIcon("./data/waxingCrescent.jpeg");
        firstQImage = new ImageIcon("./data/firstQuarter.jpeg");
        waxGibImage = new ImageIcon("./data/waxingGibbous.jpg");
        fullMImage = new ImageIcon("./data/fullMoon.jpg");
        wanGibImage = new ImageIcon("./data/waningGibbous.jpg");
        thirdQImage = new ImageIcon("./data/thirdQuarter.jpg");
        wanCrImage = new ImageIcon("./data/waningCrescent.jpg");

    }

    // MODIFIES: this
    // EFFECTS: helper method that adds all buttons to panel
    private void addMoonPhaseButtonToPanel() {
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(newMButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(waxCrButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        this.add(firstQButton, gbc);
        gbc.gridx = 4;
        gbc.gridy = 1;
        this.add(waxGibButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(fullMButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(wanGibButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        this.add(thirdQButton, gbc);
        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(wanCrButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moonPhase = e.getActionCommand(); // todo maybe some issues here
        moonPhasePanel.setVisible(false);

    }

}
