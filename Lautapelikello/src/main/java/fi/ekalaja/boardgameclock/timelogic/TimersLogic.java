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

    /**
     * TimersLogic needs the list of SimpleTimers to function. It takes
     * care of the logic related to the project.
     * @param allclocks  is an arrayList of SimpleTimers
     */
    public TimersLogic(ArrayList<SimpleTimer> allclocks) {

        clockInUse = 0;
        this.allclocks = allclocks;
        nextClock = false;
        pauseOn = true;
        listSize = allclocks.size();
        this.stopEverything = false;

    }

    /**
     * This is where the magic happens. TimeLogic's run is the method
     * responsible for counting of the used time. It also makes sure the right
     * clock is in use and checks if user has pushed new buttons.
     */
    @Override
    public void run() {

        while (true) {

            this.checkPauseOnStatus();
            this.checkNextClockStatus();

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

    /**
     * checks the status of pauseOn boolean.
     */
    public void checkPauseOnStatus() {
        if (pauseOn) {
            this.pauseMode();
        }
    }

    /**
     * checks nextClock boolean status and grows the value clockInUse if needed.
     */
    public void checkNextClockStatus() {
        if (nextClock) {
            clockInUse++;
            this.setNextClockFalse();
        }
    }

    /**
     * gives the value of clock in use.
     * @return integer value of the clockInUse.
     */
    public int getClockInUse() {
        return this.clockInUse;
    }

    /**
     * changes the status of nextClock boolean to true.
     */
    public void setNextClockTrue() {
        this.nextClock = true;
    }

    /**
     * changes the status of nextClock boolean to false.
     */
    public void setNextClockFalse() {
        this.nextClock = false;
    }

    /**
     * This is mostly used for testing.
     * @return gives the value of "nextClock" boolean.
     */
    public boolean nextClockTruthValue() {
        return nextClock;
    }

    /**
     * Gives the number of SimpleTimers.
     *
     * @return allClocks.size value.
     */
    public int numberOfClocks() {
        return listSize;
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
    @Override
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
    @Override
    public void activateStopEverything() {
        this.stopEverything = true;
    }

}
