package simulation;

import entite.*;
import systeme.Amelioration;
import systeme.Partie;

public class Besoin {
	
	public static final int besoinEnNourriture = 3;
	
	public static int totalBesoinEnNourriture = 0;

	
	public static void actualiser (Parcelle monde[][]) {
	    	Partie.maxPop=5;
	    	boolean sswitch = false;
		//lire les production
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j].getIcon()!=null) {
					if (monde[i][j].getIcon().equals("Π")) { // mine
						Partie.money += monde[i][j].getProduction();						
					}
					if (monde[i][j].getIcon().equals("≋")) { //Champ
						if ( !Temp.saison().equals("hiver") ) Partie.food += monde[i][j].getProduction();
					}
					
					if (monde[i][j].getIcon().equals("⌂")) { // maison
						Partie.maxPop += monde[i][j].getPlaceMax();						
					}
					if (monde[i][j].getIcon().equals("T")) { //Taverne
						Partie.happyness += monde[i][j].getPlaceMax();						
					}
					if (monde[i][j].getIcon().equals("×")) { //Forgeron

						Amelioration.active =true;	
						sswitch = true;
					} 
					if(!sswitch) {
						Amelioration.active =false;
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
		if ( Partie.happyness<=90 && satisfactionNourriture()>1) Partie.happyness += 10;
		if ( Partie.happyness>90 && Partie.happyness<100 && satisfactionNourriture()>1) Partie.happyness=100;
		Partie.happyness -= Math.max( 0 , (Partie.population-Partie.maxPop));
		
	}
	
	

}
