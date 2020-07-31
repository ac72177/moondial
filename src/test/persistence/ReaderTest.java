package persistence;

import model.Entry;
import model.EntryList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ReaderTest {

    @Test
    // dummy test suggested by TA in piazza for code coverage score
    void testReaderConstructorDummy() {
        Reader reader = new Reader();
    }

    @Test
    void testParseEntryListFile1() {
        try {
            EntryList entryList = Reader.readEntryList(new File("./data/testEntryFile1.txt"));
            Entry entryOne = entryList.getEntryFromList(0);
            assertEquals("New Moon", entryOne.getMoonPhase());
            assertEquals(90, entryOne.getAngleFromEast());
            assertEquals("Noon", entryOne.getTime());

            Entry entryTwo = entryList.getEntryFromList(1);
            assertEquals("Waxing Crescent", entryTwo.getMoonPhase());
            assertEquals(135, entryTwo.getAngleFromEast());
            assertEquals("6PM", entryTwo.getTime());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseAccountsFile2() {
        try {
            EntryList entryList = Reader.readEntryList(new File("./data/testEntryFile2.txt"));
            Entry entryOne = entryList.getEntryFromList(0);
            assertEquals("Full Moon", entryOne.getMoonPhase());
            assertEquals(180, entryOne.getAngleFromEast());
            assertEquals("6AM", entryOne.getTime());

            Entry entryTwo = entryList.getEntryFromList(1);
            assertEquals("Third Quarter", entryTwo.getMoonPhase());
            assertEquals(45, entryTwo.getAngleFromEast());
            assertEquals("3AM", entryTwo.getTime());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readEntryList(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}