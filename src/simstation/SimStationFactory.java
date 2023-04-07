package simstation;

import mvc.*;

public class SimStationFactory implements AppFactory {
    public Model makeModel() {
        return new Simulation();
    }

    public View makeView(Model m) {
        return new SimulationView((Simulation) m);
    }

    public String getTitle() {
        return "SimStation";
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Suspend", "Stop", "Resume", "Stats" };
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch(type){
            case "Start":
                return new StartCommand(model);

            case "Stop":
                return new StopCommand(model);
            case "Suspend":
                return new SuspendCommand(model);

            case "Resume":
                return new ResumeCommand(model);

            case "Stats":
                return new StatsCommand(model);

            default:
                return null;

        }
    }


    public String[] getHelp() {
        return new String[] {"Find the way to run it on your own!!!"};
    }

    public String about() {
        return "SimStation by group #2";
    }

}
