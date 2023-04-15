package PrisonersDilema;

import java.util.Random;

public class RandomlyCooperate extends PrisonerStrategy{

	private Random r;
	
	public RandomlyCooperate() {
		super();
		r = new Random();
	}
	
	@Override
	public boolean cooperate() {
		// TODO Auto-generated method stub
		double randInt = r.nextDouble();
		if (randInt < 0.5) {
			return true;
		}
		return false;
	}

}
