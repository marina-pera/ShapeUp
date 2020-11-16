package PackageShapeUp;

import java.util.ArrayList;
import java.util.List;

public class Partie {
	
	private static Partie partie = null;
	private int numeroPartie;
	
	private Partie() {
		java.util.Scanner input =   new java.util.Scanner(System.in); // pour récupérer les entrées utilisateur
		System.out.println("Bienvenue dans ShapeUp !");
		System.out.println("Combien de joueurs souhaitez vous dans la partie ? (2/3)");
		int nombreJoueurs = input.nextInt();
		while (nombreJoueurs != 2 && nombreJoueurs !=3) {
			nombreJoueurs = input.nextInt();
		}
		System.out.println("Combien de joueurs réels souhaitez vous parmi les joueurs de la partie ? (moins que le nombre de joueurs)");
		int nombreJoueursReels = input.nextInt();
		while (nombreJoueursReels < 0 || nombreJoueursReels > nombreJoueurs) {
			nombreJoueursReels = input.nextInt();
		}
		Difficultés level = null;
		if (nombreJoueurs != nombreJoueursReels) {
			System.out.println("Quelle difficulté souhaitez vous pour les joueurs virtuels ? (facile, intermediaire, difficile)");
			level = Difficultés.valueOf(input.next().toUpperCase());
		}
		System.out.println("Choisissez la forme du plateau (rectangle/croix/choix3)");
		FormePlateau formePlateau = null;
		while (formePlateau != FormePlateau.RECTANGLE && formePlateau != FormePlateau.CROIX && formePlateau != FormePlateau.CHOIX3) {
			formePlateau = FormePlateau.valueOf(input.next().toUpperCase());
		}
		Plateau plateau = null;
		if (formePlateau == FormePlateau.RECTANGLE) {
			plateau = new PlateauRectangle();
		} else if (formePlateau == FormePlateau.CROIX) {
			plateau = new PlateauCroix();
		} else {
			plateau = new PlateauRectangle();
		}
		Pioche liste = Pioche.getInstance(plateau);
		liste.piocher(); //Carte à supprimer en début de partie
		Strategy methode = null;
		if (nombreJoueurs != nombreJoueursReels) {
			if (level == Difficultés.FACILE) {
				methode = new JoueurVirtuelFacile(plateau, liste);
			} else if (level == Difficultés.INTERMEDIAIRE) {
				methode = new JoueurVirtuelIntermediaire(plateau, liste);
			} else {
				methode = new JoueurVirtuelFacile(plateau, liste);
			}
		}
		Joueur j1 =null;
		Joueur j2 =null;
		Joueur j3 = null;
		final List<Joueur> listeJoueurs = new ArrayList<>();
		if (nombreJoueurs == 2) {
			if (nombreJoueursReels > 1){
				j1 = new JoueurReel(liste.piocher(), plateau, liste);
			    j2 = new JoueurReel(liste.piocher(), plateau, liste);
			} else if (nombreJoueursReels > 0) {
			    j1 = new JoueurReel(liste.piocher(), plateau, liste);
			    j2 = new JoueurVirtuel(liste.piocher(), methode);
			} else {
			    j1 = new JoueurVirtuel(liste.piocher(), methode);
			    j2 = new JoueurVirtuel(liste.piocher(), methode);
			   }
			listeJoueurs.add(j1);
			listeJoueurs.add(j2);
		} else {
			if (nombreJoueursReels > 2){
				j1 = new JoueurReel(liste.piocher(), plateau, liste);
			    j2 = new JoueurReel(liste.piocher(), plateau, liste);
			    j3 = new JoueurReel(liste.piocher(), plateau, liste);
			} else if (nombreJoueursReels > 1) {
			    j1 = new JoueurReel(liste.piocher(), plateau, liste);
			    j2 = new JoueurReel(liste.piocher(), plateau, liste);
			    j3 = new JoueurVirtuel(liste.piocher(), methode);
			} else  if (nombreJoueursReels > 0) {
			    j1 = new JoueurReel(liste.piocher(), plateau, liste);
			    j2 = new JoueurVirtuel(liste.piocher(), methode);
			    j3 = new JoueurVirtuel(liste.piocher(), methode);
			} else {
			    j1 = new JoueurVirtuel(liste.piocher(), methode);
			    j2 = new JoueurVirtuel(liste.piocher(), methode);
			    j3 = new JoueurVirtuel(liste.piocher(), methode);
			}
			listeJoueurs.add(j1);
			listeJoueurs.add(j2);
			listeJoueurs.add(j3);
		}
		System.out.println("Résumé de la partie");
		System.out.println("Nombre de joueurs " + nombreJoueurs + " dont " + nombreJoueursReels + " réels");
		if (nombreJoueurs != nombreJoueursReels) {
			System.out.println("La difficulté du jeu sera " + level);
		}
		System.out.println("Le plateau est de forme " + formePlateau);
		while (liste.size() > 0) {
			for (Joueur j : listeJoueurs) {
				if (liste.size() > 0) {
					j.jouer(liste, plateau);
					System.out.println("Fin du tour du joueur");
					System.out.println();
				}
			}

		}
	}
	
	public static Partie getInstance() {
		if (partie == null) {
			partie = new Partie();
		}
		return partie;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner input =   new java.util.Scanner(System.in);
		System.out.println("Lancer une partie ? (y/n)");
		String answer = input.next();
		if (answer.equals("y")) {
			partie.getInstance();
		}
	}	
}
