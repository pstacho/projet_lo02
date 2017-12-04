package j8;

import java.util.Iterator;

public abstract class StrategieOrdinateur {
	
	public static int chosirCarteNormale(Ordinateur ordinateur, Manche maManche) {
		
		boolean trouverCarte = false;
		
		Iterator<Carte> it = ordinateur.mainJoueur.iterator();
		int indexCarteJouee = -1;
		while (!trouverCarte && it.hasNext()) {
				indexCarteJouee++;
				if (ordinateur.carteCompatible(maManche.getLeTalon(), ordinateur.mainJoueur.get(indexCarteJouee))) {
						trouverCarte = true;
				}	
		}
		return indexCarteJouee;
	}
	
	public static int choisirCarteDifficile() {
		return 2;
	}
}
