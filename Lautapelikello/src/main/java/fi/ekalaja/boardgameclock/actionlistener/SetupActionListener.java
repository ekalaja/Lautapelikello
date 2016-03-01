/**
 * This class is an ActionListener for the buttons and TextFields of the Setup
 * card.
 *
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.timers.ClockGroup;
import fi.ekalaja.boardgameclock.timelogic.TimersLogic;
import fi.ekalaja.boardgameclock.clockui.SwingUi;
import fi.ekalaja.boardgameclock.timelogic.HourglassLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SetupActionListener implements ActionListener {

    private JButton begin;
    private JTextField numberOfClocks;
    private JTextField givenMinutes;
    private JTextField givenSeconds;
    private JTextField givenExtraTime;
    private ClockGroup clocks;
    private final SwingUi swingui;
    private final JButton hourglass;
   

    /**
     * This constructor inserts listener for buttons needed at Card1, which is
     * setup card.
     *
     * @param begin starts a regular game
     * @param hourglass starts 1v1 with hourglass game mode
     * @param numberOfClocks number of clocks
     * @param givenMinutes inserted minutes
     * @param givenSeconds inserted seconds
     * @param extraTime Additional time for every turn.
     * @param swingui User interface being used
     */
    public SetupActionListener(JButton begin, JButton hourglass, JTextField numberOfClocks, JTextField givenMinutes, JTextField givenSeconds, JTextField extraTime, SwingUi swingui) {
        this.swingui = swingui;
        this.begin = begin;
        this.hourglass = hourglass;
        this.numberOfClocks = numberOfClocks;
        this.givenMinutes = givenMinutes;
        this.givenSeconds = givenSeconds;
        this.givenExtraTime = extraTime;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == begin) {
            int value = 0;
            int minutes = 0;
            int seconds = 0;
            int extraTime = 0;

            try {
                
                value = Integer.parseInt(numberOfClocks.getText());
                minutes = Integer.parseInt(givenMinutes.getText());
                seconds = Integer.parseInt(givenSeconds.getText());
                extraTime = Integer.parseInt(givenExtraTime.getText());
                if (ae.getSource() == begin) {
                    if ((value > 0 && minutes > 0 && extraTime >= 0) | (value > 0 && seconds > 0 && extraTime >= 0)) {
                        this.createClocksAndTimeLogic(value, minutes, seconds, extraTime);
                    }
                }
            } catch (Exception e) {
                System.out.println("Give positive values for time and players.");
            }
        } else if (ae.getSource() == hourglass) {
            int minutes = 0;
            int seconds = 0;
            try {
                seconds = Integer.parseInt(givenSeconds.getText());
                minutes = Integer.parseInt(givenMinutes.getText());
            } catch (Exception e) {
                System.out.println("Value of minutes must be positive.");
            }
            if ((minutes > 0 && seconds >= 0) | (minutes >= 0 && seconds > 0)) {
                this.createHourglassLogic(minutes, seconds);
            }
        }

    }

    /**
     * This method is chosen if game mode is normal. It creates as many clocks
     * as user has chosen in Card1.
     *
     * @param arvo number of players
     * @param minutes amount of minutes in the beginning
     * @param seconds amount of seconds in the beginning
     */
    public void createClocksAndTimeLogic(int arvo, int minutes, int seconds, int extraTime) {
        clocks = new ClockGroup();

        for (int i = 0; i < arvo; i++) {
            clocks.addAClock(minutes, seconds);
        }

        TimersLogic logic = new TimersLogic(clocks, extraTime);
        swingui.addTimeLogicAndClocks(logic, clocks);
        swingui.createCardTwo();

    }

    /**
     * This method is chosen if game mode is hourglass. It creates
     * HourglassLogic which always takes time from another player and gives it's
     * opponent.
     *
     * @param minutes Value of full minutes used in "hourglass".
     * @param seconds Value of seconds used in "hourglass".
     */
    public void createHourglassLogic(int minutes, int seconds) {
        clocks = new ClockGroup();
        clocks.addAClock(minutes, seconds);
        clocks.addAClock(minutes, seconds);

        HourglassLogic hourglassL = new HourglassLogic(clocks);
        swingui.addHourglassLogic(hourglassL, clocks);
        swingui.createCardTwo();
    }

}
