package entite;

public class Taverne extends Parcelle {
	private static int coutPlacer = 500;

	
	public Taverne() {
		cout = coutPlacer;
		coutPlacer += 200;
		coutSuppr = 100;
		construit = true;
		placeMax = 0;
		icon = "T";
		production = 15;
	}


}