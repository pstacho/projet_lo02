package modèle;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Classe qui représente la pioche d'une manche de jeu.
 * 
 * La pioche est caractérisée par les informations suivantes : jeuDeCartes qui
 * représente les cartes contenues dans la pioche. On utilise un LinkedList pour
 * jeuDeCartes afin de récupérer les cartes dans l'ordre où elles sont placées.
 * 
 * @author Stacho
 *
 */
public class Pioche {

	/**
	 * La liste des cartes qui constitue la pioche.
	 */
	protected LinkedList<Carte> jeuDeCartes = new LinkedList<Carte>();

	/**
	 * Constructeur de la classe Pioche.
	 * 
	 * @param nombreDeCartes
	 *            Le nombre de cartes dans la pioche.
	 */
	public Pioche(int nombreDeCartes) {

		System.out.println("On joue avec " + nombreDeCartes + " cartes");

		// dans le cas où il y a 52 cartes
		if (nombreDeCartes == 52) {
			String[] couleur = new String[] { "Pique", "Trefle", "Coeur", "Carreau" };
			String[] valeur = new String[] { "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix",
					"Valet", "Dame", "Roi", "As" };
			int[] point = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

			for (int i = 0; i < couleur.length; i++) {
				for (int j = 0; j < valeur.length; j++) {
					Carte carte = new Carte(valeur[j], couleur[i], point[j]);
					this.jeuDeCartes.add(carte);
				}
			}
			// Sinon une pioche de 32 cartes est créée
		} else {
			String[] couleur = new String[] { "Pique", "Trefle", "Coeur", "Carreau" };
			String[] valeur = new String[] { "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi", "As" };
			int[] point = new int[] { 7, 8, 9, 10, 11, 12, 13, 14 };

			for (int i = 0; i < couleur.length; i++) {
				for (int j = 0; j < valeur.length; j++) {
					Carte carte = new Carte(valeur[j], couleur[i], point[j]);
					this.jeuDeCartes.add(carte);
				}
			}
		}

		melanger();
	}

	/**
	 * Retourne la liste des cartes {@link jeuDeCartes} dans la pioche.
	 * 
	 * @return La valeur de jeuDeCartes.
	 */
	public LinkedList<Carte> getJeuDeCartes() {
		return jeuDeCartes;
	}

	/**
	 * Met à jour la liste des cartes {@link jeuDeCartes} dans la pioche.
	 * 
	 * @param jeuDeCartes
	 *            La nouvelle valeur de jeuDeCartes.
	 */
	public void setJeuDeCartes(LinkedList<Carte> jeuDeCartes) {
		this.jeuDeCartes = jeuDeCartes;
	}

	/**
	 * Méthode qui mélange jeuDeCartes.
	 */
	public void melanger() {
		Collections.shuffle(jeuDeCartes);
	}

	/**
	 * Méthode qui permet de distribuer les cartes de la pioche aux différents
	 * joueurs.
	 */
	public void distribuer() {
		System.out.println("on distribue");
		for (int i = 0; i < Partie.getPartie().getNombreCarteJoueur(); i++) {
			for (int j = 0; j < (Partie.getPartie().getNombreOrdinateur() + 1); j++) {

				Partie.getPartie().listeJoueurs.get(j).mainJoueur.add(this.jeuDeCartes.get(0));
				jeuDeCartes.remove(0);
			}
		}
	}

	// Permet de piocher la première carte de la Pioche
	/**
	 * Méthode qui permet de piocher la première carte de la pioche. La carte est
	 * retourné par la méthode et est supprimé de la pioche. Si la pioche est vide,
	 * on remet les cartes du talon dans la pioche
	 * {@link Talon.remettreCartePioche()}.
	 * 
	 * @param leTalon
	 *            Le talon de la manche en cours.
	 * @return La carte piochée.
	 */
	public Carte piocherCarte(Talon leTalon) {
		if (!jeuDeCartes.isEmpty()) {
			Carte cartePioche = jeuDeCartes.getFirst();
			jeuDeCartes.removeFirst();
			return cartePioche;
		} else {
			leTalon.remettreCartePioche(this);
			Carte cartePioche = jeuDeCartes.getFirst();
			jeuDeCartes.removeFirst();
			return cartePioche;
		}

	}

	/**
	 * Méthode qui attribue les points aux cartes dans la pioche.
	 * 
	 */
	public void attribuerPointCarte() {
		Iterator<Carte> it = jeuDeCartes.iterator();
		while (it.hasNext()) {
			Carte carteEnCours = it.next();
			if (!carteEnCours.getEffet().equals("null")) {
				if (carteEnCours.getValeur() == "As" || carteEnCours.getValeur() == "8") {
					carteEnCours.setPoint(50);
				} else {
					carteEnCours.setPoint(20);
				}
			}
		}
	}
}
