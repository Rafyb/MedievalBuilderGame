package entite;

public class Mine extends Parcelle {
	final int production =200;
	final int placeMax = 3;
	static int coutPlace = 200;
	int coutSuppr = 30;
	
	public Mine () {
		coutPlace = coutPlace + 20;
	}

}
