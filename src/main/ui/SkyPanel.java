package ui;

import javax.swing.*;
import java.awt.*;

import static ui.EntryListPanel.LBL_WIDTH;

public abstract class SkyPanel extends JPanel {
    protected GridBagConstraints gbc;
    protected JPanel panel;
    protected MoondialGUI moondialGUI;
    protected ImageIcon newMoonImage;
    protected ImageIcon waxCrImage;
    protected ImageIcon firstQImage;
    protected ImageIcon waxGibImage;
    protected ImageIcon fullMImage;
    protected ImageIcon wanGibImage;
    protected ImageIcon thirdQImage;
    protected ImageIcon wanCrImage;
    protected ImageIcon icon;
    protected ImageIcon blankImage;

    public SkyPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        setBackground(new Color(0x021623));

        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        panel = new JPanel();
        icon = blankImage;

        initializeButtons();
        addButtonsToPanel();
    }

    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all radio buttons
    protected abstract void initializeButtons();

    // MODIFIES: this
    // EFFECTS: helper method that adds all buttons to panel
    protected abstract void addButtonsToPanel();

    // EFFECTS: sets GridBagConstraints' x and y values to given integers
    protected void setGbcCoordinates(int x,int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }

    // EFFECTS: loads all the images of the moon
    protected void loadImages() {
        newMoonImage = new ImageIcon("./data/newMoon.jpeg");
        waxCrImage = new ImageIcon("./data/waxingCrescent.jpeg");
        firstQImage = new ImageIcon("./data/firstQuarter.jpeg");
        waxGibImage = new ImageIcon("./data/waxingGibbous.jpg");
        fullMImage = new ImageIcon("./data/fullMoon.jpg");
        wanGibImage = new ImageIcon("./data/waningGibbous.jpg");
        thirdQImage = new ImageIcon("./data/thirdQuarter.jpg");
        wanCrImage = new ImageIcon("./data/waningCrescent.jpg");
        blankImage = new ImageIcon("./data/blank.jpg");
    }
}
