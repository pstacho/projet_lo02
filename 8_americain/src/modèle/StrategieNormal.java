package mod�le;

import java.util.Iterator;

/**
 * Classe StrategieNormal
 * 
 * D�finit la m�thode jouerCarte() si la difficult� de l'ordinateur et normale.
 * 
 * @author Stacho
 *
 */
public class StrategieNormal implements Strategie {

	/**
	 * M�thode qui d�finit la carte � jouer par Ordinateur.
	 * 
	 * @param ordi
	 *            Ordinateur qui utilise la m�thode.
	 * @param maManche
	 *            La manche en cours.
	 */
	@Override
	public void jouerCarte(Ordinateur ordi, Manche maManche) {
		// TODO Auto-generated method stub

		// On d�finit un boolean qui indique si la carte � jouer a �t� trouv�
		boolean trouverCarte = false;

		// On parcourt la main du joueur
		Iterator<Carte> it = ordi.mainJoueur.iterator();
		int indexCarteJouee = -1;

		while (!trouverCarte && it.hasNext()) {
			it.next();
			indexCarteJouee++;
			// si la carte peut �tre jou� on passe trouverCarte � vrai
			if (ordi.carteCompatible(maManche, ordi.mainJoueur.get(indexCarteJouee))) {
				trouverCarte = true;
			}
		}

		// Si aucune carte trouv�, l'ordi pioche
		if (!trouverCarte) {
			if (maManche.getCarteAPiocherAs() > 0) {
				Effet.piocherAS(maManche);
			} else {
				Carte cartePioche = maManche.getLaPioche().piocherCarte(maManche.getLeTalon());
				ordi.mainJoueur.add(cartePioche);
				System.out.println(ordi.nom + " pioche une carte.");
			}

			// Si une carte est trouv�, l'ordi joue la carte
		} else {
			Carte carteJouee = ordi.getMainJoueur().get(indexCarteJouee);
			System.out.println(ordi.nom + " a jou� la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, carteJouee);
			maManche.getLeTalon().ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}

	}

}
