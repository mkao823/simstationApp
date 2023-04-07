package simstation;

import mvc.Command;
import mvc.Model;

public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);

    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (Simulation) model;
        sim.stats();
    }

}
