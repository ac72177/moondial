package model;

import exceptions.NotAMoonPhase;
import exceptions.NotAValidAngle;

public class Entry extends MoonTime {
    public String time;


    // EFFECTS: creates an entry to be put into a list
    public Entry(String moonPhase, int angleFromEast) throws NotAMoonPhase, NotAValidAngle {
        super(moonPhase, angleFromEast);
        this.time = super.identifyTime(moonPhase, angleFromEast);
    }

    // EFFECTS: returns the time of the entry
    public String getTime() {
        return this.time;
    }
}
