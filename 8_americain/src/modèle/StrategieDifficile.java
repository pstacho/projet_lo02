package modèle;

import java.util.ArrayList;

/**
 * @author Stacho
 *
 */
public class StrategieDifficile implements Strategie {

	/* (non-Javadoc)
	 * @see modèle.Strategie#jouerCarte(modèle.Ordinateur, modèle.Talon, modèle.Pioche, modèle.Manche)
	 */
	public void jouerCarte(Ordinateur ordi, Manche maManche) {

		ArrayList<Carte> carteJouable = new ArrayList<Carte>();

		for (int i = 0; i < ordi.mainJoueur.size(); i++) {
			if (ordi.carteCompatible(maManche, ordi.mainJoueur.get(i))) {
				carteJouable.add(ordi.mainJoueur.get(i));
			}
		}

		// S'il n'y a pas de cartes jouables l'ordi pioche
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
			ArrayList<Carte> cartesEffet = new ArrayList<Carte>(); // On regarde s'il y a des cartes à effet
			for (int i = 0; i < carteJouable.size(); i++) {
				if (!carteJouable.get(i).getEffet().equals("null")) {
					cartesEffet.add(carteJouable.get(i));
				}
			}

			// si la liste cartes à Effet n'est pas vide on cherche la carte qui a le plus
			// de point
			if (!cartesEffet.isEmpty()) {
				System.out.println("il a des cartes à effet");
				carteJouee = cartesEffet.get(trouverCartePlusForte(cartesEffet));
				// carteJouee = carteJouable.get(0);
			}
			// sinon on cherche la carte qui a le plus de point dans les cartes jouables
			else {
				System.out.println("il a pas de cartes à effet");
				carteJouee = carteJouable.get(trouverCartePlusForte(carteJouable));
			}
			System.out.println(ordi.nom + " a joué la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, carteJouee);
			maManche.getLeTalon().ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}
	}

	// méthode pour trouver la carte qui vaut le plus de point dans une liste de
	// carte
	/**
	 * @param cartes
	 * @return
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
