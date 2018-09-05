package systeme;

import entite.Champ;
import entite.Maison;
import monde.Plateau;
import simulation.Besoin;

public class Partie {
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
     * Change the amount of money you have (-10 or +10 for example)
     * @param m the amount of money
     * */
    public static void changeMoney (int m) {
	money=money+m;
	
    }
    
    /**
     * Go to the next turn changing the date
     * @param j the number of day to pass
     * @param m the number of month to pass
     * @param a the number of years to pass
     * */
    public static void nextTurn (int j,int m,int a,Plateau p) {
	date.suivant(j, m, a);
	Besoin.actualiser(monde.plateau);
    }
    
    public static void main (String[]args) {
	monde=new Plateau();
	monde.placer_batiment(5, 5, new Champ());
	monde.afficherPlateau();
	nextTurn(0,0,1,monde);
	//System.out.println("money:"+money+" food:"+food+" population:"+population+" happy:"+happyness);
	//System.out.println(monde.plateau[5][5].getClass().getName());
    }


}
