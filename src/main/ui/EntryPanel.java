package ui;

import exceptions.IllegalListSize;
import model.Entry;
import persistence.Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class EntryPanel extends JPanel implements ActionListener {
    private MoondialGUI moondialGUI;
    private GridBagConstraints gbc;
    private Entry entry;
    private JPanel entryPanel;
    private JLabel entryLabel;
    public static final String ENTRYLISTGUI_FILE = "./data/entrylistgui.txt";
    private String labelText;
    private JButton observationButton;
    private JButton saveButton;
    public JButton loadButton;
    public JLabel moonStatusLabel;
    public JLabel angleStatusLabel;

    // EFFECTS: constructs an EntryListPanel
    public EntryPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        entryPanel = new JPanel();
        setBackground(new Color(0xFF5A102A, true));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        makeMoonPhaseStatusLabel();

        makeAngleStatusLabel();
        makeEntryLabel();
        makeObservationButton();
        makeSaveButton();

    }

    public void makeMoonPhaseStatusLabel() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        moonStatusLabel = new JLabel("Selected Phase: " + moondialGUI.moonPhase);
        JPanel moonStatusPanel = new JPanel();
        moonStatusPanel.add(moonStatusLabel);
        this.add(moonStatusPanel, gbc);
    }

    public void makeAngleStatusLabel() {
        gbc.gridx = 0;
        gbc.gridy = 1;
        angleStatusLabel = new JLabel("Selected Angle: " + moondialGUI.angleFromEast);
        JPanel angleStatusPanel = new JPanel();
        angleStatusPanel.add(angleStatusLabel);
        this.add(angleStatusPanel, gbc);
    }

    private void makeEntryLabel() {
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JPanel entryLabelPanel = new JPanel();
        initializeText();
        entryLabel = new JLabel(labelText);

        entryLabelPanel.add(entryLabel);
        this.add(entryLabelPanel, gbc);
    }

    private void initializeText() {
        labelText = "Please select Moon Phase and Angle viewed.";
    }

    private void makeObservationButton() {
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        observationButton = new JButton("Enter Data");
        observationButton.addActionListener(this);
        this.add(observationButton, gbc);
    }


    private void makeSaveButton() {
        gbc.gridx = 2;
        gbc.gridy = 1;
        saveButton = new JButton("Save Entry List");
        saveButton.addActionListener(this);
        this.add(saveButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == observationButton) {
            addObservationToEntryListPanel();
        } else {
            saveEntryList();
        }
    }


    private void addObservationToEntryListPanel() {
        entry = new Entry(moondialGUI.moonPhase, moondialGUI.angleFromEast);
        entryLabel.setText("You have observed the " + entry.getMoonPhase() + " at "
                + entry.getAngleFromEast() + " degrees at " + entry.getTime() + ".");

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


    // EFFECTS: saves state of entryList to ENTRYLIST_FILE
    private void saveEntryList() {
        try {
            Writer writer = new Writer(new File(ENTRYLISTGUI_FILE));
            writer.write(moondialGUI.entryListFromGUI);
            writer.close();
            System.out.println("List of Observations saved to file " + ENTRYLISTGUI_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save observations to " + ENTRYLISTGUI_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

//    private void loadEntryList() {
//        try {
//            moondialGUI.entryListFromGUI = Reader.readEntryList(new File(ENTRYLISTGUI_FILE));
//        } catch (IOException e) {
//            moondialGUI.ep.loadButton.setText("");
//        }
//
//
//    }
}


