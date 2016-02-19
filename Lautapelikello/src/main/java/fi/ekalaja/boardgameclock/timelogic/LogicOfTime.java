/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.timelogic;

/**
 *
 * @author ekalaja
 */
public interface LogicOfTime extends Runnable {
    
    public void run();
    
    public void activateStopEverything();
    
    public void setNextClockTrue();
    
    public void changePauseOnStatus();
    
    
}
