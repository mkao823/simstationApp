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
        //heading = Heading.random();
        Agent neighbor = world.getNeighbor(this, 10);
        Bird birdNeighbor = (Bird)neighbor;
        this.speed = birdNeighbor.getSpeed();
        this.heading = birdNeighbor.getHeading();
        //int steps = Utilities.rng.nextInt(10) + 1;
        int steps = speed;
        move(steps);
    }
    public int getSpeed(){
        return this.speed;
    }
    public Heading getHeading(){
        return this.heading;
    }
}
