package Flocking;

import mvc.AppPanel;
import mvc.Utilities;
import simStation.Heading;
import simStation.Simulation;
import simStation.SimulationPanel;
import simStation.Agent;

import java.util.ArrayList;

public class FlockingSimulation extends Simulation{
    public void populate() {
        for(int i = 0; i < 30; i++) {
            Bird bird = new Bird();
            this.addAgent(bird);
        }
    }
    public void stats(){
        int speed1 = 0;
        int speed2 = 0;
        int speed3 = 0;
        int speed4 = 0;
        int speed5 = 0;
        for(Agent a: agents){
            if(((Bird)a).getSpeed() == 1){
                speed1++;
            }
            else if(((Bird)a).getSpeed() == 2){
                speed2++;
            }
            else if(((Bird)a).getSpeed() == 2){
                speed2++;
            }
            else if(((Bird)a).getSpeed() == 3){
                speed3++;
            }
            else if(((Bird)a).getSpeed() == 4){
                speed4++;
            }
            else if(((Bird)a).getSpeed() == 5){
                speed5++;
            }
        }
        String report = "#birds at speed 1 = " + speed1 +
                "\n#birds at speed 2 = " + speed2 +
                "\n#birds at speed 3 = " + speed3 +
                "\n#birds at speed 4 = " + speed4 +
                "\n#birds at speed 5 = " + speed5;
        Utilities.inform(report);
    }
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
