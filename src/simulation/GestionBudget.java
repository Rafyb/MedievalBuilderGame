package simulation;

import java.util.Scanner;

import monde.Plateau;
import systeme.Partie;

public class GestionBudget {

    public static void afficherCarte(Plateau p) {
	p.afficherPlateau();
	System.out.println();
	Partie.ShowBasicInfo();	}

    public static void Gestion(Plateau p) {
	afficherCarte(p);
	boolean ok=false;
	while(!ok) {

	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("||      Dans quoi voulez vous investir votre budget?            ||");
	    System.out.println("||      1 = Militaire (500 or)                                  ||");
	    System.out.println("||      2 = Medecine (500 or)                                   ||");
	    System.out.println("||      3 = Des fêtes pour le peuple (+20 bonheur) (500 or)     ||");
	    System.out.println("||      4 = Garder l'argent pour vous même                      ||");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    ok=true;
	    if(str.equals("1")&&Partie.money>=500) {
		Partie.budget="Militaire";
		Partie.money+=-500;
	    }else if(str.equals("2")&&Partie.money>=500) {
		Partie.budget="Medecine";
		Partie.money+=-500;
	    }else if(str.equals("3")&&Partie.money>=500) {
		Partie.budget="Bonheur";
		Partie.happyness+=20;
		Partie.money+=-500;
	    }else if(str.equals("4")) {
		Partie.budget="Argent";
	    }else{
		ok=false;
	    }
	}

    }
}
