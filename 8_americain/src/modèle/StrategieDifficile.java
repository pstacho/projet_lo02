package mod�le;

import java.util.ArrayList;

/**
 * Classe StrategieDifficile qui impl�mente l'interface Strategie. D�finit la
 * m�thode jouerCarte si la difficult� de Ordinateur est diff�rent de 1.
 * 
 * @author Stacho
 *
 */
public class StrategieDifficile implements Strategie {

	/**
	 * M�thode qui d�finit la carte � jouer par Ordinateur.
	 * 
	 * @param ordi
	 *            Ordinateur qui utilise la m�thode.
	 * @param maManche
	 *            La manche en cours.
	 */
	public void jouerCarte(Ordinateur ordi, Manche maManche) {
		// cr�ation d'un ArrayList qui contient les cartes qui peuvent �tre jou�es.
		ArrayList<Carte> carteJouable = new ArrayList<Carte>();

		// On parcours la liste, si la carte peut �tre jou�e, on l'ajoute �
		// carteJouable.
		for (int i = 0; i < ordi.mainJoueur.size(); i++) {
			if (ordi.carteCompatible(maManche, ordi.mainJoueur.get(i))) {
				carteJouable.add(ordi.mainJoueur.get(i));
			}
		}

		// S'il n'y a pas de cartes jouables l'ordinateur pioche
		if (carteJouable.isEmpty()) {
			if (maManche.getCarteAPiocherAs() > 0) {
				Effet.piocherAS(maManche);
			} else {
				Carte cartePioche = maManche.getLaPioche().piocherCarte(maManche.getLeTalon());
				ordi.mainJoueur.add(cartePioche);
				System.out.println(ordi.nom + " pioche une carte.");
			}
		}
		// il y a des cartes jouables
		else {
			System.out.println("il peut jouer une carte");
			Carte carteJouee;
			// On cr��e une liste carteEffet
			ArrayList<Carte> cartesEffet = new ArrayList<Carte>();
			// On regarde s'il y a des cartes � effet et on les ajoute � cartesEffet
			for (int i = 0; i < carteJouable.size(); i++) {
				if (!carteJouable.get(i).getEffet().equals("null")) {
					cartesEffet.add(carteJouable.get(i));
				}
			}

			// si la liste cartes � Effet n'est pas vide on cherche la carte qui a le plus
			// de point
			if (!cartesEffet.isEmpty()) {
				System.out.println("il a des cartes � effet");
				carteJouee = cartesEffet.get(trouverCartePlusForte(cartesEffet));
				// carteJouee = carteJouable.get(0);
			}
			// sinon on cherche la carte qui a le plus de point dans les cartes jouables
			else {
				System.out.println("il a pas de cartes � effet");
				carteJouee = carteJouable.get(trouverCartePlusForte(carteJouable));
			}
			System.out.println(ordi.nom + " a jou� la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, carteJouee);
			maManche.getLeTalon().ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}
	}

	// m�thode pour trouver la carte qui vaut le plus de point dans une liste de
	// carte
	/**
	 * M�thode qui permet de trouver la carte qui � la plus grande valeur de points
	 * dans une liste de cartes. Retourne la position de cette carte.
	 * 
	 * @param cartes
	 *            Une liste de cartes.
	 * @return Un entier qui repr�sente la position de la carte dans la liste.
	 */
	public int trouverCartePlusForte(ArrayList<Carte> cartes) {
		int pointCarte = 0;
		int positionCarte = 0;
		System.out.println("coucou");
		for (int i = 0; i < cartes.size(); i++) {
			if (cartes.get(i).getPoint() > pointCarte) {
				pointCarte = cartes.get(i).getPoint();
				positionCarte = i;
			}
		}
		return positionCarte;
	}

}
