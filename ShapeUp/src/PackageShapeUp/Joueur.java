package PackageShapeUp;

public abstract class Joueur {
	
	protected Carte carteVictoire;
	protected String typeJoueur;
	protected int numeroJoueur;
	private String choixOrdre;
	private boolean moveCard;
	
	public  abstract void jouer(Pioche liste, Plateau plateau);
	
	public String toString() {
		String joueurParam = " " + this.typeJoueur;
		return joueurParam;
	}
}
