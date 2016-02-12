/**
* TimeLogic is responsible for counting down the time in the SimpleTimers.
* 
*/
package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.clockui.SwingUi;
import java.util.ArrayList;

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
/**
 * This is where the magic happens. TimeLogic's run is the method responsible
 * for counting of the used time. It also makes sure the right clock is in use
 * and checks if user has pushed new buttons.
 */
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
            } else if (this.stopEverythingTestUse) {
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
     * this method is only for test use. I may extend it's usage for other
     * purposes also.
     */
    public void forTestingActivateStopEverything() {
        this.stopEverythingTestUse = true;
    }

}
