package PrisonersDilema;

import mvc.AppPanel;
import mvc.Utilities;
import simStation.Heading;
import simStation.Simulation;
import simStation.SimulationPanel;
import simStation.Agent;

import java.util.ArrayList;

public class PrisonerSimulation extends Simulation{
    public void populate() {
        for(int i = 0; i < 10; i++) {
            Prisoner prisoner = new Prisoner(Strategy.CHEAT);
            this.addAgent(prisoner);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner prisoner = new Prisoner(Strategy.COOPERATE);
            this.addAgent(prisoner);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner prisoner = new Prisoner(Strategy.RANDOM);
            this.addAgent(prisoner);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner prisoner = new Prisoner(Strategy.TIT4TAT);
            this.addAgent(prisoner);
        }
    }
    public void stats(){
        int cheat = 0;
        int cooperate = 0;
        int random = 0;
        int tit4tat = 0;
        
        for(Agent a: agents){
        	Prisoner p = (Prisoner)a;
            if(p.getStrategy() == Strategy.CHEAT){
            	cheat += p.getFit();
            }
            if(p.getStrategy() == Strategy.COOPERATE){
            	cooperate += p.getFit();
            }
            if(p.getStrategy() == Strategy.RANDOM){
            	random += p.getFit();
            }
            if(p.getStrategy() == Strategy.TIT4TAT){
            	tit4tat += p.getFit();
            }
            
        }
        String report = "avg fitness of cheat = " + cheat/10.0 +
        		"\navg fitness of cooperate = " + cooperate/10.0 +
                "\navg fitness of random = " + random/10.0 +
                "\navg fitness of tit4tat = " + tit4tat/10.0;
        Utilities.inform(report);
    }
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }
}
