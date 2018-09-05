package systeme;

import entite.*;
import monde.Plateau;

public class TestPlacerBatiment {

	public static void main(String[] args) {
		Plateau carte = new Plateau();
		Parcelle m1 = new Maison();
		Parcelle c1 = new Champ();
		Parcelle c2 = new Champ();
		
		
		
		carte.placer_batiment(1,2,new Taverne());
		carte.placer_batiment(8,3,new Mine());
		carte.placer_batiment(15,9,new Route());
		carte.placer_batiment(15,10,new Route());
		carte.placer_batiment(1,4,new Maison());
		carte.placer_batiment(4,5,new Maison());
		carte.placer_batiment(1,1,m1);
		carte.placer_batiment(8,9,c1);
		carte.placer_batiment(8,10,c2);
		
		carte.afficherPlateau();
		
	}

}
