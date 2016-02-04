/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.TimeLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ekalaja
 */
public class PlayersActionListener implements ActionListener {
    
    
    private TimeLogic timelogic;
    private JButton nextClock;
    private JButton StartOrPause;
    
    public PlayersActionListener(JButton nextClock, JButton pause, TimeLogic timelogic) {
        this.timelogic = timelogic;
        this.nextClock = nextClock;
        this.StartOrPause = pause;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextClock) {
            timelogic.setNextClockTrue();
        } else if (ae.getSource() == StartOrPause) {
            timelogic.changePauseOnStatus();
        }
    }
    
    
    
}
