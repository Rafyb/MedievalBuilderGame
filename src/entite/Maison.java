package entite;

public class Maison extends Parcelle {
	static int coutPlace = 300;
	
	public Maison () {
		placeMax = 10;
		cout = coutPlace;
		coutPlace += 20;
		coutSuppr = 50;
		construit = true;
		icon = "🏘";
	}
}
