package PrisonersDilema;

import mvc.Model;
import simStation.SimStationFactory;

public class PrisonerFactory extends SimStationFactory {

	public Model makeModel() { return new PrisonerSimulation(); }
    public String getTitle() { return "Prisoner's Dilema";}

}
