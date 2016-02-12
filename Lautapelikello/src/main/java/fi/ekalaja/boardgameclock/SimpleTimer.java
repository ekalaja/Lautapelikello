/**
* SimpleTimer is the basic element used in the project.
* This class is used to save the time used by each player.
* Each SimpleTimer is linked to one ClockNumberFrame.
*/
package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.clockui.ClockNumberFrame;

public class SimpleTimer {

    private int minutes;
    private int seconds;
    private ClockNumberFrame clockframe;

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
 * @return  
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
 * This method sets updated values for the ClockFrame.
 */
    public void refreshFrameNumbers() {
        this.clockframe.setText(this.toString());
    }
/**
 * 
 * @return  Method returns SimpleTimer's specific ClockNumberFrame.
 */
    public ClockNumberFrame returnClockNumberFrame() {
        return this.clockframe;
    }

}
