/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.clockui.SwingUi;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        ClockGroup clocks = new ClockGroup();
        try {
            clocks.addAClock(0, -1);
            
        } catch (Exception e) {
            System.out.println("Use positive time.");
        }
        try {
            clocks.addAClock(2, 2);
            
        } catch (Exception e) {
            System.out.println("Use positive time.");
        }
        

        TimeLogic timelogic = new TimeLogic(clocks.returnList());
        SwingUi swingui = new SwingUi(clocks.returnList(), timelogic);

        swingui.run();
        //ui.getFrame().repaint();

        timelogic.run();

        // <dependency>
        //  <groupId>org.assertj</groupId>
        //  <artifactId>assertj-swing-junit</artifactId>
        //  <version>3.0.2</version>
        //  <scope>test</scope>
        //</dependency>
        // pom.xml muutos jotta testit toimisi. Tässä vanha
    }

}
