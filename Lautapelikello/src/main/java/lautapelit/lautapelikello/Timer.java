/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lautapelit.lautapelikello;

/**
 *
 * @author ekalaja
 */
public class Timer {

    private int minutes;
    private int seconds;

    public Timer(int seconds, int minutes) {
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
                Thread.sleep(10);
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
    
   
}
