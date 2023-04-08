package simStation;
//TRUE IF YOU SEE THIS
import mvc.Utilities;
import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    public static int WORLD_SIZE = 250;

    private String name;
    private Integer xc, yc;
    private boolean stopped, suspended;
    protected transient Thread myThread;
    protected Simulation world;
    public Heading heading;


    public Agent() {
        world = null;
        myThread = null;

        xc = Utilities.rng.nextInt(WORLD_SIZE) + 1;
        yc = Utilities.rng.nextInt(WORLD_SIZE) + 1;

        stopped = true;
        suspended = false;
    }

    public void setWorld(Simulation world) {
        this.world = world;
    }

    public synchronized void start() {
        if (stopped) {
            stopped = false;
            myThread = new Thread(this);
            myThread.start();
        }
    }

    public synchronized void stop() {
        suspended = false;
        stopped = true;
        if (myThread != null) {
            myThread.interrupt();
        }
        world.changed();
    }

    public synchronized boolean isStopped() {
        return stopped;
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized boolean isSuspended() {
        return suspended;
    }

    public synchronized void resume() {
        if (myThread == null) {
            if (!stopped) {
                myThread = new Thread(this);
                myThread.start();
            }
        }
        if (suspended) {
            suspended = false;
            notify();
        }
    }

    public void run() {
        myThread = Thread.currentThread();
        while (!stopped) {
            update();
            try {
                Thread.sleep(100);
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                return;
            }
        }
        myThread = null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXc() {
        return xc;
    }

    public synchronized void setXc(int x_Pos) {
        this.xc = x_Pos;
    }

    public synchronized int getYc() {
        return yc;
    }

    public synchronized void setYc(int y_Pos) {
        this.yc = y_Pos;
    }

    public synchronized Heading getHeading() {
        return this.heading;
    }

    public synchronized void setHeading(Heading head) {
        this.heading = head;
    }

    public abstract void update();

    public void move(int steps) {
        int dx = 0;
        int dy = 0;
        switch (this.heading) {
            case NORTH:
                dx = -steps;
                break;
            case SOUTH:
                dx = steps;
                break;
            case EAST:
                dy = steps;
                break;
            case WEST:
                dy = -steps;
                break;
        }
        int newX = (this.xc + dx + WORLD_SIZE) % WORLD_SIZE;
        int newY = (this.yc + dy + WORLD_SIZE) % WORLD_SIZE;
        this.xc = newX;
        this.yc = newY;
        world.changed();
    }

}
