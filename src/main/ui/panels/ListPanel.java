package ui.panels;

import model.EntryList;
import ui.MoondialGUI;
import javax.swing.*;
import java.awt.*;


public abstract class ListPanel extends JPanel implements MoondialPanel, Observer {
    protected static final Color PANEL_BCKGRD_COLOR = new Color(0xFF031C23);
    protected static final Color FONT_COLOR = new Color(0xFFFFFF);
    protected MoondialGUI moondialGUI;
    protected EntryList entryList;
    protected GridBagConstraints gbc;



    // EFFECTS: constructs an EntryListPanel
    public ListPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        entryList = moondialGUI.entryListFromGUI;
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBackground(PANEL_BCKGRD_COLOR);
        makePanelComponents();
    }

    // MODIFIES: this
    // EFFECTS: initializes components on the panel
    public abstract void makePanelComponents();

    // MODIFIES: this
    // EFFECTS: resets sorted list Panel to initial state
    protected void resetListPanel() {
        this.removeAll();
        this.revalidate();
        this.repaint();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }
}
