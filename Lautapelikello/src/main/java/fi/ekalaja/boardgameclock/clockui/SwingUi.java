package fi.ekalaja.boardgameclock.clockui;

import fi.ekalaja.boardgameclock.SimpleTimer;
import fi.ekalaja.boardgameclock.TimeLogic;
import fi.ekalaja.boardgameclock.actionlistener.PlayersActionListener;
import fi.ekalaja.boardgameclock.actionlistener.SetupActionListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class SwingUi implements Runnable, ItemListener {

//    private JPanel cardLayoutPanel;
//    private JPanel card1;
    private JFrame frame;
    private ArrayList<SimpleTimer> allClocks;
    private TimeLogic timelogic;
    private JPanel cards;
    private JTextField numberOfClocks;
    
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
        String comboBoxItems[]  = { SETUPPANEL, CLOCKSPANEL};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        cards = new JPanel(new CardLayout());
        cards.add(this.createCardOne(), SETUPPANEL);
        cards.add(this.createCardTwo(), CLOCKSPANEL);
        
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public JPanel createCardOne() {
        Font f = new Font("Greek", 1, 20);
        
        JPanel card1 = new JPanel(new GridLayout(2,1));
        JPanel panelOfTextFields = new JPanel(new GridLayout(2,2));
        
        JLabel playerNumberInfo = new JLabel("Number of players:");
        playerNumberInfo.setFont(f);
        playerNumberInfo.setEnabled(false);
        
        JLabel plusTimeInfo = new JLabel("Additional time/move in seconds");

        numberOfClocks = new JTextField("Insert number of players.");
        JTextField additionalTime = new JTextField("0");
        
        JButton begin = new JButton("Begin");
        
        SetupActionListener setupListener = new SetupActionListener(begin, numberOfClocks, additionalTime, timelogic);
        
        panelOfTextFields.add(playerNumberInfo);
        panelOfTextFields.add(plusTimeInfo);
        panelOfTextFields.add(numberOfClocks);
        panelOfTextFields.add(additionalTime);

        card1.add(panelOfTextFields);
        
        
        JPanel setupButtonsPanel = new JPanel();
        
        
        return card1;
    }
    
    
    public JPanel createCardTwo() {
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
        
        return card2;
    }
    
    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    public JFrame getFrame() {
        return frame;
    }
    

}
