package ui;

import model.EntryList;
import persistence.Reader;
import ui.panels.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static ui.panels.EntryListPanel.ENTRYLISTGUI_FILE;

// GUI for Moondial
public class MoondialGUI extends JFrame {
    private static final int WIDTH = 1400;
    private static final int FRAME_HEIGHT = 700;
    private static final int ELP_WIDTH = 425;
    private static final int OP_WIDTH = WIDTH - ELP_WIDTH;
    private static final int DISPLAYPANEL_HEIGHT = 100;
    private static final int SKYPANEL_HEIGHT = WIDTH - DISPLAYPANEL_HEIGHT;
    private static final int MOONPHASEPANEL_WIDTH = 200;
    private static final int ANGLEPANEL_WIDTH = OP_WIDTH - MOONPHASEPANEL_WIDTH;
    private static final int SORTEDLISTPANEL_HEIGHT = 400;
    private GridBagConstraints gbc;
    public EntryListPanel elp;
    public SortedListPanel slp;
    private JPanel op;
    private JPanel lp;
    private MoonPhasePanel moonPhasePanel;
    public EntryList entryListFromGUI;
    public String moonPhase;
    public int angleFromEast;
    public AnglePanel anglePanel;
    public DisplayPanel dp;
    public ImageIcon angleIcon;

    // EFFECTS: creates a moondialGUI
    public MoondialGUI() {
        super("Moondial");
        initializeGraphics();

    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame window where Moondial will operate
    private void initializeGraphics() {
        gbc = new GridBagConstraints();
        setLayout(new BorderLayout());
        setSize(new Dimension(WIDTH, FRAME_HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializePanels();
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: initializes the panels that appear on the JFrame window
    private void initializePanels() {
        loadEntryList();
        lp = new JPanel(new BorderLayout());
        lp.setPreferredSize(new Dimension(ELP_WIDTH, FRAME_HEIGHT));
        lp.setBackground(new Color(0xFF031C23));

        elp = new EntryListPanel(this);
        elp.setPreferredSize(new Dimension(ELP_WIDTH, FRAME_HEIGHT - SORTEDLISTPANEL_HEIGHT));

        slp = new SortedListPanel(this);
        slp.setPreferredSize(new Dimension(ELP_WIDTH, SORTEDLISTPANEL_HEIGHT));

        op = new JPanel(new BorderLayout());
        op.setPreferredSize(new Dimension(OP_WIDTH, FRAME_HEIGHT));

        moonPhasePanel = new MoonPhasePanel(this);
        moonPhasePanel.setPreferredSize(new Dimension(MOONPHASEPANEL_WIDTH, SKYPANEL_HEIGHT));

        anglePanel = new AnglePanel(this);
        this.setPreferredSize(new Dimension(ANGLEPANEL_WIDTH, SKYPANEL_HEIGHT));

        dp = new DisplayPanel(this);
        dp.setPreferredSize(new Dimension(OP_WIDTH, DISPLAYPANEL_HEIGHT));

        addPanelsToSpecifiedLocation();
    }

    // MODIFIES: this
    // EFFECTS: helper method to add panels to specified location
    private void addPanelsToSpecifiedLocation() {
        this.add(lp, BorderLayout.EAST);
        this.add(op, BorderLayout.WEST);

        lp.add(elp, BorderLayout.NORTH);

        lp.add(slp, BorderLayout.SOUTH);

        op.add(moonPhasePanel, BorderLayout.WEST);

        op.add(anglePanel, BorderLayout.CENTER);

        op.add(dp, BorderLayout.NORTH);
    }

    // EFFECTS: loads entryList from ENTRYLISTGUI_FILE, creates new entry list if empty
    private void loadEntryList() {
        try {
            entryListFromGUI = Reader.readEntryList(new File(ENTRYLISTGUI_FILE));

        } catch (IOException e) {
            entryListFromGUI = new EntryList();
        }
    }

    // EFFECTS: moonPhase setter
    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    // EFFECTS: angleFromEast setter
    public void setAngleFromEast(int angleFromEast) {
        this.angleFromEast = angleFromEast;
    }

    public static void main(String[] args) {
        new MoondialGUI();
    }
}
