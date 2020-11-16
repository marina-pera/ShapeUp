package PackageShapeUp;

public class PlateauRectangle extends Plateau {
	
	private Carte [][] disposition = {};
	
	public PlateauRectangle() {
		this.disposition = new Carte [5][7];
	}
	
	public boolean caseIsEmpty(int indexLigne, int indexColonne) {
		boolean caseLibre = true;
		if (this.getDisposition()[indexLigne][indexColonne] != null ) {
			caseLibre = false;
		}
		return caseLibre;
	}
	
	public void printDisposition() {
		this.centrer();
		for (int k=0; k<5; k++) {
			for (int i=0; i<7; i++) {
				if (disposition[k][i] != null) {
					System.out.print(disposition[k][i].toString() + " ");
				} else {
					System.out.print("___ ");
				}
			}
			System.out.println();
		}
	}
	
	public void setDisposition(int indexLigne, int indexColonne, Carte carte) {
		disposition[indexLigne][indexColonne] = carte;
	}
	
	public Carte [][] getDisposition() {
		return this.disposition;
	}
	
	public boolean plateauVide() {
			boolean vide = true;
			for (Carte [] ligne : this.disposition) {
				for (Carte carte : ligne) {
					if (carte != null) {
						vide = false;
					}
				}
			}
			return vide;
	}
	
	public Carte[][] copy(Carte[][] plateau) {
		Carte[][] terrain = new Carte [5][7];
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<7; j++) {
				terrain[i][j] = plateau[i][j];
			}
		}
		return terrain;
	}
	
	public boolean estPossible(int indexLigne, int indexColonne, Carte carte) {
		Carte[][] copiePlateau = null;
		copiePlateau = copy(this.getDisposition());
		boolean possible = true;
		copiePlateau[indexLigne][indexColonne] = carte;
		int minIndexLigne = 100;
		int maxIndexLigne = -1;
		int minIndexColonne = 100;
		int maxIndexColonne = -1;
		for (int i=0; i<copiePlateau.length; i++) {
			for (int j=0; j<copiePlateau[0].length;j++) {
				if (copiePlateau[i][j] != null) {
					if (i>maxIndexLigne) {
						maxIndexLigne = i;
					}
					if (j>maxIndexColonne) {
						maxIndexColonne = j;
					}
					if (i<minIndexLigne) {
						minIndexLigne = i;
					}
					if (j<minIndexColonne) {
						minIndexColonne = j;
					}
				}
			}
		}
		if (maxIndexColonne - minIndexColonne > 4 || maxIndexLigne - minIndexLigne > 2) {
			possible = false;
		}
		return possible;
	}
	
	public void centrer() {
		boolean isUp = false;
		boolean isDown = false;
		boolean isRight = false;
		boolean isLeft = false;
		for (Carte carte : this.getDisposition()[0]) {
			if (carte != null) {
				isUp = true;
			}
		}
		for (Carte carte : this.getDisposition()[this.getDisposition().length-1]) {
			if (carte != null) {
				isDown = true;
			}
		}
		for (int j=0; j<this.getDisposition().length-1; j++) {
			if (this.getDisposition()[j][0] != null) {
				isLeft = true;
			}
		}
		for (int j=0; j<this.getDisposition().length-1; j++) {
			if (this.getDisposition()[j][this.getDisposition()[0].length-1] != null) {
				isRight = true;
			}
		}
		if (isUp) {
			this.disposition[4] = this.disposition[3].clone();
			this.disposition[3] = this.disposition[2].clone();
			this.disposition[2] = this.disposition[1].clone();
			this.disposition[1] = this.disposition[0].clone();
			Carte nullCard = null;
			for (int k = 0; k<this.getDisposition()[0].length; k++) {
				this.disposition[0][k] = nullCard;
			}
		}
		if (isDown) {
			this.disposition[0] = this.disposition[1].clone();
			this.disposition[1] = this.disposition[2].clone();
			this.disposition[2] = this.disposition[3].clone();
			this.disposition[3] = this.disposition[4].clone();
			Carte nullCard = null;
			for (int k = 0; k<this.getDisposition()[0].length; k++) {
				this.disposition[4][k] = nullCard;
			}
		}
		if (isLeft) {
			for (int i = 0; i < this.getDisposition().length; i++) {
				for (int j = this.getDisposition()[0].length-1; j > 0; j--) {
					Carte tempValue = this.disposition[i][j-1];
					this.disposition[i][j] = tempValue;
				}
			}
			Carte nullCard = null;
			for (int k = 0; k<this.getDisposition().length; k++) {
				this.disposition[k][0] = nullCard;
			}
		}
		if (isRight) {
			for (int i = 0; i < this.getDisposition().length; i++) {
				for (int j = 1; j < this.getDisposition()[0].length; j++) {
					Carte tempValue = this.disposition[i][j];
					this.disposition[i][j-1] = tempValue;
				}
			}
			Carte nullCard = null;
			for (int k = 0; k<this.getDisposition().length; k++) {
				this.disposition[k][this.getDisposition()[0].length-1] = nullCard;
			}
		}
	}
	
}
