package systeme;

    public class Tour {
        int jour;
        int mois;
        int annee;
        
        /**
         * Constructor of the date system
         * @param j days
         * @param m month
         * @param a year
         * */
        public Tour(int j,int m,int a) {
    	if(j>0 && j<=28 && m>0 && m<=12 && a>=0) {
    	    jour = j;
    	    mois = m;
    	    annee = a;
    	}
        }
    	
        /**
    	 * Passing days, month and year to the next one
    	 * @param j days
    	 * @param m month
    	 * @param a year
    	 * */
    	public void suivant (int j,int m,int a) {
    	    jour=jour+j;
    	    if(jour>28) {
    		mois=mois+(jour/28);
    		jour=jour%28;
    	    }
    	    mois=mois+m;
    	    if(mois>12) {
    		annee=annee+(mois/12);
    		mois=mois%12;
    	    }
    	    annee=annee+a;
    	}
    	/**
    	 * @return the current day
    	 * */
    	public int getJour() {
    	    return jour;
    	}
    	/**
    	 * @return the current month
    	 * */
    	public int getMois() {
    	    return mois;
    	}/**
    	 * @return the current year
    	 * */
    	public int getAnnee() {
    	    return annee;
    	}
    }
