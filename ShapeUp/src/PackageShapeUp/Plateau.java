package PackageShapeUp;

public abstract class Plateau {
	
	private FormePlateau formePlateau;
	
	
	public abstract Carte[][] getDisposition();
	
	public abstract void printDisposition();
	
	public abstract void setDisposition(int indexLigne, int indexColonne, Carte carte);
	
	public abstract boolean caseIsEmpty(int indexLigne, int indexColonne);
	
	public abstract boolean plateauVide(); 
	
	public int [] indexOf(Carte carte){
	       int indexLigne = -1;
	       int indexColonne = -1;
	       for (int i = 0; i < this.getDisposition().length; i++) {
	    	   for (int j = 0; j < this.getDisposition()[0].length; j++) {
	    		   if(this.getDisposition()[i][j] == carte){
		                indexLigne = i;
		                indexColonne = j;
		           }
	    	   }
	       }
	       int [] table = {indexLigne, indexColonne};
	       return table;
	}

	public abstract boolean estPossible(int indexLigne, int indexColonne, Carte cartePiochee);
}
