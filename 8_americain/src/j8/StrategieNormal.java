package j8;

import java.util.Iterator;

public class StrategieNormal implements Strategie{

	@Override
	public void jouerCarte(Ordinateur ordi, Talon leTalon, Pioche laPioche, Manche maManche) {
		// TODO Auto-generated method stub
		
		boolean trouverCarte = false;
		
		Iterator<Carte >it = ordi.mainJoueur.iterator();
		int indexCarteJouee = -1;
		while (!trouverCarte && it.hasNext()) {
				it.next();
				indexCarteJouee++;
				if (ordi.carteCompatible(maManche, leTalon, ordi.mainJoueur.get(indexCarteJouee))) {
						trouverCarte = true;
				}
		}
		
		if (!trouverCarte) {
			if (maManche.getCarteAPiocherAs() > 0) {
				Effet.piocherAS(maManche,laPioche);
			} else {
				Carte cartePioche = laPioche.piocherCarte(leTalon);
				ordi.mainJoueur.add(cartePioche);
				System.out.println(ordi.nom + " pioche une carte.");
			}
			
			
			
		
		}
		else {
			Carte carteJouee = ordi.getMainJoueur().get(indexCarteJouee);
			System.out.println(ordi.nom + " a joué la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, laPioche, carteJouee);
			leTalon.ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}
		
	}

}
