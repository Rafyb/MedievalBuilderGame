package systeme;

import entite.Parcelle;

public class Amelioration {
	boolean active = false;
	
	public void amelioMaison(Parcelle monde[][]) {
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {	
					if (monde[i][j].getIcon().equals("H")) {
						monde[i][j].setPlaceMax(monde[i][j].getPlaceMax()+5);				
					}

				}
			}
		}
	}
	
	public void amelioMine(Parcelle monde[][]) {
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {	
					if (monde[i][j].getIcon().equals("M")) {
						monde[i][j].setProduction((monde[i][j].getProduction()+50));						
					}

				}
			}
		}
	}
	
	public void amelioChamp(Parcelle monde[][]) {
		for (int i = 0 ; i<monde.length ; i++) {
			for (int j = 0 ; j<monde[i].length ; j++) {
				if (monde[i][j]!=null) {	
					if (monde[i][j].getIcon().equals("C")) {
						monde[i][j].setProduction((monde[i][j].getProduction()+30));						
					}

				}
			}
		}
	}

}
