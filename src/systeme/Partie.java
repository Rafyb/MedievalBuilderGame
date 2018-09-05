package systeme;

public class Partie {
    /**
     * Current amount of money you have
     * */
    int money;
    /**
     * Current amount of food you have
     * */
    int food;
    /**
     * Current amount of people you have in your city
     * */
    int population;
    /**
     * Current happyness of your people
     * */
    int happyness;
    /**
     * Current date
     * */
    Tour date;
    
    /**
     * Constructor of a game
     * */
    public Partie() {
	money = 1000;
	food = 100;
	population = 10;
	happyness = 50;
	date = new Tour(1,1,0);
    }
    /**
     * Go to the next turn changing the date
     * @param j the number of day to pass
     * @param m the number of month to pass
     * @param a the number of years to pass
     * */
    public void nextTurn (int j,int m,int a) {
	date.suivant(j, m, a);
    }
    /**
     * Change the amont of money you have (-10 or +10 for example)
     * @param m the amount of money
     * */
    public void changeMoney (int m) {
	money=money+m;
    }
}
