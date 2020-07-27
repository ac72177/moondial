package ui;

import exceptions.IllegalListSize;
import model.Entry;
import model.EntryList;

import java.util.List;
import java.util.Scanner;

// Time Estimator Application based on TellerApp in AccountNotRobust

public class MoondialApp {
    private EntryList entryList;
    private List<Integer> sortedByPhase;
    private Scanner input;
    private String moonPhase;
    private int angleFromEast;
    private Entry entry;

    // EFFECTS: runs the teller application
    public MoondialApp() {
        runMoondial();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runMoondial() {
        boolean keepGoing = true;
        String command;
        input = new Scanner(System.in);

        initialize();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes an empty Entry List and sorted List by phase
    private void initialize() {
        entryList = new EntryList();
        sortedByPhase = entryList.sortAndCountListByPhase();
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tm -> make observation");
        System.out.println("\tr -> remove entry");
        System.out.println("\te -> print entry");
        System.out.println("\tp -> select list to print");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("m")) {
            doMakeObservation();
        } else if (command.equals("r")) {
            doRemoveEntry();
        } else if (command.equals("e")) {
            printSelectedEntry();
        } else if (command.equals("p")) {
            printList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: makes an observation and adds it to the end of the list
    private void doMakeObservation() {
        moonPhase = selectMoonPhase();
        angleFromEast = selectAngleFromEast();
        entry = new Entry(moonPhase, angleFromEast);
        try {
            entryList.addObservation(entry);
        } catch (IllegalListSize illegalListSize) {
            System.err.println("The entry list has reached maximum capacity. Please remove an entry.");
        }
        System.out.println("You observed the " + moonPhase + " at " + angleFromEast + " degrees at "
                + entry.getTime() + ".");
    }

    // EFFECTS: prompts user to select moon phase
    private String selectMoonPhase() {
        String selectionMoonPhase = ""; // force entry into loop

        while (!(selectionMoonPhase.equals("nm") || selectionMoonPhase.equals("waxcr")
                || selectionMoonPhase.equals("firstq") || selectionMoonPhase.equals("waxgib")
                || selectionMoonPhase.equals("fullm") || selectionMoonPhase.equals("wangib")
                || selectionMoonPhase.equals("thirdq") || selectionMoonPhase.equals("wancr"))) {
            System.out.println("Please input phase as viewed from the N.Hemisphere");
            System.out.println();
            System.out.println("nm -> New Moon");
            System.out.println("waxcr -> Waxing Crescent");
            System.out.println("firstq -> First Quarter");
            System.out.println("waxgib -> Waxing Gibbous");
            System.out.println("fullm -> Full Moon");
            System.out.println("wangib -> Waning Gibbous");
            System.out.println("thirdq -> Third Quarter");
            System.out.println("wancr -> Waning Crescent");
            selectionMoonPhase = input.next();
            selectionMoonPhase = selectionMoonPhase.toLowerCase();
        }

        return expandPhase(selectionMoonPhase);
    }

    // EFFECTS: expands a shortened moon phase to full name
    private String expandPhase(String s) {
        if (s.equals("nm")) {
            return "New Moon";
        } else if (s.equals("waxcr")) {
            return "Waxing Crescent";
        } else if (s.equals("firstq")) {
            return "First Quarter";
        } else if (s.equals("waxgib")) {
            return "Waxing Gibbous";
        } else if (s.equals("fullm")) {
            return "Full Moon";
        } else if (s.equals("wangib")) {
            return "Waning Gibbous";
        } else if (s.equals("thirdq")) {
            return "Third Quarter";
        } else if (s.equals("wancr")) {
            return "Waning Crescent";
        } else {
            return null;
        }
    }

    // EFFECTS: prompts user to select angle from east
    private int selectAngleFromEast() {
        String selectionAngle = ""; // force entry into loop

        while (!(selectionAngle.equals("0") || selectionAngle.equals("45") || selectionAngle.equals("90")
                || selectionAngle.equals("135") || selectionAngle.equals("180"))) {
            System.out.println("Please input Angle from East when facing South.");
            System.out.println();
            System.out.println("0 -> 0 degrees");
            System.out.println("45 -> 45 degrees");
            System.out.println("90 -> 90 degrees");
            System.out.println("135 -> 135 degrees");
            System.out.println("180 -> 180 degrees");
            selectionAngle = input.next();
        }

        return convertAngle(selectionAngle);
    }

    // EFFECTS: changes a string representing an angle value into an integer
    private int convertAngle(String a) {
        if (a.equals("0")) {
            return 0;
        } else if (a.equals("45")) {
            return 45;
        } else if (a.equals("90")) {
            return 90;
        } else if (a.equals("135")) {
            return 135;
        } else if (a.equals("180")) {
            return 180;
        } else {
            return 156;
        }
    }

    // MODIFIES: this
    // EFFECTS: removes specified entry from entry list
    private void doRemoveEntry() {
        printEntryList();
        try {
            entryList.removeObservation(selectEntry());
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.err.println("This is out of the bounds of the list.");
        }
        entryList.sortAndCountListByPhase();
        printEntryList();
    }

    // MODIFIES: this
    // EFFECTS: selects Entry
    private int selectEntry() {
        String selectionEntry = ""; // force entry into loop

        while (!(selectionEntry.equals("0") || (selectionEntry.equals("1")) || (selectionEntry.equals("2"))
                || (selectionEntry.equals("3")) || (selectionEntry.equals("4")))) {
            System.out.println("0 -> Entry 0");
            System.out.println("1 -> Entry 1");
            System.out.println("2 -> Entry 2");
            System.out.println("3 -> Entry 3");
            System.out.println("4 -> Entry 4");
            selectionEntry = input.next();
        }

        if (selectionEntry.equals("0")) {
            return 0;
        } else if (selectionEntry.equals("1")) {
            return 1;
        } else if (selectionEntry.equals("2")) {
            return 2;
        } else if (selectionEntry.equals("3")) {
            return 3;
        } else if (selectionEntry.equals("4")) {
            return 4;
        } else {
            return 5;
        }

    }

    // EFFECTS: prints specified entry
    private void printEntry(int i) {
        System.out.println("Entry " + i + ": " + getEntryMoonPhaseFromEntryList(i)
                + " " + getEntryAngleFromEntryList(i) + " degrees at " + getEntryTimeFromEntryList(i));

    }

    // EFFECTS: prompts user to select an entry and prints entry to screen,
    private void printSelectedEntry() {
//        selectEntryToPrint();
//    }
//
//    // EFFECTS: selects entry to print, and returns true if index of entry is in list, false otherwise
//    private boolean selectEntryToPrint() {
        String selectionEntry = ""; // force entry into loop
        boolean notValidEntry = !(selectionEntry.equals("0") || (selectionEntry.equals("1"))
                || (selectionEntry.equals("2")) || (selectionEntry.equals("3")) || (selectionEntry.equals("4")));

        while (notValidEntry) {
            System.out.println("0 for Entry 0");
            System.out.println("1 for Entry 1");
            System.out.println("2 for Entry 2");
            System.out.println("3 for Entry 3");
            System.out.println("4 for Entry 4");
            selectionEntry = input.next();
        }

        printEntryAtValidIndex(selectionEntry);
    }

    // EFFECTS: prints entry at selected index
    private void printEntryAtValidIndex(String selectionEntry) {
        if (selectionEntry.equals("0")) {
            printEntry(0);
        } else if (selectionEntry.equals("1")) {
            printEntry(1);
        } else if (selectionEntry.equals("2")) {
            printEntry(2);
        } else if (selectionEntry.equals("3")) {
            printEntry(3);
        } else if (selectionEntry.equals("4")) {
            printEntry(4);
        } else {
            System.out.println("This is not a valid entry.");
        }
    }

    // EFFECTS: prompts user to select entry list or sorted list and prints it
    private void printList() {
        String selectionList = ""; // force entry into loop

        while (!(selectionList.equals("e") || (selectionList.equals("s")))) {
            System.out.println("Select a list to print.");


            System.out.println("e -> Entry List");
            System.out.println("s -> Sorted List");
            selectionList = input.next();
            selectionList = selectionList.toLowerCase();
        }

        if (selectionList.equals("e")) {
            printEntryList();
        } else {
            printSortedByPhase();
        }
    }

    // EFFECTS: prints sortedByPhase
    private void printSortedByPhase() {
        if (entryList.size() == 0) {
            System.out.println("No observations have been made.");
        }
        entryList.sortAndCountListByPhase();
        System.out.println(" Here is your summary of observations");
        System.out.println(" ");
        System.out.println("# of New Moon = " + sortedByPhase.get(0));
        System.out.println("# of Waxing Crescent = " + sortedByPhase.get(1));
        System.out.println("# of First Quarter = " + sortedByPhase.get(2));
        System.out.println("# of Waxing Gibbous = " + sortedByPhase.get(3));
        System.out.println("# of Full Moon = " + sortedByPhase.get(4));
        System.out.println("# of Waning Gibbous = " + sortedByPhase.get(5));
        System.out.println("# of Third Quarter = " + sortedByPhase.get(6));
        System.out.println("# of Waning Crescent = " + sortedByPhase.get(7));
    }

    // EFFECTS: prints entry List
    private void printEntryList() {
        if (!(entryList.size() == 0)) {
            for (int i = 0; i < entryList.size(); i++) {
                printEntry(i);
            }
        } else {
            System.out.println("No Observations have been made.");
        }
        System.out.println(entryList);
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's moon phase
    public String getEntryMoonPhaseFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getMoonPhase();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's angle
    public int getEntryAngleFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getAngleFromEast();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's angle
    public String getEntryTimeFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getTime();
    }
}

