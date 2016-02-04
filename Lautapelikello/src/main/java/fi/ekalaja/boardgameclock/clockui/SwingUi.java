package fi.ekalaja.boardgameclock.clockui;

import fi.ekalaja.boardgameclock.SimpleTimer;
import fi.ekalaja.boardgameclock.TimeLogic;
import fi.ekalaja.boardgameclock.actionlistener.PlayersActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SwingUi implements Runnable {

    private JFrame frame;
    private ArrayList<SimpleTimer> allClocks;
    private TimeLogic timelogic;

    public SwingUi(ArrayList<SimpleTimer> allClocks, TimeLogic timelogic) {
        this.allClocks = allClocks;
        this.timelogic = timelogic;
    }

    @Override
    public void run() {
        frame = new JFrame("Clocks");
        frame.setPreferredSize(new Dimension(600, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createAllComponents();
        // käytä frame.getContentPane() allComponents sisällä
        frame.pack();
        frame.setVisible(true);
    }

    public void createAllComponents() {
        frame.setLayout(new GridLayout(2, 1));
        JPanel panelOfClocks = new JPanel(new GridLayout(1, 0));

        for (int i = 0; i < this.allClocks.size(); i++) {
            ClockNumberFrame ClockFrame = allClocks.get(i).returnClockNumberFrame();
            Font f = new Font("Greek", 1, 30);

            ClockFrame.setFont(f);
            ClockFrame.setEnabled(false);
            panelOfClocks.add(ClockFrame);
        }
//        ClockFrame.setForeground(Color.GREEN); ei toimi noin
//        panel.setFont(new Font("Greek", 1, 30)); eikä näin
        frame.add(panelOfClocks);

        JButton start = new JButton("Start/Pause");
        JButton next = new JButton("Next");
        start.setName("Start/Pause");
        next.setName("Next");

        PlayersActionListener userListener = new PlayersActionListener(next, start, timelogic);
        next.addActionListener(userListener);
        start.addActionListener(userListener);

        JPanel panelOfButtons = new JPanel(new GridLayout(1, 0));
        panelOfButtons.add(next);
        panelOfButtons.add(start);
        frame.add(panelOfButtons);

    }

    public JFrame getFrame() {
        return frame;
    }

}
