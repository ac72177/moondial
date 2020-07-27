package ui;

import model.Entry;
import model.EntryList;

import java.util.List;
import java.util.Scanner;

// Time Estimator Application based on TellerApp in AccountNotRobust
public class MoondialApp {
    private EntryList entryList;
    private List<Integer> sortedByPhase;
    private Scanner input;

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
    // EFFECTS: initializes an empty entryList and sortedByPhase
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
        System.out.println("\tl -> print entry list");
        System.out.println("\ts -> print list summarized by phase");
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
        } else if (command.equals("l")) {
            printEntryList();
        } else if (command.equals("s")) {
            printSortedByPhase();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: makes an observation and adds it to the end of the list
    private void doMakeObservation() {
        String moonPhase = selectMoonPhase();
        int angleFromEast = selectAngleFromEast();
        Entry entry = new Entry(moonPhase, angleFromEast);
        entryList.addObservation(entry);
        System.out.println("You observed the " + moonPhase + " with " + angleFromEast + " degrees at "
                + entry.getTime());
    }

    // EFFECTS: prompts user to select moon phase
    private String selectMoonPhase() {
        String selectionMoonPhase = ""; // force entry into loop

        while (!(selectionMoonPhase.equals("nm") || selectionMoonPhase.equals("waxcr")
                || selectionMoonPhase.equals("firstq") || selectionMoonPhase.equals("waxgib")
                || selectionMoonPhase.equals("fullm") || selectionMoonPhase.equals("wangib")
                || selectionMoonPhase.equals("thirdq") || selectionMoonPhase.equals("wancr"))) {
            System.out.println("Input phase as viewed from the N.Hemisphere");
            System.out.println();
            System.out.println("nm for New Moon");
            System.out.println("waxcr for Waxing Crescent");
            System.out.println("firstq for First Quarter");
            System.out.println("waxgib for Waxing Gibbous");
            System.out.println("fullm for Full Moon");
            System.out.println("wangib for Waning Gibbous");
            System.out.println("thirdq for Third Quarter");
            System.out.println("wancr for Waning Crescent");
            selectionMoonPhase = input.next();
            selectionMoonPhase = selectionMoonPhase.toLowerCase();
        }

        return expandPhase(selectionMoonPhase);
    }

    // EFFECTS: expands a shortened phase to full titles
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
            return "Not a valid moon phase.";
        }
    }

    // EFFECTS: prompts user to select angle from east
    private int selectAngleFromEast() {
        String selectionAngle = ""; // force entry into loop

        while (!(selectionAngle.equals("0") || selectionAngle.equals("45") || selectionAngle.equals("90")
                || selectionAngle.equals("135") || selectionAngle.equals("180"))) {
            System.out.println("Input Angle from east (0, 45, 90, 135, 180)");
            System.out.println();
            System.out.println("0 for 0 degrees from East facing South");
            System.out.println("45 for 45 degrees from East facing South");
            System.out.println("90 for 90 degrees from East facing South");
            System.out.println("135 for 135 degrees from East facing South");
            System.out.println("180 for 180 degrees from East facing South");
            selectionAngle = input.next();
            selectionAngle = selectionAngle.toLowerCase();
        }

        return convertAngle(selectionAngle);
    }

    // EFFECTS: changes a string representing an angle value into an integer
    private Integer convertAngle(String a) {
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
            return 0; // stub (throw exception here CATCH EXCEPTION in the method that calls this method)
        }
    }


    // MODIFIES: this
    // EFFECTS: removes specified entry from entry list
    private void doRemoveEntry() {
        printEntryList();
        entryList.removeObservation(selectEntry());
        printEntryList();
    }

    // MODIFIES: this
    // EFFECTS: selects Entry
    private Entry selectEntry() {
        String selectionEntry = ""; // force entry into loop


        while (!(selectionEntry.equals("1") || (selectionEntry.equals("2")) || (selectionEntry.equals("3"))
                || (selectionEntry.equals("4")) || (selectionEntry.equals("5")))) {
            System.out.println("1 for first entry");
            System.out.println("2 for second entry");
            System.out.println("3 for third entry");
            System.out.println("4 for fourth entry");
            System.out.println("5 for fifth entry");
            selectionEntry = input.next();
        }

        if (selectionEntry.equals("1")) {
            return entryList.getEntryFromList(0);
        } else if (selectionEntry.equals("2")) {
            return entryList.getEntryFromList(1);
        } else if (selectionEntry.equals("3")) {
            return entryList.getEntryFromList(2);
        } else if (selectionEntry.equals("4")) {
            return entryList.getEntryFromList(3);
        } else if (selectionEntry.equals("5")) {
            return entryList.getEntryFromList(4);
        } else {
            return null;
        }
        // stub (throw exception here CATCH EXCEPTION in the method that calls this method)
    }

    // EFFECTS: prompts user to select entry list or sorted list and returns it
    private void printSortedByPhase() {
        System.out.println(" Here is your summary of observations");
        System.out.println(" ");
        System.out.println("# of New Moon = " + entryList.getIndexValue(0));
        System.out.println("# of Waxing Crescent = " + entryList.getIndexValue(1));
        System.out.println("# of First Quarter = " + entryList.getIndexValue(2));
        System.out.println("# of Waxing Gibbous = " + entryList.getIndexValue(3));
        System.out.println("# of Full Moon = " + entryList.getIndexValue(4));
        System.out.println("# of Waning Gibbous = " + entryList.getIndexValue(5));
        System.out.println("# of Third Quarter = " + entryList.getIndexValue(6));
        System.out.println("# of Waning Crescent = " + entryList.getIndexValue(7));
    }

    // EFFECTS: prints specified entry
    private void printEntry(int i) {

        System.out.println("Entry " + i + " " + getEntryMoonPhaseFromEntryList(i)
                + " " + getEntryAngleFromEntryList(i) + " degrees " + getEntryTimeFromEntryList(i));

    }

    // EFFECTS: prompts user to select an entry and prints entry to screen
    private void printSelectedEntry() {
        printEntryList();
        selectEntryToPrint();
    }

    // MODIFIES: this
    // EFFECTS: selects Entry
    private void selectEntryToPrint() {
        String selectionEntry = ""; // force entry into loop

        while (!(selectionEntry.equals("0") || (selectionEntry.equals("1")) || (selectionEntry.equals("2"))
                || (selectionEntry.equals("3")) || (selectionEntry.equals("4")))) {
            System.out.println("0 for 1st entry");
            System.out.println("1 for 2nd entry");
            System.out.println("2 for 3rd entry");
            System.out.println("3 for 4th entry");
            System.out.println("4 for 5th entry");
            selectionEntry = input.next();
        }

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
            System.out.println("Not a valid selection... ");
        }
        // stub (throw exception here CATCH EXCEPTION in the method that calls this method)
    }

    // EFFECTS: prints entry List
    private void printEntryList() {
        for (int i = 0; i < entryList.size(); i++) {
            printEntry(i);
        }
        System.out.println(entryList);
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's moonphase
    public String getEntryMoonPhaseFromEntryList(int i) {
        Entry entry = entryList.getEntryFromList(i);
        return entry.getMoonPhase();
    }

    // REQUIRES: observation is in list
    // MODIFIES: this
    // EFFECTS: returns specified entry's angle
    public double getEntryAngleFromEntryList(int i) {
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

