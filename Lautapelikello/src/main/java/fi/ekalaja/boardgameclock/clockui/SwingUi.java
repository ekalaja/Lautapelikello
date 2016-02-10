package fi.ekalaja.boardgameclock.clockui;

import fi.ekalaja.boardgameclock.SimpleTimer;
import fi.ekalaja.boardgameclock.TimeLogic;
import fi.ekalaja.boardgameclock.actionlistener.PlayersActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class SwingUi implements Runnable, ItemListener {

//    private JPanel cardLayoutPanel;
//    private JPanel card1;
    private JFrame frame;
    private ArrayList<SimpleTimer> allClocks;
    private TimeLogic timelogic;
    private JPanel cards;
    final static String CLOCKSPANEL = "CLOCKS";
    final static String SETUPPANEL = "SETUP";

    public SwingUi(ArrayList<SimpleTimer> allClocks, TimeLogic timelogic) {
        this.allClocks = allClocks;
        this.timelogic = timelogic;
    }

    @Override
    public void run() {       

        frame = new JFrame("Clocks");
        frame.setPreferredSize(new Dimension(600, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createAllComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
//        cardLayoutPanel.add(frame);
    }

    public void createAllComponents(Container pane) {

        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[]  = { CLOCKSPANEL, SETUPPANEL};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
//        cb.addItemListener(null);
        comboBoxPane.add(cb);
        JPanel card1 = new JPanel();
        // lisätään setup toiminnallisuudet card1:seen.
        
        
        JPanel card2 = new JPanel(new GridLayout(2,1));
        JPanel panelOfClocks = new JPanel(new GridLayout(1, 0));

        for (int i = 0; i < this.allClocks.size(); i++) {
            ClockNumberFrame ClockFrame = allClocks.get(i).returnClockNumberFrame();
            Font f = new Font("Greek", 1, 30);

            ClockFrame.setFont(f);
            ClockFrame.setEnabled(false);
            panelOfClocks.add(ClockFrame);
        }
        
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
        
        card2.add(panelOfButtons);
        card2.add(panelOfClocks);
//        frame.add(panelOfButtons);
        
        
        cards = new JPanel(new CardLayout());
        cards.add(card2, CLOCKSPANEL);
        cards.add(card1, SETUPPANEL);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
//        frame.setLayout(new GridLayout(2, 1)); oli ennen
//        frame.add(panelOfClocks);

    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    public JFrame getFrame() {
        return frame;
    }
    

}
