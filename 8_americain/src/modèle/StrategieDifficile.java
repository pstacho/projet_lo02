package modèle;

import java.util.ArrayList;
import java.util.Iterator;

public class StrategieDifficile implements Strategie {
	
	public void jouerCarte(Ordinateur ordi, Talon leTalon, Pioche laPioche, Manche maManche) {
	 
	ArrayList<Carte> carteJouable = new ArrayList<Carte>();
		
		Iterator<Carte> itMainOrdi = ordi.mainJoueur.iterator();
		while (itMainOrdi.hasNext()) {
			if (ordi.carteCompatible(maManche, leTalon, itMainOrdi.next())) {
				carteJouable.add(itMainOrdi.next());
			}
		}
		 // S'il n'y a pas de cartes jouables l'ordi pioche
		if (carteJouable.isEmpty()) {
			if (maManche.getCarteAPiocherAs() > 0) {
				Effet.piocherAS(maManche,laPioche);
			} else {
				Carte cartePioche = laPioche.piocherCarte(leTalon);
				ordi.mainJoueur.add(cartePioche);
				System.out.println(ordi.nom + " pioche une carte.");
			}
		}
		// il y a des cartes jouables
		else {
			Carte carteJouee;
			ArrayList<Carte> cartesEffet = new ArrayList<Carte>(); //On regarde s'il y a des cartes à effet
			for(int i = 0; i < carteJouable.size(); i++) {
				if(! carteJouable.get(i).getEffet().equals(null)) {
					cartesEffet.add(carteJouable.get(i));
				}
			}
			// si la liste cartes à Effet n'est pas vide on cherche la carte qui a le plus de point
			if(! cartesEffet.isEmpty()) {
				carteJouee = cartesEffet.get(trouverCartePlusForte(cartesEffet));
			}
			//sinon on cherche la carte qui a le plus de point dans les cartes jouables
			else {
				carteJouee = carteJouable.get(trouverCartePlusForte(carteJouable));
			}
			System.out.println(ordi.nom + " a joué la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, laPioche, carteJouee);
			leTalon.ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}
	}
	//méthode pour trouver la carte qui vaut le plus de point dans une liste de carte
		public int trouverCartePlusForte(ArrayList<Carte> cartes) {
			int pointCarte = 0;
			for (int i = 0; i < cartes.size(); i++) {
				if(cartes.get(i).getPoint() > pointCarte){
					pointCarte = cartes.get(i).getPoint();
				}
			}
			return pointCarte;
		}
}
