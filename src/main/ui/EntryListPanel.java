package ui;


import model.Entry;
import model.EntryList;

import javax.swing.*;
import java.awt.*;

// Represents the panel in which the entry list is displayed
public class EntryListPanel extends JPanel {
    private EntryList entryList;
    private JPanel entryListPanel;
    private JLabel entryListLbl;
    public static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = HEIGHT;

    public EntryListPanel(EntryList e) {
        entryList = e;
        entryListPanel = new JPanel(new BorderLayout());
        setBackground(new Color(0xFF5A102A, true));
        entryListLbl = new JLabel(addEntryListLbl());
        entryListLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));

        this.add(entryListLbl);
    }

    // EFFECTS: prints entry List
    private String addEntryListLbl() {
        if (!(entryList.size() == 0)) {
            for (int i = 0; i < entryList.size(); i++) {
                return ("Entry " + i + ": " + getEntryMoonPhaseFromEntryList(i)
                        + " " + getEntryAngleFromEntryList(i) + " degrees at " + getEntryTimeFromEntryList(i) + "\n");
            }
        }
        return "No Observations have been made.";
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


}
