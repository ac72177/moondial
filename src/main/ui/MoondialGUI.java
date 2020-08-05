package ui;

import model.Entry;
import model.EntryList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static ui.EntryListPanel.LBL_WIDTH;

public class MoondialGUI extends JFrame {


    private JFrame frame;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private EntryList entryList;
    private EntryListPanel ep;
    private JPanel op;
    private MoonPhasePanel moonPhasePanel;
    private Entry currentObservation;
    public String moonPhase;
    private int angleFromEast;
    public AnglePanel anglePanel;


    public MoondialGUI() {
        super("Moondial");
        initializeGraphics();
        initializeFields();
    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame window where Moondial will operate
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setSize(new Dimension(WIDTH, HEIGHT));
//        try {
//            addNewEntry();
//        } catch (IllegalListSize illegalListSize) {
//            System.out.println("The list is full.");
//        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializePanels();
        setVisible(true);
    }

    private void initializePanels() {
        entryList = new EntryList();
        ep = new EntryListPanel(entryList);
        op = new JPanel();
        op.setBackground(new Color(0x095166));
        op.setPreferredSize(new Dimension(WIDTH - LBL_WIDTH, HEIGHT));

        moonPhasePanel = new MoonPhasePanel();
      //  moonPhasePanel.setBounds(0, HEIGHT - 200, WIDTH, 100);
        anglePanel = new AnglePanel();
       // anglePanel.setBounds(0,HEIGHT - 100, WIDTH, 100);

        add(ep, BorderLayout.EAST);
        add(op, BorderLayout.WEST);
        op.add(moonPhasePanel, BorderLayout.NORTH);
        op.add(anglePanel, BorderLayout.SOUTH);
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





    


    public static void main(String[] args) {
        new MoondialGUI();
    }
}
