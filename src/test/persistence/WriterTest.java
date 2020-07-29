package persistence;

import exceptions.IllegalListSize;
import model.Entry;
import model.EntryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class WriterTest {
    private static final String TEST_FILE = "./data/testEntryList.txt";
    private Writer testWriter;
    private EntryList entryList;
    private EntryList pastEntryList;
    private Entry newMoonEntry;
    private Entry waxCrEntry;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        entryList = new EntryList();
        newMoonEntry = new Entry("New Moon", 90);
        waxCrEntry = new Entry("Waxing Crescent", 135);
        try {
            entryList.addObservation(newMoonEntry);
            entryList.addObservation(waxCrEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize exception");
        }
    }

    @Test
    void testWriteAccounts() {
        // save entryList to file
        testWriter.write(entryList);
        testWriter.close();

        // now read them back in and verify that the entry list has the expected values
        try {
            pastEntryList = Reader.readEntryList(new File(TEST_FILE));
            entryList = pastEntryList;
            assertEquals(newMoonEntry, getEntryFromPastList(0));
            assertEquals(waxCrEntry, pastEntryList.getEntryFromList(1));

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    //
    private void getEntryFromPastList(int i) {
        pastEntryList.getEntryFromList(i);
    }
}