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
public class TimeLogic implements Runnable {

    private ArrayList<SimpleTimer> allclocks;
    private boolean nextClock;
    private int clockInUse;
//    private SwingUi swingui;
    private int listSize;
    private boolean pauseOn;
    private boolean stopEverythingTestUse;

    public TimeLogic(ArrayList<SimpleTimer> allclocks) {

        clockInUse = 0;
        this.allclocks = allclocks;
        nextClock = false;
        pauseOn = true;
        listSize = allclocks.size();
        this.stopEverythingTestUse = false;

    }

    public void run() {
        
        while (true) {
            if (pauseOn) {
                System.out.println(this.toString());
                this.pauseMode();
            }
            if (nextClock) {
                clockInUse++;
                this.setNextClockFalse();
            }
            allclocks.get((clockInUse % listSize)).timerTicks();
            allclocks.get((clockInUse % listSize)).refreshFrameNumbers();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("awakened prematurely");
            }
            if (stopEverythingTestUse) {
                break;
            }
//            System.out.println("paasi loppuun");
        }
    }
    

//    public void setSwingUi(SwingUi swingui) {
//        this.swingui = swingui;
//    }
    public int getClockInUse() {
        return this.clockInUse;
    }
    
    public void setNextClockTrue() {
        this.nextClock = true;
    }

    public void setNextClockFalse() {
        this.nextClock = false;
    }

    public boolean nextClockTruthValue() {
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
            } else if (this.stopEverythingTestUse) {
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
    
    public boolean getPauseOnStatus() {
        return this.pauseOn;
    }
    
    public void forTestingActivateStopEverything() {
        this.stopEverythingTestUse = true;
    }

}
