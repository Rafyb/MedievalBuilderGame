package entite;

public class Champ extends Parcelle {
	static int coutPlace = 200;
	
	public Champ () {
		placeMax = 5;
	    production = 25;
	    cout = coutPlace;
		//coutPlace += 10;
		coutSuppr = 30;
		construit = true;
		icon = "≋";
	}
}
