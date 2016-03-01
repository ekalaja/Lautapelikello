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
public class HourglassLogicTest {

    private HourglassLogic hl;
    private ClockGroup clockgroup;

    public HourglassLogicTest() {
    }

    @Before
    public void setUp() {
        clockgroup = new ClockGroup();
        clockgroup.addAClock(5, 0);
        clockgroup.addAClock(0, 10);
        hl = new HourglassLogic(clockgroup);
        hl.activateStopEverything();
    }

    @Test
    public void testCheckNextClockStatus() {
        assertFalse(hl.nextClockTruthValue());
    }

    @Test
    public void testGetActiveClock() {
        assertEquals(0, hl.getActiveClock());
    }

    @Test
    public void testSleepForOneSec() {
        Date date = new Date();
        long before = date.getTime();
        before += 1000;
        this.hl.sleepForOneSecond();
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
        this.hl.tellTimerToTickAndRefresh();
        assertEquals("04:59", this.clockgroup.returnList().get(0).toString());
    }

    @Test
    public void testTimerTicksAndRefreshesPassiveClock() {
        this.hl.tellTimerToTickAndRefresh();
        assertEquals("00:11", this.clockgroup.returnList().get(1).toString());
    }

    @Test
    public void testNextClockTruthValue() {
        assertFalse(this.hl.nextClockTruthValue());
    }

    @Test
    public void testSetNextClockFalse() {
        hl.setNextClockTrue();
        hl.setNextClockFalse();
        assertFalse(this.hl.nextClockTruthValue());
    }

    @Test
    public void testChangePauseOnStatus() {
        hl.changePauseOnStatus();
        assertFalse(hl.getPauseOnStatus());
    }

    @Test
    public void testChangePauseOnStatusTwice() {
        hl.changePauseOnStatus();
        hl.changePauseOnStatus();
        assertTrue(hl.getPauseOnStatus());
    }

    @Test
    public void testGetPauseOnStatus() {
        assertTrue(hl.getPauseOnStatus());
    }

// These tests time-out while checking mutations.
    @Test
    public void testRunAfterOneCycles() {
        this.hl.changePauseOnStatus();
        this.hl.run();
        assertEquals(0, this.hl.getActiveClock());
    }

    @Test
    public void testRunAfterOneCycleGoPauseMode() {
        this.hl.run();
        assertEquals(0, this.hl.getActiveClock());
    }

    @Test
    public void testRunAfterOneCycleChangeToNextClock() {
        this.hl.setNextClockTrue();
        this.hl.run();
        assertEquals(1, this.hl.getActiveClock());
    }

    @Test
    public void testSetNextClockTrue() {
        hl.setNextClockTrue();
        hl.activateStopEverything();
        hl.run();
        assertEquals(1, hl.getActiveClock());
    }

}
