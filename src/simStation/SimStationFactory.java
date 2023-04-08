package simStation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class SimStationFactory implements AppFactory 
{
	public Model makeModel() { return new Simulation(); }
	
	public View makeView(Model m) 
	{
		return new SimulationView( (Simulation) m);
	}

	public String getTitle()
	{
		return "SimStation";
	}

	public String[] getEditCommands()
	{
		return new String[] {"Start", "Suspend", "Stop", "Resume", "Stats"};
	}
	
	public Command makeEditCommand(Model model, String type, Object source)
	{
		switch(type){
			case "Start":
				return new StartCommand(model);
			case "Stats":
				return new StatsCommand(model);
			case "Suspend":
				return new SuspendCommand(model);
			case "Stop":
				return new StopCommand(model);
			case "Resume":
				return new ResumeCommand(model);
		}
		return null;
	}
	
	public String[] getHelp()
	{
		return new String[] {" \"Start\" begins the simulation"
				+ "\n \"Suspend\" to pause " +
				" \n \"Resume\" will continue "
				+ "\n  \"Stop\" the end the simulation"};
	}

	public String about()
	{
		return "SimStation Project by Team #2";
	}
}
