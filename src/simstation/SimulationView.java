package simstation;
import mvc.*;

import java.awt.*;


public class SimulationView extends View{

    public SimulationView(Model model) {
        super(model);
    }

    public void paintComponent(Graphics gc){
        Simulation simulation = (Simulation) model;
        for(Agent agent : simulation.getAgents())
        {
            gc.setColor(Color.RED);
            gc.fillOval(agent.getXc(), agent.getYc(), simulation.AGENT_SIZE, simulation.AGENT_SIZE);
        }
    }
}