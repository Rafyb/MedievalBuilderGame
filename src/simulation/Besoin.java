package simulation;

import entite.Parcelle;
import systeme.Partie;

public class Besoin {
	
	public static final int besoinEnNourriture = 3;
	
	public static int totalBesoinEnNourriture = 0;

	
	public static void actualiser (Parcelle monde[][]) {
		//lire les production
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {
					if (monde[i][j].getClass().getName()=="Mine") {
						Partie.money += monde[i][j].getProduction();						
					}
					if (monde[i][j].getClass().getName()=="Champs") {
						Partie.food += monde[i][j].getProduction();						
					}
					
					if (monde[i][j].getClass().getName()=="Maison") {
						Partie.population += monde[i][j].getPlaceMax();						
					}					
				}
			}
		}
		//deduire les besoins
		totalBesoinEnNourriture = Partie.population*besoinEnNourriture;
		Partie.food -= totalBesoinEnNourriture;
		
	}
	
	private static double satisfactionNourriture () {
		return Math.min( Partie.food / totalBesoinEnNourriture , 100);
	}
	
	public static double satisfactionBonheur() {
		return satisfactionNourriture();
	
		
	}
	
	

}
