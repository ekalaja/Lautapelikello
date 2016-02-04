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

    private ArrayList<SimpleTimer> allclocks;
    private boolean nextClock;
    private int clockInUse;
//    private SwingUi swingui;
    private int listSize;
    private boolean pauseOn;

    public TimeLogic(ArrayList<SimpleTimer> allclocks) {

        clockInUse = 0;
        this.allclocks = allclocks;
        nextClock = false;
        pauseOn = true;
        listSize = allclocks.size();

    }

    public void run() {

        while (true) {
            if (pauseOn) {
                this.pauseMode();
            }
            if (nextClock) {
                clockInUse++;
                this.setNextClockFalse();
            }
            allclocks.get((clockInUse % listSize)).timerTicks();
            allclocks.get((clockInUse % listSize)).refreshFrameNumbers();

            // tässä kutsutaan repaint
//            System.out.println(allclocks.get(clockInUse).toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("awakened prematurely");
            }

            
            
        }
    }

//    public void setSwingUi(SwingUi swingui) {
//        this.swingui = swingui;
//    }
    public void setNextClockTrue() {
        this.nextClock = true;
    }

    public void setNextClockFalse() {
        this.nextClock = false;
    }

    public boolean nextClockValue() {
        return nextClock;
    }

    public int numberOfClocks() {
        return listSize;
    }

    public void pauseMode() {
        
        while (true) {
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("awakened prematurely");
            }
            if (pauseOn == false) {
                break;
            }
        }
    }

    public void changePauseOnStatus() {
        if (pauseOn == true) {
            pauseOn = false;
        } else if (pauseOn == false) {
            this.pauseOn = true;
        }

    }

}
