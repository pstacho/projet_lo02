package j8;

import java.util.Iterator;

public abstract class StrategieOrdinateur {
	
	public static int chosirCarteNormale(Ordinateur ordinateur, Manche maManche) {
		
		boolean trouverCarte = false;
		
		Iterator<Carte >it = ordinateur.mainJoueur.iterator();
		int indexCarteJouee = -1;
		while (!trouverCarte && it.hasNext()) {
				indexCarteJouee++;
				
				if (ordinateur.carteCompatible(maManche.getLeTalon(), ordinateur.mainJoueur.get(indexCarteJouee))) {
						trouverCarte = true;
				}	
		}
		
		if (trouverCarte == false) {
			indexCarteJouee = -1; // ne pas mettre 0
		}
		return indexCarteJouee;
	}
	
	public static int choisirCarteDifficile(Ordinateur ordinateur) {
		Iterator<Carte> it = ordinateur.mainJoueur.iterator();
		return 2;
	}
}
