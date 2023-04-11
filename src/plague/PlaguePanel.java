package plague;

import simStation.SimulationPanel;


public class PlaguePanel extends SimulationPanel{
    public PlaguePanel(PlagueFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        PlaguePanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}
