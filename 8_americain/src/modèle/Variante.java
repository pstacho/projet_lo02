package modèle;

import java.util.ArrayList;
import java.util.Scanner;

public class Variante {

	private String varianteEnCours;
	private Scanner sc;

	protected ArrayList<String> listeVariantes = new ArrayList<String>();

	public Variante() {

		this.varianteEnCours = Partie.getPartie().getVariante();
		// variantes trop chiantes : "1", des Ulis", "4", "6", normalement la variante 7
		// et ca aussi : /*"Jules", "Paradox Hech", "de l'us17", "par stratégie", "Rosa
		// l'injuste" */
		/*
		 * String[] nomVariante = new String[] { "Minimale", "de Monclar",
		 * "carte et maou", "man et resta", "5", "Courte Amicale (32 cartes)",
		 * "7 (32 cartes)" }; for (int i = 0; i < nomVariante.length; i++) { String
		 * variante = new String(nomVariante[i]); this.listeVariantes.add(variante); }
		 */
	}
	/*
	 * public void afficherChoixVariantes() {
	 * System.out.println("\nChoissisez votre Variante"); for (int i = 0; i <
	 * this.listeVariantes.size(); i++) { System.out.println((i + 1) +
	 * " : Variante " + listeVariantes.get(i));
	 * 
	 * } }
	 * 
	 * public void ChoisirVariante(Manche maManche) { sc = new Scanner(System.in);
	 * int indiceVarianteEnCours = (sc.nextInt() - 1); varianteEnCours =
	 * listeVariantes.get(indiceVarianteEnCours);
	 */

	// nouvelle version:

	public void setVariante(String VarianteEnCours, Manche maManche) {

		if (varianteEnCours.equals("variante6") || varianteEnCours.equals("variante7")) {
			maManche.setNombreDeCartes(32);
		} else {
			maManche.setNombreDeCartes(52);
		}

	System.out.println(VarianteEnCours);varianteEnCours=VarianteEnCours;

	}

	public void appliquerVariante(Pioche laPioche) {

		if (varianteEnCours.equals("variante1")) { // variante Minimale
			changerEffet(laPioche, "Huit", "permet de changer de couleur, se pose sur n'importe quelle carte");
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			System.out.println("fezubioefiofdsonjfsfsonpiopjsdfiodjfssionfdnofonivfonopfkfo");

		} else if (varianteEnCours.equals("variante2")) { // variante Monclar
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			changerEffet(laPioche, "Sept", "le joueur suivant passe son tour");
			changerEffet(laPioche, "Valet", "change le sens du jeu");
			changerEffet(laPioche, "Neuf", "fait piocher une carte au joueur suivant sans recours");
			changerEffet(laPioche, "As", "fait piocher 3 cartes au joueur suivant, à moins de poser un 8 ou un As");
			changerEffet(laPioche, "Huit", "permet de changer de couleur et arrête les attaques");

		} else if (varianteEnCours.equals("variante3")) { // variante carte et maou
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			changerEffet(laPioche, "Huit", "le joueur suivant passe son tour");
			changerEffet(laPioche, "Sept", "fait piocher 2 cartes au joueur suivant");
			changerEffet(laPioche, "Valet", "permet de changer de couleur, se pose sur n'importe quelle carte");

		} else if (varianteEnCours.equals("variante4")) { // variante 5
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			changerEffet(laPioche, "Sept", "change le sens du jeu");
			changerEffet(laPioche, "As", "fait piocher 2 cartes au joueur suivant, à moins de poser un 8 ou un As");
			changerEffet(laPioche, "Huit", "permet de changer de couleur et arrête les attaques");

		} else if (varianteEnCours.equals("variante7")) { // variante 7
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			changerEffet(laPioche, "Sept", "le joueur suivant passe son tour");
			changerEffet(laPioche, "Valet", "change le sens du jeu");
			changerEffet(laPioche, "As",
					"fait piocher 2 cartes au joueur suivant, à moins de poser un autre As qui s'ajoute pour le joueur suivant");
			changerEffet(laPioche, "Huit", "permet de changer de couleur, se pose sur n'importe quelle carte");
			changerEffetPlus(laPioche, "Dame", "Trèfle", "fait piocher 3 cartes au joueur suivant sans aucun recours");

		} else if (varianteEnCours.equals("variante6")) { // courte Amicale
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			changerEffet(laPioche, "Dame", "le joueur suivant passe son tour");
			changerEffet(laPioche, "Valet", "change le sens du jeu");
			changerEffet(laPioche, "As", "fait piocher 2 cartes au joueur suivant, à moins de poser un 8 ou un As");
			changerEffet(laPioche, "Huit", "permet de changer de couleur et arrête les attaques"); // J'ai fait que 2

		} else if (varianteEnCours.equals("variante5")) { // variante man et resa
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			changerEffet(laPioche, "Sept", "le joueur suivant passe son tour");
			changerEffet(laPioche, "Valet", "change le sens du jeu");
			changerEffet(laPioche, "As",
					"fait piocher 2 cartes au joueur suivant, à moins de poser un autre As qui s'ajoute pour le joueur suivant");
			changerEffet(laPioche, "Deux", "fait piocher 2 cartes au joueur suivant");

		}
	}

	public String getVarianteEnCours() {
		return varianteEnCours;
	}

	public void setVarianteEnCours(String varianteEnCours) {
		this.varianteEnCours = varianteEnCours;
	}

	public void changerEffet(Pioche laPioche, String valeur, String effet) { // on verifie la valeur de toute les Cartes
																				// du jeu
		for (int i = 0; i < laPioche.jeuDeCartes.size(); i++) { // Cela permet de changer de variante en cours de Jeu
			if (laPioche.jeuDeCartes.get(i).getValeur().equals(valeur)) {
				laPioche.jeuDeCartes.get(i).setEffet(effet);
			}
		}
	}

	// Il est très rare de voir des effets qui ne s'apllique qu'a une couleur
	// précise, dans ce cas on utilise cette methode plus complete
	public void changerEffetPlus(Pioche laPioche, String valeur, String couleur, String effet) {
		for (int i = 0; i < laPioche.jeuDeCartes.size(); i++) {
			if (laPioche.jeuDeCartes.get(i).getValeur().equals(valeur)
					&& laPioche.jeuDeCartes.get(i).getCouleur().equals(couleur)) {
				laPioche.jeuDeCartes.get(i).setEffet(effet);
			}
		}
	}
}