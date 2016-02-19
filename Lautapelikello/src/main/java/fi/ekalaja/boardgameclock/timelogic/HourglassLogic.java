/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.timelogic;

import fi.ekalaja.boardgameclock.timers.SimpleTimer;
import java.util.ArrayList;

/**
 *
 * @author ekalaja
 */
public class HourglassLogic implements LogicOfTime {

    private ArrayList<SimpleTimer> allclocks;
    private boolean nextClock;
    private int activeClock;
//    private int listSize;
    private boolean pauseOn;
    private boolean stopEverything;
    private int passiveClock;

    public HourglassLogic(ArrayList<SimpleTimer> allclocks) {

        activeClock = 0;
        passiveClock = 1;
        this.allclocks = allclocks;
        nextClock = false;
        pauseOn = true;
        this.stopEverything = false;

    }

    /**
     * This is where
     */
@Override
    public void run() {

        while (true) {

            if (pauseOn) {
                this.pauseMode();
            }

            if (nextClock) {
                if (this.getActiveClock() == 0) {
                    this.activeClock = 1;
                    this.passiveClock = 0;
                } else {
                    this.activeClock = 0;
                    this.passiveClock = 1;
                }
                this.setNextClockFalse();
            }
            allclocks.get(activeClock).timerTicks();
            allclocks.get(passiveClock).timerUnticks();
            allclocks.get(activeClock).refreshFrameNumbers();
            allclocks.get(passiveClock).refreshFrameNumbers();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("awakened prematurely");
            }
            if (stopEverything) {
                break;
            }
        }
    }

    public int getActiveClock() {
        return this.activeClock;
    }

    @Override
    public void setNextClockTrue() {
        this.nextClock = true;
    }

    public void setNextClockFalse() {
        this.nextClock = false;
    }

    public boolean nextClockTruthValue() {
        return nextClock;
    }


    /**
     * pauseMode is activated when the clocks are created and when ever user
     * pushes pause.
     */
    public void pauseMode() {

        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("awakened prematurely");
            }
            if (pauseOn == false) {
                break;
            } else if (this.stopEverything) {
                break;
            }
        }
    }

    /**
     * This enables changes in the run method so TimeLogic can enter pauseMode.
     */
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

    /**
     * This method stops the "run" loop when new logic is created.
     */

    @Override
    public void activateStopEverything() {
        this.stopEverything = true;

    }

}
