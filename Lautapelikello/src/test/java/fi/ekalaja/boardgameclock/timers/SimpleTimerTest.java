/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.timers;

import fi.ekalaja.boardgameclock.timers.SimpleTimer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ekalaja
 */
public class SimpleTimerTest {

    SimpleTimer simpletimer;

    public SimpleTimerTest() {

    }

    @Before
    public void setUp() {
        try {
            this.simpletimer = new SimpleTimer(10, 0);
        } catch (Exception e) {

        }

    }

    @Test
    public void testToStringToTenMinutes() {
        assertEquals("10:00", simpletimer.toString());
    }

    @Test
    public void testReducingAQuarterMinuteFrom10Min() {
        this.simpletimer.reduceAQuarterMinute();
        assertEquals("09:45", simpletimer.toString());
    }

    @Test
    public void testReducingAQuarterMinuteManyTimes() {
        this.simpletimer.reduceAQuarterMinute();
        this.simpletimer.reduceAQuarterMinute();
        this.simpletimer.reduceAQuarterMinute();
        this.simpletimer.reduceAQuarterMinute();

        assertEquals("09:00", simpletimer.toString());
    }

    @Test
    public void testAddingAQuarterMinuteFor10Min() {
        this.simpletimer.addAQuarterMinute();
        assertEquals("10:15", simpletimer.toString());
    }

    @Test
    public void testAddingAQuarterMinuteManyTimes() {
        this.simpletimer.addAQuarterMinute();
        this.simpletimer.addAQuarterMinute();
        this.simpletimer.addAQuarterMinute();
        this.simpletimer.addAQuarterMinute();

        assertEquals("11:00", simpletimer.toString());
    }

    @Test
    public void testTimerUnticks() {
        this.simpletimer.timerUnticks();
        assertEquals("10:01", simpletimer.toString());
    }

    @Test
    public void testTimerUnticksForFullMinute() {
        try {
            SimpleTimer othertimer = new SimpleTimer(0, 59);
            othertimer.timerUnticks();
            assertEquals("01:00", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }

    @Test
    public void testClockframeSameAfterTimerTicks() {
        this.simpletimer.timerTicks();
        assertEquals("10:00", this.simpletimer.returnClockNumberFrame().getText());
    }

    @Test
    public void testClockframeRefreshedAfterTimerTicksAndRefreshes() {
        this.simpletimer.timerTicks();
        this.simpletimer.refreshFrameNumbers();
        assertEquals("09:59", this.simpletimer.returnClockNumberFrame().getText());
    }

    @Test
    public void testToStringForManyMinManySec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(11, 11);
            assertEquals("11:11", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }

    @Test
    public void testToStringForManyMinFewSec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(12, 0);
            assertEquals("12:00", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }

    @Test
    public void testToStringForFewMinManySec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(1, 12);
            assertEquals("01:12", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }

    @Test
    public void testToStringFewMinFewSec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(1, 1);
            assertEquals("01:01", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }

    @Test
    public void testOfOneMinutePlusTwoSec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(1, 2);
            othertimer.timerTicks();
            assertEquals("01:01", othertimer.toString());
        } catch (Exception e) {
        }
    }

    @Test
    public void testOtherTimertoStringCorrect() {
        try {
            SimpleTimer othertimer = new SimpleTimer(6, 11);
            assertEquals("06:11", othertimer.toString());
        } catch (Exception e) {
        }
    }

    @Test
    public void testTimerTicks() {

        simpletimer.timerTicks();
        assertEquals("09:59", simpletimer.toString());
    }

    @Test
    public void testTimerTicksZero() {
        try {
            SimpleTimer othertimer = new SimpleTimer(0, 1);
            othertimer.timerTicks();
            assertEquals("00:00", othertimer.toString());
        } catch (Exception e) {
        }

    }

    @Test
    public void testTimerTicksZeroTwice() {
        try {
            SimpleTimer othertimer = new SimpleTimer(0, 1);
            othertimer.timerTicks();
            othertimer.timerTicks();
            assertEquals("00:00", othertimer.toString());
        } catch (Exception e) {
        }
    }

    @Test
    public void testTimerGetsNegativeValues() {
        try {
            SimpleTimer othertimer = new SimpleTimer(-1, 0);
            othertimer.timerTicks();
            othertimer.timerTicks();
            assertEquals("00:00", othertimer.toString());
        } catch (Exception e) {
            String errorReport = "fail";
            assertEquals("fail", errorReport);
        }
    }

    @Test
    public void testFrameValuesCorrecttAfterCreation() {
        assertEquals("10:00", this.simpletimer.returnClockNumberFrame().getText());
    }

    @Test
    public void testFrameValuesCorrectAfterTimerTicksAndUpdates() {
        this.simpletimer.timerTicks();
        this.simpletimer.refreshFrameNumbers();
        assertEquals("09:59", this.simpletimer.returnClockNumberFrame().getText());
    }

}
