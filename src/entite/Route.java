package entite;

public class Route extends Parcelle {
	public int coutPlace = 10;
	public int coutSuppr = 5;
	
	public Route() {
		construit = true;
	}
	
	public String getIcon() {
		return "■";
	}
}
