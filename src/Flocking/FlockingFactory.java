package Flocking;

import mvc.Model;
import simStation.SimStationFactory;

public class FlockingFactory extends SimStationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking";}
}
