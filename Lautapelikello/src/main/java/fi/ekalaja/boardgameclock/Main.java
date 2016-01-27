/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.clockui.SwingUi;
import javax.swing.SwingUtilities;




public class Main {

 
    public static void main(String[] args) {
        

        ClockGroup clocks = new ClockGroup();
        clocks.addAClock(3,0);
        TimeLogic logic = new TimeLogic(clocks.returnList());
        logic.run();
//        SwingUtilities.invokeLater(new SwingUi());
//        SimpleTimer timer = new SimpleTimer(5,3);
//        timer.startTimer();
    }
    
}
