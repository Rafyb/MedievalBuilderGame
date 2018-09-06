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
		System.out.println("||      Quelle type de batiment ajouter ?                      ||");
		System.out.println("||  1 = Maison ("+m.getCoutPlace()+" or)        4 = Route("+r.getCoutPlace()+" or)                 ||");
		System.out.println("||  2 = Champ ("+c.getCoutPlace()+" or)       5 = Taverne("+t.getCoutPlace()+" or)                ||");
		System.out.println("||  3 = Mine ("+mm.getCoutPlace()+" or)        6 = Forgeron("+f.getCoutPlace()+"or)                ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public void affichageSupprimerBatiment(Plateau p) {
		afficherCarteBesoin(p);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      Quelle type de batiment supprimer ?                     ||");
		System.out.println("||  1 = Maison ("+m.getCoutSuppr()+" or)        4 = Route("+r.getCoutSuppr()+" or)                   ||");
		System.out.println("||  2 = Champ ("+c.getCoutSuppr()+" or)       5 = Taverne("+t.getCoutSuppr()+" or)                 ||");
		System.out.println("||  3 = Mine ("+mm.getCoutSuppr()+" or)        6 = Forgeron("+f.getCoutSuppr()+"or)                 ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public void afficaheAmélioration(Plateau p){
		afficherCarteBesoin(p);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      Quelle batiment améliorer ?                             ||");
		System.out.println("||      1 = Maison ("+ a.coutAmelioMaison+" or)                                     ||");
		System.out.println("||      2 = Champ ("+ a.coutAmelioChamp+" or)                                      ||");
		System.out.println("||      3 = Mine ("+ a.coutAmelioMine+" or)                                       ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	/**
	 * Si le numéro en paramétre est 0 l'affichage sera pour la coordonné X sinon pour la Y 
	 * 1 affiche un message d'erreur avec un batiment construit, 2 pour des coordonnèes invalide
	 * 3 pas assez d'argent
	 * @param num
	 */
	public void afficherDivers(Plateau p,int num) {
		afficherCarteBesoin(p );

		if(num==0) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Saissisez la coordonné X :                              ||");
			System.out.println("||                                                              ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}else {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Saissisez la coordonné Y :                              ||");
			System.out.println("||                                                              ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		if(num==1) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Coordonnées incorrect :  Batiment déjà présent          ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		if(num==2) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Coordonnées incorrect :  Coordonnées Incorrect          ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		if(num==3) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Pas assez d'argent !!!!!                                ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		if(num==4) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("||                                                              ||");
			System.out.println("||      Aucun batiment à cette endroit                          ||");
			System.out.println("||                                                              ||");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
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
	public String saisieAmelio (Plateau p ) {
		this.afficaheAmélioration(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	int getCoordo(Plateau p) {
		this.afficherDivers(p,0);

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return Integer.valueOf(str);
	}

	public void construire(Plateau p,Parcelle pa,int x, int y ) {

		if( x > 35 || x < 0  || y < 0 || y > 19) {
			afficherDivers(p, 2);
		}else if(Plateau.plateau[x][y].estConstruit() && !((Plateau.plateau[x][y].getIcon().equals("^") && pa.getIcon().equals("⩄")))) {
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
			Plateau.supprimer_batiment(x, y);
		}
	}

	public static void main (String[]args) {
		Interface i = new Interface();
		Partie pp = new Partie();
		Plateau p = new Plateau();
		boolean fin = false;
		String choix = "";

		do {
			fin = false;
			choix = i.saisiePrincipal(p);
			if(choix.equals("1")){
				i.construire(p, i.saisieAchat(p), i.getCoordo(p), i.getCoordo(p));
			}
			if(choix.equals("2")){
				i.detruire(p,i.saisieSuppr(p), i.getCoordo(p), i.getCoordo(p));
			}
			if(choix.equals("3")) {
				
			}
			if(choix.equals("3")){
				fin = true;
			}


		}while(!fin);
	}
}
