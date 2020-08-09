package ui.panels;

import ui.MoondialGUI;

import javax.swing.*;
import java.awt.*;

// Abstract class for AnglePanel and MoonPhasePanel
public abstract class SkyPanel extends JPanel {
    private static final Color BACKGROUND_COLOUR = new Color(0x02020A);
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
    protected ImageIcon blankImage;

    // EFFECTS: sets up the panel specifications and components
    public SkyPanel(MoondialGUI moondialGUI) {
        this.moondialGUI = moondialGUI;
        setBackground(BACKGROUND_COLOUR);

        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        panel = new JPanel();

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

    // EFFECTS: helper method that sets the radio button features
    protected void setButtonFeatures(JRadioButton button, String s) {
        button.setBackground(BACKGROUND_COLOUR);
        button.setForeground(new Color(0xFFFFFF));
        button.setActionCommand(s);
        button.setFont(new Font("Serif", Font.PLAIN, 14));
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
