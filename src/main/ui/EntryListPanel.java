package ui;


import model.Entry;
import model.EntryList;

import javax.swing.*;
import java.awt.*;

import static ui.MoondialGUI.FRAME_HEIGHT;


// Represents the panel in which the entry list is displayed
public class EntryListPanel extends JPanel implements Observer {
    private EntryList entryList;
    private JPanel entryListPanel;
    private JLabel entryListLbl;
    public static final int LBL_WIDTH = 400;

    // EFFECTS: constructs an EntryListPanel
    public EntryListPanel(EntryList e) {
        entryList = e;
        entryListPanel = new JPanel(new BorderLayout());
        setBackground(new Color(0xFFFFFFFF, true));
        entryListLbl = new JLabel(addEntryListLbl());
        entryListPanel.setMinimumSize(new Dimension(LBL_WIDTH, FRAME_HEIGHT));

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
