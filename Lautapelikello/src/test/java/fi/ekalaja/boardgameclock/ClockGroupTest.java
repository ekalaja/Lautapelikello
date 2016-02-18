package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.timers.ClockGroup;
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
    
//    @Test
//    public void testIfIllegalClockCanBeCreated() {
//        try {
//            clockgroup.addAClock(0,-5);
//            assertEquals(0,clockgroup.returnList().size());
//        } catch (Exception e) {
//            fail("illegal clock created?");
//        }
//    }
    
    @Test
    public void testIfIllegalClockCanBeCreated() {
            clockgroup.addAClock(0,-5);
            assertEquals(0,clockgroup.returnList().size());
    }
    
//    @Test
//    public void testIfIllegalClockCreationReportsRight() {
//            clockgroup.addAClock(0,-5);
//            
//    }
    
    
    
}
