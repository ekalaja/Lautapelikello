/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.timelogic;

import fi.ekalaja.boardgameclock.timers.ClockGroup;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ekalaja
 */
public class TimersLogicTest {

    TimersLogic timelogic;
    ClockGroup clockgroup;

    public TimersLogicTest() {
    }

    @Before
    public void setUp() {
        clockgroup = new ClockGroup();
        clockgroup.addAClock(5, 0);
        clockgroup.addAClock(0, 10);
        timelogic = new TimersLogic(clockgroup, 0);
        timelogic.activateStopEverything();

    }

    @Test
    public void testNextClockValue() {

        assertFalse(timelogic.nextClockTruthValue());
    }

    @Test
    public void getClockInUse() {
        assertEquals(0, timelogic.getClockInUse());
    }

    @Test
    public void testCheckNextClockStatus() {
        this.timelogic.setNextClockTrue();
        this.timelogic.checkNextClockStatus();
        assertFalse(this.timelogic.nextClockTruthValue());
    }

    @Test
    public void testSetNextClockTrue() {
        timelogic.setNextClockTrue();
        assertTrue(timelogic.nextClockTruthValue());
    }

    @Test
    public void testSetNextClockFalse() {
        timelogic.setNextClockTrue();
        timelogic.setNextClockFalse();
        assertFalse(timelogic.nextClockTruthValue());
    }

    @Test
    public void PauseStatusCorrectAfterCreation() {
        assertTrue(this.timelogic.getPauseOnStatus());
    }

    @Test
    public void testChangePauseOnStatusOnce() {
        this.timelogic.changePauseOnStatus();
        assertFalse(this.timelogic.getPauseOnStatus());
    }

    @Test
    public void testChangePauseOnStatusTwice() {
        this.timelogic.changePauseOnStatus();
        this.timelogic.changePauseOnStatus();
        assertTrue(this.timelogic.getPauseOnStatus());
    }

    @Test
    public void testPauseLoopWhileFalse() {
        // Tests loop's ability to finish after false value on PauseOn
        this.timelogic.changePauseOnStatus();
        this.timelogic.pauseMode();
        assertFalse(this.timelogic.getPauseOnStatus());
    }

    @Test
    public void testSleepForOneSec() {
        Date date = new Date();
        long before = date.getTime();
        before += 1000;
        this.timelogic.sleepForOneSecond();
        Date date2 = new Date();
        long after = date2.getTime();
        boolean value = false;
        if (Math.abs(before - after) < 5) {
            value = true;
        }
        assertTrue(value);
    }

    @Test
    public void testTickAndRefresh() {
        this.timelogic.tellTimerToTickAndRefresh();
        assertEquals("04:59", this.clockgroup.returnList().get(0).toString());
    }
    
    @Test
    public void testExtraTimeInTimelogicForFiveSec() {
        TimersLogic logic = new TimersLogic(clockgroup, 5);
        logic.setNextClockTrue();
        logic.checkNextClockStatus();
        assertEquals("00:15", clockgroup.returnList().get(1).toString());
    }
    
    @Test
    public void testExtraTimelogicCheckNextClockStatusWhileFalse() {
        TimersLogic logic = new TimersLogic(clockgroup, 5);
        logic.checkNextClockStatus();
        assertEquals("00:10", clockgroup.returnList().get(1).toString());
    }

// These tests time-out while checking mutations.
    @Test
    public void testRunAfterOneCycles() {
        this.timelogic.changePauseOnStatus();
        this.timelogic.run();
        assertEquals(0, this.timelogic.getClockInUse());
    }

    @Test
    public void testRunAfterOneCycleGoPauseMode() {
        this.timelogic.run();
        assertEquals(0, this.timelogic.getClockInUse());
    }

    @Test
    public void testRunAfterOneCycleChangeToNextClock() {
        this.timelogic.setNextClockTrue();
        this.timelogic.run();
        assertEquals(1, this.timelogic.getClockInUse());
    }
}
