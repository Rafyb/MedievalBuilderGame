package monde;

import java.util.Random;

import entite.Lac;
import entite.Parcelle;
import systeme.Partie;

public class Obstacle {

	public static double chance = 20;
	private static Random rand=new Random();

	public static void lac(Parcelle [][] monde, int x, int y)
	{  
		System.out.println(x+"/"+y);
		System.out.println("ok");
		System.out.println(x<35 && x>0 && y<19 && y>0 );


		if( x<35 && x>0 && y<19 && y>0 ) {
			System.out.println("check");

			System.out.println("luck");
			if(!(monde[x][y].getIcon().equals("~"))) {

				monde[x][y]=new Lac();

				if(rand.nextInt(101) > chance) { 
					System.out.println("luck");
					lac(monde, x-1, y);
					lac(monde, x+1, y);
					lac(monde, x, y-1);
					lac(monde, x, y+1);
					//}

					chance/=0.5;
				}
			}
		}

	}
}
