package model;

public class Observation {

    public String moonPhase;
    public double angleFromEast;

    // REQUIRES: angle to be 0, 45, 90, 135, or 180 degrees and moon to be in visible sky
    public Observation(String moonPhase, double angleFromEast) {
        this.moonPhase = moonPhase;
        this.angleFromEast = angleFromEast;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public double getAngleFromEast() {
        return angleFromEast;
    }

    // MODIFIES: this
    // EFFECTS: returns time of New Moon indicated by angle
    public String newMoonTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: returns time of Waxing Crescent indicated by angle
    public String waxingCrescentTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: returns time of First Quarter indicated by angle
    public String firstQuarterTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: returns time of Waxing Gibbous indicated by angle
    public String waxingGibbousTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: returns time of Full Moon indicated by angle
    public String fullMoonTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: returns time of Waning Gibbous indicated by angle
    public String waningGibbousTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: returns time of Third Quarter indicated by angle
    public String thirdQuarterTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: returns time of Waning Crescent indicated by angle
    public String waningCrescentTime(int i) {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: return approximate time based on moonPhase and angleFromEast
    public String identifyTime() {
        return null; // stub
    }
}