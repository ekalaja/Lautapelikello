/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.clockui.ClockNumberFrame;

/**
 *
 * @author ekalaja
 */
public class SimpleTimer {

    private int minutes;
    private int seconds;
    private ClockNumberFrame clockframe;

    public SimpleTimer(int minutes, int seconds) throws Exception  {

  
        if (minutes < 0 || seconds < 0) {
            throw new Exception("Time is not allowed.");
        } 
        this.minutes = minutes;
            this.seconds = seconds;
            this.clockframe = new ClockNumberFrame(this.toString());
        
    }

    @Override
    public String toString() {
        if (minutes < 10 && seconds > 9) {
            return "0" + minutes + ":" + seconds;
        } else if (minutes > 9 && seconds < 10) {
            return minutes + ":" + "0" + seconds;
        } else if (minutes > 9 && seconds > 9) {
            return minutes + ":" + seconds;
        } else if (minutes < 10 && seconds < 10) {
            return "0" + minutes + ":" + "0" + seconds;
        }
        return "Problem with returning time value.";
    }

    public void timerTicks() {
        if (seconds > 0) {
            seconds -= 1;

        } else if (seconds == 0 && minutes > 0) {
            minutes -= 1;
            seconds = 59;

        }
    }
    
    public void refreshFrameNumbers() {
        this.clockframe.setText(this.toString());
    }
    
    public ClockNumberFrame returnClockNumberFrame() {
        return this.clockframe;
    }

   
}
