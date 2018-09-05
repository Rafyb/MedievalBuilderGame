package entite;

public class Maison extends Parcelle {
	final int production =0;
	final int placeMax = 10;
	static int coutPlace = 300;
	int coutSuppr = 50;
	
	public Maison () {
		coutPlace = coutPlace + 50;
	}
}
