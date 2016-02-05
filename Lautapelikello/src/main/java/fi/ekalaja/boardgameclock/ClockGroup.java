package fi.ekalaja.boardgameclock;

import java.util.ArrayList;
import java.util.List;

public class ClockGroup {

    private ArrayList<SimpleTimer> listOfClocks;

    public ClockGroup() {
        this.listOfClocks = new ArrayList();
        
    }
    
    public void addAClock(int minutes, int seconds) {
        try {
            listOfClocks.add(new SimpleTimer(minutes, seconds));
        } catch (Exception e) {
            System.out.println("Use positive time.");
        }
        
    }
    
    public ArrayList<SimpleTimer> returnList() {
        return this.listOfClocks;
    }
}
