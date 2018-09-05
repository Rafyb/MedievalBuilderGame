package entite;

public class Forgeron extends Parcelle {
	private int coutPlacer = 800;
	private final int coutSuppr = 300;
	private final int placeMax = 0;
	private final int production = 0;
	
	public Forgeron() {
		construit = true;
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
	
	public boolean getConstruit() {
		return construit;
	}
	
	public String getIcon() {
		return "F";
	}
}