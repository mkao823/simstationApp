package simStation;

import mvc.AppPanel;
import mvc.View;

import java.awt.*;
import java.util.List;

public class SimulationView extends View {

    public SimulationView(Object model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation sim = (Simulation) model;
        List<Agent> agents = sim.getAgents();

        Graphics2D g2d = (Graphics2D) gc;
        int currentDisplayHeight = this.getHeight();
        int currentDisplayWidth = this.getWidth();
        double widthScale  = currentDisplayWidth  / (double) AppPanel.FRAME_WIDTH;
        double heightScale = currentDisplayHeight / (double) AppPanel.FRAME_HEIGHT;
        // Background
        g2d.setColor(new Color(50, 50, 50));
        g2d.fillRect(
                0,
                0,
                currentDisplayWidth,
                currentDisplayHeight);
        g2d.setColor(new Color(50, 200, 100));  //
        for (Agent a : agents) {


            gc.setColor(Color.RED);
            gc.fillOval(a.getXc(), a.getYc(), sim.AGENT_SIZE, sim.AGENT_SIZE);
        }
    }
}
