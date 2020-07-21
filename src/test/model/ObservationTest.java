package model;

import org.junit.jupiter.api.Test;

// Unit tests for Observation

import static org.junit.jupiter.api.Assertions.*;

class ObservationTest {
    private Observation newObservation;


    @Test
    public void testIdentifyTimeNewMoonIsNoon() {
        newObservation = new Observation("New Moon", 90);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeIsThreePM() {
        newObservation = new Observation("New Moon", 45);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeNewMoonIsSixPM() {
        newObservation = new Observation("New Moon", 0);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeNewMoonIsSixAM() {
        newObservation = new Observation("New Moon", 180);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeNewMoonIsNineAM() {
        newObservation = new Observation("New Moon", 135);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.identifyTime());
    }

    // WaxingCrescent
    @Test
    public void testIdentifyTimeWaxingCrescentIsNoon() {
        newObservation = new Observation("Waxing Crescent", 135);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsThreePM() {
        newObservation = new Observation("Waxing Crescent", 90);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsSixPM() {
        newObservation = new Observation("Waxing Crescent", 45);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsNinePM() {
        newObservation = new Observation("Waxing Crescent", 0);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsNineAM() {
        newObservation = new Observation("Waxing Crescent", 180);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.identifyTime());
    }
    // FirstQuarter
    @Test
    public void testIdentifyTimeFirstQuarterIsNoon() {
        newObservation = new Observation("First Quarter", 180);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsThreePM() {
        newObservation = new Observation("First Quarter", 135);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsSixPM() {
        newObservation = new Observation("First Quarter", 90);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsNinePM() {
        newObservation = new Observation("First Quarter", 45);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsMidnight() {
        newObservation = new Observation("First Quarter", 0);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.identifyTime());
    }

    // WaxingGibbous
    @Test
    public void testIdentifyTimeWaxingGibbousIsThreePM() {
        newObservation = new Observation("Waxing Gibbous", 180);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsSixPM() {
        newObservation = new Observation("Waxing Gibbous", 135);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsNinePM() {
        newObservation = new Observation("Waxing Gibbous", 90);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsMidnight() {
        newObservation = new Observation("Waxing Gibbous", 45);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsThreeAM() {
        newObservation = new Observation("Waxing Gibbous", 0);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.identifyTime());
    }

    // FullMoon
    @Test
    public void testIdentifyTimeFullMoonIsSixPM() {
        newObservation = new Observation("Full Moon", 180);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsNinePM() {
        newObservation = new Observation("Full Moon", 135);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsMidnight() {
        newObservation = new Observation("Full Moon", 90);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsThreeAM() {
        newObservation = new Observation("Full Moon", 45);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsSixAM() {
        newObservation = new Observation("Full Moon", 0);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.identifyTime());
    }

    // WaningGibbous

    @Test
    public void testIdentifyTimeWaningGibbousIsNinePM() {
        newObservation = new Observation("Waning Gibbous", 180);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsMidnight() {
        newObservation = new Observation("Waning Gibbous", 135);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsThreeAM() {
        newObservation = new Observation("Waning Gibbous", 90);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsSixAM() {
        newObservation = new Observation("Waning Gibbous", 45);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsNineAM() {
        newObservation = new Observation("Waning Gibbous", 0);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.identifyTime());
    }
    // ThirdQuarter
    @Test
    public void testIdentifyTimeThirdQuarterIsNoon() {
        newObservation = new Observation("Third Quarter", 0);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsMidnight() {
        newObservation = new Observation("Third Quarter", 180);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsThreeAM() {
        newObservation = new Observation("Third Quarter", 135);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsSixAM() {
        newObservation = new Observation("Third Quarter", 90);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("Six", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsNineAM() {
        newObservation = new Observation("Third Quarter", 45);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.identifyTime());
    }
    // WaningCrescent
    @Test
    public void testIdentifyTimeWaningCrescentIsNoon() {
        newObservation = new Observation("Waning Crescent", 45);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningCrescentIsThreePM() {
        newObservation = new Observation("Waning Crescent", 0);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.identifyTime());
    }


    @Test
    public void testIdentifyTimeWaningCrescentIsThreeAM() {
        newObservation = new Observation("Waning Crescent", 180);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningCrescentIsSixAM() {
        newObservation = new Observation("Waning Crescent", 135);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningCrescentIsNineAM() {
        newObservation = new Observation("Waning Crescent", 90);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.identifyTime());
    }
    //
}