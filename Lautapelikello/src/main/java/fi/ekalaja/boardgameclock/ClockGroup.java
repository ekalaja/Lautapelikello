package fi.ekalaja.boardgameclock;

import java.util.ArrayList;
import java.util.List;

public class ClockGroup {

    private ArrayList<SimpleTimer> listOfClocks;

    public ClockGroup() {
        this.listOfClocks = new ArrayList();
        
    }
    
    public void addAClock(int minutes, int seconds) {
        listOfClocks.add(new SimpleTimer(minutes, seconds));
    }
    
    public ArrayList<SimpleTimer> returnList() {
        return this.listOfClocks;
    }
}
