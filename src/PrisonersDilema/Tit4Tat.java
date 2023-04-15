package PrisonersDilema;

public class Tit4Tat extends PrisonerStrategy{

	private boolean partnerCheated;
	
	
	public boolean cooperate(boolean partnerCheated) {
		// TODO Auto-generated method stub
		if (partnerCheated) {
			return false;
		}
		return true;
	}


	@Override
	public boolean cooperate() {
		// TODO Auto-generated method stub
		return false;
	}

}
