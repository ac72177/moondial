package ui;


import model.Entry;
import model.EntryList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the panel in which the entry list is displayed
public class EntryListPanel extends JPanel implements ActionListener {
    private MoondialGUI moondialGUI;
    private GridBagConstraints gbc;
    private EntryList entryList;
    private JPanel entryListPanel;
    public JLabel entryListLbl;
    public static final int LBL_WIDTH = 400;

    // EFFECTS: constructs an EntryListPanel
    public EntryListPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        entryList = moondialGUI.entryListFromGUI;
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        entryListPanel = new JPanel();
        setBackground(new Color(0xFF031C23, true));
        addEntryListLblToPanel();
    }

    public void addEntryListLblToPanel() {
        this.removeAll();
        this.revalidate();
        this.repaint();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        if (!(entryList.size() == 0)) {
            for (int i = 0; i < entryList.size(); i++) {
                gbc.gridy = i;
                entryListLbl = new JLabel(("  Entry " + i + " : " + getEntryMoonPhaseFromEntryList(i)
                        + " at " + getEntryAngleFromEntryList(i) + " degrees at " + getEntryTimeFromEntryList(i) + " \n"));
                JPanel entryListLblPanel = new JPanel(new BorderLayout());
                entryListLbl.setForeground(new Color(0xFF031C23));
                entryListLblPanel.setBackground(new Color(0xCAEAF1));
                entryListLbl.setFont(new Font("Serif", Font.PLAIN, 16));

                entryListLblPanel.add(entryListLbl, BorderLayout.WEST);
                addRemoveButtonToEntryListLblPanel(entryListLblPanel, i);
                this.add(entryListLblPanel, gbc);
            }
        } else {
            entryListLbl = new JLabel("No Observations have been made.");
            entryListLbl.setFont(new Font("Serif", Font.PLAIN, 14));
            gbc.gridy = 0;
            this.add(entryListLbl, gbc);
        }
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
