package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryListTest {
    private EntryList newEntryList;
    private final Entry newMoonEntryOne;
    private final Entry newMoonEntryTwo;
    private final Entry waxingCrescentOne;
    private final Entry waxingCrescentTwo;
    private final Entry firstQuarterSingleEntry;
    private final Entry waxingGibbousSingleEntry;
    private final Entry fullMoonEntryOne;
    private final Entry fullMoonEntryTwo;
    private final Entry waningGibbousEntryOne;
    private final Entry waningGibbousEntryTwo;
    private final Entry thirdQuarterSingleEntry;
    private final Entry waningCrescentSingleEntry;
    {
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

    @BeforeEach
    public void runBefore() {
        newEntryList = new EntryList();
    }

    @Test
    void testAddOneObservation() {
        newEntryList.addObservation(newMoonEntryOne);
        assertEquals(1, newEntryList.size());
    }

    @Test
    void testAddManyObservations() {
        for (int i = 0; i < 1000; i++) {
            newEntryList.addObservation(waxingGibbousSingleEntry);
        }
        assertEquals(1000, newEntryList.size());
    }

    @Test
    void testRemoveObservation() {
        newEntryList.addObservation(firstQuarterSingleEntry);
        newEntryList.addObservation(thirdQuarterSingleEntry);
        newEntryList.addObservation(firstQuarterSingleEntry);
        newEntryList.removeObservation(firstQuarterSingleEntry);

        assertEquals(2, newEntryList.size());
        assertEquals(thirdQuarterSingleEntry, newEntryList.getEntryFromList(0));
        assertEquals(firstQuarterSingleEntry, newEntryList.getEntryFromList(1));
    }

    @Test
    void testIncrementNewMoon() {
        newEntryList.addObservation(newMoonEntryOne);
        newEntryList.increment(newMoonEntryOne);
        assertEquals(1, newEntryList.getIndexValue(0));
    }

    @Test
    void testIncrementWaxingCrescent() {
        newEntryList.addObservation(waxingCrescentOne);
        newEntryList.increment(waxingCrescentOne);
        assertEquals(1, newEntryList.getIndexValue(1));
    }

    @Test
    void testIncrementFirstQuarter() {
        newEntryList.addObservation(firstQuarterSingleEntry);
        newEntryList.increment(firstQuarterSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(2));
    }

    @Test
    void testIncrementWaxingGibbous() {
        newEntryList.addObservation(waxingGibbousSingleEntry);
        newEntryList.increment(waxingGibbousSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(3));
    }

    @Test
    void testIncrementFullMoon() {
        newEntryList.addObservation(fullMoonEntryOne);
        newEntryList.addObservation(fullMoonEntryTwo);
        newEntryList.increment(fullMoonEntryOne);
        assertEquals(1, newEntryList.getIndexValue(4));
        newEntryList.increment(fullMoonEntryTwo);
        assertEquals(2, newEntryList.getIndexValue(4));
    }

    @Test
    void testIncrementWaningGibbous() {
        newEntryList.addObservation(waningGibbousEntryOne);
        newEntryList.increment(waningGibbousEntryOne);
        assertEquals(1, newEntryList.getIndexValue(5));
    }

    @Test
    void testIncrementThirdQuarter() {
        newEntryList.addObservation(thirdQuarterSingleEntry);
        newEntryList.increment(thirdQuarterSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(6));
    }

    @Test
    void testIncrementWaningCrescent() {
        newEntryList.addObservation(waningCrescentSingleEntry);
        newEntryList.increment(waningCrescentSingleEntry);
        assertEquals(1, newEntryList.getIndexValue(7));
    }

    @Test
    void testSortAndCountListByPhaseOnlyNewMoon() {
        newEntryList.addObservation(newMoonEntryOne);
        newEntryList.addObservation(newMoonEntryTwo);
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
        newEntryList.addObservation(waxingCrescentOne);
        newEntryList.addObservation(waxingCrescentTwo);
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
        newEntryList.addObservation(firstQuarterSingleEntry);
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
        newEntryList.addObservation(waxingGibbousSingleEntry);
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
        newEntryList.addObservation(fullMoonEntryOne);
        newEntryList.addObservation(fullMoonEntryTwo);
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
        newEntryList.addObservation(waningGibbousEntryOne);
        newEntryList.addObservation(waningGibbousEntryTwo);
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
        newEntryList.addObservation(thirdQuarterSingleEntry);
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
        newEntryList.addObservation(waningCrescentSingleEntry);
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
        newEntryList.addObservation(waxingGibbousSingleEntry);
        newEntryList.addObservation(waningCrescentSingleEntry);
        newEntryList.addObservation(newMoonEntryOne);
        newEntryList.addObservation(fullMoonEntryTwo);
        newEntryList.addObservation(newMoonEntryTwo);
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
    void testSortAndCountListByPhaseManyDifferentPhasesAllPhasesIncludedWithRepeats() {
        newEntryList.addObservation(waxingGibbousSingleEntry);
        newEntryList.addObservation(waningCrescentSingleEntry);
        newEntryList.addObservation(thirdQuarterSingleEntry);
        newEntryList.addObservation(newMoonEntryOne);
        newEntryList.addObservation(fullMoonEntryTwo);
        newEntryList.addObservation(thirdQuarterSingleEntry);
        newEntryList.addObservation(newMoonEntryTwo);
        newEntryList.addObservation(waxingCrescentTwo);
        newEntryList.addObservation(firstQuarterSingleEntry);
        newEntryList.addObservation(waningGibbousEntryOne);
        newEntryList.addObservation(thirdQuarterSingleEntry);
        newEntryList.sortAndCountListByPhase();

        assertEquals(2, newEntryList.getIndexValue(0));
        assertEquals(1, newEntryList.getIndexValue(1));
        assertEquals(1, newEntryList.getIndexValue(2));
        assertEquals(1, newEntryList.getIndexValue(3));
        assertEquals(1, newEntryList.getIndexValue(4));
        assertEquals(1, newEntryList.getIndexValue(5));
        assertEquals(3, newEntryList.getIndexValue(6));
        assertEquals(1, newEntryList.getIndexValue(7));
        assertEquals(8, newEntryList.getSortedListSize());
    }
}
