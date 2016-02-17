/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.SimpleTimer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ekalaja
 */
public class TimerSpecificListener implements ActionListener {

    private SimpleTimer simpletimer;
    private JButton addTime;
    private JButton timePenalty;

    public TimerSpecificListener(SimpleTimer simpletimer) {
        this.simpletimer = simpletimer;
    }

    public TimerSpecificListener(SimpleTimer simpletimer, JButton addTime, JButton timePenalty) {
        this.simpletimer = simpletimer;
        this.addTime = addTime;
        this.timePenalty = timePenalty;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTime) {
            simpletimer.addAQuarterMinute();
            simpletimer.refreshFrameNumbers();
        } else if (e.getSource() == timePenalty) {
            simpletimer.reduceAQuarterMinute();
            simpletimer.refreshFrameNumbers();
        }

    }

}
