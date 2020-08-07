package ui;

import model.Entry;
import model.EntryList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static ui.EntryListPanel.LBL_WIDTH;

public class MoondialGUI extends JFrame {


    private GridBagConstraints gbc;
    public static final int WIDTH = 1200;
    public static final int FRAME_HEIGHT = 700;
    private EntryList entryList;
    private EntryListPanel elp;
    private JPanel op;
    private MoonPhasePanel moonPhasePanel;
    private Entry currentObservation;
    public String moonPhase;
    public int angleFromEast;
    public AnglePanel anglePanel;
    private static final int PANEL_HEIGHT = 170;
    private EntryPanel ep;


    public MoondialGUI() {
        super("Moondial");
        initializeGraphics();
        initializeFields();
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
        entryList = new EntryList();
        elp = new EntryListPanel(entryList);

        op = new JPanel(new BorderLayout());
        op.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, FRAME_HEIGHT));

        moonPhasePanel = new MoonPhasePanel(this);
        moonPhasePanel.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, PANEL_HEIGHT));

        anglePanel = new AnglePanel(this);
        anglePanel.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, PANEL_HEIGHT / 2));

        ep = new EntryPanel(this);
        ep.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, PANEL_HEIGHT));

        addPanelsToSpecifiedLocation();
    }

    private void addPanelsToSpecifiedLocation() {
        this.add(elp, BorderLayout.EAST);
        this.add(op, BorderLayout.WEST);

        op.add(moonPhasePanel, BorderLayout.NORTH);

        op.add(anglePanel, BorderLayout.CENTER);

        op.add(ep, BorderLayout.SOUTH);

    }


    // MODIFIES: this
    // EFFECTS: sets currentObservation to null
    private void initializeFields() {
        currentObservation = null;
    }

//    // MODIFIES: this
//    // EFFECTS: declares and instantiates an entry (newEntry), and adds it to the entryList
//    private void addNewEntry() throws IllegalListSize {
//        Entry newEntry = new Entry(moonPhase, angleFromEast);
//        currentObservation = newEntry;
//        entryList.addObservation(newEntry);
//        validate();
//



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
