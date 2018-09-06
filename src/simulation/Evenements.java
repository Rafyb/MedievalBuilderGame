package simulation;

import java.util.Random;
import java.util.Scanner;

import entite.Parcelle;
import monde.Plateau;
import systeme.Partie;

public class Evenements {
    private static boolean occur;

    public static void afficherCarte(Plateau monde) {
	monde.afficherPlateau();
	System.out.println();
	Partie.ShowBasicInfo();	}

    public static void Event(Plateau monde) {
	occur = false;
	Random rand = new Random();
	int val = rand.nextInt(100);
	if(val<=15) {
	    occur=true;
	}
	if(occur) {
	    val = rand.nextInt(3);
	    if(val==0) {
		event_incendie(monde);
	    }else if(val==1) {
		event_fête_du_bonheur(monde);
	    }else if(val==2) {
		
	    }
	}
    }
    
    public static void event_fête_du_bonheur(Plateau p) {
	afficherCarte(p);
	Random rand = new Random();
	int val=rand.nextInt(20)+5;
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("||                          EVENEMENT                           ||");
	    System.out.println("||        Votre peuple organise une fête du bonheur!            ||");
	    System.out.println("||      -> Bonheur + "+val+"                                       ||");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    
	    Partie.happyness+=val+5;

	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
    }





    public static void event_incendie(Plateau p) {
	afficherCarte(p);
	Parcelle[][] monde=p.getPlateau();
	String icon="";
	int val=0;
	int chance=70;
	Random rand = new Random();
	boolean ok=false;
	while(!ok) {

	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("||                          EVENEMENT                           ||");
	    System.out.println("||              Un incendie ravage votre royaume!               ||");
	    System.out.println("||      1= Proteger les récoltes                                ||");
	    System.out.println("||      2= Proteger les habitations                             ||");
	    System.out.println("||      3= Ne rien faire                                        ||");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    ok=true;
	    if(str.equals("1")) {
		icon="⌂";
	    }else if(str.equals("2")) {
		icon="≋";
	    }else if(str.equals("3")){
		icon="autre";
	    }else{
		ok=false;
	    }
	}
	for (int i = 0 ; i<monde.length ; i++) {
	    for (int j = 0 ; j<monde[i].length ; j++) {
		if (monde[i][j].getIcon()!=null) {
		    if (monde[i][j].getIcon().equals(icon)||(icon.equals("autre")&&monde[i][j].getIcon().equals("⌂"))||monde[i][j].getIcon().equals("≋")) {
			val=rand.nextInt(100);
			if(val<=chance) {
			    monde[i][j]=new Parcelle();
			    if(chance>=10) {
				chance=chance-10;
			    }
			}
		    }
		}
	    }
	}

	int victimes=0;
	victimes=rand.nextInt(Partie.population/3);
	Partie.population-=victimes;
	Partie.happyness-=20;

	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("||                          EVENEMENT                           ||");
	System.out.println("||              Un incendie ravage votre royaume!               ||");
	System.out.println("||      -> Vous avez perdu certains batiments!                  ||");
	System.out.println("||      -> Il y a eu "+victimes+" victimes!                              ||");
	System.out.println("||      -> Votre peuple a perdu du bonheur!                     ||");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
    }
}
