/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.timelogic;

import fi.ekalaja.boardgameclock.timers.ClockGroup;
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
public class HourglassLogicTest {
    private HourglassLogic hl;
    
    public HourglassLogicTest() {
    }

    
    @Before
    public void setUp() {
        ClockGroup clockgroup = new ClockGroup();
        clockgroup.addAClock(5, 0);
        clockgroup.addAClock(0, 10);
        hl = new HourglassLogic(clockgroup.returnList());
    }

    /**
     * Test of run method, of class HourglassLogic.
     */
//    @Test
//    public void testRun() {
//        System.out.println("run");
//        HourglassLogic instance = null;
//        instance.run();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testCheckNextClockStatus() {
        System.out.println("checkNextClockStatus");
        assertFalse(hl.nextClockTruthValue());
    }

//
//    /**
//     * Test of getActiveClock method, of class HourglassLogic.
//     */
    @Test
    public void testGetActiveClock() {
        assertEquals(0,hl.getActiveClock());
    }
//
//    /**
//     * Test of setNextClockTrue method, of class HourglassLogic.
//     */
//    @Test
//    public void testSetNextClockTrue() {
//        hl.setNextClockTrue();
//        hl.activateStopEverything();
//        hl.run();
//        assertEquals(1,hl.getActiveClock());
//    }
//
//    /**
//     * Test of nextClockTruthValue method, of class HourglassLogic.
//     */
//    @Test
//    public void testNextClockTruthValue() {
//        System.out.println("nextClockTruthValue");
//        HourglassLogic instance = null;
//        boolean expResult = false;
//        boolean result = instance.nextClockTruthValue();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNextClockFalse method, of class HourglassLogic.
//     */
//    @Test
//    public void testSetNextClockFalse() {
//        System.out.println("setNextClockFalse");
//        HourglassLogic instance = null;
//        instance.setNextClockFalse();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of pauseMode method, of class HourglassLogic.
//     */
//    @Test
//    public void testPauseMode() {
//        System.out.println("pauseMode");
//        HourglassLogic instance = null;
//        instance.pauseMode();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of changePauseOnStatus method, of class HourglassLogic.
//     */
//    @Test
//    public void testChangePauseOnStatus() {
//        System.out.println("changePauseOnStatus");
//        HourglassLogic instance = null;
//        instance.changePauseOnStatus();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPauseOnStatus method, of class HourglassLogic.
//     */
//    @Test
//    public void testGetPauseOnStatus() {
//        System.out.println("getPauseOnStatus");
//        HourglassLogic instance = null;
//        boolean expResult = false;
//        boolean result = instance.getPauseOnStatus();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of activateStopEverything method, of class HourglassLogic.
//     */
//    @Test
//    public void testActivateStopEverything() {
//        System.out.println("activateStopEverything");
//        HourglassLogic instance = null;
//        instance.activateStopEverything();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
