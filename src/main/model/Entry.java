package model;

public class Entry extends MoonTime {
    public String time;


    // REQUIRES: angle to be 0, 45, 90, 135, or 180 degrees and moon to be in visible sky
    // EFFECTS: creates an entry

    public Entry(String moonPhase, double angleFromEast) {
        super(moonPhase, angleFromEast);
        this.time = super.identifyTime(moonPhase, angleFromEast);
    }

    public String getTime() {
        return this.time;
    }


}
