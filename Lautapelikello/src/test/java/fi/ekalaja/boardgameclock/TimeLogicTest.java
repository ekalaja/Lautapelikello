package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.timelogic.TimersLogic;
import fi.ekalaja.boardgameclock.timers.ClockGroup;
import fi.ekalaja.boardgameclock.clockui.SwingUi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ekalaja
 */
public class TimeLogicTest {

    TimersLogic timelogic;

    public TimeLogicTest() {
    }

    @Before
    public void setUp() {
        ClockGroup clockgroup = new ClockGroup();
        clockgroup.addAClock(5, 0);
        clockgroup.addAClock(0, 10);
        timelogic = new TimersLogic(clockgroup.returnList());

    }

//    @Test
//    public void testNextClockValue() {
//
//        assertFalse(timelogic.nextClockTruthValue());
    }
//
//    @Test
//    public void getClockInUse() {
//        assertEquals(0, timelogic.getClockInUse());
//    }
//
//    @Test
//    public void testSetNextClockTrue() {
//        timelogic.setNextClockTrue();
//        assertTrue(timelogic.nextClockTruthValue());
//    }
//
//    @Test
//    public void testSetNextClockFalse() {
//        timelogic.setNextClockTrue();
//        timelogic.setNextClockFalse();
//        assertFalse(timelogic.nextClockTruthValue());
//    }
//
//    @Test
//    public void testNumberOfClocksIsRight() {
//        assertEquals(2, timelogic.numberOfClocks());
//    }
//
//    @Test
//    public void PauseStatusCorrectAfterCreation() {
//        assertTrue(this.timelogic.getPauseOnStatus());
//    }
//
//    @Test
//    public void testChangePauseOnStatusOnce() {
//        this.timelogic.changePauseOnStatus();
//        assertFalse(this.timelogic.getPauseOnStatus());
//    }
//
//    @Test
//    public void testChangePauseOnStatusTwice() {
//        this.timelogic.changePauseOnStatus();
//        this.timelogic.changePauseOnStatus();
//        assertTrue(this.timelogic.getPauseOnStatus());
//    }
//
//    @Test
//    public void testPauseLoopWhileFalse() {
//        // Tests loops ability to finish after false value on PauseOn
//        this.timelogic.changePauseOnStatus();
//        this.timelogic.pauseMode();
//        assertFalse(this.timelogic.getPauseOnStatus());
//    }
//
//    @Test
//    public void testPauseLoopWhileTrue() {
//        // Tests loops ability to finish after false value on PauseOn
//        this.timelogic.activateStopEverything();
//        this.timelogic.pauseMode();
//        assertTrue(this.timelogic.getPauseOnStatus());
//    }
//
//    @Test
//    public void testRunAfterOneCycles() {
//        this.timelogic.activateStopEverything();
//        this.timelogic.changePauseOnStatus();
//        this.timelogic.run();
//        assertEquals(0, this.timelogic.getClockInUse());
//    }
//
//    @Test
//    public void testRunAfterOneCycleGoPauseMode() {
//        this.timelogic.activateStopEverything();
//        this.timelogic.run();
//        assertEquals(0, this.timelogic.getClockInUse());
//    }
//
//    @Test
//    public void testRunAfterOneCycleChangeToNextClock() {
//        this.timelogic.activateStopEverything();
//        this.timelogic.setNextClockTrue();
//        this.timelogic.run();
//        assertEquals(1, this.timelogic.getClockInUse());
//    }
//
//}
