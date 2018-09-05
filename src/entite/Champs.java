package entite;

public class Champs extends Parcelle {
	final int production =50;
	final int placeMax = 5;
	static int coutPlace = 200;
	int coutSuppr = 30;
	
	public Champs () {
		coutPlace = coutPlace + 10;
		construit = true;
	}


}
