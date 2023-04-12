package Flocking;

import mvc.Utilities;
import simStation.Agent;
import simStation.Heading;
public class Bird extends Agent{
    private int speed;
    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public void update() {
        //heading = Heading.random();
        Agent neighbor = world.getNeighbor(this, 10);
        Bird birdNeighbor = (Bird)neighbor;
        if(birdNeighbor != null){
            this.setSpeed(birdNeighbor.getSpeed());
            this.setHeading(birdNeighbor.getHeading());
        }
        int steps = speed;
        move(steps);
    }
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed) {this.speed = speed;}
    public Heading getHeading(){
        return this.heading;
    }
    public void setHeading(Heading heading){this.heading = heading;}
}
