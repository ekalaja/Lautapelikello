/**
 * This class gives every created SimpleTimer two buttons,  
 * which effect only that SimpleTimer.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.timers.SimpleTimer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * This class gives every created SimpleTimer two buttons,  
 * which effect only that SimpleTimer.
 */
public class TimerSpecificListener implements ActionListener {

    private SimpleTimer simpletimer;
    private JButton addTime;
    private JButton timePenalty;


/**
 * This constructor is given the specific timer and two buttons related to it.
 * @param simpletimer the specific timer
 * @param addTime gives 15 seconds to the SimpleTimer
 * @param timePenalty takes 15 seconds from the SimpleTimer
 */
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
