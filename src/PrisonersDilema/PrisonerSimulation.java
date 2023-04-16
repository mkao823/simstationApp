package PrisonersDilema;

import mvc.AppPanel;
import mvc.Utilities;
import simStation.Simulation;
import simStation.SimulationPanel;
import simStation.Agent;

import java.text.DecimalFormat;


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

//    public void stats() {
//        int cheat = 0;
//        int cooperate = 0;
//        int random = 0;
//        int tit4tat = 0;
//
//        for (Agent a : agents) {
//            Prisoner p = (Prisoner) a;
//            if (p.getStrategy() == Strategy.CHEAT) {
//                cheat += p.getFit();
//            }
//            if (p.getStrategy() == Strategy.COOPERATE) {
//                cooperate += p.getFit();
//            }
//            if (p.getStrategy() == Strategy.RANDOM) {
//                random += p.getFit();
//            }
//            if (p.getStrategy() == Strategy.TIT4TAT) {
//                tit4tat += p.getFit();
//            }
//
//        }
//        String report = "avg fitness of cheat = " + cheat / 10.0 +
//                "\navg fitness of cooperate = " + cooperate / 10.0 +
//                "\navg fitness of random = " + random / 10.0 +
//                "\navg fitness of tit4tat = " + tit4tat / 10.0;
//        Utilities.inform(report);
//    }
public void stats()					//to get a String of the prisoner stats
{
    System.out.println("Trigger");
    String statsString = "";
    double average1 = 0, average2 = 0, average3 = 0, average4 = 0;
    double strategy1Prisoners = 0, strategy2Prisoners = 0, strategy3Prisoners = 0, strategy4Prisoners = 0;
    DecimalFormat df2 = new DecimalFormat("#.##");						//better formatting

    for(Agent a: agents)
    {
        Prisoner prisoner = (Prisoner)a;
        if(prisoner.getStrategy() == Strategy.CHEAT)		//uses equals method to compare the strategy objects
        {
            strategy1Prisoners += 1;
            average1 += prisoner.getFit();
        }
        else if(prisoner.getStrategy() == Strategy.COOPERATE)
        {
            strategy2Prisoners += 1;
            average2 += prisoner.getFit();
        }
        else if(prisoner.getStrategy() == Strategy.RANDOM)
        {
            strategy3Prisoners += 1;
            average3 += prisoner.getFit();
        }
        else if(prisoner.getStrategy() == Strategy.TIT4TAT)
        {
            strategy4Prisoners += 1;
            average4 += prisoner.getFit();
        }
    }

    average1 /= strategy1Prisoners;
    average2 /= strategy2Prisoners;
    average3 /= strategy3Prisoners;
    average4 /= strategy4Prisoners;

    System.out.println(strategy1Prisoners);

    statsString = "Always Cheat Average Fitness: " + df2.format(average1) +
            "\nAlways Cooperate Average Fitness: " + df2.format(average2) +
            "\nRandomly Cooperate Average Fitness: " + df2.format(average3) +
            "\nPrevious Opponent Strategy Average: " + df2.format(average4);
    Utilities.inform(statsString);
}
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }
}
