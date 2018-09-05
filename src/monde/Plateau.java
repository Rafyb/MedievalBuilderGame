package monde;

import entite.Parcelle;

public class Plateau {
	final private int longueur = 36;
	final private int largeur = 20;
	final private char vide = '+';
	final public Parcelle [][] plateau = new Parcelle [longueur][largeur];

	public Plateau () {
		for (int i = longueur; i < longueur; i++) {
			for (int j = largeur; j < largeur; j++) {
				plateau[i][j] = new Parcelle();
			}
		}
	}

	public int getLongueur() {
		return longueur;
	}
	public int getLargeur() {
		return largeur;
	}

	public String toString() {
		String affichage = "";

		affichage +=" 0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
		for (int i = longueur; i < longueur; i++) {
			for (int j = largeur; j < largeur; j++) {
				if(plateau[i][j].estConstruit()) {
					affichage += plateau[i][j].getChar(); + " ";
				}else {
					affichage += vide + " ";
				}
			}
			affichage +="\n";
		}


		return affichage;
	}
	
	public void afficherPlateau() {
		System.out.println(this.toString());
	}




}
