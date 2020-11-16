package PackageShapeUp;

public class PlateauCroix extends Plateau {
	
	private Carte [][] disposition = {};
	
	public PlateauCroix() {
		this.disposition = new Carte [8][8];
	}
	
	public Carte[][] getDisposition() {
		Carte[][] tableau = new Carte[2][2];
		return tableau;
	};
	
	public void printDisposition() {
		for (int k=0; k<8; k++) {
			for (int i=0; i<8; i++) {
				if (disposition[k][i] != null) {
					System.out.print(disposition[k][i].toString() + " ");
				} else if ((k<2 && i<2) || (k<2 && i>5) || (k>5 && i<2) || (k>5 && i>5)) {
					System.out.print("    ");
				} else {
					System.out.print("___ ");
				}
			}
			System.out.println();
		}
	}
	
	public void setDisposition(int indexLigne, int indexColonne, Carte carte) {
		
	}
	
	public boolean caseIsEmpty(int indexLigne, int indexColonne) {
		return true;
	}
	
	public boolean plateauVide() {
		return true;
	}
	
	public boolean estPossible(int indexLigne, int indexColonne, Carte cartePiochee) {
		return true;
	}
	
}
