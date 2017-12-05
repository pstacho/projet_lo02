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
				if (ordi.carteCompatible(leTalon, ordi.mainJoueur.get(indexCarteJouee))) {
						trouverCarte = true;
				}	
		}
		
		if (indexCarteJouee == -1) {
		Carte cartePioche = laPioche.piocherCarte();
		ordi.mainJoueur.add(cartePioche);
		System.out.println(ordi.nom + " pioche une carte.");
		}
		else {
			Carte carteJouee = ordi.getMainJoueur().get(indexCarteJouee);
			Effet.checkEffetApres(maManche, laPioche, carteJouee);
			System.out.println(ordi.nom + " a joué la carte " + carteJouee.toString() + " .");
			leTalon.ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}
		
	}

}
