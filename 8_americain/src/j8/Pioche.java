package j8;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

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
	
	public void attribuerPointCarte() {
		Iterator<Carte> it = jeuDeCartes.iterator();
		while (it.hasNext()) {
			if (it.next().getEffet().equals("null")) {
				if (it.next().getValeur() == "Neuf"){
					it.next().setPoint(9);
				}
				else if (it.next().getValeur() == "Six") {
					it.next().setPoint(6);
				}
				else if (it.next().getValeur() == "Cinq") {
					it.next().setPoint(5);
				}
				else if (it.next().getValeur() == "Quatre") {
					it.next().setPoint(4);
				}
				else if (it.next().getValeur() == "Trois") {
					it.next().setPoint(3);
				}
			}else if (! it.next().getEffet().equals("null")){
				if (it.next().getValeur() == "As" || it.next().getValeur() == "8" ) {
					it.next().setPoint(50);
				}
				else {it.next().setPoint(20);}
			}
		}
	}
	public void attribuerPointCarte2() {
		for (int i = 0; i < jeuDeCartes.size(); i++) {
			Carte carte = jeuDeCartes.get(i);
			if (carte.getEffet().equals("null")) {
				if (carte.getValeur() == "Neuf"){
					carte.setPoint(9);
				}
				else if (carte.getValeur() == "Six") {
					carte.setPoint(6);
				}
				else if (carte.getValeur() == "Cinq") {
					carte.setPoint(5);
				}
				else if (carte.getValeur() == "Quatre") {
					carte.setPoint(4);
				}
				else if (carte.getValeur() == "Trois") {
					carte.setPoint(3);
				}
			}else if (! carte.getEffet().equals("null")){
				if (carte.getValeur() == "As" || carte.getValeur() == "8" ) {
					carte.setPoint(50);
				}
				else {carte.setPoint(20);}
			}
			
		}
		
	}
	
}
