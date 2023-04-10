package Flocking;

import mvc.AppPanel;
import simStation.Heading;
import simStation.Simulation;
import simStation.SimulationPanel;
import simStation.Agent;

import java.util.ArrayList;

public class FlockingSimulation extends Simulation{
    public void populate() {
        for(int i = 0; i < 15; i++) {
            Bird bird = new Bird();
            //Agent neighbor = getNeighbor(bird, 10);
            //getStats(neighbor);
            this.addAgent(bird);
        }
    }
    /*public String getStats(Agent agent){
        Heading heading = getHeading(agent);
        return "hello";
    }*/
    @Override
    public Agent getNeighbor(Agent a1, int range){
        ArrayList<Agent> inRange = new ArrayList<Agent>();
        for (int i = 0; i < agents.size(); i++) {
            Agent a2 = agents.get(i);
            double newDist = Math.sqrt(Math.pow(a1.getXc() - a2.getXc(), 2) + Math.pow(a1.getYc() - a2.getYc(), 2));
            if (newDist < range) {
                inRange.add(a2);
            }
        }
        if (inRange.isEmpty()) {
            return agents.get((int) (Math.random() * agents.size()));
        } else {
            int index = (int) (Math.random() * inRange.size());
            while (inRange.get(index) == a1) {
                index = (int) (Math.random() * inRange.size());
            }
            return inRange.get(index);
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
