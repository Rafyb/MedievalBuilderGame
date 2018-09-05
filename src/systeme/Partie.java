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
     * Change the amount of money you have (-10 or +10 for example)
     * @param m the amount of money
     * */
    public void changeMoney (int m) {
	money=money+m;
    }
    
    /**
     * Go to the next turn changing the date
     * @param j the number of day to pass
     * @param m the number of month to pass
     * @param a the number of years to pass
     * */
    public void nextTurn (int j,int m,int a) {
	date.suivant(j, m, a);
	food = food-population*3;
    }
    
    public int getMoney() {
	return money;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getHappyness() {
        return happyness;
    }

    public void setHappyness(int happyness) {
        this.happyness = happyness;
    }

    public Tour getDate() {
        return date;
    }

    public void setDate(Tour date) {
        this.date = date;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
