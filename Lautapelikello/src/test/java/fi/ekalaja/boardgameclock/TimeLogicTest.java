/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

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
    TimeLogic timelogic;
    public TimeLogicTest() {
    }

    @Before
    public void setUp() {
        ClockGroup clockgroup = new ClockGroup();
        clockgroup.addAClock(5,0);
        clockgroup.addAClock(0,10);
        timelogic = new TimeLogic(clockgroup.returnList());
        
    }
    
 


    @Test
    public void testNextClockValue() {

        assertFalse(timelogic.nextClockTruthValue());
    }

    @Test
    public void getClockInUse() {
        assertEquals(0,timelogic.getClockInUse());
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
    public void testNumberOfClocksIsRight() {
        assertEquals(2,timelogic.numberOfClocks());
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
        // Tests loops ability to finish after false value on PauseOn
        this.timelogic.changePauseOnStatus();
        this.timelogic.pauseMode();
        assertFalse(this.timelogic.getPauseOnStatus());
    }
    
    @Test
    public void testPauseLoopWhileTrue() {
        // Tests loops ability to finish after false value on PauseOn
        this.timelogic.forTestingActivateStopEverything();
        this.timelogic.pauseMode();
        assertTrue(this.timelogic.getPauseOnStatus());
    }
    
    @Test
    public void testRunAfterOneCycles() {
        this.timelogic.forTestingActivateStopEverything();
        this.timelogic.changePauseOnStatus();
        this.timelogic.run();
        assertEquals(0,this.timelogic.getClockInUse());
    }
    
    @Test
    public void testRunAfterOneCycleGoPauseMode() {
        this.timelogic.forTestingActivateStopEverything();
        this.timelogic.run();
        assertEquals(0,this.timelogic.getClockInUse());
    }
    
    @Test
    public void testRunAfterOneCycleChangeToNextClock() {
        this.timelogic.forTestingActivateStopEverything();
        this.timelogic.setNextClockTrue();
        this.timelogic.run();
        assertEquals(1,this.timelogic.getClockInUse());
    }
    
    
    
}
