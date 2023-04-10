package Flocking;

import mvc.Utilities;
import simStation.Agent;
import simStation.Heading;
public class Bird extends Agent{
    private int speed;
    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(10) + 1;
    }

    public void update() {
        heading = Heading.random();
        speed =
        //int steps = Utilities.rng.nextInt(10) + 1;
        int steps = speed;
        move(steps);
    }
}
