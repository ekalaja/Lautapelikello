/**
 * SimpleTimer is the basic element used in the project. This class is used to
 * save the time used by each player. Each SimpleTimer is linked to one
 * ClockNumberFrame.
 */
package fi.ekalaja.boardgameclock.timers;

import fi.ekalaja.boardgameclock.clockui.ClockNumberFrame;

public class SimpleTimer {

    private int minutes;
    private int seconds;
    private ClockNumberFrame clockframe;

    /**
     * Each SimpleTimer has a ClockFrame specified for it.
     * @param minutes the number of minutes left in the timer
     * @param seconds the number of seconds left in the timer
     * @throws Exception Prevents illegal values to be given for the timers.
     */
    public SimpleTimer(int minutes, int seconds) throws Exception {
        if (minutes < 0 || seconds < 0) {
            throw new Exception("Time is not allowed.");
        }
        this.minutes = minutes;
        this.seconds = seconds;
        this.clockframe = new ClockNumberFrame(this.toString());

    }

    /**
     * This method makes sure that time is given in the right format.
     * @return is a String which contains the time in minutes and seconds
     */
    @Override
    public String toString() {
        if (minutes < 10 && seconds > 9) {
            return "0" + minutes + ":" + seconds;
        } else if (minutes > 9 && seconds < 10) {
            return minutes + ":" + "0" + seconds;
        } else if (minutes > 9 && seconds > 9) {
            return minutes + ":" + seconds;
        } else {
            return "0" + minutes + ":" + "0" + seconds;
        }
    }

    /**
     * This method takes one second away from the timer.
     */
    public void timerTicks() {
        if (seconds > 0) {
            seconds -= 1;
        } else if (seconds == 0 && minutes > 0) {
            minutes -= 1;
            seconds = 59;
        }
    }
/**
 * This method gives the timer additional second.
 */
    public void timerUnticks() {
        if (seconds < 59) {
            seconds += 1;
        } else if (seconds == 59) {
            minutes += 1;
            seconds = 0;
        }
    }
/**
 * This method adds 15 seconds for the timer.
 */
    public void addAQuarterMinute() {
        if (this.seconds < 45) {
            this.seconds += 15;
        } else {
            int change = 60 - this.seconds;
            this.seconds = 15 - change;
            this.minutes += 1;
        }
    }

    /**
     * This method sets updated values for the ClockFrame.
     */
    public void refreshFrameNumbers() {
        this.clockframe.setText(this.toString());
    }

    /**
     * Method returns SimpleTimer's specific ClockNumberFrame.
     * @return SimpleTimer's specific ClockFrame.
     */
    public ClockNumberFrame returnClockNumberFrame() {
        return this.clockframe;
    }
/**
 * This method takes 15 seconds from the timer.
 */
    public void reduceAQuarterMinute() {
        if (this.seconds > 14) {
            this.seconds -= 15;
        } else {
            int change = 15 - this.seconds;
            this.seconds = 60 - change;
            this.minutes -= 1;
        }
    }

}
