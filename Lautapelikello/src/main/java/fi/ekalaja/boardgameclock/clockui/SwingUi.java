/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.clockui;





import fi.ekalaja.boardgameclock.SimpleTimer;
import fi.ekalaja.boardgameclock.TimeLogic;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class SwingUi implements Runnable {
    
    private JFrame frame;
    private ArrayList<SimpleTimer> allClocks;
//    private TimeLogic timelogic; tod.näk turha

    public SwingUi(ArrayList<SimpleTimer> allClocks) {
        this.allClocks = allClocks;
    }
    
    
    
    @Override
    public void run() {
        frame = new JFrame("Clocks");
        frame.setPreferredSize(new Dimension(600,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createAllComponents();
        // käytä frame.getContentPane() allComponents sisällä
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createAllComponents() {
        frame.setLayout(new GridLayout(1,2));
        frame.add(new JButton("next"));
        frame.add(new JButton("start"));
        
    }
    
//    public void createAllComponents(Container container) { varmaan parempi tapa?
    
//        frame.setLayout(new GridLayout(1,2));
//        container.add(new JButton("next"));
//    }

    public JFrame getFrame() {
        return frame;
    }
    
//    public void setTimeLogic(TimeLogic timelogic) {     tod.näk turha
//        this.timelogic = timelogic;
//    }
    
    
    
}