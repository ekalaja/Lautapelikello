/**
 * This is user interface.
 */
package fi.ekalaja.boardgameclock.clockui;

import fi.ekalaja.boardgameclock.SimpleTimer;
import fi.ekalaja.boardgameclock.TimeLogic;
import fi.ekalaja.boardgameclock.actionlistener.PlayersActionListener;
import fi.ekalaja.boardgameclock.actionlistener.SetupActionListener;
import fi.ekalaja.boardgameclock.actionlistener.TimerSpecificListener;
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

    private JFrame frame;
    private ArrayList<SimpleTimer> allClocks;
    private TimeLogic timelogic;
    private JPanel cards;
    private JTextField numberOfClocks;

    final static String CLOCKSPANEL = "CLOCKS";
    final static String SETUPPANEL = "SETUP";

    @Override
    public void run() {
        frame = new JFrame("Clocks");
        frame.setPreferredSize(new Dimension(600, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createAllComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createAllComponents(Container pane) {
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = {SETUPPANEL, CLOCKSPANEL};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        cards = new JPanel(new CardLayout());
        cards.add(this.createCardOne(), SETUPPANEL);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public JPanel createCardOne() {
        JPanel card1 = new JPanel(new GridLayout(2, 1));
        JPanel panelOfTextFields = new JPanel(new GridLayout(2, 3));

        JLabel playerNumberInfo = new JLabel("Number of players:");
        JLabel minutesInfo = new JLabel("Insert minutes");
        JLabel secondsInfo = new JLabel("Insert seconds");

        numberOfClocks = new JTextField("2");
        JTextField givenMinutes = new JTextField("5");
        JTextField givenSeconds = new JTextField("0");

        JButton begin = new JButton("Begin");
        SetupActionListener setupListener = new SetupActionListener(begin, numberOfClocks, givenMinutes, givenSeconds, this);
        begin.addActionListener(setupListener);

        panelOfTextFields.add(playerNumberInfo);
        panelOfTextFields.add(minutesInfo);
        panelOfTextFields.add(secondsInfo);
        panelOfTextFields.add(numberOfClocks);
        panelOfTextFields.add(givenMinutes);
        panelOfTextFields.add(givenSeconds);

        card1.add(panelOfTextFields);

        JPanel setupButtonsPanel = new JPanel(new GridLayout(1, 0));
        setupButtonsPanel.add(begin);
        card1.add(setupButtonsPanel);
        return card1;
    }

    public void createCardTwo() {
        JPanel card2 = new JPanel(new GridLayout(3, 1));
        JPanel panelOfClocks = new JPanel(new GridLayout(1, 0));

        for (int i = 0; i < allClocks.size(); i++) {
            ClockNumberFrame clockFrame = allClocks.get(i).returnClockNumberFrame();
            clockFrame.setOpaque(true);
            clockFrame.setForeground(Color.red);
            Font f = new Font("Greek", 1, 30);
            

            clockFrame.setFont(f);
            clockFrame.setEnabled(false);
            panelOfClocks.add(clockFrame);
        }

        JButton start = new JButton("Start/Pause");
        JButton next = new JButton("Next");
        start.setName("Start/Pause");
        next.setName("Next");

        //        
        JPanel panelOfTimeEditing = new JPanel(new GridLayout(1, 0));
        for (int i = 0; i < allClocks.size(); i++) {
            JPanel buttonSpecificPanel = new JPanel(new GridLayout(1, 3));
            panelOfTimeEditing.add(buttonSpecificPanel);
            JButton addTime = new JButton("+ 15 sec");
            JButton timePenalty = new JButton("- 15 sec");

            buttonSpecificPanel.add(timePenalty);
            buttonSpecificPanel.add(addTime);
            panelOfTimeEditing.add(buttonSpecificPanel);

            TimerSpecificListener tSListener = new TimerSpecificListener(allClocks.get(i), addTime, timePenalty);

            addTime.addActionListener(tSListener);
            timePenalty.addActionListener(tSListener);
            timePenalty.addActionListener(new TimerSpecificListener(allClocks.get(i)));

        }

//     
        PlayersActionListener userListener = new PlayersActionListener(next, start, timelogic);
        next.addActionListener(userListener);
        start.addActionListener(userListener);

        JPanel panelOfButtons = new JPanel(new GridLayout(1, 0));
        panelOfButtons.add(start);
        panelOfButtons.add(next);

        card2.add(panelOfButtons);
        card2.add(panelOfClocks);
        card2.add(panelOfTimeEditing);

        new Thread(timelogic).start();
        cards.add(card2, CLOCKSPANEL);
        frame.getContentPane().add(cards);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    public void addTimeLogicAndClocks(TimeLogic timelogic, ArrayList allClocks) {
        this.timelogic = timelogic;
        this.allClocks = allClocks;

    }

    public JFrame getFrame() {
        return frame;
    }

}
