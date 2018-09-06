package simulation;

import systeme.Partie;

public class temp {
	
	public static String saison() {
		if (Partie.date.getMois() == 1 ) return "hiver";
		if (Partie.date.getMois() == 4 ) return "printemps";
		if (Partie.date.getMois() == 7 ) return "ete";
		return "automn";
	}

}
