/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.ClockGroup;
import fi.ekalaja.boardgameclock.TimeLogic;
import fi.ekalaja.boardgameclock.clockui.SwingUi;
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

    private JButton begin;
    private JTextField numberOfClocks;
    private JTextField givenMinutes;
    private JTextField givenSeconds;
    private ClockGroup clocks;
    private TimeLogic timelogic;
    private final SwingUi swingui;

    public SetupActionListener(JButton begin, JTextField numberOfClocks, JTextField givenMinutes, JTextField givenSeconds, SwingUi swingui) {
        this.swingui = swingui;
        this.begin = begin;

        this.numberOfClocks = numberOfClocks;
        this.givenMinutes = givenMinutes;
        this.givenSeconds = givenSeconds;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int value = 0;
        int minutes = 0;
        int seconds = 0;

        try {
            value = Integer.parseInt(numberOfClocks.getText());
            minutes = Integer.parseInt(givenMinutes.getText());
            seconds = Integer.parseInt(givenSeconds.getText());
        } catch (Exception e) {
            System.out.println("virhe");
        }
        if (ae.getSource() == begin) {
            this.createClocksAndTimeLogic(value, minutes, seconds);

        }
    }

    public void createClocksAndTimeLogic(int arvo, int minutes, int seconds) {
        clocks = new ClockGroup();
        for (int i = 0; i < arvo; i++) {
            try {
                clocks.addAClock(minutes, seconds);
            } catch (Exception e) {
            }
            timelogic = new TimeLogic(clocks.returnList());
            swingui.addTimeLogicAndClocks(timelogic, clocks.returnList());
            swingui.createCardTwo();
        }

    }

}
