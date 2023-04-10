package RandomWalk;

import mvc.Utilities;
import simStation.Agent;
import simStation.Heading;

public class Drunk extends Agent {

    public Drunk() {
        super();
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}





