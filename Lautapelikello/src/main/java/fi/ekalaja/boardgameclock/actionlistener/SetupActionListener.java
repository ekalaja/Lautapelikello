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
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetupActionListener implements ActionListener {

    private JButton begin;
    private JTextField numberOfClocks;
    private JTextField givenMinutes;
    private JTextField givenSeconds;
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
     * @param swingui User interface being used
     */
    public SetupActionListener(JButton begin, JButton hourglass, JTextField numberOfClocks, JTextField givenMinutes, JTextField givenSeconds, SwingUi swingui) {
        this.swingui = swingui;
        this.begin = begin;
        this.hourglass = hourglass;
        this.numberOfClocks = numberOfClocks;
        this.givenMinutes = givenMinutes;
        this.givenSeconds = givenSeconds;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == begin) {
            int value = 0;
            int minutes = 0;
            int seconds = 0;

            try {
                value = Integer.parseInt(numberOfClocks.getText());
                minutes = Integer.parseInt(givenMinutes.getText());
                seconds = Integer.parseInt(givenSeconds.getText());
                if (ae.getSource() == begin) {
                    if ((value > 0 && minutes > 0) | (value > 0 && seconds > 0)) {
                        this.createClocksAndTimeLogic(value, minutes, seconds);
                    }
                }
            } catch (Exception e) {
                System.out.println("virhe");
            }
        } else if (ae.getSource() == hourglass) {
            int minutes = 0;
            try {
                minutes = Integer.parseInt(givenMinutes.getText());
            } catch (Exception e) {
                System.out.println("Value of minutes must be positive.");
            }
            if (minutes > 0) {
                this.createHourglassLogic(minutes);
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
    public void createClocksAndTimeLogic(int arvo, int minutes, int seconds) {
        clocks = new ClockGroup();

        for (int i = 0; i < arvo; i++) {
            clocks.addAClock(minutes, seconds);
        }

        TimersLogic logic = new TimersLogic(clocks.returnList());
        swingui.addTimeLogicAndClocks(logic, clocks.returnList());
        swingui.createCardTwo();

    }

    /**
     * This method is chosen if game mode is hourglass. It creates
     * HourglassLogic which always takes time from another player and gives it's
     * opponent.
     *
     * @param minutes
     */
    public void createHourglassLogic(int minutes) {
        clocks = new ClockGroup();

        clocks.addAClock(minutes, 0);
        clocks.addAClock(minutes, 0);

        HourglassLogic hourglassL = new HourglassLogic(clocks.returnList());
        swingui.addHourglassLogic(hourglassL, clocks.returnList());
        swingui.createCardTwo();
    }

}
