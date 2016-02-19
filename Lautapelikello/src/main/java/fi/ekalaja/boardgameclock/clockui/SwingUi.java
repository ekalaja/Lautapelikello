/**
 * This is user interface.
 */
package fi.ekalaja.boardgameclock.clockui;

import fi.ekalaja.boardgameclock.timers.SimpleTimer;
import fi.ekalaja.boardgameclock.timelogic.TimersLogic;
import fi.ekalaja.boardgameclock.actionlistener.PlayersActionListener;
import fi.ekalaja.boardgameclock.actionlistener.SettingsPanelListener;
import fi.ekalaja.boardgameclock.actionlistener.SetupActionListener;
import fi.ekalaja.boardgameclock.actionlistener.TimerSpecificListener;
import fi.ekalaja.boardgameclock.timelogic.HourglassLogic;
import fi.ekalaja.boardgameclock.timelogic.LogicOfTime;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SwingUi implements Runnable {

    private JFrame frame;
    private ArrayList<SimpleTimer> allClocks;
    private LogicOfTime logic;
    private JPanel cards;
    private JTextField numberOfClocks;
    private JPanel card2;
    private JButton back;

    @Override
    public void run() {
        frame = new JFrame("Clocks");
        frame.setPreferredSize(new Dimension(600, 200));
        frame.setMinimumSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createAllComponents(frame.getContentPane());
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public void createAllComponents(Container pane) {

        cards = new JPanel(new CardLayout());
        JPanel card1 = this.createCardOne();
        cards.add(card1);

        back = new JButton("back");
        back.setVisible(false);
        SettingsPanelListener settingsListener = new SettingsPanelListener(back, this);
        back.addActionListener(settingsListener);
        JPanel topSettings = new JPanel(new GridLayout(1, 3));
        topSettings.add(new JLabel(""));
        topSettings.add(new JLabel(""));
        topSettings.add(back);

        pane.add(topSettings, BorderLayout.PAGE_START);
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
        JButton hourglass = new JButton("Start 1v1 with hourglass");
        SetupActionListener setupListener = new SetupActionListener(begin, hourglass, numberOfClocks, givenMinutes, givenSeconds, this);
        begin.addActionListener(setupListener);
        hourglass.addActionListener(setupListener);

        panelOfTextFields.add(playerNumberInfo);
        panelOfTextFields.add(minutesInfo);
        panelOfTextFields.add(secondsInfo);
        panelOfTextFields.add(numberOfClocks);
        panelOfTextFields.add(givenMinutes);
        panelOfTextFields.add(givenSeconds);

        card1.add(panelOfTextFields);

        JPanel setupButtonsPanel = new JPanel(new GridLayout(1, 0));
        setupButtonsPanel.add(begin);
        setupButtonsPanel.add(hourglass);
        card1.add(setupButtonsPanel);
        return card1;
    }

    public void createCardTwo() {

        card2 = new JPanel(new GridLayout(0, 1));
        JPanel panelOfClocks = new JPanel(new GridLayout(1, 0));

        for (int i = 0; i < allClocks.size(); i++) {
            ClockNumberFrame clockFrame = allClocks.get(i).returnClockNumberFrame();
            Font f = new Font("Greek", 1, 30);

            clockFrame.setFont(f);
            clockFrame.setForeground(Color.black);
            panelOfClocks.add(clockFrame);
        }

        JButton start = new JButton("Start/Pause");
        JButton next = new JButton("Next");
        start.setName("Start/Pause");
        next.setName("Next");

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
        }

        PlayersActionListener userListener = new PlayersActionListener(next, start, logic);
        next.addActionListener(userListener);
        start.addActionListener(userListener);

        JPanel panelOfButtons = new JPanel(new GridLayout(1, 0));
        panelOfButtons.add(start);
        panelOfButtons.add(next);

        card2.add(panelOfButtons);
        card2.add(panelOfClocks);

        if (logic.getClass() == TimersLogic.class) {
            card2.add(panelOfTimeEditing);

        }

        new Thread(logic).start();

        cards.add(card2);
        frame.getContentPane().add(cards);
        back.setVisible(true);
        this.changeToAnotherView();

    }

    public void changeToAnotherView() {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }

    public void addTimeLogicAndClocks(TimersLogic timelogic, ArrayList allClocks) {
        if (this.logic != null) {
            this.logic.activateStopEverything();
            this.cards.remove(card2);

        }
        this.logic = timelogic;
        this.allClocks = allClocks;

    }

    public JFrame getFrame() {
        return frame;
    }

    public void addHourglassLogic(HourglassLogic hourglassL, ArrayList<SimpleTimer> returnList) {
        if (this.logic != null) {
            this.logic.activateStopEverything();
            this.cards.remove(card2);
        }

        this.logic = hourglassL;
        this.allClocks = returnList;
    }

}
