package RandomWalk;

import mvc.Model;
import simStation.SimStationFactory;

class RandomWalkFactory extends SimStationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}