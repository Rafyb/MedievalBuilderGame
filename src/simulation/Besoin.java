package simulation;

import entite.*;
import systeme.Partie;

public class Besoin {
	
	public static final int besoinEnNourriture = 3;
	
	public static int totalBesoinEnNourriture = 0;

	
	public static void actualiser (Parcelle monde[][]) {
	    	Partie.maxPop=0;
		//lire les production
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j].getIcon()!=null) {
					if (monde[i][j].getIcon().equals("M")) {
						Partie.money += monde[i][j].getProduction();						
					}
					if (monde[i][j].getIcon().equals("C")) {
						Partie.food += monde[i][j].getProduction();
					}
					
					if (monde[i][j].getIcon().equals("H")) {
						Partie.maxPop += monde[i][j].getPlaceMax();						
					}
					if (monde[i][j].getIcon().equals("T")) {
						Partie.happyness += monde[i][j].getPlaceMax();						
					}
				}
			}
		}
		//deduire les besoins
		totalBesoinEnNourriture = Partie.population*besoinEnNourriture;
		Partie.food -= totalBesoinEnNourriture;
		
		
		Partie.reproduction();
		satisfactionBonheur();
	}
	
	private static double satisfactionNourriture () {
		return Partie.food / totalBesoinEnNourriture;
		
	}
	
	public static void satisfactionBonheur() {
		if ( satisfactionNourriture()>1) Partie.happyness += 10;
		Partie.happyness -= Math.max( 0 , (Partie.population-Partie.maxPop));
		
	}
	
	

}
