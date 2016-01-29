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

        assertFalse(timelogic.nextClockValue());
    }


    @Test
    public void testSetNextClockTrue() {
        timelogic.setNextClockTrue();
        assertTrue(timelogic.nextClockValue());
    }
    
    @Test
    public void testSetNextClockFalse() {
        timelogic.setNextClockTrue();
        timelogic.setNextClockFalse();
        assertFalse(timelogic.nextClockValue());
    }
    
    @Test
    public void testNumberOfClocksIsRight() {
        System.out.println(timelogic.numberOfClocks());
        assertEquals(2,timelogic.numberOfClocks());
    }
}
