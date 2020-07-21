package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for Observation

class ObservationTest {
    private Observation newObservation;


    @Test
    public void testIdentifyTimeNewMoonIsNoon() {
        newObservation = new Observation("New Moon", 90);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.newMoonTime(90));
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeIsThreePM() {
        newObservation = new Observation("New Moon", 45);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.newMoonTime(45));
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeNewMoonIsSixPM() {
        newObservation = new Observation("New Moon", 0);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.newMoonTime(0));
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeNewMoonIsSixAM() {
        newObservation = new Observation("New Moon", 180);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.newMoonTime(180));
        assertEquals("6AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeNewMoonIsNineAM() {
        newObservation = new Observation("New Moon", 135);

        assertEquals("New Moon", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.newMoonTime(135));
        assertEquals("9AM", newObservation.identifyTime());
    }

    // WaxingCrescent
    @Test
    public void testIdentifyTimeWaxingCrescentIsNoon() {
        newObservation = new Observation("Waxing Crescent", 135);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.waxingCrescentTime(135));
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsThreePM() {
        newObservation = new Observation("Waxing Crescent", 90);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.waxingCrescentTime(90));
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsSixPM() {
        newObservation = new Observation("Waxing Crescent", 45);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.waxingCrescentTime(45));
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsNinePM() {
        newObservation = new Observation("Waxing Crescent", 0);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.waxingCrescentTime(0));
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingCrescentIsNineAM() {
        newObservation = new Observation("Waxing Crescent", 180);

        assertEquals("Waxing Crescent", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.waxingCrescentTime(180));
        assertEquals("9AM", newObservation.identifyTime());
    }
    // FirstQuarter
    @Test
    public void testIdentifyTimeFirstQuarterIsNoon() {
        newObservation = new Observation("First Quarter", 180);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.firstQuarterTime(180));
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsThreePM() {
        newObservation = new Observation("First Quarter", 135);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.firstQuarterTime(135));
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsSixPM() {
        newObservation = new Observation("First Quarter", 90);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.firstQuarterTime(90));
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsNinePM() {
        newObservation = new Observation("First Quarter", 45);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.firstQuarterTime(45));
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFirstQuarterIsMidnight() {
        newObservation = new Observation("First Quarter", 0);

        assertEquals("First Quarter", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.firstQuarterTime(0));
        assertEquals("Midnight", newObservation.identifyTime());
    }

    // WaxingGibbous
    @Test
    public void testIdentifyTimeWaxingGibbousIsThreePM() {
        newObservation = new Observation("Waxing Gibbous", 180);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.waxingGibbousTime(180));
        assertEquals("3PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsSixPM() {
        newObservation = new Observation("Waxing Gibbous", 135);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.waxingGibbousTime(135));
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsNinePM() {
        newObservation = new Observation("Waxing Gibbous", 90);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.waxingGibbousTime(90));
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsMidnight() {
        newObservation = new Observation("Waxing Gibbous", 45);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.waxingGibbousTime(45));
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaxingGibbousIsThreeAM() {
        newObservation = new Observation("Waxing Gibbous", 0);

        assertEquals("Waxing Gibbous", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.waxingGibbousTime(0));
        assertEquals("3AM", newObservation.identifyTime());
    }

    // FullMoon
    @Test
    public void testIdentifyTimeFullMoonIsSixPM() {
        newObservation = new Observation("Full Moon", 180);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("6PM", newObservation.fullMoonTime(180));
        assertEquals("6PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsNinePM() {
        newObservation = new Observation("Full Moon", 135);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.fullMoonTime(135));
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsMidnight() {
        newObservation = new Observation("Full Moon", 90);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.fullMoonTime(90));
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsThreeAM() {
        newObservation = new Observation("Full Moon", 45);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.fullMoonTime(45));
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeFullMoonIsSixAM() {
        newObservation = new Observation("Full Moon", 0);

        assertEquals("Full Moon", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.fullMoonTime(0));
        assertEquals("6AM", newObservation.identifyTime());
    }

    // WaningGibbous

    @Test
    public void testIdentifyTimeWaningGibbousIsNinePM() {
        newObservation = new Observation("Waning Gibbous", 180);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("9PM", newObservation.waningGibbousTime(180));
        assertEquals("9PM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsMidnight() {
        newObservation = new Observation("Waning Gibbous", 135);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.waningGibbousTime(135));
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsThreeAM() {
        newObservation = new Observation("Waning Gibbous", 90);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.waningGibbousTime(90));
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsSixAM() {
        newObservation = new Observation("Waning Gibbous", 45);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.waningGibbousTime(45));
        assertEquals("6AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningGibbousIsNineAM() {
        newObservation = new Observation("Waning Gibbous", 0);

        assertEquals("Waning Gibbous", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.waningGibbousTime(0));
        assertEquals("9AM", newObservation.identifyTime());
    }
    // ThirdQuarter
    @Test
    public void testIdentifyTimeThirdQuarterIsNoon() {
        newObservation = new Observation("Third Quarter", 0);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.thirdQuarterTime(0));
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsMidnight() {
        newObservation = new Observation("Third Quarter", 180);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("Midnight", newObservation.thirdQuarterTime(180));
        assertEquals("Midnight", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsThreeAM() {
        newObservation = new Observation("Third Quarter", 135);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.thirdQuarterTime(135));
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsSixAM() {
        newObservation = new Observation("Third Quarter", 90);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.thirdQuarterTime(90));
        assertEquals("6AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeThirdQuarterIsNineAM() {
        newObservation = new Observation("Third Quarter", 45);

        assertEquals("Third Quarter", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.thirdQuarterTime(45));
        assertEquals("9AM", newObservation.identifyTime());
    }
    // WaningCrescent
    @Test
    public void testIdentifyTimeWaningCrescentIsNoon() {
        newObservation = new Observation("Waning Crescent", 45);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(45, newObservation.getAngleFromEast());
        assertEquals("Noon", newObservation.waningCrescentTime(45));
        assertEquals("Noon", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningCrescentIsThreePM() {
        newObservation = new Observation("Waning Crescent", 0);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(0, newObservation.getAngleFromEast());
        assertEquals("3PM", newObservation.waningCrescentTime(0));
        assertEquals("3PM", newObservation.identifyTime());
    }


    @Test
    public void testIdentifyTimeWaningCrescentIsThreeAM() {
        newObservation = new Observation("Waning Crescent", 180);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(180, newObservation.getAngleFromEast());
        assertEquals("3AM", newObservation.waningCrescentTime(180));
        assertEquals("3AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningCrescentIsSixAM() {
        newObservation = new Observation("Waning Crescent", 135);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(135, newObservation.getAngleFromEast());
        assertEquals("6AM", newObservation.waningCrescentTime(135));
        assertEquals("6AM", newObservation.identifyTime());
    }

    @Test
    public void testIdentifyTimeWaningCrescentIsNineAM() {
        newObservation = new Observation("Waning Crescent", 90);

        assertEquals("Waning Crescent", newObservation.getMoonPhase());
        assertEquals(90, newObservation.getAngleFromEast());
        assertEquals("9AM", newObservation.waningCrescentTime(90));
        assertEquals("9AM", newObservation.identifyTime());
    }
    //
}