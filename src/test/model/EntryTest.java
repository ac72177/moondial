package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EntryTest {
    Entry newObservation;

    @Test
    void testConstructorValidMoonPhaseAndValidAngle() {
        newObservation = new Entry("Waxing Crescent", 90);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.getTime());
    }

    @Test
    void testEntryConstructorThreeParameters() {
        newObservation = new Entry("Full Moon", 135, "Noon");

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.getTime());
    }

    @Test
    public void testIdentifyTimeNewMoonIsNoon() {
        newObservation = new Entry("New Moon", 90);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.newMoonTime(90));
        assertEquals("Noon", newObservation.identifyTime("New Moon", 90));
    }

    @Test
    public void testIdentifyTimeNewMoonIs9AM() {
        newObservation = new Entry("New Moon", 45);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.newMoonTime(45));
        assertEquals("9AM", newObservation.identifyTime("New Moon", 45));
    }

    @Test
    public void testIdentifyTimeNewMoonIs6AM() {
        newObservation = new Entry("New Moon", 0);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.newMoonTime(0));
        assertEquals("6AM", newObservation.identifyTime("New Moon", 0));
    }

    @Test
    public void testIdentifyTimeNewMoonIs6PM() {
        newObservation = new Entry("New Moon", 180);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.newMoonTime(180));
        assertEquals("6PM", newObservation.identifyTime("New Moon", 180));
    }

    @Test
    public void testIdentifyTimeNewMoonIs3PM() {
        newObservation = new Entry("New Moon", 135);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.newMoonTime(135));
        assertEquals("3PM", newObservation.identifyTime("New Moon", 135));
    }

    // WaxingCrescent
    @Test
    public void testIdentifyTimeWaxingCrescentIs6PM() {
        newObservation = new Entry("Waxing Crescent", 135);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.waxingCrescentTime(135));
        assertEquals("6PM", newObservation.identifyTime("Waxing Crescent", 135));
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIs3PM() {
        newObservation = new Entry("Waxing Crescent", 90);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.waxingCrescentTime(90));
        assertEquals("3PM", newObservation.identifyTime("Waxing Crescent", 90));
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsNoon() {
        newObservation = new Entry("Waxing Crescent", 45);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.waxingCrescentTime(45));
        assertEquals("Noon", newObservation.identifyTime("Waxing Crescent", 45));
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIs9AM() {
        newObservation = new Entry("Waxing Crescent", 0);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.waxingCrescentTime(0));
        assertEquals("9AM", newObservation.identifyTime("Waxing Crescent", 0));
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIs9PM() {
        newObservation = new Entry("Waxing Crescent", 180);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.waxingCrescentTime(180));
        assertEquals("9PM", newObservation.identifyTime("Waxing Crescent", 180));
    }
    // FirstQuarter
    @Test
    public void testIdentifyTimeFirstQuarterIsMidnight() {
        newObservation = new Entry("First Quarter", 180);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.firstQuarterTime(180));
        assertEquals("Midnight", newObservation.identifyTime("First Quarter", 180));
    }

    @Test
    public void testIdentifyTimeFirstQuarterIs9PM() {
        newObservation = new Entry("First Quarter", 135);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.firstQuarterTime(135));
        assertEquals("9PM", newObservation.identifyTime("First Quarter", 135));
    }

    @Test
    public void testIdentifyTimeFirstQuarterIs6PM() {
        newObservation = new Entry("First Quarter", 90);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.firstQuarterTime(90));
        assertEquals("6PM", newObservation.identifyTime("First Quarter", 90));
    }

    @Test
    public void testIdentifyTimeFirstQuarterIs3PM() {
        newObservation = new Entry("First Quarter", 45);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.firstQuarterTime(45));
        assertEquals("3PM", newObservation.identifyTime("First Quarter", 45));
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsNoon() {
        newObservation = new Entry("First Quarter", 0);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.firstQuarterTime(0));
        assertEquals("Noon", newObservation.identifyTime("First Quarter", 0));
    }

    // WaxingGibbous
    @Test
    public void testIdentifyTimeWaxingGibbousIs3AM() {
        newObservation = new Entry("Waxing Gibbous", 180);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.waxingGibbousTime(180));
        assertEquals("3AM", newObservation.identifyTime("Waxing Gibbous", 180));
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsMidnight() {
        newObservation = new Entry("Waxing Gibbous", 135);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.waxingGibbousTime(135));
        assertEquals("Midnight", newObservation.identifyTime("Waxing Gibbous", 135));
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIs9PM() {
        newObservation = new Entry("Waxing Gibbous", 90);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.waxingGibbousTime(90));
        assertEquals("9PM", newObservation.identifyTime("Waxing Gibbous", 90));
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIs6PM() {
        newObservation = new Entry("Waxing Gibbous", 45);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.waxingGibbousTime(45));
        assertEquals("6PM", newObservation.identifyTime("Waxing Gibbous", 45));
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIs3PM() {
        newObservation = new Entry("Waxing Gibbous", 0);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.waxingGibbousTime(0));
        assertEquals("3PM", newObservation.identifyTime("Waxing Gibbous", 0));
    }

    // FullMoon
    @Test
    public void testIdentifyTimeFullMoonIs6AM() {
        newObservation = new Entry("Full Moon", 180);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.fullMoonTime(180));
        assertEquals("6AM", newObservation.identifyTime("Full Moon", 180));
    }

    @Test
    public void testIdentifyTimeFullMoonIs3AM() {
        newObservation = new Entry("Full Moon", 135);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.fullMoonTime(135));
        assertEquals("3AM", newObservation.identifyTime("Full Moon", 135));
    }

    @Test
    public void testIdentifyTimeFullMoonIsMidnight() {
        newObservation = new Entry("Full Moon", 90);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.fullMoonTime(90));
        assertEquals("Midnight", newObservation.identifyTime("Full Moon", 90));
    }

    @Test
    public void testIdentifyTimeFullMoonIs9PM() {
        newObservation = new Entry("Full Moon", 45);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.fullMoonTime(45));
        assertEquals("9PM", newObservation.identifyTime("Full Moon", 45));
    }

    @Test
    public void testIdentifyTimeFullMoonIs6PM() {
        newObservation = new Entry("Full Moon", 0);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.fullMoonTime(0));
        assertEquals("6PM", newObservation.identifyTime("Full Moon", 0));
    }

    // WaningGibbous

    @Test
    public void testIdentifyTimeWaningGibbousIs9AM() {
        newObservation = new Entry("Waning Gibbous", 180);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.waningGibbousTime(180));
        assertEquals("9AM", newObservation.identifyTime("Waning Gibbous", 180));
    }

    @Test
    public void testIdentifyTimeWaningGibbousIs6AM() {
        newObservation = new Entry("Waning Gibbous", 135);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.waningGibbousTime(135));
        assertEquals("6AM", newObservation.identifyTime("Waning Gibbous", 135));
    }

    @Test
    public void testIdentifyTimeWaningGibbousIs3AM() {
        newObservation = new Entry("Waning Gibbous", 90);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.waningGibbousTime(90));
        assertEquals("3AM", newObservation.identifyTime("Waning Gibbous", 90));
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsMidnight() {
        newObservation = new Entry("Waning Gibbous", 45);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.waningGibbousTime(45));
        assertEquals("Midnight", newObservation.identifyTime("Waning Gibbous", 45));
    }

    @Test
    public void testIdentifyTimeWaningGibbousIs9PM() {
        newObservation = new Entry("Waning Gibbous", 0);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.waningGibbousTime(0));
        assertEquals("9PM", newObservation.identifyTime("Waning Gibbous", 0));
    }
    // ThirdQuarter
    @Test
    public void testIdentifyTimeThirdQuarterIsMidnight() {
        newObservation = new Entry("Third Quarter", 0);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.thirdQuarterTime(0));
        assertEquals("Midnight", newObservation.identifyTime("Third Quarter", 0));
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsNoon() {
        newObservation = new Entry("Third Quarter", 180);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.thirdQuarterTime(180));
        assertEquals("Noon", newObservation.identifyTime("Third Quarter", 180));
    }

    @Test
    public void testIdentifyTimeThirdQuarterIs9AM() {
        newObservation = new Entry("Third Quarter", 135);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.thirdQuarterTime(135));
        assertEquals("9AM", newObservation.identifyTime("Third Quarter", 135));
    }

    @Test
    public void testIdentifyTimeThirdQuarterIs6AM() {
        newObservation = new Entry("Third Quarter", 90);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.thirdQuarterTime(90));
        assertEquals("6AM", newObservation.identifyTime("Third Quarter", 90));
    }

    @Test
    public void testIdentifyTimeThirdQuarterIs3AM() {
        newObservation = new Entry("Third Quarter", 45);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.thirdQuarterTime(45));
        assertEquals("3AM", newObservation.identifyTime("Third Quarter", 45));
    }
    // WaningCrescent
    @Test
    public void testIdentifyTimeWaningCrescentIs6AM() {
        newObservation = new Entry("Waning Crescent", 45);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.waningCrescentTime(45));
        assertEquals("6AM", newObservation.identifyTime("Waning Crescent", 45));
    }

    @Test
    public void testIdentifyTimeWaningCrescentIs3AM() {
        newObservation = new Entry("Waning Crescent", 0);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.waningCrescentTime(0));
        assertEquals("3AM", newObservation.identifyTime("Waning Crescent", 0));
    }


    @Test
    public void testIdentifyTimeWaningCrescentIs3PM() {
        newObservation = new Entry("Waning Crescent", 180);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.waningCrescentTime(180));
        assertEquals("3PM", newObservation.identifyTime("Waning Crescent", 180));
    }

    @Test
    public void testIdentifyTimeWaningCrescentIsNoon() {
        newObservation = new Entry("Waning Crescent", 135);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.waningCrescentTime(135));
        assertEquals("Noon", newObservation.identifyTime("Waning Crescent", 135));
    }

    @Test
    public void testIdentifyTimeWaningCrescentIs9AM() {
        newObservation = new Entry("Waning Crescent", 90);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.waningCrescentTime(90));
        assertEquals("9AM", newObservation.identifyTime("Waning Crescent", 90));
    }
}

