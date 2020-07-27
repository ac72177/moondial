package model;

// Represents a moon observation accompanied by the estimated time it was observed
public class Entry extends MoonTime {
    public String time;


    // EFFECTS: creates an entry to be put into a list
    public Entry(String moonPhase, int angleFromEast) {
        super(moonPhase, angleFromEast);
        this.time = super.identifyTime(moonPhase, angleFromEast);
    }

    // EFFECTS: returns the time of the entry
    public String getTime() {
        return this.time;
    }
}
