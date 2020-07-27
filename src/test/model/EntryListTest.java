package model;

import exceptions.IllegalListSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EntryListTest {
    private EntryList newEntryList;
    private Entry newMoonEntryOne;
    private Entry newMoonEntryTwo;
    private Entry waxingCrescentOne;
    private Entry waxingCrescentTwo;
    private Entry firstQuarterSingleEntry;
    private Entry waxingGibbousSingleEntry;
    private Entry fullMoonEntryOne;
    private Entry fullMoonEntryTwo;
    private Entry waningGibbousEntryOne;
    private Entry waningGibbousEntryTwo;
    private Entry thirdQuarterSingleEntry;
    private Entry waningCrescentSingleEntry;

    public EntryListTest() {
    }

    @BeforeEach
    public void setUpBeforeEachTest() {
        newEntryList = new EntryList();
        newMoonEntryOne = new Entry("New Moon", 135);
        newMoonEntryTwo = new Entry("New Moon", 45);
        waxingCrescentOne = new Entry("Waxing Crescent", 90);
        waxingCrescentTwo = new Entry("Waxing Crescent", 0);
        firstQuarterSingleEntry = new Entry("First Quarter", 135);
        waxingGibbousSingleEntry = new Entry("Waxing Gibbous", 0);
        fullMoonEntryOne = new Entry("Full Moon", 180);
        fullMoonEntryTwo = new Entry("Full Moon", 90);
        waningGibbousEntryOne = new Entry("Waning Gibbous", 180);
        waningGibbousEntryTwo = new Entry("Waning Gibbous", 180);
        thirdQuarterSingleEntry = new Entry("Third Quarter", 45);
        waningCrescentSingleEntry = new Entry("Waning Crescent", 90);
    }

    @Test
    void testAddObservationUnexpectedIllegalSizeException() {
        try {
            newEntryList.addObservation(newMoonEntryOne);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        assertEquals(1, newEntryList.size());
    }

    @Test
    void testAddObservationsExpectIllegalSizeException() {
        for (int i = 0; i <= 7 ; i++) {
            try {
                newEntryList.addObservation(waxingGibbousSingleEntry);
            } catch (IllegalListSize illegalListSize) {
                // expect this
            }
        }
        assertEquals(5, newEntryList.size());
    }

    @Test
    void testRemoveObservation() {
        try {
            newEntryList.addObservation(firstQuarterSingleEntry);
            newEntryList.addObservation(thirdQuarterSingleEntry);
            newEntryList.addObservation(firstQuarterSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }

        try {
            newEntryList.removeObservation(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            fail("Unexpected IndexOutOfBoundsException Exception");
        }

        assertEquals(2, newEntryList.size());
        assertEquals(thirdQuarterSingleEntry, newEntryList.getEntryFromList(0));
        assertEquals(firstQuarterSingleEntry, newEntryList.getEntryFromList(1));
    }

    @Test
    void testRemoveObservationFromEmptyList() {
        assertEquals(0, newEntryList.size());
        try {
            newEntryList.removeObservation(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // expect this
        }
        assertEquals(0, newEntryList.size());


    }

    @Test
    void testIncrementNewMoon() {
        try {
            newEntryList.addObservation(newMoonEntryOne);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.increment(newMoonEntryOne);
        assertEquals(1, newEntryList.getIndexValue(0));
    }

    @Test
    void testIncrementWaxingCrescent() {
        try {
            newEntryList.addObservation(waxingCrescentOne);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.increment(waxingCrescentOne);
        assertEquals(1, newEntryList.getIndexValue(1));
    }

    @Test
    void testIncrementFirstQuarter() {
        try {
            newEntryList.addObservation(firstQuarterSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.increment(firstQuarterSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(2));
    }

    @Test
    void testIncrementWaxingGibbous() {
        try {
            newEntryList.addObservation(waxingGibbousSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.increment(waxingGibbousSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(3));
    }

    @Test
    void testIncrementFullMoon() {
        try {
            newEntryList.addObservation(fullMoonEntryOne);
            newEntryList.addObservation(fullMoonEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }

        newEntryList.increment(fullMoonEntryOne);
        assertEquals(1, newEntryList.getIndexValue(4));
        newEntryList.increment(fullMoonEntryTwo);
        assertEquals(2, newEntryList.getIndexValue(4));
    }

    @Test
    void testIncrementWaningGibbous() {
        try {
            newEntryList.addObservation(waningGibbousEntryOne);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.increment(waningGibbousEntryOne);
        assertEquals(1, newEntryList.getIndexValue(5));
    }

    @Test
    void testIncrementThirdQuarter() {
        try {
            newEntryList.addObservation(thirdQuarterSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.increment(thirdQuarterSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(6));
    }

    @Test
    void testIncrementWaningCrescent() {
        try {
            newEntryList.addObservation(waningCrescentSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.increment(waningCrescentSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(7));
    }

    @Test
    void testSortAndCountListByPhaseMoreThanOnceOnSameList() {
        try {
            newEntryList.addObservation(newMoonEntryOne);
            newEntryList.addObservation(newMoonEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(2, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());

        newEntryList.sortAndCountListByPhase();
        assertEquals(2, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseMoreThanOnceOnSameListAfterRemovingOneOfSamePhase() {
        try {
            newEntryList.addObservation(newMoonEntryOne);
            newEntryList.addObservation(newMoonEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(2, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());

        try {
            newEntryList.removeObservation(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            fail("Unexpected IndexOutOfBoundsException Exception");
        }
        newEntryList.sortAndCountListByPhase();
        assertEquals(1, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseMoreThanOnceOnSameListAfterRemovingOneOfDifferentPhase() {
        try {
            newEntryList.addObservation(newMoonEntryOne);
            newEntryList.addObservation(firstQuarterSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(1, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(1, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());

        try {
            newEntryList.removeObservation(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            fail("Unexpected IndexOutOfBoundsException Exception");
        }
        newEntryList.sortAndCountListByPhase();
        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(1, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyNewMoon() {
        try {
            newEntryList.addObservation(newMoonEntryOne);
            newEntryList.addObservation(newMoonEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(2, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaxingCrescent() {
        try {
            newEntryList.addObservation(waxingCrescentOne);
            newEntryList.addObservation(waxingCrescentTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(2, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyFirstQuarter() {
        try {
            newEntryList.addObservation(firstQuarterSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(1, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaxingGibbous() {
        try {
            newEntryList.addObservation(waxingGibbousSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(1, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyFullMoon() {
        try {
            newEntryList.addObservation(fullMoonEntryOne);
            newEntryList.addObservation(fullMoonEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");

        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(2, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaningGibbous() {
        try {
            newEntryList.addObservation(waningGibbousEntryOne);
            newEntryList.addObservation(waningGibbousEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }

        newEntryList.sortAndCountListByPhase();

        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(2, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyThirdQuarter() {
        try {
            newEntryList.addObservation(thirdQuarterSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(1, newEntryList.getIndexValue(6));
        assertEquals(0, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaningCrescent() {
        try {
            newEntryList.addObservation(waningCrescentSingleEntry);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(0, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(0, newEntryList.getIndexValue(3));
        assertEquals(0, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(1, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseManyDifferentPhasesSomePhasesOmitted() {

        try {
            newEntryList.addObservation(waxingGibbousSingleEntry);
            newEntryList.addObservation(waningCrescentSingleEntry);
            newEntryList.addObservation(newMoonEntryOne);
            newEntryList.addObservation(fullMoonEntryTwo);
            newEntryList.addObservation(newMoonEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected NotIllegalListSize Exception");
        }

        newEntryList.sortAndCountListByPhase();

        assertEquals(2, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(1, newEntryList.getIndexValue(3));
        assertEquals(1, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(0, newEntryList.getIndexValue(6));
        assertEquals(1, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }

    @Test
    void testSortAndCountListByPhaseManyDifferentPhasesTooManyEntries() {
        try {
            newEntryList.addObservation(waxingGibbousSingleEntry);
            newEntryList.addObservation(waningCrescentSingleEntry);
            newEntryList.addObservation(thirdQuarterSingleEntry);
            newEntryList.addObservation(newMoonEntryOne);
            newEntryList.addObservation(fullMoonEntryTwo);
        } catch (IllegalListSize illegalListSize) {
            fail("Unexpected IllegalListSize Exception");
        }
        try {
            newEntryList.addObservation(firstQuarterSingleEntry);
            newEntryList.addObservation(waningGibbousEntryOne);
            newEntryList.addObservation(thirdQuarterSingleEntry);
        } catch (IllegalListSize illegalListsize) {
            // expect this
        }
        newEntryList.sortAndCountListByPhase();

        assertEquals(1, newEntryList.getIndexValue(0));
        assertEquals(0, newEntryList.getIndexValue(1));
        assertEquals(0, newEntryList.getIndexValue(2));
        assertEquals(1, newEntryList.getIndexValue(3));
        assertEquals(1, newEntryList.getIndexValue(4));
        assertEquals(0, newEntryList.getIndexValue(5));
        assertEquals(1, newEntryList.getIndexValue(6));
        assertEquals(1, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }
}
