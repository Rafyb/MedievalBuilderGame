package entite;

public class Champ extends Parcelle {
	final int placeMax = 5;
	static int coutPlace = 200;
	int coutSuppr = 30;
	
	public Champ () {
	    	production = 50;
	    	cout = coutPlace;
		coutPlace = coutPlace + 10;
		construit = true;
	}
	
	public String getIcon() {
		return "C";
	}

}
