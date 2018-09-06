package simulation;

import entite.Parcelle;
import systeme.Partie;

public class prevision {
	
	public static int prevBesoinNourriture=0;
	public static int prevProdNourriture=0;

	public static void estimer (Parcelle monde[][]) {
		
		


		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j].getIcon()!=null) {
					if (monde[i][j].getIcon().equals("⩄")) { // mine
						Partie.money += monde[i][j].getProduction();						
					}
					if (monde[i][j].getIcon().equals("≋")) { //Champ
						if ( !temp.saison().equals("hiver") ) Partie.food += monde[i][j].getProduction();
					}
				}
			}
		}
	}
}
