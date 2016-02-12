package fi.ekalaja.boardgameclock;

import fi.ekalaja.boardgameclock.clockui.SwingUi;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUi swingui = new SwingUi();
        swingui.run();

        // <dependency>
        //  <groupId>org.assertj</groupId>
        //  <artifactId>assertj-swing-junit</artifactId>
        //  <version>3.0.2</version>
        //  <scope>test</scope>
        //</dependency>
        // pom.xml muutos jotta testit toimisi. Tässä vanha
    }

}
