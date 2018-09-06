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
		System.out.println();
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
		System.out.println("||      Qu'elle type de batiment ajouter ?                      ||");
		System.out.println("||  1 = Maison ("+m.getCoutPlace()+" or)        4 = Route("+r.getCoutPlace()+" or)                 ||");
		System.out.println("||  2 = Champ ("+c.getCoutPlace()+" or)       5 = Taverne("+t.getCoutPlace()+" or)                ||");
		System.out.println("||  3 = Mine ("+mm.getCoutPlace()+" or)        6 = Forgeron("+f.getCoutPlace()+"or)                ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public void affichageSupprimerBatiment(Plateau p) {
		afficherCarteBesoin(p);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      Qu'elle type de batiment supprimer ?                    ||");
		System.out.println("||  1 = Maison ("+m.getCoutSuppr()+" or)        4 = Route("+r.getCoutSuppr()+" or)                   ||");
		System.out.println("||  2 = Champ ("+c.getCoutSuppr()+" or)       5 = Taverne("+t.getCoutSuppr()+" or)                 ||");
		System.out.println("||  3 = Mine ("+mm.getCoutSuppr()+" or)        6 = Forgeron("+f.getCoutSuppr()+"or)                 ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public void afficaheAmélioration(Plateau p){
		afficherCarteBesoin(p);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||      Qu'elle batiment améliorer ?                            ||");
		System.out.println("||      1 = Maison ("+ a.coutAmelioMaison+" or)                                     ||");
		System.out.println("||      2 = Champ ("+ a.coutAmelioChamp+" or)                                      ||");
		System.out.println("||      3 = Mine ("+ a.coutAmelioMine+" or)                                       ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	/**
	 * Si le numéro en paramétre est 0 l'affichage sera pour la coordonné X sinon pour la Y 
	 * @param num
	 */
	public void afficherDemandeDeCoordonné(Plateau p,int num) {
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

	}
	public String saisiePrincipal (Plateau p) {
		this.affichagePrincipale(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	public String saisieAchat (Plateau p) {
		this.affichagePlacementBatiment(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	public String saisieSuppr (Plateau p ) {
		this.affichageSupprimerBatiment(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}
	public String saisieAmelio (Plateau p ) {
		this.afficaheAmélioration(p);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}


	public static void main (String[]args) {
		Interface i = new Interface();
		Partie pp = new Partie();
		Plateau p = new Plateau();
		boolean fin = false;
		String choix = "";
		
		do {
			 fin = false;
			 choix = i.saisiePrincipal(p );
			 if(choix.equals("1")) {i.saisieAchat(p );};
			 if(choix.equals("2"))i.saisieSuppr(p );
			 if(choix.equals("3"))i.saisieAmelio(p );
			 if(choix.equals("4")) fin = true;
			 
			 
		}while(!fin);
		//pp.nextTurn(0, 0, 1);
	}
}
