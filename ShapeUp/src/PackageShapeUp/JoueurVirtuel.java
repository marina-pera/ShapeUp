package PackageShapeUp;

public class JoueurVirtuel extends Joueur {
	
	private Strategy methode;
	
	public JoueurVirtuel(Carte carteVictoire, Strategy strategy) {
		this.carteVictoire = carteVictoire;
		this.typeJoueur = "Virtuel";
		this.methode = strategy;
	}
	
	@Override
	public void jouer(Pioche liste, Plateau plateau) {
		this.methode.jouer(liste, plateau);
	}	
}
