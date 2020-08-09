package ui.panels;

import model.EntryList;
import ui.MoondialGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// Represents a panel of labels sorted entries
public class SortedListPanel extends JPanel {
    private static final Color PANEL_BCKGRD_COLOR = new Color(0xFF031C23);
    private static final Color FONT_COLOR = new Color(0xFFFFFF);
    private final MoondialGUI moondialGUI;
    private final GridBagConstraints gbc;
    private final EntryList entryList;
    private final JPanel entryListPanel;
    private List<Integer> sortedByPhase;

    // EFFECTS: Constructs a sorted list panel
    public SortedListPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        entryList = moondialGUI.entryListFromGUI;
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        entryListPanel = new JPanel();
        setBackground(PANEL_BCKGRD_COLOR);

        makeSortedLabels();
    }


    // MODIFIES: this
    // EFFECTS: initializes labels of sorted list
    public void makeSortedLabels() {
        resetSortedListPanel();
        if (moondialGUI.entryListFromGUI.size() > 0) {
            sortedByPhase = moondialGUI.entryListFromGUI.sortAndCountListByPhase();

            JLabel newMoonCount = new JLabel("# of New Moon = " + sortedByPhase.get(0));
            setLabelFeatures(newMoonCount, 0, 0);

            JLabel waxCrCount = new JLabel("# of Waxing Crescent = " + sortedByPhase.get(1));
            setLabelFeatures(waxCrCount, 1, 0);

            JLabel firstQCount = new JLabel("# of First Quarter = " + sortedByPhase.get(2));
            setLabelFeatures(firstQCount, 2, 0);

            JLabel waxGibCount = new JLabel("# of Waxing Gibbous = " + sortedByPhase.get(3));
            setLabelFeatures(waxGibCount,3, 0);

            JLabel fullMCount = new JLabel("# of Full Moon = " + sortedByPhase.get(4));
            setLabelFeatures(fullMCount, 0, 1);

            JLabel wanGibCount = new JLabel("# of Waning Gibbous = " + sortedByPhase.get(5));
            setLabelFeatures(wanGibCount, 1, 1);

            JLabel thirdQCount = new JLabel("# of Third Quarter = " + sortedByPhase.get(6));
            setLabelFeatures(thirdQCount, 2, 1);

            JLabel wanCrCount = new JLabel("# of Waning Crescent = " + sortedByPhase.get(7));
            setLabelFeatures(wanCrCount, 3, 1);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a label with specified features to the panel
    private void setLabelFeatures(JLabel label, int coordinateY, int coordinateX) {
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        gbc.gridy = coordinateY;
        gbc.gridx = coordinateX;
        label.setForeground(FONT_COLOR);
        this.add(label, gbc);
    }

    // MODIFIES: this
    // EFFECTS: resets sorted list Panel to initial state
    private void resetSortedListPanel() {
        this.removeAll();
        this.revalidate();
        this.repaint();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }
}

