package plague;

import mvc.Utilities;
import simStation.Agent;
import simStation.Heading;

public class PlagueAgent extends Agent {
    boolean infected;
    PlagueAgent(boolean infected) {
        super();
        this.infected = infected;
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
        infect();

    }

    public void infect()
    {
        PlagueAgent neighbor = (PlagueAgent)(world.getNeighbor(this, 10));

        if(this.isInfected() && neighbor != null ) {
            int infectedChance = (int) (Math.random() * 100) + 1;
            int resistanceChance = PlagueSimulation.VIRULENCE * (100 - PlagueSimulation.RESISTANCE) / 100;
            if(infectedChance <= resistanceChance) {
                neighbor.setInfected(true);
            }
        }
    }
    public boolean isInfected(){
        return infected;
    }
    private void setInfected(boolean flag) {
            infected = true;
    }
}
