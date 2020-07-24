package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of observations of the moon
public class EntryList {
    protected final List<Entry> entries;

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
}




