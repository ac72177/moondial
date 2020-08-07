package ui;

import model.Entry;
import model.EntryList;
import persistence.Reader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static ui.EntryListPanel.LBL_WIDTH;
import static ui.EntryPanel.ENTRYLISTGUI_FILE;

public class MoondialGUI extends JFrame {


    private GridBagConstraints gbc;
    public static final int WIDTH = 1300;
    public static final int FRAME_HEIGHT = 700;
    public EntryListPanel elp;
    private JPanel op;
    private MoonPhasePanel moonPhasePanel;
    public EntryList entryListFromGUI;
    public String moonPhase;
    public int angleFromEast;
    public AnglePanel anglePanel;
    private static final int PANEL_HEIGHT = 150;
    public EntryPanel ep;
    protected ImageIcon icon;


    public MoondialGUI() {
        super("Moondial");
        initializeGraphics();

        icon = null;
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

    private void initializePanels() {
        loadEntryList();
        elp = new EntryListPanel(this);
        elp.setPreferredSize(new Dimension(LBL_WIDTH, FRAME_HEIGHT));

        op = new JPanel(new BorderLayout());
        op.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, FRAME_HEIGHT));

        moonPhasePanel = new MoonPhasePanel(this);
        moonPhasePanel.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, PANEL_HEIGHT));

        anglePanel = new AnglePanel(this);
        anglePanel.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, PANEL_HEIGHT * 2));

        ep = new EntryPanel(this);
        ep.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, PANEL_HEIGHT / 3 * 2));

        addPanelsToSpecifiedLocation();
    }

    private void addPanelsToSpecifiedLocation() {
        this.add(elp, BorderLayout.EAST);
        this.add(op, BorderLayout.WEST);

        op.add(moonPhasePanel, BorderLayout.NORTH);

        op.add(anglePanel, BorderLayout.CENTER);

        op.add(ep, BorderLayout.SOUTH);

    }

    private void loadEntryList() {
        try {
            entryListFromGUI = Reader.readEntryList(new File(ENTRYLISTGUI_FILE));

        } catch (IOException e) {
            entryListFromGUI = new EntryList();
        }


    }




    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    public void setAngleFromEast(int angleFromEast) {
        this.angleFromEast = angleFromEast;
    }

    


    public static void main(String[] args) {
        new MoondialGUI();
    }
}
