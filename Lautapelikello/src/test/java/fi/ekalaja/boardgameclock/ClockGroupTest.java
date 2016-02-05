/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ClockGroupTest {
    
    ClockGroup clockgroup;
    public ClockGroupTest() {
    }
    
    
    @Before
    public void setUp() {
        clockgroup = new ClockGroup();
        
    }
   
    @Test
    public void testAddAClock() {
        clockgroup.addAClock(5, 0);
        clockgroup.addAClock(10, 10);
        clockgroup.addAClock(0, 5);
        assertEquals(3,clockgroup.returnList().size());
    }

   
    @Test
    public void testReturnList() {
        clockgroup.addAClock(1, 0);
        assertEquals("01:00",clockgroup.returnList().get(0).toString());
    }
    
    @Test
    public void testReturnEmptyList() {
        assertEquals(0,clockgroup.returnList().size());
    }
    
    @Test
    public void testIllegalValuesForClock() {
        try {
            clockgroup.addAClock(0,-5);
            fail("illegal clock was created");
        } catch (Exception e) {
            String errorMsg = "fail";
            assertEquals("fail", errorMsg);
        }
    }
    
}
