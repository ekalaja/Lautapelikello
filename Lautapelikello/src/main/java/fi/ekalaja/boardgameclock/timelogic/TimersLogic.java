/**
* TimeLogic is responsible for counting down the time in the SimpleTimers.
* 
*/
package fi.ekalaja.boardgameclock.timelogic;

import fi.ekalaja.boardgameclock.timers.SimpleTimer;
import java.util.ArrayList;

public class TimersLogic implements LogicOfTime {

    private ArrayList<SimpleTimer> allclocks;
    private boolean nextClock;
    private int clockInUse;
//    private SwingUi swingui;
    private int listSize;
    private boolean pauseOn;
    private boolean stopEverything;

    public TimersLogic(ArrayList<SimpleTimer> allclocks) {

        clockInUse = 0;
        this.allclocks = allclocks;
        nextClock = false;
        pauseOn = true;
        listSize = allclocks.size();
        this.stopEverything = false;

    }
/**
 * This is where the magic happens. TimeLogic's run is the method responsible
 * for counting of the used time. It also makes sure the right clock is in use
 * and checks if user has pushed new buttons.
 */
    @Override
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
/**
 * pauseMode is activated when the clocks are created and when ever user pushes pause.
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
     * This method stops the "run" loop when new TimeLogic is created.
     */
    public void ActivateStopEverything() {
        this.stopEverything = true;
    }

    @Override
    public void activateStopEverything() {
        this.stopEverything = true;
    }

}
