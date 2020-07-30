package persistence;

import java.io.PrintWriter;

// Represents data that can be saved to file based on Reader in AccountNotRobust
public interface Saveable {
    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printWriter
    void save(PrintWriter printWriter);
}
