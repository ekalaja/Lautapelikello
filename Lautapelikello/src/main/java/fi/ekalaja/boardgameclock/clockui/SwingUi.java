
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
        frame.setPreferredSize(new Dimension(600,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createAllComponents();
        // käytä frame.getContentPane() allComponents sisällä
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createAllComponents() {
        frame.setLayout(new GridLayout(2,1));
        JPanel panel = new JPanel(new GridLayout(1,0));

        for (int i = 0; i < this.allClocks.size(); i++) {
            ClockNumberFrame ClockFrame = allClocks.get(i).returnClockNumberFrame();
            Font f = new Font("Greek", 1, 30);
            
            ClockFrame.setFont(f);
            ClockFrame.setForeground(Color.GREEN);
//            newClockFrame.set
            ClockFrame.setEnabled(false);
            panel.add(ClockFrame);
        }
//        panel.setFont(new Font("Greek", 1, 30));
        frame.add(panel);
        
        JButton next = new JButton("next");
        frame.add(next);
//        this.addTimeLogic(timelogic);
        PlayersActionListener userListener = new PlayersActionListener(next, timelogic);
        next.addActionListener(userListener);
//        frame.add(new JButton("start"));
        
    }

    
    
//    public void addTimeLogic(TimeLogic timelogic) {
//        this.timelogic = timelogic;
//    }
    
    
    public JFrame getFrame() {
        return frame;
    }
    
    
    
    
}