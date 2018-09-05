package entite;

public class Forgeron extends Parcelle {
	private int coutPlacer = 500;
	private int coutSuppr = 100;
	private final int placeMax = 5;
	private final int production = 0;
	
	public Forgeron() {
		coutPlacer += 50;
		coutSuppr = 100;
	}
	
	public void Forger() {
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
