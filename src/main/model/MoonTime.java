package model;

// Represents an observation given a moon phase and an angle
public class MoonTime {
    private final String moonPhase;
    private final int angleFromEast;

    // REQUIRES: moonPhase to be a moon Phase and angleFromEast to be one of 0, 45, 90, 135, 180
    // EFFECTS: creates an observation of moonPhase and angle
    public MoonTime(String moonPhase, int angleFromEast) {
        this.moonPhase = moonPhase;
        this.angleFromEast = angleFromEast;
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of New Moon indicated by angle
    public String newMoonTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "6AM";
        } else if (angleFromEast == 45) {
            return "9AM";
        } else if (angleFromEast == 90) {
            return "Noon";
        } else if (angleFromEast == 135) {
            return "3PM";
        } else {
            return "6PM";
        }
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waxing Crescent indicated by angle
    public String waxingCrescentTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "9AM";
        } else if (angleFromEast == 45) {
            return "Noon";
        } else if (angleFromEast == 90) {
            return "3PM";
        } else if (angleFromEast == 135) {
            return "6PM";
        } else {
            return "9PM";
        }
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of First Quarter indicated by angle
    public String firstQuarterTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "Noon";
        } else if (angleFromEast == 45) {
            return "3PM";
        } else if (angleFromEast == 90) {
            return "6PM";
        } else if (angleFromEast == 135) {
            return "9PM";
        } else {
            return "Midnight";
        }
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waxing Gibbous indicated by angle
    public String waxingGibbousTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "3PM";
        } else if (angleFromEast == 45) {
            return "6PM";
        } else if (angleFromEast == 90) {
            return "9PM";
        } else if (angleFromEast == 135) {
            return "Midnight";
        } else {
            return "3AM";
        }
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Full Moon indicated by angle
    public String fullMoonTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "6PM";
        } else if (angleFromEast == 45) {
            return "9PM";
        } else if (angleFromEast == 90) {
            return "Midnight";
        } else if (angleFromEast == 135) {
            return "3AM";
        } else {
            return "6AM";
        }
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waning Gibbous indicated by angle
    public String waningGibbousTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "9PM";
        } else if (angleFromEast == 45) {
            return "Midnight";
        } else if (angleFromEast == 90) {
            return "3AM";
        } else if (angleFromEast == 135) {
            return "6AM";
        } else {
            return "9AM";
        }
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Third Quarter indicated by angle
    public String thirdQuarterTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "Midnight";
        } else if (angleFromEast == 45) {
            return "3AM";
        } else if (angleFromEast == 90) {
            return "6AM";
        } else if (angleFromEast == 135) {
            return "9AM";
        } else {
            return "Noon";
        }
    }

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waning Crescent indicated by angle
    public String waningCrescentTime(int angleFromEast) {
        if (angleFromEast == 0) {
            return "3AM";
        } else if (angleFromEast == 45) {
            return "6AM";
        } else if (angleFromEast == 90) {
            return "9AM";
        } else if (angleFromEast == 135) {
            return "Noon";
        } else {
            return "3PM";
        }
    }

    // MODIFIES: this
    // EFFECTS: returns moon phase
    public String getMoonPhase() {
        return moonPhase;
    }

    // MODIFIES: this
    // EFFECTS: returns angle from east
    public int getAngleFromEast() {
        return angleFromEast;
    }

    // REQUIRES: moonPhase to be a moon Phase and angleFromEast to be one of 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: return approximate time based on moonPhase and angleFromEast
    public String identifyTime(String moonPhase, int angleFromEast) {
        if (moonPhase.equals("New Moon")) {
            return newMoonTime(angleFromEast);
        } else if (moonPhase.equals("Waxing Crescent")) {
            return waxingCrescentTime(angleFromEast);
        } else if (moonPhase.equals("First Quarter")) {
            return firstQuarterTime(angleFromEast);
        } else if (moonPhase.equals("Waxing Gibbous")) {
            return waxingGibbousTime(angleFromEast);
        } else if (moonPhase.equals("Full Moon")) {
            return fullMoonTime(angleFromEast);
        } else if (moonPhase.equals("Waning Gibbous")) {
            return waningGibbousTime(angleFromEast);
        } else if (moonPhase.equals("Third Quarter")) {
            return thirdQuarterTime(angleFromEast);
        } else {
            return waningCrescentTime(angleFromEast);
        }
    }
}
