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
        assertEquals(thirdQuarterSingleEntry, newEntryList.getEntry(thirdQuarterSingleEntry));
        assertEquals(firstQuarterSingleEntry, newEntryList.getEntry(firstQuarterSingleEntry));
    }

    @Test
    void testSortAndCountListByPhaseOnlyNewMoon() {
        newEntryList.addObservation(newMoonEntryOne);
        newEntryList.addObservation(newMoonEntryTwo);

        assertEquals(2, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaxingCrescent() {
        newEntryList.addObservation(waxingCrescentOne);
        newEntryList.addObservation(waxingCrescentTwo);

        assertEquals(0, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(2, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseOnlyFirstQuarter() {
        newEntryList.addObservation(firstQuarterSingleEntry);

        assertEquals(0, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaxingGibbous() {
        newEntryList.addObservation(waxingGibbousSingleEntry);

        assertEquals(0, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseOnlyFullMoon() {
        newEntryList.addObservation(fullMoonEntryOne);
        newEntryList.addObservation(fullMoonEntryTwo);

        assertEquals(0, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(2, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaningGibbous() {
        newEntryList.addObservation(waningGibbousEntryOne);
        newEntryList.addObservation(waningGibbousEntryTwo);

        assertEquals(0, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(2, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseOnlyThirdQuarter() {
        newEntryList.addObservation(thirdQuarterSingleEntry);

        assertEquals(0, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseOnlyWaningCrescent() {
        newEntryList.addObservation(waningCrescentSingleEntry);

        assertEquals(0, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }

    @Test
    void testSortAndCountListByPhaseManyDifferentPhasesSomePhasesOmitted() {
        newEntryList.addObservation(waxingGibbousSingleEntry);
        newEntryList.addObservation(waningCrescentSingleEntry);
        newEntryList.addObservation(newMoonEntryOne);
        newEntryList.addObservation(fullMoonEntryTwo);
        newEntryList.addObservation(newMoonEntryTwo);

        assertEquals(2, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(0, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
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

        assertEquals(2, newEntryList.sortAndCountListByPhase().get(0));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(1));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(2));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(3));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(4));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(5));
        assertEquals(3, newEntryList.sortAndCountListByPhase().get(6));
        assertEquals(1, newEntryList.sortAndCountListByPhase().get(7));
        assertEquals(8, newEntryList.sortAndCountListByPhase().size());
    }
}
