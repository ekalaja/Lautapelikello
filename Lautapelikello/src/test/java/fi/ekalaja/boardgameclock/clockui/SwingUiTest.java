package fi.ekalaja.boardgameclock.clockui;

import java.awt.Frame;
import javax.swing.JFrame;
import org.assertj.swing.core.GenericTypeMatcher;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;

/**
 *
 * @author ekalaja
 */
public class SwingUiTest extends AssertJSwingJUnitTestCase {

    FrameFixture window;

//    @Test
//    public void testPushingStartChangesPauseOnFalse() {
//        assertEquals(1,1);
//
//    }

    @Override
    protected void onSetUp() {
        application(fi.ekalaja.boardgameclock.Main.class).start();

        window = findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
            protected boolean isMatching(Frame frame) {
                return frame.isShowing();
            }
        }).using(robot());
    }


}
