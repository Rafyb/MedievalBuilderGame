package systeme;

import entite.Champ;
import entite.Maison;
import entite.Mine;
import monde.Plateau;
import simulation.Besoin;

public class Partie {
    
    /**
     * the Max population of your city
     * */
    public static int maxPop=0;
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
    }
    
    public static void main (String[]args) {
	monde=new Plateau();
	//monde.afficherPlateau();
	//System.out.println("money:"+money+" food:"+food+" population:"+population+" happy:"+happyness);
	monde.placer_batiment(5, 5, new Champ());
	monde.placer_batiment(5, 6, new Maison());
	//monde.placer_batiment(5, 7, new Maison());
	//monde.placer_batiment(5, 8, new Maison());
	//monde.placer_batiment(5, 9, new Maison());
	monde.placer_batiment(5, 10, new Mine());
	monde.afficherPlateau();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
	nextTurn(0,0,1,monde);
	ShowBasicInfo();
    }
    
    public static void ShowBasicInfo() {
	System.out.println("money:"+money+" food:"+food+" population:"+population+"/"+maxPop+" happyness:"+happyness);
    }
    
    public static void reproduction() {
    	population*=1.2;
    }
    
    


}
