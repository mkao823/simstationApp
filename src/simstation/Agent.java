package simstation;

import java.io.Serializable;


public abstract class Agent implements Runnable, Serializable {

    protected String name;
    private int xc;
    private int yc;
    private boolean suspend;
    protected Heading heading;
    protected boolean stopped;
    protected Thread myThread;
    protected Simulation world;


    public Agent(String name, int xc, int yc, Heading heading, Simulation world) {
        this.name = name;
        this.xc = xc;
        this.yc = yc;
        this.heading = heading;
        this.world = world;
    }
    
    public void run() {
        while (!this.stopped) {
            try{
                if(this.suspend){
                    Thread.sleep(20);
                    continue;
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            update();
        }
    }
    
    public void start() {
        this.myThread = new Thread(this);
        this.myThread.start();
    }
    
    public void suspend() {
        this.suspend = true;
    }
    
    public void resume() {
        this.suspend = false;
    }
    
    public void stop() {
        this.stopped = true;
    }
    
    public abstract void update();

    // ensure race condition wont happen
    public synchronized void move(int steps) {

        switch (this.heading) {
            case NORTH:
                this.xc -= steps; 
                if (this.xc < 0) 
                    this.xc += 250; 
                break;

            case SOUTH:
                this.xc += steps;
                if (this.xc > 250)
                    this.xc -= 250;
                break;

            case EAST:
                this.yc += steps;
                if (this.yc > 250)
                    this.yc -= 250;
                break;

            case WEST:
                this.yc -= steps;
                if (this.yc < 0)
                    this.yc += 250;
                break;
        }
        world.changed();
    }

}
