/**
 * This class creates an ArrayList of SimpleTimers.
 */
package fi.ekalaja.boardgameclock.timers;

import fi.ekalaja.boardgameclock.timers.SimpleTimer;
import java.util.ArrayList;
import java.util.List;

public class ClockGroup {

    private ArrayList<SimpleTimer> listOfClocks;

    /**
     * Generates an ArrayList where new SimpleTimers can be added.
     */
    public ClockGroup() {
        this.listOfClocks = new ArrayList();

    }

    /**
     * Adds a SimpleTimer to the ArrayList.
     * @param minutes is given in the setup UI for every SimpleTimer.
     * @param seconds is given in the setup UI for every SimpleTimer.
     */
    public void addAClock(int minutes, int seconds) {
        try {
            listOfClocks.add(new SimpleTimer(minutes, seconds));
        } catch (Exception e) {
            System.out.println("Use positive time.");
        }
    }

    /**
     * returns a list of SimpleTimers.
     * @return an ArrayList listOfClocks
     */
    public ArrayList<SimpleTimer> returnList() {
        return this.listOfClocks;
    }
}
