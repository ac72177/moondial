package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of observations of the moon
public class EntryList {
    private final List<Entry> entries;
    private final List<Integer> sortedByPhase = null;

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

    // EFFECTS: creates an empty list
    private SortedListByPhase() {
        sortedByPhase = new ArrayList<>();
    }
    public List<Integer> sortAndCountListByPhase(EntryList entries) {
        for (Entry item : entries) {
            if (item.getMoonPhase().equals("New Moon")) {
                newM = newM + 1;
                sortedByPhase.add(0, newM);
            } else if (item.getMoonPhase().equals("Waxing Crescent")) {
                waxCr = waxCr + 1;
                sortedByPhase.add(1, waxCr);
            } else if (item.getMoonPhase().equals("First Quarter")) {
                firstQ = firstQ + 1;
                sortedByPhase.add(2, firstQ);
            } else if (item.getMoonPhase().equals("Waxing Gibbous")) {
                waxGib = waxGib + 1;
                sortedByPhase.add(3, waxGib);
            } else if (item.getMoonPhase().equals("Full Moon")) {
                fullM = fullM + 1;
                sortedByPhase.add(4, fullM);
            } else if (item.getMoonPhase().equals("Waning Gibbous")) {
                wanGib = wanGib + 1;
                sortedByPhase.add(5, wanGib);
            } else if (item.getMoonPhase().equals("Third Quarter")) {
                thirdQ = thirdQ + 1;
                sortedByPhase.add(6, thirdQ);
            } else {
                wanCr = wanCr + 1;
                sortedByPhase.add(7, wanCr);
            }
}
        return sortedByPhase;
                }
}




