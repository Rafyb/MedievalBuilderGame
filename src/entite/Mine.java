package entite;

public class Mine extends Parcelle {
	static int coutPlace = 200;
	
	public Mine () {
		placeMax = 3;
		production = 150;
		cout = coutPlace;
		coutPlace += 10;
		coutSuppr = 30;
		construit = true;
		icon = "Ʌ";
	}
}
