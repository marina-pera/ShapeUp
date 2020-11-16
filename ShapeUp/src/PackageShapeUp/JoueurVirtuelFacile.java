package PackageShapeUp;

public class JoueurVirtuelFacile implements Strategy {
	
	private static Plateau plateau;
	private static Pioche pioche;
	
	public JoueurVirtuelFacile(Plateau plateau, Pioche pioche) {
		this.plateau = plateau;
		this.pioche = pioche;
	}
	
	public void jouer(Pioche liste, Plateau plateau) {
		this.plateau.printDisposition();
		System.out.println();
		int answer = (int)(Math.random() * 2);
		if (answer == 0) {
			Carte cartePiochee = liste.piocher();
			int indexLigne = -1;
			int indexColonne = -1;
			indexLigne = (int)(Math.random() * (plateau.getDisposition().length));
			indexColonne = (int)(Math.random()* (plateau.getDisposition()[0].length));
			while(indexLigne < 0 || indexLigne > plateau.getDisposition().length || indexColonne < 0 || indexColonne > plateau.getDisposition()[0].length || plateau.caseIsEmpty(indexLigne,indexColonne) != true || !plateau.estPossible(indexLigne,indexColonne,cartePiochee)) {
				indexLigne = (int)(Math.random() * (plateau.getDisposition().length));
				indexColonne = (int)(Math.random() * (plateau.getDisposition()[0].length));
			}
			cartePiochee.poserCarte(plateau, indexLigne, indexColonne);
			this.plateau.printDisposition();
			System.out.println();
			int answer2 = (int)(Math.random() * 2);
			if (answer2 == 0 && plateau.plateauVide() == false) {
				Carte carteChoisie = null;
				int choixLigne;
				int choixColonne;
				int [] choix = new int[2];
				while(carteChoisie == null) {
					choixLigne = (int)(Math.random() * (plateau.getDisposition().length));
					choixColonne = (int)(Math.random()* (plateau.getDisposition()[0].length));
					choix[0] = choixLigne;
					choix[1] = choixColonne;
					for (Carte[] ligne : plateau.getDisposition()) {
						for (Carte carte : ligne) {
							if (carte != null && plateau.indexOf(carte)[0] == choix[0] && plateau.indexOf(carte)[1] == choix[1]) {
								carteChoisie = carte;
							}
						}
					}
				}
				int newIndexLigne = (int)(Math.random() * (plateau.getDisposition().length));
				int newIndexColonne = (int)(Math.random()* (plateau.getDisposition()[0].length));
				while (plateau.caseIsEmpty(newIndexLigne, newIndexColonne) != true || !plateau.estPossible(newIndexLigne,newIndexColonne,carteChoisie)) {
					newIndexLigne = (int)(Math.random() * (plateau.getDisposition().length));
					newIndexColonne = (int)(Math.random()* (plateau.getDisposition()[0].length));
				}
				carteChoisie.deplacerCarte(plateau, newIndexLigne, newIndexColonne);
				this.plateau.printDisposition();
				System.out.println();
			} else if (answer2 == 0 && plateau.plateauVide() == true) {
				
			}
		} else {
			if (plateau.plateauVide() != true) {
				Carte carteChoisie = null;
				int choixLigne;
				int choixColonne;
				int [] choix = new int [2];
				while(carteChoisie == null) {
					choixLigne = (int)(Math.random() * (plateau.getDisposition().length));
					choixColonne = (int)(Math.random()* (plateau.getDisposition()[0].length));
					choix[0] = choixLigne;
					choix[1] = choixColonne;
					for (Carte[] ligne : plateau.getDisposition()) {
						for (Carte carte : ligne) {
							if (carte != null && plateau.indexOf(carte)[0] == choix[0] && plateau.indexOf(carte)[1] == choix[1]) {
								carteChoisie = carte;
							}
						}
					}
				}
				int newIndexLigne = (int)(Math.random() * (plateau.getDisposition().length));
				int newIndexColonne = (int)(Math.random() * (plateau.getDisposition()[0].length));
				while (plateau.caseIsEmpty(newIndexLigne, newIndexColonne) != true || !plateau.estPossible(newIndexLigne,newIndexColonne,carteChoisie)) {
					newIndexLigne = (int)(Math.random() * (plateau.getDisposition().length));
					newIndexColonne = (int)(Math.random() * (plateau.getDisposition()[0].length));
				}
				carteChoisie.deplacerCarte(plateau, newIndexLigne, newIndexColonne);
				this.plateau.printDisposition();
				System.out.println();
			} 
			Carte cartePiochee = liste.piocher();
			int indexLigne = -1;
			int indexColonne = -1;
			while(indexLigne < 0 || indexLigne > plateau.getDisposition().length || indexColonne < 0 || indexColonne > plateau.getDisposition()[0].length || plateau.caseIsEmpty(indexLigne,indexColonne) != true || !plateau.estPossible(indexLigne,indexColonne,cartePiochee)) {
				indexLigne = (int)(Math.random() * (plateau.getDisposition().length));
				indexColonne = (int)(Math.random() * (plateau.getDisposition()[0].length));
			}
			cartePiochee.poserCarte(plateau, indexLigne, indexColonne);
			this.plateau.printDisposition();
			System.out.println();
		}
	}
	
}
