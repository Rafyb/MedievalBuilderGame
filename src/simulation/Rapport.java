package simulation;

import entite.Parcelle;
import systeme.Partie;

public class Rapport {
	
	public static int rapBesoinNourriture=0;
	public static int rapProdNourriture=0;
	public static int rapProdArgent=0;

	public static void estimer (Parcelle monde[][]) {
		rapBesoinNourriture=Partie.population*Besoin.besoinEnNourriture;
		rapProdNourriture=0;
		rapProdArgent=0;
		
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j].getIcon()!=null) {
					if (monde[i][j].getIcon().equals("Π")) { // mine
						rapProdArgent += monde[i][j].getProduction();						
					}
					if (monde[i][j].getIcon().equals("≋")) { //Champ
						if ( !temp.saison().equals("hiver") ) rapProdNourriture += monde[i][j].getProduction();
					}
					
				}
			}
		}
	}
}
