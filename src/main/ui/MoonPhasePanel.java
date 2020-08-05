package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.EntryListPanel.LBL_WIDTH;

public class MoonPhasePanel extends JPanel implements ActionListener {
    private final JPanel moonPhasePanel;
    private JPanel newMoon;
    private JPanel waxingCrescent;
    private JPanel firstQuarter;
    private JPanel waxingGibbous;
    private JPanel fullMoon;
    private JPanel waningGibbous;
    private JPanel thirdQuarter;
    private JPanel waningCrescent;
    private String moonPhase;
    private static final int ANGLE_PANEL_HEIGHT = 200;

    public MoonPhasePanel() {
        moonPhasePanel = new JPanel(new FlowLayout());
        moonPhasePanel.setBackground(new Color(0x488090));
        moonPhasePanel.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, ANGLE_PANEL_HEIGHT));
      //  initializeMoonPhaseButtonPanels();
      //  initializePhaseButtons();
    }

    private void initializeMoonPhaseButtonPanels() {
        newMoon = new JPanel();
        waxingCrescent = new JPanel();
        firstQuarter = new JPanel();
        waxingGibbous = new JPanel();
        fullMoon = new JPanel();
        waningGibbous = new JPanel();
        thirdQuarter = new JPanel();
        waningCrescent = new JPanel();

        moonPhasePanel.add(newMoon, FlowLayout.LEFT);
        moonPhasePanel.add(waxingCrescent, FlowLayout.RIGHT);
        moonPhasePanel.add(firstQuarter, FlowLayout.CENTER);
        moonPhasePanel.add(waxingGibbous, FlowLayout.SOUTH);
        moonPhasePanel.add(fullMoon, BorderLayout.SOUTH);
        moonPhasePanel.add(waningGibbous, BorderLayout.SOUTH);
        moonPhasePanel.add(thirdQuarter, BorderLayout.SOUTH);
        moonPhasePanel.add(waningCrescent, BorderLayout.SOUTH);
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio moon phase buttons
    private void initializePhaseButtons() {
        JRadioButton newMButton = new JRadioButton("New Moon");
        newMButton.setActionCommand("New Moon");
        JRadioButton waxCrButton = new JRadioButton("Waxing Crescent");
        waxCrButton.setActionCommand("Waxing Crescent");
        JRadioButton firstQButton = new JRadioButton("First Quarter");
        firstQButton.setActionCommand("First Quarter");
        JRadioButton waxGibButton = new JRadioButton("Waxing Gibbous");
        waxGibButton.setActionCommand("Waxing Gibbous");
        JRadioButton fullMButton = new JRadioButton("Full Moon");
        fullMButton.setActionCommand("Full Moon");
        JRadioButton wanGibButton = new JRadioButton("Waning Gibbous");
        wanGibButton.setActionCommand("Waning Gibbous");
        JRadioButton thirdQButton = new JRadioButton("Third Quarter");
        thirdQButton.setActionCommand("Third Quarter");
        JRadioButton wanCrButton = new JRadioButton("Waning Crescent");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        moonPhase = e.getActionCommand(); // todo maybe some issues here
        moonPhasePanel.setVisible(false);

    }

}
