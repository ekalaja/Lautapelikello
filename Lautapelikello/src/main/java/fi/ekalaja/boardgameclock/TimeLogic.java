/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.clockui.SwingUi;
import java.util.ArrayList;

/**
 *
 * @author ekalaja
 */
public class TimeLogic {
    
    private ArrayList<SimpleTimer> list;
    private boolean nextClock;
    private int clockInUse;
    private SwingUi swingui;
    
    public TimeLogic(ArrayList<SimpleTimer> allClocks) {
        this.swingui = swingui;
        clockInUse = 0;
        this.list = allClocks;
        nextClock = false;
        int listSize = allClocks.size();
    }

    public void run() {
        
        while (true) {
            list.get(clockInUse).timerTicks();
            swingui.getFrame().repaint();
            // tässä kutsutaan repaint
            
            System.out.println(list.get(clockInUse).toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                System.out.println("awakened prematurely");
            } 
            if (nextClock) {
                clockInUse++;
                this.setNextClockFalse();
               
            }
        }
    }
    
    public void setSwingUi(SwingUi swingui) {
        this.swingui = swingui;
    }
    
    public void setNextClockTrue() {
        this.nextClock = true;
    }
    
    public void setNextClockFalse() {
        this.nextClock = false;
    }
    
}
