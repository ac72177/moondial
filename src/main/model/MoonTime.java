package model;

import exceptions.NotAMoonPhase;
import exceptions.NotAValidAngle;

import java.util.List;

public class MoonTime extends ValidAngle {
    private final String moonPhase;
    private final int angleFromEast;

    // EFFECTS: creates an observation of moonPhase and angle
    public MoonTime(String moonPhase, int angleFromEast) throws NotAMoonPhase, NotAValidAngle {
        if (!(moonPhase.equals("New Moon") || moonPhase.equals("Waxing Crescent") || moonPhase.equals("First Quarter")
                || moonPhase.equals("Waxing Gibbous") || moonPhase.equals("Full Moon")
                || moonPhase.equals("Waning Gibbous") || moonPhase.equals("Third Quarter")
                || moonPhase.equals("Waning Crescent"))) {
            throw new NotAMoonPhase();
        } else if (!containsValidAngle(angleFromEast)) {
            throw new NotAValidAngle();
        } else {
            this.moonPhase = moonPhase;
            this.angleFromEast = angleFromEast;
        }
    }

    // EFFECTS: returns true if angle is 0, 45, 90, 135, or 180, false otherwise
    private boolean containsValidAngle(int i) {
        List<Integer> validAngles = null;
        validAngles.add(0, 0);
        validAngles.add(1, 45);
        validAngles.add(2, 90);
        validAngles.add(3, 135);
        validAngles.add(4, 180);

        return validAngles.contains(i);
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
    public double getAngleFromEast() {
        return angleFromEast;
    }

    // REQUIRES: moonPhase is one of "New Moon", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full Moon",
    //           "Waning Gibbous",
    //           angleFromEast is one of 0, 45, 90, 135, 180
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
