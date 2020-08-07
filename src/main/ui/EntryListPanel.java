package ui;


import model.Entry;
import model.EntryList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import static ui.MoondialGUI.FRAME_HEIGHT;


// Represents the panel in which the entry list is displayed
public class EntryListPanel extends JPanel implements ActionListener {
    private MoondialGUI moondialGUI;
    private GridBagConstraints gbc;
    private EntryList entryList;
    private JPanel entryListPanel;
    public JLabel entryListLbl;
    private JPanel entryListLblPanel;
    public static final int LBL_WIDTH = 400;

    // EFFECTS: constructs an EntryListPanel
    public EntryListPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        entryList = moondialGUI.entryListFromGUI;
        gbc = new GridBagConstraints();
        entryListPanel = new JPanel(new GridBagLayout());
        setBackground(new Color(0xFFFFFFFF, true));
        entryListPanel.setMinimumSize(new Dimension(LBL_WIDTH, FRAME_HEIGHT));
        addEntryListLblToPanel();
    }

    public void addEntryListLblToPanel() {
        this.removeAll();
        if (!(entryList.size() == 0)) {
            for (int i = 0; i < entryList.size(); i++) {
                entryListLbl = new JLabel(("Entry " + i + ": " + getEntryMoonPhaseFromEntryList(i)
                        + " " + getEntryAngleFromEntryList(i) + " degrees at " + getEntryTimeFromEntryList(i) + "\n"));
                gbc.gridx = i;
                entryListLblPanel = new JPanel();
                addRemoveButtonToEntryListLblPanel(i);
                entryListLblPanel.add(entryListLbl,gbc);
                this.add(entryListLblPanel, gbc);
            }
        } else {
            entryListLbl = new JLabel("No Observations have been made.");
            gbc.gridx = 0;
            this.add(entryListLbl, gbc);
        }
    }

    private void addRemoveButtonToEntryListLblPanel(int i) {
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        entryListLblPanel.add(removeButton);
        removeButton.setActionCommand(Integer.toString(i));
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's moon phase
    public String getEntryMoonPhaseFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getMoonPhase();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's angle
    public int getEntryAngleFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getAngleFromEast();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's angle
    public String getEntryTimeFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getTime();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = Integer.parseInt(e.getActionCommand());
        entryList.removeObservation(i);
        addEntryListLblToPanel();
    }
}
