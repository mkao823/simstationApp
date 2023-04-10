package simStation;

import mvc.Model;
import mvc.Utilities;

import java.util.*;


public class Simulation extends Model {

    public static int AGENT_SIZE = 5;

    private transient Timer timer;
    int clock;
    protected List<Agent> agents;
    public Simulation() {
        clock = 0;
        agents = new LinkedList<Agent>();
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 10, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public int getClock() {
        return clock;
    }


    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            changed();
        }
    }


    public void start() {
        clock = 0;
                if(agents.size() != 0) {
            if(timer != null) {
                stopTimer();
            }
            for (Agent a : agents)
                a.stop();
                agents = new ArrayList<Agent>();
        }
        populate();
        startTimer();
        for( Agent a : agents ) {
            a.start();
        }
    }
    public void suspend() {
        if (timer != null) stopTimer();

        for( Agent a : agents ) {
            a.suspend();
        }
    }
    public void resume() {
        if (timer == null)
        {
            startTimer();
        }
        for(Agent a : agents) {
            a.resume();
        }
    }
    public void stop() {
        if (timer != null) stopTimer();
        for(Agent a : agents) {
            a.stop();
            try {
                a.myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stats() {
        Utilities.inform("#agents = " + getAgents().size() + "\nclock = " + getClock());
    }

    public Agent getNeighbor(Agent a1, int range) {
        ArrayList<Agent> inRange = new ArrayList<Agent>();
        for (int i = 0; i < agents.size(); i++) {
            Agent a2 = agents.get(i);
            double newDist = Math.sqrt(Math.pow(a1.getXc() - a2.getXc(), 2) + Math.pow(a1.getYc() - a2.getYc(), 2));
            if (newDist < range) {
                inRange.add(a2);
            }
        }
        if (inRange.isEmpty()) {
            return agents.get((int) (Math.random() * agents.size()));
        } else {
            int index = (int) (Math.random() * inRange.size());
            while (inRange.get(index) == a1) {
                index = (int) (Math.random() * inRange.size());
            }
            return inRange.get(index);
        }
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void addAgent(Agent a){
        this.agents.add(a);
        a.setWorld(this);
    }
    public void populate() {
    }



}

