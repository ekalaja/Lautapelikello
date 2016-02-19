/**
 * This class is an ActionListener for the buttons of the Clocks card.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.timelogic.LogicOfTime;
import fi.ekalaja.boardgameclock.timelogic.TimersLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class PlayersActionListener implements ActionListener {

    private LogicOfTime timelogic;
    private JButton nextClock;
    private JButton startOrPause;
/**
 * This constructor defines which buttons are listened.
 * @param nextClock changes the truth value of a boolean "nextClock" to true
 * @param pause changes the truth value of a boolean "pauseOn" to true
 * @param timelogic inserts the LogicOfTime being used
 */
    public PlayersActionListener(JButton nextClock, JButton pause, LogicOfTime timelogic) {
        this.timelogic = timelogic;
        this.nextClock = nextClock;
        this.startOrPause = pause;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextClock) {
            timelogic.setNextClockTrue();
        } else if (ae.getSource() == startOrPause) {
            timelogic.changePauseOnStatus();
        }
    }

}
