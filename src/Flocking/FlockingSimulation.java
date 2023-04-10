package Flocking;

import mvc.AppPanel;
import simStation.Simulation;
import simStation.SimulationPanel;
import simStation.Agent;

public class FlockingSimulation extends Simulation{
    public void populate() {
        for(int i = 0; i < 15; i++) {
            Bird bird = new Bird();
            Agent neighbor = getNeighbor(bird, 10);
            this.addAgent(bird);
        }
    }
    public String getStats(){
        //Agent neighbor = getNeighbor(, 10);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
