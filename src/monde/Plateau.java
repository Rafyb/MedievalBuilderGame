package monde;

import java.util.Random;

import entite.Montagne;
import entite.Parcelle;
import systeme.Partie;

public class Plateau {
	final static private int longueur = 36;
	final static private int hauteur = 20;
	final private char vide = '.';
	final static public Parcelle [][] plateau = new Parcelle [longueur][hauteur];

	public Plateau () {
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if (randomMoutain()) {
					plateau[i][j] = new Montagne();
				} else {
					plateau[i][j] = new Parcelle();
				}
			}
		}
	}
	
	public static Parcelle [][] getPlateau(){
		return plateau;
	}
	
	public static int getLongueur() {
		return longueur;
	}
	public static int getHauteur() {
		return hauteur;
	}

	public String toString() {
		String affichage = "";

		affichage +="   0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z \n";
		for (int i = 0; i < hauteur ; i++) {
			if(i>=10) {
				affichage += i + " ";
			}else {
				affichage += i + "  ";
			}
			for (int j = 0; j < longueur ; j++) {
				if(plateau[j][i].estConstruit() ) {
					affichage += ""+plateau[j][i].getIcon() + " ";
				}else {
					affichage += vide + " ";
				}
			}
			affichage +="\n";
		}


		return affichage;
	}

	public static void placer_batiment(int x, int y, Parcelle batiment) {
		if(!plateau[x][y].estConstruit()) {
			plateau[x][y] = batiment;
			Partie.money =- batiment.getCoutPlace();
		}
		else if (plateau[x][y].getIcon().equals("^") && batiment.getIcon().equals("M")) {
			plateau[x][y] = batiment;
			batiment.setProduction(batiment.getProduction() + 50);
			Partie.money =- batiment.getCoutPlace();
		}
	}
	
	public static void supprimer_batiment(int x, int y) {
		if (plateau[x][y].estConstruit()) plateau[x][y] = new Parcelle();
	}

	public static boolean randomMoutain() {
		Random random = new Random();
		int r = random.nextInt(101);
		if (r > 90) {
			return true;
		}
		return false;
	}
	
	public void afficherPlateau() {
		System.out.println(this.toString());
	}
}