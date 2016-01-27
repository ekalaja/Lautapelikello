/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.clockui;





import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class SwingUi implements Runnable {
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Clocks");
        frame.setPreferredSize(new Dimension(600,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
}