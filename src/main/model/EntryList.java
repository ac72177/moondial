package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of observations of the moon
public class EntryList extends Sortable {
    private final List<Entry> entries;
    private int newM = 0;
    private int waxCr = 0;
    private int firstQ = 0;
    public int waxGib = 0;
    public int fullM = 0;
    public int wanGib = 0;
    public int thirdQ = 0;
    public int wanCr = 0;

    // EFFECTS: entries is empty
    public EntryList() {
        entries = new ArrayList<>();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry
    public Entry getEntry(Entry e) {
        return entries.get(entries.indexOf(e));
    }


    // MODIFIES: this
    // EFFECTS: adds an entry to the end of the list
    public void addObservation(Entry e) {
        entries.add(e);
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: removes first occurrence of entry from list
    public void removeObservation(Entry e) {
        entries.remove(e);
    }

    // EFFECTS: returns number of observations in list
    public int size() {
        return entries.size();
    }

    // MODIFIES: this
    // EFFECTS: increments value at index by 1 specified by the condition met
    public void increment(Entry item) {
        if (item.getMoonPhase().equals("New Moon")) {
            sortedByPhase.set(0, newM = newM + 1);
        } else if (item.getMoonPhase().equals("Waxing Crescent")) {
            sortedByPhase.set(1, waxCr = waxCr + 1);
        } else if (item.getMoonPhase().equals("First Quarter")) {
            sortedByPhase.set(2, firstQ = firstQ + 1);
        } else if (item.getMoonPhase().equals("Waxing Gibbous")) {
            sortedByPhase.set(3, waxGib = waxGib + 1);
        } else if (item.getMoonPhase().equals("Full Moon")) {
            sortedByPhase.set(4, fullM = fullM + 1);
        } else if (item.getMoonPhase().equals("Waning Gibbous")) {
            sortedByPhase.set(5, wanGib = wanGib + 1);
        } else if (item.getMoonPhase().equals("Third Quarter")) {
            sortedByPhase.set(6, thirdQ = thirdQ + 1);
        } else {
            sortedByPhase.set(7, wanCr = wanCr + 1);
        }
    }

    @Override
    // EFFECTS: returns the amount of each type of phase in a list ordered by new Moon,
    // waxing Crescent, first quarter, waxing gibbous, full moon, waning gibbous, third quarter, waning crescent
    public List<Integer> sortAndCountListByPhase() {
        for (Entry item : entries) {
            increment(item);
        }
        return sortedByPhase;
    }
}




