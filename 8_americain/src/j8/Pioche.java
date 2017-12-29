package j8;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

// Classe repr�sentant le paquet de carte qui constituera la pioche
public class Pioche {

	protected LinkedList<Carte> jeuDeCartes = new LinkedList<Carte>();

	// Cr�ation du jeu de cartes
	public Pioche(int nombreDeCartes) {
	
		
System.out.println("On joue avec "+nombreDeCartes + " cartes");

		if (nombreDeCartes == 52) {
			String[] couleur = new String[] { "Pique", "Tr�fle", "Coeur", "Carreau" };
			String[] valeur = new String[] { "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix",
					"Valet", "Dame", "Roi", "As" };
			int[] point = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

			for (int i = 0; i < couleur.length; i++) {
				for (int j = 0; j < valeur.length; j++) {
					Carte carte = new Carte(valeur[j], couleur[i], point[j]);
					this.jeuDeCartes.add(carte);
				}
			}
		}
		else {
			String[] couleur = new String[] { "Pique", "Tr�fle", "Coeur", "Carreau" };
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

	// M�lange les cartes du jeu de cartes
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

	// Permet de piocher la premi�re carte de la Pioche
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
