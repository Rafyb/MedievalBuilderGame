package systeme;

public class Partie {
    int money;
    int food;
    int population;
    int happyness;
    Tour date;
    
    
    public Partie() {
	money = 1000;
	food = 100;
	population = 10;
	happyness = 50;
	date = new Tour(1,1,0);
    }
    /**
     * @param j the number of day to pass
     * @param m the number of month to pass
     * @param a the number of years to pass
     * */
    public void nextTurn (int j,int m,int a) {
	date.suivant(j, m, a);
    }
}
