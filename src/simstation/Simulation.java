package simstation;

import java.util.*;
import mvc.*;

public class Simulation extends Model {

    private Timer timer;
    private int clock;
    protected List<Agent> agents;

    public Simulation() {
        clock = 0;
        agents = new LinkedList<Agent>();
    }


    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            changed();
        }
    }

    public int getClock() {
        return clock;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    // should it stop all the other agents if there are some agents running, then just begin a new set of agents
    // or not????
    public synchronized void start() {
        
        clock = 0;

        // stop all agents
        if (this.agents.size() != 0) {
            for (Agent agent : agents) {
                agent.stop();
            }
            this.agents = new ArrayList<Agent>();
            if (timer != null) {
                stopTimer();
            }

        }
    }
    
    public synchronized void suspend() {
        
        // empty
    }
    public synchronized void resume() {
        
        // empty
    }

    public synchronized void stop() {
        // empty

    }

    public void stats() {
        // empty

    }

    public Agent getNeighbor(Agent a, double radius) {
        return a;
    }

    public void populate() {}
    


}