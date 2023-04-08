package RandomWalk;

import mvc.AppPanel;
import simStation.Simulation;
import simStation.SimulationPanel;

public class RandomWalkSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 15; i++)
            this.addAgent(new Drunk());
    }



    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }

}