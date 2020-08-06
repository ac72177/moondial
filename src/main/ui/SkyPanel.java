package ui;

import javax.swing.*;
import java.awt.*;

public abstract class SkyPanel extends JPanel {
    protected GridBagConstraints gbc;
    protected JPanel panel;
    public ImageIcon newMoonImage;
    public ImageIcon waxCrImage;
    public ImageIcon firstQImage;
    public ImageIcon waxGibImage;
    public ImageIcon fullMImage;
    public ImageIcon wanGibImage;
    public ImageIcon thirdQImage;
    public ImageIcon wanCrImage;
    protected ImageIcon icon;

    public SkyPanel() {
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        panel = new JPanel();
        icon = null;

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
    }
}
