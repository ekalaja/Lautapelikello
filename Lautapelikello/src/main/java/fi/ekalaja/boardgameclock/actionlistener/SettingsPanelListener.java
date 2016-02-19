/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ekalaja.boardgameclock.actionlistener;

import fi.ekalaja.boardgameclock.clockui.SwingUi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ekalaja
 */
public class SettingsPanelListener implements ActionListener {
    
    private JButton back;
    private SwingUi swingui;
    
    public SettingsPanelListener(JButton back, SwingUi swingui) {
    this.back = back;
    this.swingui = swingui;
}

    @Override
    public void actionPerformed(ActionEvent e) {
        this.swingui.changeToAnotherView();
    }
    
}
