package simulation;

import entite.Parcelle;

public class Besoin {
	
	public static final int besoinEnNourriture = 3;
	
	public static int stockNourriture = 0;
	public static int totalBesoinEnNourriture = 0;
	public static int argent = 0;
	public static int population = 0;
	public static int populationMax = 0;
	
	public static void actualiser (Parcelle monde[][]) {
		//lire les production
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {
					if (monde[i][j].getClass().getName()=="Mine") {
						argent += monde[i][j].getProduction();						
					}
					if (monde[i][j].getClass().getName()=="Champs") {
						stockNourriture += monde[i][j].getProduction();						
					}
					
					if (monde[i][j].getClass().getName()=="Maison") {
						populationMax += monde[i][j].getPlaceMax();						
					}					
				}
			}
		}
		//deduire les besoins
		totalBesoinEnNourriture = population*besoinEnNourriture;
		stockNourriture -= totalBesoinEnNourriture;
	}
	
	public static double satisfactionNourriture () {
		return Math.min( stockNourriture / totalBesoinEnNourriture , 100);
	}
	
	

}
