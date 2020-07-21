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
    // EFFECTS: return approximate time based on moonPhase and angleFromEast
    public String identifyTime() {
        return null; // stub
    }

}
