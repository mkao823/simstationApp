package simStation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;


public class SimulationPanel extends AppPanel {
    public SimulationPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new GridLayout(0, 1));

        controlPanel.setBackground(Color.LIGHT_GRAY);
        view.setBackground(Color.LIGHT_GRAY);

        JButton start = new JButton("Start");
        start.addActionListener(this);
        controlPanel.add(start);

        JButton suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        controlPanel.add(suspend);

        JButton resume = new JButton("Resume");
        resume.addActionListener(this);
        controlPanel.add(resume);

        JButton stop = new JButton("Stop");
        stop.addActionListener(this);
        controlPanel.add(stop);

        JButton stats = new JButton("Stats");
        stats.addActionListener(this);
        controlPanel.add(stats);
    }

    public static void main(String[] args) {
        AppFactory factory = new SimStationFactory();
        AppPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}