package model;


// Represents an observation given a moon phase and an angle
public interface MoonTime {

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of New Moon indicated by angle
    String newMoonTime(int angleFromEast);


    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waxing Crescent indicated by angle
    String waxingCrescentTime(int angleFromEast);

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of First Quarter indicated by angle
    String firstQuarterTime(int angleFromEast);

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waxing Gibbous indicated by angle
    String waxingGibbousTime(int angleFromEast);

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Full Moon indicated by angle
    String fullMoonTime(int angleFromEast);

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waning Gibbous indicated by angle
    String waningGibbousTime(int angleFromEast);

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Third Quarter indicated by angle
    String thirdQuarterTime(int angleFromEast);

    // REQUIRES: angleFromEast to be 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: returns time of Waning Crescent indicated by angle
    String waningCrescentTime(int angleFromEast);

    // MODIFIES: this
    // EFFECTS: returns moon phase
    String getMoonPhase();

    // MODIFIES: this
    // EFFECTS: returns angle from east
    int getAngleFromEast();

    // REQUIRES: moonPhase to be a moon Phase and angleFromEast to be one of 0, 45, 90, 135, 180
    // MODIFIES: this
    // EFFECTS: return approximate time based on moonPhase and angleFromEast
    String identifyTime(String moonPhase, int angleFromEast);
}
