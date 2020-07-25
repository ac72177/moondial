package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryTest {
    Entry newEntry;

    @Test
    void testConstructor() {
        newEntry = new Entry("Waxing Crescent", 90);

        assertEquals("3PM", newEntry.getTime());
    }
}
