package systeme;

import monde.*;

import java.util.Scanner;

import entite.*;
public class Interface {

	Champ c = new Champ();
	Forgeron f = new Forgeron ();
	Maison m = new Maison();
	Mine mm = new Mine();
	Route r = new Route();
	Taverne t = new Taverne();
	Amelioration a = new Amelioration();

	public void afficherCarteBesoin(Plateau p) {
		p.afficherPlateau();
		Partie.ShowBasicInfo();	}

	public void affichageNommerVillage() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||                                                              ||");
		System.out.println("||      Quel est le nom de votre village ?                      ||");
		System.out.println("||                                                              ||");
		System.out.println("||                                                              ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void affichagePrincipale(Plateau p){
		afficherCarteBesoin(p);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      1 = Placer un batiment                                  ||");
		System.out.println("||      2 = Detruire batiment                                   ||");
		System.out.println("||      3 = Ameliorer batiment (Si forgeron disponible)         ||");
		System.out.println("||      4 = Fin du tour                                         ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	public void affichagePlacementBatiment(Plateau p) {
		afficherCarteBesoin(p);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      Quelle type de batiment ajouter ?   0 = Parcelle(0or)   ||");
		System.out.println("||  1 = Maison ("+m.getCoutPlace()+" or)        4 = Route("+r.getCoutPlace()+" or)                 ||");
		System.out.println("||  2 = Champ ("+c.getCoutPlace()+" or)       5 = Taverne("+t.getCoutPlace()+" or)                ||");
		System.out.println("||  3 = Mine ("+mm.getCoutPlace()+" or)        6 = Forgeron("+f.getCoutPlace()+"or)                ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public void affichageSupprimerBatiment(Plateau p) {
		afficherCarteBesoin(p);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      Quelle type de batiment supprimer ?   0 = Parcelle(0or) ||");
		System.out.println("||  1 = Maison (100 or)     4 = Route (100 or)                  ||");
		System.out.println("||  2 = Champ (100 or)      5 = Taverne  (100 or)               ||");
		System.out.println("||  3 = Mine (100 or)       6 = Forgeron  (100 or)		        ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public void afficaheAmélioration(Plateau p){
		afficherCarteBesoin(p);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      Quelle batiment améliorer ?      0 = annuler      ||");
		System.out.println("||      1 = Maison ("+ a.coutAmelioMaison+" or)                                     ||");
		System.out.println("||      2 = Champ ("+ a.coutAmelioChamp+" or)                                      ||");
		System.out.println("||      3 = Mine ("+ a.coutAmelioMine+" or)                                       ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	/**
	 * Si le numéro en paramétre est 0 l'affichage sera pour la coordonné X sinon pour la Y 
	 * 1 affiche un message d'erreur avec un batiment construit, 2 pour des coordonnèes invalide
	 * 3 pas assez d'argent 4 Aucun batiment à ameliorer
	 * @param num
	 */
	public void afficherDivers(Plateau p,int num) {
		afficherCarteBesoin(p );

		if(num==0) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Saissisez la coordonnée X :                              ||");
			System.out.println("||                                                              ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}else {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Saissisez la coordonnée Y :                              ||");
			System.out.println("||                                                              ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		if(num==1) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Coordonnées incorrects : Placement invalide             ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Scanner sc = new Scanner(System.in);String str = " " + sc.nextLine();

		}
		if(num==2) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Coordonnées incorrectes :  Hors du tableau              ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Scanner sc = new Scanner(System.in);String str = " " + sc.nextLine();

		}
		if(num==3) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Pas assez d'argent !!!!!                                ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Scanner sc = new Scanner(System.in);String str = " " + sc.nextLine();

		}
		if(num==4) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Aucun batiment à cette endroit                          ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Scanner sc = new Scanner(System.in);String str = " " + sc.nextLine();

		}
	}
	
	public String saisieNom() {
		this.affichageNommerVillage();
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public String saisiePrincipal (Plateau p) {
		this.affichagePrincipale(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	public Parcelle saisieAchat (Plateau p) {
		this.affichagePlacementBatiment(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(str.equals("1")) {
			return new Maison();
		}
		if(str.equals("2")) {
			return new Champ();
		}
		if(str.equals("3")) {
			return new Mine();
		}
		if(str.equals("4")) {
			return new Route();
		}
		if(str.equals("5")) {
			return new Taverne();
		}
		if(str.equals("6")) {
			return new Forgeron();
		}
		return new Parcelle();
	}

	public Parcelle saisieSuppr (Plateau p ) {
		this.affichageSupprimerBatiment(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(str.equals("1")) {
			return new Maison();
		}
		if(str.equals("2")) {
			return new Champ();
		}
		if(str.equals("3")) {
			return new Mine();
		}
		if(str.equals("4")) {
			return new Route();
		}
		if(str.equals("5")) {
			return new Taverne();
		}
		if(str.equals("6")) {
			return new Forgeron();
		}
		return new Parcelle();
	}
	public void saisieAmelio ( Plateau mondee,Parcelle [][] monde) {
		this.afficaheAmélioration(mondee);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Parcelle pa;
		if(str.equals("1")) {
			a.amelioMaison(monde);
		}
		if(str.equals("2")) {
			a.amelioChamp(monde);
		}
		if(str.equals("3")) {
			a.amelioMine(monde);
		}
		

	}

	int getCoordo(Plateau p,int i) {
		this.afficherDivers(p,i);

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return Integer.valueOf(str);
	}

	public void construire(Plateau p,Parcelle pa,int x, int y ) {

		if( x > 35 || x < 0  || y < 0 || y > 19) {
			afficherDivers(p, 2);
			
		}else if(Plateau.plateau[x][y].estConstruit() && !((Plateau.plateau[x][y].getIcon().equals("^") && pa.getIcon().equals("Ʌ")))) {
			afficherDivers(p, 1);
		}else if(Partie.money<pa.getCoutPlace()) {
			afficherDivers(p, 3);
		}else {
			Plateau.placer_batiment(x, y, pa);
		}
	}

	public void detruire(Plateau p,Parcelle pa,int x, int y ) {

		if( x > 35 || x < 0  || y < 0 || y > 19) {
			afficherDivers(p, 2);

		}else if(!Plateau.plateau[x][y].estConstruit()) {
			afficherDivers(p, 4);

		}else if(Partie.money<pa.getCoutSuppr()) {
			afficherDivers(p, 3);
		}else {
			Partie.money -= 100;
			Plateau.supprimer_batiment(x, y);
		}
	}

	public static void main (String[]args) {

	}
}
