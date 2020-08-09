package ui.panels;


import model.Entry;
import model.EntryList;
import persistence.Writer;
import ui.MoondialGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

// Represents the panel in which the entry list is displayed
public class EntryListPanel extends JPanel implements ActionListener {
    private static final Color BUTTON_BACKGRD_COLOR = new Color(0x084D4E);
    private static final Color FONT_COLOR = new Color(0xFFFFFF);
    public static final String ENTRYLISTGUI_FILE = "./data/entrylistgui.txt";
    private MoondialGUI moondialGUI;
    private GridBagConstraints gbc;
    private EntryList entryList;
    private JPanel entryListPanel;
    public JLabel entryListLbl;
    private JButton saveButton;

    // EFFECTS: constructs an EntryListPanel
    public EntryListPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        entryList = moondialGUI.entryListFromGUI;
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        entryListPanel = new JPanel();
        setBackground(new Color(0xFF031C23, true));
        makeSaveButton();
        addEntryListLblToPanel();
    }

    private void makeSaveButton() {
        saveButton = new JButton("SAVE");
        saveButton.addActionListener(this);
        saveButton.setBackground(BUTTON_BACKGRD_COLOR);
        saveButton.setForeground(FONT_COLOR);
        saveButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
    }

    // EFFECTS: saves state of entryList to ENTRYLIST_FILE
    private void saveEntryList() {
        try {
            Writer writer = new Writer(new File(ENTRYLISTGUI_FILE));
            writer.write(moondialGUI.entryListFromGUI);
            writer.close();
            System.out.println("List of Observations saved to file " + ENTRYLISTGUI_FILE);
            moondialGUI.dp.entryLabel.setText("Saved");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save observations to " + ENTRYLISTGUI_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // MODIFIES: this
    // EFFECTS: updates the entry list with empty status or entries
    public void addEntryListLblToPanel() {
        resetEntryListPanel();

        if (!(entryList.size() == 0)) {
            for (int i = 0; i < entryList.size(); i++) {
                addEntry(i);
            }
            addSaveButtonToPanel(entryList.size());
        } else {
            addNoEntryStatus();
            addSaveButtonToPanel(1);
        }
    }

    // MODIFIES: this
    // EFFECTS: resets entry list Panel to initial state
    private void resetEntryListPanel() {
        this.removeAll();
        this.revalidate();
        this.repaint();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }


    // MODIFIES: this
    // EFFECTS: helper method that makes an entry panel with a label and remove button and adds it to this
    private void addEntry(int i) {
        gbc.gridy = i;
        entryListLbl = new JLabel(("  Entry " + i + " : " + getEntryMoonPhaseFromEntryList(i)
                + " at " + getEntryAngleFromEntryList(i) + " degrees at "
                + getEntryTimeFromEntryList(i) + " \n"));
        JPanel entryListLblPanel = new JPanel(new BorderLayout());
        entryListLbl.setForeground(new Color(0xFF031C23));
        entryListLblPanel.setBackground(new Color(0xFF9BBDB6, true));
        entryListLbl.setFont(new Font("Serif", Font.PLAIN, 16));

        entryListLblPanel.add(entryListLbl, BorderLayout.WEST);
        addRemoveButtonToEntryListLblPanel(entryListLblPanel, i);
        this.add(entryListLblPanel, gbc);
    }

    private void addRemoveButtonToEntryListLblPanel(JPanel jp, int i) {
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        removeButton.setForeground(new Color(0xB48208));
        removeButton.setBackground(new Color(0x440218));
        removeButton.setFont(new Font("Serif", Font.PLAIN, 16));
        jp.add(removeButton, BorderLayout.EAST);
        removeButton.setActionCommand(Integer.toString(i));
    }

    private void addSaveButtonToPanel(int i) {
        gbc.gridy = i;
        this.add(saveButton, gbc);
    }

    // MODIFIES: this
    // EFFECTS: informs user that there are no entries in the list
    private void addNoEntryStatus() {
        entryListLbl = new JLabel("No Observations have been made.");
        entryListLbl.setFont(new Font("Serif", Font.PLAIN, 14));
        entryListLbl.setForeground(new Color(0xFFFFFF));
        gbc.gridy = 0;
        this.add(entryListLbl, gbc);
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: helper method that returns specified entry's moon phase
    public String getEntryMoonPhaseFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getMoonPhase();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: helper method that returns specified entry's angle
    public int getEntryAngleFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getAngleFromEast();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: helper method that returns specified entry's angle
    public String getEntryTimeFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getTime();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            saveEntryList();

        } else {
            int i = Integer.parseInt(e.getActionCommand());
            entryList.removeObservation(i);
            moondialGUI.dp.entryLabel.setText("Select moon phase and angle");
            addEntryListLblToPanel();
            moondialGUI.slp.makeSortedLabels();
        }
    }
}
