package plague;

import mvc.AppPanel;
import mvc.View;
import simStation.Agent;
import simStation.Simulation;

import java.awt.*;
import java.util.List;

public class PlagueView extends View {

    public PlagueView(Object model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation sim = (Simulation) model;
        for(Agent a : sim.getAgents())
        {
            if(((PlagueAgent)a).isInfected())
            {
                gc.setColor(Color.RED);
            }
            else
            {
                gc.setColor(Color.BLUE);
            }
            gc.fillOval(a.getXc(), a.getYc(), sim.AGENT_SIZE, sim.AGENT_SIZE);
        }



    }
}
