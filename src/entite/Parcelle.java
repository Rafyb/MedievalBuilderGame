package entite;

public class Parcelle {
	protected int cout = 0;
	protected int production = 0;
	protected int placeMax = 0;
	protected int coutSuppr = 0;
	protected boolean construit = false;
	protected String icon= ".";
	
	public int recolte() {
		return production;
	}

	public int getCoutPlace() {
		return cout;
	}

	public void setCoutPlace(int coutPlace) {
		this.cout = coutPlace;
	}

	public int getProduction() {
		return production;
	}

	public void setProduction(int production) {
		this.production = production;
	}

	public int getPlaceMax() {
		return placeMax;
	}

	public void setPlaceMax(int placeMax) {
		this.placeMax = placeMax;
	}

	public int getCoutSuppr() {
		return coutSuppr;
	}

	public void setCoutSuppr(int coutSuppr) {
		this.coutSuppr = coutSuppr;
	}

	public boolean estConstruit() {
		return construit;
	}

	public void setConstruit(boolean construit) {
		this.construit = construit;
	}
	
	public String getIcon() {
		return icon;
	}
}