package entite;

public class Parcelle {
	public int cout = 0;
	public int production = 0;
	public int placeMax = 0;
	public int coutSuppr = 0;
	public boolean construit = false;
	
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
		return " ";
	}
	
	
}
