package PrisonersDilema;

import Flocking.FlockingSimulation;
import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;
import simStation.SimStationFactory;

public class PrisonerFactory extends SimStationFactory {

	public Model makeModel() { return new PrisonerSimulation(); }
    public String getTitle() { return "Prisoner's Dilema";}

}
