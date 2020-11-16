package PackageShapeUp;

public class JoueurVirtuelIntermediaire implements Strategy {
	
	private static Plateau plateau;
	private static Pioche pioche;
	
	public JoueurVirtuelIntermediaire(Plateau plateau, Pioche pioche) {
		this.plateau = plateau;
		this.pioche = pioche;
	}
	
	public void jouer(Pioche liste, Plateau plateau) {
		
	}
	
}
