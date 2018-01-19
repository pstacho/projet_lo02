package modèle;

import java.util.ArrayList;

/**
 * Classe qui représente la variante. Elle est caractérisé par son nom. Elle
 * applique les effets aux cartes en focntion de sa valeur.
 * 
 * @author Stacho
 *
 */
public class Variante {

	/**
	 * La variante en cours dans la partie.
	 */
	private String varianteEnCours;
	/**
	 * La liste des variantes possibles pour la partie.
	 */
	protected ArrayList<String> listeVariantes = new ArrayList<String>();

	/**
	 * Constructeur de la variante. Récupère la variante de la partie.
	 */
	public Variante() {

		this.varianteEnCours = Partie.getPartie().getVariante();

	}

	/**
	 * Méthode qui détermine le nombre de cartes avec lesquelles joués en fonction
	 * de la variante de la partie.
	 * 
	 * @param VarianteEnCours
	 *            La variante de la partie.
	 * 
	 * @param maManche
	 *            La manche en cours.
	 */
	public void setVariante(String VarianteEnCours, Manche maManche) {

		if (varianteEnCours.equals("variante6") || varianteEnCours.equals("variante7")) {
			maManche.setNombreDeCartes(32);
		} else {
			maManche.setNombreDeCartes(52);
		}

		System.out.println(VarianteEnCours);
		varianteEnCours = VarianteEnCours;

	}

	/**
	 * Méthode qui applique la variante de la partie. Affecte les effets des cartes
	 * dans la pioche de la manche.
	 * 
	 * @param laPioche
	 *            La pioche de la manche.
	 */
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

	/**
	 * Méthode qui affecte le nom des effets aux cartes de la pioche qui ont la
	 * valeur renseigné en paramètre.
	 * 
	 * @param laPioche
	 *            La pioche de la manche.
	 * @param valeur
	 *            La valeur de la carte à qui on attribue l'effet.
	 * @param effet
	 *            L'effet à appliquer à la carte.
	 * 
	 */
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
	/**
	 * Méthode qui applique l'effet à une carte spécifique. On renseigne en
	 * paramètres la valeur de la carte mais également sa couleur.
	 * 
	 * @param laPioche
	 *            La pioche de la manche.
	 * @param valeur
	 *            La valeur de la carte à qui on attribue l'effet.
	 * @param couleur
	 *            La couleur de la carte à qui on attribue l'effet.
	 * @param effet
	 *            L'effet à attribuer à la carte.
	 */
	public void changerEffetPlus(Pioche laPioche, String valeur, String couleur, String effet) {
		for (int i = 0; i < laPioche.jeuDeCartes.size(); i++) {
			if (laPioche.jeuDeCartes.get(i).getValeur().equals(valeur)
					&& laPioche.jeuDeCartes.get(i).getCouleur().equals(couleur)) {
				laPioche.jeuDeCartes.get(i).setEffet(effet);
			}
		}
	}
}