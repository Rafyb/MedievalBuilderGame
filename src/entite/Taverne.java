package entite;

public class Taverne extends Parcelle {
	private static int coutPlacer = 600;

	
	public Taverne() {
		cout = coutPlacer;
		//coutPlacer += 200;
		coutSuppr = 100;
		construit = true;
		placeMax = 0;
		icon = "☕";
		production = 15;
	}


}