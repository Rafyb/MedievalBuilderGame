package entite;

public class Maison extends Parcelle {
	static int coutPlace = 300;
	int coutSuppr = 50;
	
	public Maison () {
		placeMax = 10;
		coutPlace += 20;
		coutSuppr = 50;
		construit = true;
		icon = "H";
	}
}
