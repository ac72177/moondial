package model;

import exceptions.IllegalListSize;

import java.util.ArrayList;
import java.util.List;

// Represents a list of entries of the moon observations
public class EntryList extends Sortable {
    private final List<Entry> entryList;
    private final int maxListSize = 5;

    public int newM = 0;
    public int waxCr = 0;
    public int firstQ = 0;
    public int waxGib = 0;
    public int fullM = 0;
    public int wanGib = 0;
    public int thirdQ = 0;
    public int wanCr = 0;

    // EFFECTS: entries is empty
    public EntryList() {
        entryList = new ArrayList<>();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry
    public Entry getEntryFromList(int i) {
        return entryList.get(i);
    }

    // MODIFIES: this
    // EFFECTS: adds an entry to the end of the list
    public void addObservation(Entry e) throws IllegalListSize {
        if (entryList.size() >= maxListSize) {
            throw new IllegalListSize();
        } else {
            entryList.add(e);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes observation at specified index
    public void removeObservation(int i) throws IndexOutOfBoundsException {
        if (entryList.size() > i) {
            entryList.remove(i);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // EFFECTS: returns number of observations in list
    public int size() {
        return entryList.size();
    }

    @Override
    // EFFECTS: returns the amount of each type of phase in a list ordered by new Moon,
    // waxing Crescent, first quarter, waxing gibbous, full moon, waning gibbous, third quarter, waning crescent
    public List<Integer> sortAndCountListByPhase() {
        sortedByPhase.set(0, newM = 0);
        sortedByPhase.set(1, waxCr = 0);
        sortedByPhase.set(2, firstQ = 0);
        sortedByPhase.set(3, waxGib = 0);
        sortedByPhase.set(4, fullM = 0);
        sortedByPhase.set(5, wanGib = 0);
        sortedByPhase.set(6, thirdQ = 0);
        sortedByPhase.set(7, wanCr = 0);

        for (Entry item : entryList) {
            increment(item);
        }
        return sortedByPhase;
    }

    // MODIFIES: this
    // EFFECTS: increments value at index by 1 specified by the condition met
    public void increment(Entry item) {
        if (item.getMoonPhase().equals("New Moon")) {
            sortedByPhase.set(0, newM += 1);
        } else if (item.getMoonPhase().equals("Waxing Crescent")) {
            sortedByPhase.set(1, waxCr += 1);
        } else if (item.getMoonPhase().equals("First Quarter")) {
            sortedByPhase.set(2, firstQ += 1);
        } else if (item.getMoonPhase().equals("Waxing Gibbous")) {
            sortedByPhase.set(3, waxGib += 1);
        } else if (item.getMoonPhase().equals("Full Moon")) {
            sortedByPhase.set(4, fullM += 1);
        } else if (item.getMoonPhase().equals("Waning Gibbous")) {
            sortedByPhase.set(5, wanGib += 1);
        } else if (item.getMoonPhase().equals("Third Quarter")) {
            sortedByPhase.set(6, thirdQ += 1);
        } else {
            sortedByPhase.set(7, wanCr += 1);
        }
    }
}




