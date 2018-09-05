package test;

import entite.*;
import monde.*;

public class Test_plateau {

	public static void main(String[] args) {
		Plateau p = new Plateau();
		p.afficherPlateau();
		System.out.println("PLACEMENT DE BATIMENT DE TYPE MAISON");
		p.placer_batiment(6, 9, new Maison());
		p.afficherPlateau();
		System.out.println("FIN");
	}

}
