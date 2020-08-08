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
    private static final Color BACKGROUND_COLOR = new Color(0x102322);
    private static final Color BUTTON_BACKGRD_COLOR = new Color(0x084D4E);
    private static final Color FONT_COLOR = new Color(0xFFFFFF) ;
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
        setBackground(BACKGROUND_COLOR);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        makeEntryLabel();
        makeMoonPhaseStatusLabel();
        makeAngleStatusLabel();
        makeObservationButton();
        makeSaveButton();

    }

    private void makeEntryLabel() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        JPanel entryLabelPanel = new JPanel();
        initializeText();
        entryLabel = new JLabel(labelText);
        entryLabel.setOpaque(true);
        entryLabel.setBackground(BACKGROUND_COLOR);
        entryLabel.setForeground(FONT_COLOR);
        entryLabel.setFont(new Font("DialogInput", Font.PLAIN, 16));

        entryLabelPanel.add(entryLabel);
        entryLabelPanel.setBackground(BACKGROUND_COLOR);
        this.add(entryLabelPanel, gbc);
        gbc.gridheight = 1;
    }

    public void makeMoonPhaseStatusLabel() {
        gbc.gridx = 1;
        gbc.gridy = 0;
        moonStatusLabel = new JLabel("Selected: " + moondialGUI.moonPhase);
        moonStatusLabel.setFont(new Font("DialogInput", Font.PLAIN, 12));
        moonStatusLabel.setForeground(FONT_COLOR);
        JPanel moonStatusPanel = new JPanel();
        moonStatusPanel.setBackground(BACKGROUND_COLOR);

        moonStatusPanel.add(moonStatusLabel);
        this.add(moonStatusPanel, gbc);
    }

    public void makeAngleStatusLabel() {
        gbc.gridx = 1;
        gbc.gridy = 1;
        angleStatusLabel = new JLabel("Selected: " + moondialGUI.angleFromEast);
        angleStatusLabel.setFont(new Font("DialogInput", Font.PLAIN, 12));
        angleStatusLabel.setForeground(FONT_COLOR);
        JPanel angleStatusPanel = new JPanel();
        angleStatusPanel.setBackground(BACKGROUND_COLOR);
        angleStatusPanel.add(angleStatusLabel);
        this.add(angleStatusPanel, gbc);
    }



    private void initializeText() {
        labelText = " Welcome to Moondial";
    }

    private void makeObservationButton() {
        gbc.gridx = 2;
        gbc.gridy = 0;
        observationButton = new JButton("Enter Data");
        observationButton.addActionListener(this);
        observationButton.setBackground(BUTTON_BACKGRD_COLOR);
        observationButton.setForeground(FONT_COLOR);
        observationButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
        this.add(observationButton, gbc);
    }


    private void makeSaveButton() {
        gbc.gridx = 2;
        gbc.gridy = 1;
        saveButton = new JButton("Save List");
        saveButton.addActionListener(this);
        saveButton.setBackground(BUTTON_BACKGRD_COLOR);
        saveButton.setForeground(FONT_COLOR);
        saveButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
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
        entryLabel.setText("Observed Time: " + entry.getTime() + ".");

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

}


