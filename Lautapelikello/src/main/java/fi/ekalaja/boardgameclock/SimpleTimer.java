/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

/**
 *
 * @author ekalaja
 */
public class SimpleTimer {

    private int minutes;
    private int seconds;
    private boolean clockOn;

    public SimpleTimer(int seconds, int minutes) {
        this.clockOn = true;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void startTimer() {
        while (true) {
            System.out.println(this.toString());
            if (minutes == 0 && seconds == 0) {
                System.out.println("loppu");
                break;
            }
            this.timerTicks();
            
        }
    }

//    public void printTime() {
//        if (minutes < 10 && seconds > 9) {
//            System.out.println("0" + minutes + ":" + seconds);
//        } else if (minutes > 9 && seconds < 10) {
//            System.out.println(minutes + ":" + "0" + seconds);
//        } else if (minutes > 9 && seconds > 9) {
//            System.out.println(minutes + ":" + seconds);
//        } else if (minutes < 10 && seconds < 10) {
//            System.out.println("0" + minutes + ":" + "0" + seconds);
//        }
//
//    }
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("awakened prematurely");
                // us = Thread.currentThread();
                // ...
                // us.interrupt();
            }
        } else if (seconds == 0 && minutes > 0) {
            minutes -= 1;
            seconds = 59;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("awakened prematurely");
            }
        }
    }
    
    public void pauseMode() {
        while (true) {
            if (clockOn=true) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e)
            {
                System.out.println("awakened prematurely");
            }            
        }
    }
    
    public void startOrStop() {
        if (clockOn) {
            clockOn = false;
        } else {
            clockOn = true;
        }
    }
   
}
