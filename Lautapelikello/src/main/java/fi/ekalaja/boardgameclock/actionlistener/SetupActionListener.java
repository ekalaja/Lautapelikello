/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.ClockGroup;
import fi.ekalaja.boardgameclock.TimeLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ekalaja
 */
public class SetupActionListener implements ActionListener {
    private final JButton begin;
    private final JTextField numberOfClocks;
    private final JTextField additionalTime;
    private ClockGroup clocks;



    public SetupActionListener(JButton begin, JTextField numberOfClocks, JTextField additionalTime, TimeLogic timelogic) {
        this.begin = begin;
        this.numberOfClocks = numberOfClocks;
        this.additionalTime = additionalTime;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int value = 0;
        int time = 0;
        
        try{
            value = Integer.parseInt(numberOfClocks.getText());
            time = Integer.parseInt(numberOfClocks.getText());
        } catch (Exception e) {         
        } 
        if (ae.getSource() == begin) {
            if (value > 0 ) {
                this.createClocks(value, time);
            }
        }
    }
    
    public ClockGroup createClocks(int arvo, int minutes) {
        clocks = new ClockGroup();
//        for (int i = 0; i < arvo; i++) {
//            try {
//                clocks.addAClock(i, minutes);
//            }
//        }
        return clocks;
    }
    
}
