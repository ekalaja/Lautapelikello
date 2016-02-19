/*
 * SettingsPanel only has button "back" at the moment, but the idea is to 
enable easy access to important buttons any time.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.clockui.SwingUi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class SettingsPanelListener implements ActionListener {

    private JButton back;
    private SwingUi swingui;

    /**
     * button "back" changes the CardLayout to previous card every time.
     *
     * @param back always returns to previous card
     * @param swingui the user interface being used
     */
    public SettingsPanelListener(JButton back, SwingUi swingui) {
        this.back = back;
        this.swingui = swingui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.swingui.changeToAnotherView();
    }

}
