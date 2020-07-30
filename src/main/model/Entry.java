package model;

// Represents a moon observation accompanied by the estimated time it was observed
public class Entry extends MoonTime {

    private String time;

    // REQUIRES: moonPhase to be a moon Phase and angleFromEast to be one of 0, 45, 90, 135, 180
    // EFFECTS: creates an entry to be put into a list
    public Entry(String moonPhase, int angleFromEast) {
        super(moonPhase, angleFromEast);
        this.time = super.identifyTime(moonPhase, angleFromEast);
    }

    /* REQUIRES: moonPhase to be a moon Phase and angleFromEast to be one of 0, 45, 90, 135, 180
     * EFFECTS: creates an entry to be put into a list
     * NOTE: this constructor is to be used only when constructing
     * an account from data stored in file
     */
    public Entry(String phaseName, int angle, String time) {
        super(phaseName, angle);
        this.time = time;
    }


    // EFFECTS: returns the time of the entry
    public String getTime() {
        return this.time;
    }
}
