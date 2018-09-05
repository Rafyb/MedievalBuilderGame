package entite;

public class Champ extends Parcelle {
	final int production =50;
	final int placeMax = 5;
	static int coutPlace = 200;
	int coutSuppr = 30;
	
	public Champ () {
		coutPlace = coutPlace + 10;
		construit = true;
	}
	
	public String getIcon() {
		return "C";
	}


}
