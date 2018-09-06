package simulation;

import systeme.Partie;

public class Temp {
	
	public static String saison() {
		if (Partie.date.getMois() == 1 ) return "Hiver";
		if (Partie.date.getMois() == 4 ) return "Printemps";
		if (Partie.date.getMois() == 7 ) return "Eté";
		return "Automne";
	}

}
