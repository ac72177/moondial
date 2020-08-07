package ui;

import exceptions.IllegalListSize;
import model.Entry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.EntryListPanel.LBL_WIDTH;

public class EntryPanel extends JPanel implements ActionListener {
    private MoondialGUI moondialGUI;
    private GridBagConstraints gbc;
    private String moonPhase;
    private int angleFromEast;
    private Entry entry;
    private JPanel entryPanel;
    private JLabel entryLabel;
    private JButton makeObservation;
    public static final int EP_LBL_WIDTH = WIDTH - LBL_WIDTH;
    private static final int LBL_HEIGHT = 200;
    private String labelText;

    // EFFECTS: constructs an EntryListPanel
    public EntryPanel(MoondialGUI moondialGUI) { // todo when you wake up
        this.moondialGUI = moondialGUI;
//        gbc = new GridBagConstraints();
//        setLayout(new GridBagLayout());
        entryPanel = new JPanel(new BorderLayout());
        setBackground(new Color(0xFF5A102A, true));
        makeEntryLabel();
        makeObservationButton();
    }

    private void makeEntryLabel() {
        JPanel entryLabelPanel = new JPanel();
        initializeText();
        entryLabel = new JLabel(labelText);

        entryLabelPanel.add(entryLabel);
        this.add(entryLabelPanel);

    }

    private void initializeText() {
        labelText = "Please select Moon Phase and Angle viewed.";
    }

    private void makeObservationButton() {
        makeObservation = new JButton("Enter Data");
        makeObservation.addActionListener(this);
        this.add(makeObservation, BorderLayout.EAST);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == makeObservation) {
            entry = new Entry(moondialGUI.moonPhase, moondialGUI.angleFromEast);
            entryLabel.setText("You have observed the " + entry.getMoonPhase() + " at "
                    + entry.getAngleFromEast() + " degrees at " + entry.getTime() + ".");
        }

        try {
            moondialGUI.entryListFromGUI.addObservation(entry);
        } catch (IllegalListSize illegalListSize) {
            entryLabel.setText("Too many entries, delete one first.");
        }

        setEntryListPanelLabels();

    }

    private void setEntryListPanelLabels() {
        moondialGUI.elp.addEntryListLblToPanel();
    }

}
