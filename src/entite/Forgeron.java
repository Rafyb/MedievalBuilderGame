package entite;

public class Forgeron extends Parcelle {
	static int coutPlace = 800;
	
	public Forgeron() {
		cout = coutPlace;
		coutPlace += 300;
		construit = true;
		icon = "F";
	}
	
	public void Forger() {
		
	}
}