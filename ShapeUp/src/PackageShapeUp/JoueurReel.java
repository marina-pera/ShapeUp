package PackageShapeUp;

public class JoueurReel extends Joueur {
	
	private int numJoueur = 1;
	private static Plateau plateau;
	private static Pioche pioche;
	
	public JoueurReel(Carte carteVictoire, Plateau plateau, Pioche pioche) {
		this.carteVictoire = carteVictoire;
		this.typeJoueur = "Reel";
		this.plateau = plateau;
		this.pioche = pioche;
		this.numeroJoueur = numJoueur;
		numJoueur++;
	}
	
	public void jouer(Pioche liste, Plateau plateau) {
		this.plateau.printDisposition();
		System.out.println();
		java.util.Scanner input =   new java.util.Scanner(System.in);
		System.out.println("Souhaitez vous poser une carte ou déplacer une carte en premier ? (poser/deplacer)");
		String answer = input.next();
		while (!answer.equals("poser") && !(answer.equals("deplacer"))) {
			answer = input.next();
		}
		plateau.printDisposition();
		if (answer.equals("poser")) {
			Carte cartePiochee = liste.piocher();
			int indexLigne;
			int indexColonne;
			System.out.println("Où voulez vous placer la carte ? (ligne puis colonne)");
			indexLigne = input.nextInt();
			indexColonne = input.nextInt();
			while((indexLigne < 0 || indexLigne > plateau.getDisposition().length-1 || indexColonne < 0 || indexColonne > plateau.getDisposition()[0].length-1 || plateau.caseIsEmpty(indexLigne, indexColonne) != true) || !plateau.estPossible(indexLigne,indexColonne,cartePiochee)) {
				indexLigne = input.nextInt();
				indexColonne = input.nextInt();
			}
			cartePiochee.poserCarte(plateau, indexLigne, indexColonne);
			this.plateau.printDisposition();
			System.out.println();
			System.out.println("Souhaitez vous déplacer une carte ? (y/n)");
			String answer2 = input.next();
			while (!answer2.equals("y") && !answer2.equals("n")) {
				answer2 = input.next();
			}
			if (answer2.equals("y") && plateau.plateauVide() == false) {
				System.out.println("Choisissez les indices de la carte à déplacer");
				Carte carteChoisie = null;
				int choixLigne;
				int choixColonne;
				int [] choix = new int[2];
				while(carteChoisie == null) {
					choixLigne = input.nextInt();
					choixColonne = input.nextInt();
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
				int newIndexLigne = -1;
				int newIndexColonne = -1;
				System.out.println("Choisissez le nouvel indice de la carte");
				while (newIndexLigne < 0 || newIndexLigne > plateau.getDisposition().length-1 || newIndexColonne < 0 || newIndexColonne > plateau.getDisposition()[0].length-1 || !plateau.estPossible(newIndexLigne,newIndexColonne,carteChoisie)) {
					newIndexLigne = input.nextInt();
					newIndexColonne = input.nextInt();
				}
				carteChoisie.deplacerCarte(plateau, newIndexLigne, newIndexColonne);
				this.plateau.printDisposition();
				System.out.println();
			} else if (answer2.equals("y") && plateau.plateauVide() == true) {
				System.out.println("Le plateau est vide");
			}
		} else {
			if (plateau.plateauVide() != true) {
				System.out.println("Choisissez les indices de la carte à déplacer");
				Carte carteChoisie = null;
				int choixLigne;
				int choixColonne;
				int [] choix = new int [2];
				while(carteChoisie == null) {
					choixLigne = input.nextInt();
					choixColonne = input.nextInt();
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
				int newIndexLigne = -1;
				int newIndexColonne = -1;
				System.out.println("Choisissez les nouveaux indices de la carte");
				while (newIndexLigne < 0 || newIndexLigne > plateau.getDisposition().length-1 || newIndexColonne < 0 || newIndexColonne > plateau.getDisposition()[0].length-1 || !plateau.estPossible(newIndexLigne,newIndexColonne,carteChoisie)) {
					newIndexLigne = input.nextInt();
					newIndexColonne = input.nextInt();
				}
				carteChoisie.deplacerCarte(plateau, newIndexLigne, newIndexColonne);
				this.plateau.printDisposition();
				System.out.println();
			} else {
				System.out.println("Le plateau est vide");
			}
			Carte cartePiochee = liste.piocher();
			int indexLigne1 = -1;
			int indexColonne2 = -1;
			System.out.println("Où voulez vous placer la carte ?");
			while(indexLigne1 < 0 || indexLigne1 > plateau.getDisposition().length-1 || indexColonne2 < -1 || indexColonne2 > plateau.getDisposition()[0].length-1 || plateau.caseIsEmpty(indexLigne1, indexColonne2) != true || !plateau.estPossible(indexLigne1,indexColonne2,cartePiochee)) {
				indexLigne1 = input.nextInt();
				indexColonne2 = input.nextInt();
			}
			cartePiochee.poserCarte(plateau, indexLigne1, indexColonne2);
			this.plateau.printDisposition();
			System.out.println();
		}
	}
	
	public void quitterPartie() {
		
	}
	
}
