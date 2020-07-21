
package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of observations of the moon
public class ObservationList {
    private List<Observation> observations;
    private List<Integer> count;

    private int newM = 0;
    private int waxCr = 0;
    private int firstQ = 0;
    private int waxGib = 0;
    private int fullM = 0;
    private int wanGib = 0;
    private int thirdQ = 0;
    private int wanCr = 0;

    // EFFECTS: list of observations is empty
    public ObservationList() {
        observations = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds an observation to the end of the list
    public void addObservation(Observation o) {
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: removes observation from list
    public void removeObservation(Observation o) {
         //stub
    }

    // EFFECTS: returns number of observations in list
    public int size() {
        return observations.size();
    }

    // MODIFIES: this
    // EFFECTS: returns number of observations categorized by moon phase appearing in the order
    //          newM waxCr firstQ waxGib fullM wanGib thirdQ wanCr
    public List<Integer> getCount() {
        return null; // stub
    }
}




