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
        
        System.out.println("toimii");

        ClockGroup clockgroup = new ClockGroup();
        SwingUtilities.invokeLater(new SwingUi());
        SimpleTimer timer = new SimpleTimer(5,3);
        timer.startTimer();
    }
    
}
