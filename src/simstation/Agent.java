package simstation;

import java.io.Serializable;


public abstract class Agent implements Runnable, Serializable {

    protected String name;
    private int xc;
    private int yc;
    private boolean suspended;
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

    
    private synchronized void checkSuspended() throws InterruptedException {
            while (!stopped && suspended) {
                wait();
                suspended = false;
            }
    }

    public void run() {
        myThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(10);
                checkSuspended();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    
    public synchronized void start() {
        this.myThread = new Thread(this);
        this.myThread.start();
    }

    public synchronized void suspend() {
        this.suspended = true;
    }

    public synchronized void resume() {
        this.suspended = false;
    }

    public synchronized void stop() {
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

    public boolean isSuspended() {
        return this.suspended;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public synchronized void join() throws InterruptedException {

        if (myThread != null)
            myThread.join();

    }

    public int getYc() {
        return this.yc;
    }

    public int getXc() {
        return this.xc;
    }

    public Heading getHeading() {
        return this.heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    public String getName() {
        return this.name;
    }

}
