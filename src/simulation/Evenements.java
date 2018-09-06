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
	if(val<=20) {
	    occur=true;
	}
	if(occur) {
	    val = rand.nextInt(6);
	    if(val==0) {
		event_incendie(monde);
	    }else if(val==1) {
		event_fête_du_bonheur(monde);
	    }else if(val==2) {
		event_filon_or(monde);
	    }else if(val==3) {
		event_maladie(monde);
	    }else if(val==4) {
		event_pillage(monde);
	    }else if(val==5) {
		event_nuee_sauterelle(monde);
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
	System.out.println("||      -> Bonheur + "+val+"\t                             ||");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	Partie.happyness+=val+5;
	if(Partie.happyness>100) {
	    Partie.happyness=100;
	}

	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
    }
    
    public static void event_marchand(Plateau p) {
	afficherCarte(p);
	boolean ok=false;
	String str="";
	Random rand = new Random();
	int val=rand.nextInt(700)+300;
	while(!ok) {
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("||                          EVENEMENT                           ||");
	    System.out.println("||        Une caravane marchande passe dans votre ville         ||");
	    System.out.println("||                     Elle vend des vivres                     ||");
	    System.out.println("||      1= Acheter "+val+" vivres ("+val+" or) \t        ||");
	    System.out.println("||      2= Ne rien acheter                                      ||");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    Scanner sc = new Scanner(System.in);
	    ok=true;
	    if(str.equals("1")) {
		Partie.food+=val;
		Partie.money-=val;
	    }else if (str.equals("2")){

	    }else {
		ok=false;
	    }
	}
    }



    public static void event_nuee_sauterelle(Plateau p) {
	Parcelle[][] monde=p.getPlateau();
	afficherCarte(p);
	int val=0;
	int chance=80;
	Random rand = new Random();
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("||                          EVENEMENT                           ||");
	System.out.println("||        Des nuées de sauterelles déciments vos champs         ||");
	System.out.println("||      -> Pertes de certains champs                            ||");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	for (int i = 0 ; i<monde.length ; i++) {
	    for (int j = 0 ; j<monde[i].length ; j++) {
		if (monde[i][j].getIcon()!=null) {
		    if (monde[i][j].getIcon().equals("≋")) {
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
	victimes=rand.nextInt(Partie.population/3)+5;
	Partie.population-=victimes;
	Partie.happyness-=20;
	if(Partie.happyness<0) {
	    Partie.happyness=0;
	}

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

    public static void event_filon_or(Plateau p) {
	afficherCarte(p);
	int val=0;
	Random rand = new Random();
	boolean ok=false;
	while(!ok) {

	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("||                          EVENEMENT                           ||");
	    System.out.println("||         Vos mineurs ont trouvé un immense filon d'or!        ||");
	    System.out.println("||      1= Partager avec votre peuple                           ||");
	    System.out.println("||      2= Garder l'or pour vous                                ||");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    ok=true;
	    val=rand.nextInt(3000)+600;
	    if(str.equals("1")) {
		Partie.happyness+=10;
		if(Partie.happyness>100) {
		    Partie.happyness=100;
		}
		Partie.money+=val/2;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||                          EVENEMENT                           ||");
		System.out.println("||             Vous Partagez l'or avec votre peuple             ||");
		System.out.println("||      -> Vous récupérez "+val/2+" or!                             ||");
		System.out.println("||      -> Votre peuple gagne en bonheur                        ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		str = sc.nextLine();
	    }else if(str.equals("2")) {
		Partie.money+=val;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||                          EVENEMENT                           ||");
		System.out.println("||                 Vous garder l'or pour vous!                  ||");
		System.out.println("||      -> Vous récupérez "+val+" or!                             ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		str = sc.nextLine();
	    }else{
		ok=false;
	    }
	}

	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();

    }






    public static void event_maladie(Plateau p) {
	afficherCarte(p);
	if(!Partie.budget.equals("Medecine")) {
	    int val=0;
	    Random rand = new Random();
	    boolean ok=false;
	    while(!ok) {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||                          EVENEMENT                           ||");
		System.out.println("||            Votre royaume est victime d'une épidemie          ||");
		System.out.println("||      1= Investir dans des soins (400 or)                     ||");
		System.out.println("||      2= Exiler les personnes infectées                       ||");
		System.out.println("||      3= Ne rien faire                                        ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ok=true;
		val=Partie.population;
		if(str.equals("1")) {
		    Partie.happyness-=10;
		    if(Partie.happyness<0) {
			Partie.happyness=0;
		    }
		    Partie.population-=(val/2);
		    Partie.money-=400;
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    System.out.println("||                          EVENEMENT                           ||");
		    System.out.println("||          Vos médecins arrivent a endiguer l'epidemie         ||");
		    System.out.println("||      -> Il y a eu "+val/2+" victimes                         ||");
		    System.out.println("||      -> Votre peuple perd 10 de bonheur                      ||");
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		    str = sc.nextLine();
		}else if(str.equals("2")) {
		    Partie.money+=val;
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    System.out.println("||                          EVENEMENT                           ||");
		    System.out.println("||             Vous exiler les personnes infectées              ||");
		    System.out.println("||      -> Il y a "+val/2+" victimes                                ||");
		    System.out.println("||      -> Votre peuple perd 25 de bonheur                      ||");
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    
		    Partie.happyness-=25;
		    if(Partie.happyness<0) {
			Partie.happyness=0;
		    }
		    Partie.population-=(val/2);

		    str = sc.nextLine();
		    
		}else if(str.equals("3")) {
		    Partie.money+=val;
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    System.out.println("||                          EVENEMENT                           ||");
		    System.out.println("||             L'épidemie ravage votre population               ||");
		    System.out.println("||      -> Il y a "+(2*val/3)+" victimes                             ||");
		    System.out.println("||      -> Votre peuple perd 40 de bonheur                      ||");
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    
		    Partie.happyness-=40;
		    if(Partie.happyness<0) {
			Partie.happyness=0;
		    }
		    Partie.population-=(2*val/3);

		    str = sc.nextLine();
		}else {
		    ok=false;
		}
	    }

	}else {
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("||                          EVENEMENT                           ||");
	    System.out.println("||      Une maladie grave a été trouvé dans votre royaume       ||");
	    System.out.println("||   	Mais vos médecins ont empêché l'epidemie!               ||");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	}
    }
    
    public static void event_pillage(Plateau p) {
	afficherCarte(p);
	if(!Partie.budget.equals("Militaire")) {
	    int val=0;
	    int val2=0;
	    Random rand = new Random();
	    boolean ok=false;
	    while(!ok) {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("||                          EVENEMENT                           ||");
		System.out.println("|| Des bandits de la région cherchent à piller vos réserves     ||");
		System.out.println("||      1= Defendre les habitants                               ||");
		System.out.println("||      2= Defendre les réserves (abandonner les habitant à     ||");
		System.out.println("||            leurs triste sort)                                ||");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ok=true;
		val=rand.nextInt(Partie.food);
		val2=rand.nextInt(Partie.money);
		if(str.equals("1")) {
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    System.out.println("||                          EVENEMENT                           ||");
		    System.out.println("||             Les Bandits ont pillé vos réserves               ||");
		    System.out.println("||      -> Vous perdez "+val+" nourriture                          ||");
		    System.out.println("||      -> Vous perdez "+val2+" or                                 ||");
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    
		    Partie.money-=val2;
		    Partie.food-=val;

		    str = sc.nextLine();
		}else if(str.equals("2")) {
		    val=rand.nextInt(Partie.population)/4;
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    System.out.println("||                          EVENEMENT                           ||");
		    System.out.println("||         Les Bandits s'attaquent à votre population           ||");
		    System.out.println("||      -> Il y a "+val+" victimes                                  ||");
		    System.out.println("||      -> Votre peuple perd 20 de bonheur                      ||");
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    
		    Partie.happyness-=20;
		    if(Partie.happyness<0) {
			Partie.happyness=0;
		    }
		    Partie.population-=val;

		    str = sc.nextLine();
		    
		}else {
		    ok=false;
		}
	    }

	}else {
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("||                          EVENEMENT                           ||");
	    System.out.println("||      Les bandits s'enfuient devant votre force militaire     ||");
	    System.out.println("||   	-> bonheur +5                                           ||");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    
	    Partie.happyness+=5;
	    if(Partie.happyness>100) {
		Partie.happyness=100;
	    }

	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	}
    }
}
