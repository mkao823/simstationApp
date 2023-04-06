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
        if (timer != null) {
            stopTimer();
        }
        for (Agent agent : this.agents) {
            agent.suspend();
        }
    }
    public synchronized void resume() {
        
        if (timer != null) {
            startTimer();
            for (Agent agent : agents) {
                agent.resume();
            }
        }
    }

    public synchronized void stop() {
        
        if (timer != null) {
            stopTimer();

            for (Agent agent : agents) {
                agent.stop();
            }
        }
        agents = new LinkedList<Agent>();
        changed();

    }

    public void stats() {
        Utilities.inform("#agents = " + agents.size()+ "\nclock = " + getClock());

    }

    public Agent getNeighbor(Agent a, double radius) {
        return a;
    }

    public void populate() {}
    


}