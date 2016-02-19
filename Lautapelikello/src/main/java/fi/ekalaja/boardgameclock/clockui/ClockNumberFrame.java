/**
 * This is an extension of JTextField. Each ClockNumberFrame is created for a
 * specific SimpeTimer.
 */
package fi.ekalaja.boardgameclock.clockui;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ClockNumberFrame extends JLabel {

    /**
     * This constructor inserts a given String in to a JLabel.
     * @param values Are SimpleTimer's minutes and seconds
     */
    public ClockNumberFrame(String values) {
        super(values);
    }

}
