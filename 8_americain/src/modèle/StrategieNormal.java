package modèle;

import java.util.Iterator;

/**
 * Classe StrategieNormal
 * 
 * Définit la méthode jouerCarte() si la difficulté de l'ordinateur et normale.
 * 
 * @author Stacho
 *
 */
public class StrategieNormal implements Strategie {

	/**
	 * Méthode qui définit la carte à jouer par Ordinateur.
	 * 
	 * @param ordi
	 *            Ordinateur qui utilise la méthode.
	 * @param maManche
	 *            La manche en cours.
	 */
	@Override
	public void jouerCarte(Ordinateur ordi, Manche maManche) {
		// TODO Auto-generated method stub

		// On définit un boolean qui indique si la carte à jouer a été trouvé
		boolean trouverCarte = false;

		// On parcourt la main du joueur
		Iterator<Carte> it = ordi.mainJoueur.iterator();
		int indexCarteJouee = -1;

		while (!trouverCarte && it.hasNext()) {
			it.next();
			indexCarteJouee++;
			// si la carte peut être joué on passe trouverCarte à vrai
			if (ordi.carteCompatible(maManche, ordi.mainJoueur.get(indexCarteJouee))) {
				trouverCarte = true;
			}
		}

		// Si aucune carte trouvé, l'ordi pioche
		if (!trouverCarte) {
			if (maManche.getCarteAPiocherAs() > 0) {
				Effet.piocherAS(maManche);
			} else {
				Carte cartePioche = maManche.getLaPioche().piocherCarte(maManche.getLeTalon());
				ordi.mainJoueur.add(cartePioche);
				System.out.println(ordi.nom + " pioche une carte.");
			}

			// Si une carte est trouvé, l'ordi joue la carte
		} else {
			Carte carteJouee = ordi.getMainJoueur().get(indexCarteJouee);
			System.out.println(ordi.nom + " a joué la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, carteJouee);
			maManche.getLeTalon().ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}

	}

}
