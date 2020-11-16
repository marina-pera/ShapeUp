package PackageShapeUp;

public class Carte {
	
	private  String couleur;
	private String forme;
	private String remplissage;
	private static Plateau plateau;
	
	public Carte(String couleur, String forme, String remplissage, Plateau plateau) {
		this.couleur = couleur;
		this.forme = forme;
		this.remplissage = remplissage;
		this.plateau = plateau;
	}
	
	public void piocherCarte() {
		
	}
	
	public void poserCarte(Plateau plateau, int indexLigne, int indexColonne) {
		plateau.setDisposition(indexLigne, indexColonne, this);
	}
	
	public void deplacerCarte(Plateau plateau, int newIndexLigne, int newIndexColonne) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		int oldIndexLigne = -1;
		int oldIndexColonne = -1;
		for (int i=0; i<plateau.getDisposition().length; i++) {
			for (int j = 0; j<plateau.getDisposition()[0].length; j++) {
				if (plateau.getDisposition()[i][j] == this) {
					oldIndexLigne = i;
					oldIndexColonne = j;
				}
			}
		}
		if (plateau.caseIsEmpty(newIndexLigne, newIndexColonne) == true) {
			plateau.setDisposition(newIndexLigne, newIndexColonne, plateau.getDisposition()[oldIndexLigne][oldIndexColonne]);
			plateau.setDisposition(oldIndexLigne, oldIndexColonne, null);
		} else {
			System.out.println("L'emplacement n'est pas libre");
		}
	}
		
	public void acceptVisitor() {
		
	}
	public String toString() {
		String maCarte = "";
		if (this == null) {
			maCarte = "___";
		} else {
			maCarte += String.valueOf(this.couleur.charAt(0)) + String.valueOf(this.forme.charAt(0)) + String.valueOf(this.remplissage.charAt(0));	
		}
		return maCarte;	
	}
}
