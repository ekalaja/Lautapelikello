/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

import java.util.ArrayList;

/**
 *
 * @author ekalaja
 */
public class TimeLogic {
    
    private ArrayList<SimpleTimer> list;
    private boolean nextClock;
    public TimeLogic(ArrayList<SimpleTimer> list) {
        this.list = list;
        nextClock = false;
        int listSize = list.size();
    }

    public void run() {
        int clock = 0;
        while (true) {
            list.get(clock).timerTicks();
            System.out.println(list.get(clock).toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                System.out.println("awakened prematurely");
            } 
            if (nextClock) {
                clock++;
            }
        }
    }
    
}
