/*
 * This class is an interface for the differend logics being used in the project.
 */
package fi.ekalaja.boardgameclock.timelogic;

/**
 * Interface of the logic only includes most important methods.
 * @author ekalaja
 */
public interface LogicOfTime extends Runnable {
/**
 * Takes care of the actual logic.
 */
    @Override
    public void run();

    /**
     * this is currently used to stop old and no more needed timers
     * from being active in the background.
     */
    public void activateStopEverything();

    /**
     * always changes the status of nextClock boolean to true.
     */
    public void setNextClockTrue();
/**
     * always changes the status of pauseOn boolean to true.
     */
    public void changePauseOnStatus();

}
