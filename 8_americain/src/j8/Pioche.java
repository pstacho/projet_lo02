package j8;

import java.util.LinkedList;
import java.util.Collections;

// Classe représentant le paquet de carte qui constituera la pioche
public class Pioche {

	protected LinkedList<Carte> jeuDeCartes = new LinkedList<Carte>();

	// Création du jeu de cartes
	public Pioche() {
		// TODO Auto-generated constructor stub

		String[] couleur = new String[] { "Pique", "Trèfle", "Coeur", "Carreau" };
		String[] valeur = new String[] { "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix",
				"Valet", "Dame", "Roi", "As" };

		for (int i = 0; i < couleur.length; i++) {
			for (int j = 0; j < valeur.length; j++) {
				Carte carte = new Carte(valeur[j], couleur[i]);
				this.jeuDeCartes.add(carte);
			}
		}
		

		Collections.shuffle(jeuDeCartes);
		/*
		 * int k=0; for(int i = 0; i < jeuDeCartes.size(); i++) {
		 * System.out.println(jeuDeCartes.get(i)); k++; } System.out.println(k);
		 */
	}

	public LinkedList<Carte> getJeuDeCartes() {
		return jeuDeCartes;
	}

	public void setJeuDeCartes(LinkedList<Carte> jeuDeCartes) {
		this.jeuDeCartes = jeuDeCartes;
	}

	// Mélange les cartes du jeu de cartes
	public void melanger() {
		Collections.shuffle(jeuDeCartes);
	}

	// Distribue les cartes aux joueurs
	public void distribuer() {

		for (int i = 0; i < Partie.getPartie().getNombreCarteJoueur(); i++) {
			for (int j = 0; j < (Partie.getPartie().getNombreOrdinateur() + 1); j++) {

				Partie.getPartie().listeJoueur.get(j).mainJoueur.add(this.jeuDeCartes.get(0));
				jeuDeCartes.remove(0);
			}
		}
	}

	// Permet de piocher la première carte de la Pioche
	public Carte piocherCarte() {
		Carte cartePioche = jeuDeCartes.getFirst();
		jeuDeCartes.removeFirst();
		return cartePioche;
	}
}
