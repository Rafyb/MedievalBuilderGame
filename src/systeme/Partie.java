package systeme;

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
    public static void nextTurn (int j,int m,int a) {
	date.suivant(j, m, a);
	food = food-population*3;
    }


}
