package persistence;

import model.Entry;
import model.EntryList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read an entry list from a file based on Reader in AccountNotRobust
public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns an entry list parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static EntryList readEntryList(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of entries parsed from list of strings
    // where each string contains data for one entry
    private static EntryList parseContent(List<String> fileContent) {
        EntryList entryList = new EntryList();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            entryList.add(parseEntry(lineComponents));
        }

        return entryList;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 3 where element 0 represents the
    // moon phase of the next Entry to be constructed, element 1 represents
    // the angle from the East facing South, element 2 represents the time of observation
    // EFFECTS: returns an entry constructed from components
    private static Entry parseEntry(List<String> components) {
        String phaseName = components.get(0);
        int angle = Integer.parseInt(components.get(1));
        String time = components.get(2);
        return new Entry(phaseName, angle, time);
    }
}

