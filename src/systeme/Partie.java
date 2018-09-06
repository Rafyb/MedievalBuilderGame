package systeme;

import entite.Champ;
import entite.Maison;
import entite.Mine;
import monde.Plateau;
import simulation.Besoin;
import simulation.GestionBudget;
import simulation.rapport;
import simulation.temp;

public class Partie {
	
	public static String budget="Defaut";

	/**
	 * 
	 */
	public static boolean end;
	/**
	 * the Max population of your city
	 * */
	public static int maxPop=5;
	/**
	 * Current amount of money you have
	 * */
	public static int money=1000;
	/**
	 * Current amount of food you have
	 * */
	public static int food=100;
	/**
	 * Current amount of people you have in your city
	 * */
	public static int population=10;
	/**
	 * Current happyness of your people
	 * */
	public static int happyness=50;
	/**
	 * Current date
	 * */
	public static Tour date= new Tour(1,1,0);

	public static Plateau monde;

	/**
	 * Go to the next turn changing the date
	 * @param j the number of day to pass
	 * @param m the number of month to pass
	 * @param a the number of years to pass
	 * */
	public static void nextTurn (int j,int m,int a,Plateau p) {
		date.suivant(j, m, a);
		Besoin.actualiser(monde.plateau);
		finDePartie();
	}

	public static void main (String[]args) {
		Interface i = new Interface();
		monde=new Plateau();
		end = false;
		/*monde.placer_batiment(5, 5, new Champ());
		monde.placer_batiment(5, 6, new Maison());
		monde.placer_batiment(5, 7, new Maison());
		monde.placer_batiment(5, 8, new Maison());
		monde.placer_batiment(5, 9, new Maison());
		monde.placer_batiment(5, 10, new Mine());*/
		boolean fin = false;
		String choix = "";
		while(!end) {
		    for(int cpt=0;cpt<4;cpt++) {
		    	do {
					fin = false;
					choix = i.saisiePrincipal(monde);
					if(choix.equals("1")){
						i.construire(monde, i.saisieAchat(monde), i.getCoordo(monde), i.getCoordo(monde));
					}
					if(choix.equals("2")){
						i.detruire(monde,i.saisieSuppr(monde), i.getCoordo(monde), i.getCoordo(monde));
					}
					if(choix.equals("3")) {
						
					}
					if(choix.equals("4")){
						fin = true;
					}


				}while(!fin);
			Partie.nextTurn(0, 3, 0, monde);
		    }
		    GestionBudget.Gestion(monde);
		}
		System.out.println("Fin de la partie, vous avez survécu jusqu'au "+date.getJour()+"/"+date.getMois()+"/"+date.getAnnee()+"\n");
	}

	public static void ShowBasicInfo() {
		System.out.println("money:"+money+" food:"+food+" population:"+population+" happyness:"+happyness+" date:"+date.getMois()+"/"+date.getAnnee()+" saison:"+temp.saison());
		
		rapport.estimer(monde.getPlateau());
		System.out.println("rapport de saison:  production nourriture:"+rapport.rapProdNourriture+" consomation nourriture:"+rapport.rapBesoinNourriture+" production Argent:"+rapport.rapProdArgent);
	}

	public static void reproduction() {
		population*=1.2;
	}
	
	public static void finDePartie() {
		if(population <= 0) end = true;
		if(food <= 0) end = true;
		if(happyness <= 0) {
			end = true;
			happyness = 0;
		}
	}




}
