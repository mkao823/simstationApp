package PrisonersDilema;

import mvc.*;
import simStation.*;
import simStation.Heading;

public class Prisoner extends Agent{
	
	private int fit;
	private boolean partnerCheated;
	private int speed = Utilities.rng.nextInt(10) + 1;
	PrisonerStrategy pStrat;
	Strategy st;
	
	public Prisoner(Strategy strat) {
		super();
		fit = 0;
		partnerCheated = false;
		
		if (strat == Strategy.CHEAT) {
			pStrat = new Cheat();
		} else if (strat == Strategy.COOPERATE) {
			pStrat = new Cooperate();
		} else if (strat == Strategy.RANDOM) {
			pStrat = new RandomlyCooperate();
		} else if (strat == Strategy.TIT4TAT){
			pStrat = new Tit4Tat();
		}
		
		st = strat;
	}
	
	public boolean cooperate() {
		if (st == Strategy.TIT4TAT) {
			Tit4Tat t = (Tit4Tat) pStrat;
			return t.cooperate(partnerCheated);
		}
		
		 return pStrat.cooperate();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		Agent n = world.getNeighbor(this, 10);
		Prisoner p = (Prisoner)n;
		// both cooperate
		if (p != null) {
			if (p.cooperate() && this.cooperate()) {
				setFit(3);
				partnerCheated = false;
				//p.setFit(3);
			// you cheat
			} else if (p.cooperate() && !this.cooperate()) {
				setFit(5);
				partnerCheated = false;
				//p.setFit(0);
			}
			// both cheat
			else if (!p.cooperate() && !this.cooperate()) {
				setFit(1);
				partnerCheated = true;
				//p.setFit(0);
			}
			// partner cheats
			else {
				setFit(0);
				partnerCheated = true;
				//p.setFit(5);
			}
		}
		
		heading = Heading.random();
		int steps = speed;
        move(steps);
	}
	
	public int getFit() {
		return fit;
	}
	
	public void setFit(int f) {
		fit = f;
	}
	
	public Strategy getStrategy() {
		return st;
	}

}
