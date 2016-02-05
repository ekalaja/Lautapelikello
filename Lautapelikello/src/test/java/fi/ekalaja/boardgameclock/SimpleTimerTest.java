/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

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
    public void testToStringForManyMinManySec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(11, 11);
            othertimer.timerTicks();
            assertEquals("11:10", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }
    
//    @Test
//    public void testToStringForManyMinFewSec() {
//        try {
//            SimpleTimer othertimer = new SimpleTimer(11, 2);
//            othertimer.timerTicks();
//            assertEquals("11:01", othertimer.toString());
//        } catch (Exception e) {
//            fail("ei nain");
//        }
//    }
//    
    @Test
    public void testToStringForFewMinManySec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(1, 12);
            othertimer.timerTicks();
            assertEquals("01:11", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }

    @Test
    public void testOfOneMinute() {
        try {
            SimpleTimer othertimer = new SimpleTimer(1, 0);
            othertimer.timerTicks();
            assertEquals("00:59", othertimer.toString());
        } catch (Exception e) {
            fail("ei nain");
        }
    }

    @Test
    public void testOfOneMinutePlusOneSec() {
        try {
            SimpleTimer othertimer = new SimpleTimer(1, 1);
            othertimer.timerTicks();
            assertEquals("01:00", othertimer.toString());
        } catch (Exception e) {
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
        assertEquals("10:00",this.simpletimer.returnClockNumberFrame().getText());
    }
    
    @Test
    public void testFrameValuesCorrectAfterTimerTicksAndUpdates() {
        this.simpletimer.timerTicks();
        this.simpletimer.refreshFrameNumbers();
        assertEquals("09:59",this.simpletimer.returnClockNumberFrame().getText());
    }
    
}
