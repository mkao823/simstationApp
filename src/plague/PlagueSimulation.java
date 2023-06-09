package plague;

import mvc.Utilities;
import simStation.Agent;
import simStation.Simulation;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 10;  // % chance of infection (range)
    public static int RESISTANCE = 90; // % chance of resisting infection
    public static int INITIAL_POPULATION = 90;
    public static int INITIAL_INFECTED = 4;
    public void populate() {
        int count_infected = INITIAL_INFECTED;
        for( int x=0; x<INITIAL_POPULATION; x++ ) {
            addAgent( new PlagueAgent(count_infected>0));
            count_infected--;
        }
    }

    public void stats() {
        int infected=0;
        for(Agent a: agents) {
            if(((PlagueAgent)a).isInfected())
                infected++;
        }
        String report="#agents = " + agents.size()
            + "\nclock = " + getClock()
            + "\n% infected = " + (infected/(float)agents.size())*100;
        Utilities.inform(report);
    }
}
