package systeme;

import entite.Parcelle;

public class Amelioration {
	boolean active = false;
	int coutAmelioMaison = 200;
	int coutAmelioMine = 250;
	int coutAmelioChamp = 150;
	
	public void amelioMaison(Parcelle monde[][]) {
		Partie.money =- coutAmelioMaison;
		coutAmelioMaison =+ 100;
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {	
					if (monde[i][j].getIcon().equals("⌂")) {
						monde[i][j].setPlaceMax(monde[i][j].getPlaceMax()+5);				
					}

				}
			}
		}
	}
	
	public void amelioMine(Parcelle monde[][]) {
		Partie.money =- coutAmelioMine;
		coutAmelioMine =+ 150;
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {	
					if (monde[i][j].getIcon().equals("⩄")) {
						monde[i][j].setProduction((monde[i][j].getProduction()+50));						
					}

				}
			}
		}
	}
	
	public void amelioChamp(Parcelle monde[][]) {
		Partie.money =- coutAmelioChamp;
		coutAmelioChamp =+ 100;
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {	
					if (monde[i][j].getIcon().equals("≋")) {
						monde[i][j].setProduction((monde[i][j].getProduction()+30));						
					}

				}
			}
		}
	}

}
