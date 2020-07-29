package model;

import persistence.Saveable;

import java.util.ArrayList;
import java.util.List;

// Represents a Sorted List by phase
public abstract class Sortable implements Saveable {
    public List<Integer> sortedByPhase;

    public Sortable() {
        sortedByPhase = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            sortedByPhase.add(i, 0);
        }
    }

    // EFFECTS: returns the amount of each type of phase in a list ordered by new Moon,
    // waxing Crescent, first quarter, waxing gibbous, full moon, waning gibbous, third quarter, waning crescent
    public abstract List<Integer> sortAndCountListByPhase();

    // MODIFIES: this
    // EFFECTS: gets value at given index
    public int getIndexValue(int i) {
        return sortedByPhase.get(i);
    }

    // MODIFIES: this
    // EFFECTS:
    public int getSortedListSize() {
        return sortedByPhase.size();
    }

    public abstract void add(Entry parseEntry);
}

