package mod�le;

import java.util.Iterator;

/**
 * @author Stacho
 *
 */
public class StrategieNormal implements Strategie {

	/* (non-Javadoc)
	 * @see mod�le.Strategie#jouerCarte(mod�le.Ordinateur, mod�le.Talon, mod�le.Pioche, mod�le.Manche)
	 */
	@Override
	public void jouerCarte(Ordinateur ordi, Manche maManche) {
		// TODO Auto-generated method stub

		boolean trouverCarte = false;

		Iterator<Carte> it = ordi.mainJoueur.iterator();
		int indexCarteJouee = -1;
		while (!trouverCarte && it.hasNext()) {
			it.next();
			indexCarteJouee++;
			if (ordi.carteCompatible(maManche, ordi.mainJoueur.get(indexCarteJouee))) {
				trouverCarte = true;
			}
		}

		if (!trouverCarte) {
			if (maManche.getCarteAPiocherAs() > 0) {
				Effet.piocherAS(maManche);
			} else {
				Carte cartePioche = maManche.getLaPioche().piocherCarte(maManche.getLeTalon());
				ordi.mainJoueur.add(cartePioche);
				System.out.println(ordi.nom + " pioche une carte.");
			}

		} else {
			Carte carteJouee = ordi.getMainJoueur().get(indexCarteJouee);
			System.out.println(ordi.nom + " a jou� la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, carteJouee);
			maManche.getLeTalon().ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}

	}

}
