package PackageShapeUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {
	
	public List<Carte> pioche = new ArrayList<>();
	private static Pioche instance = null;
	private static Plateau plateau;
	
	private Pioche(Plateau plateau) {
		String [] tableCouleur = {"bleu", "vert", "rouge"};
		String [] tableForme = {"rond", "carré", "triangle"};
		String [] tableRemplissage = {"vide", "rempli"};
		this.plateau = plateau;
		Carte c1 = new Carte(tableCouleur[0], tableForme[0], tableRemplissage[0], plateau);
		Carte c2 = new Carte(tableCouleur[0], tableForme[0], tableRemplissage[1], plateau);
		Carte c3 = new Carte(tableCouleur[0], tableForme[1], tableRemplissage[0], plateau);
		Carte c4 = new Carte(tableCouleur[0], tableForme[1], tableRemplissage[1], plateau);
		Carte c5 = new Carte(tableCouleur[0], tableForme[2], tableRemplissage[0], plateau);
		Carte c6 = new Carte(tableCouleur[0], tableForme[2], tableRemplissage[1], plateau);
		Carte c7 = new Carte(tableCouleur[1], tableForme[0], tableRemplissage[0], plateau);
		Carte c8 = new Carte(tableCouleur[1], tableForme[0], tableRemplissage[1], plateau);
		Carte c9 = new Carte(tableCouleur[1], tableForme[1], tableRemplissage[0], plateau);
		Carte c10 = new Carte(tableCouleur[1], tableForme[1], tableRemplissage[1], plateau);
		Carte c11 = new Carte(tableCouleur[1], tableForme[2], tableRemplissage[0], plateau);
		Carte c12 = new Carte(tableCouleur[1], tableForme[2], tableRemplissage[1], plateau);
		Carte c13 = new Carte(tableCouleur[2], tableForme[0], tableRemplissage[0], plateau);
		Carte c14 = new Carte(tableCouleur[2], tableForme[0], tableRemplissage[1], plateau);
		Carte c15 = new Carte(tableCouleur[2], tableForme[1], tableRemplissage[0], plateau);
		Carte c16 = new Carte(tableCouleur[2], tableForme[1], tableRemplissage[1], plateau);
		Carte c17 = new Carte(tableCouleur[2], tableForme[2], tableRemplissage[0], plateau);
		Carte c18 = new Carte(tableCouleur[2], tableForme[2], tableRemplissage[1], plateau);
		this.pioche.add(c1);
		this.pioche.add(c2);
		this.pioche.add(c3);
		this.pioche.add(c4);
		this.pioche.add(c5);
		this.pioche.add(c6);
		this.pioche.add(c7);
		this.pioche.add(c8);
		this.pioche.add(c9);
		this.pioche.add(c10);
		this.pioche.add(c11);
		this.pioche.add(c12);
		this.pioche.add(c13);
		this.pioche.add(c14);
		this.pioche.add(c15);
		this.pioche.add(c16);
		this.pioche.add(c17);
		this.pioche.add(c18);
		Collections.shuffle(pioche);
	}
	
	public static Pioche getInstance(Plateau plateau) {
		if (instance == null) {
			instance = new Pioche(plateau);
		}
		return instance;
	}
	
	public Carte piocher() {
		Carte carte = this.pioche.get(0);
		pioche.remove(0);
		return carte;
	}
	
	public int size() {
		int length = 0;
		length = pioche.size();
		return length;
	}
	
}
