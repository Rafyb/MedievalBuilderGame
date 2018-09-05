package entite;

public class Taverne extends Parcelle {
	private int coutPlacer = 500;
	private int coutSuppr = 100;
	private final int placeMax = 5;
	private final int production = 10;
	
	public Taverne() {
		coutPlacer += 50;
	}

	public int getCoutPlacer() {
		return coutPlacer;
	}

	public int getCoutSuppr() {
		return coutSuppr;
	}

	public int getPlaceMax() {
		return placeMax;
	}

	public int getProduction() {
		return production;
	}
}