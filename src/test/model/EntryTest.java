package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EntryTest {
    Entry newEntry;

    @Test
    void testConstructorValidMoonPhaseAndValidAngle() {
            newEntry = new Entry("Waxing Crescent", 90);


        assertEquals("3PM", newEntry.getTime());
    }
}
