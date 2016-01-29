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
        this.simpletimer = new SimpleTimer(10,0);
    }

    
    @Test
    public void testToString() {

        assertEquals("10:00", simpletimer.toString());

    }
    
    @Test
    public void testOfOneMinute() {
        SimpleTimer othertimer = new SimpleTimer(1,0);
        othertimer.timerTicks();
        assertEquals("00:59", othertimer.toString());
        
    }


    @Test
    public void testTimerTicks() {

        simpletimer.timerTicks();
        assertEquals("09:59", simpletimer.toString());      
    }
    
}
