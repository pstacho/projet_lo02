package mod�le;

import java.util.ArrayList;

public class StrategieDifficile implements Strategie{
	
	
	public void jouerCarte(Ordinateur ordi, Talon leTalon, Pioche laPioche, Manche maManche) {
	 
	ArrayList<Carte> carteJouable = new ArrayList<Carte>();
		
		
		for (int i = 0; i < ordi.mainJoueur.size(); i++) {
			if (ordi.carteCompatible(maManche, leTalon, ordi.mainJoueur.get(i))) {
				carteJouable.add(ordi.mainJoueur.get(i));
			}
		}
		
		// test pour voir les cartes qu'il peut jouer
		/*Iterator<Carte> itCarteJouable = carteJouable.iterator();
		while (itCarteJouable.hasNext()) {
			System.out.println(itCarteJouable.next());
		}*/
			
	
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
			System.out.println("il peut jouer une carte");
			Carte carteJouee;
			ArrayList<Carte> cartesEffet = new ArrayList<Carte>(); //On regarde s'il y a des cartes � effet
			for(int i = 0; i < carteJouable.size(); i++) {
				if( ! carteJouable.get(i).getEffet().equals("null")) {
					cartesEffet.add(carteJouable.get(i));
				}
			}
			
			// test pour voir les cartes � effet jouables
			/*Iterator itCartesEffet = cartesEffet.iterator();
			while (itCartesEffet.hasNext()) {
				System.out.println(itCartesEffet.next());
			}*/
			
			// si la liste cartes � Effet n'est pas vide on cherche la carte qui a le plus de point
			if(!cartesEffet.isEmpty()) {
				System.out.println("il a des cartes � effet");
				carteJouee = cartesEffet.get(trouverCartePlusForte(cartesEffet));
				//carteJouee = carteJouable.get(0);
			}
			//sinon on cherche la carte qui a le plus de point dans les cartes jouables
			else {
				System.out.println("il a pas de cartes � effet");
				carteJouee = carteJouable.get(trouverCartePlusForte(carteJouable));
			}
			System.out.println(ordi.nom + " a jou� la carte " + carteJouee.toString() + " .");
			Effet.checkEffetApres(maManche, laPioche, carteJouee);
			leTalon.ajouterCarte(carteJouee);
			ordi.getMainJoueur().remove(carteJouee);
		}
	}
	//m�thode pour trouver la carte qui vaut le plus de point dans une liste de carte
		public int trouverCartePlusForte(ArrayList<Carte> cartes) {
			int pointCarte = 0;
			int positionCarte = 0;
			System.out.println("coucou");
			for (int i = 0; i < cartes.size(); i++) {
				if(cartes.get(i).getPoint() > pointCarte){
					pointCarte = cartes.get(i).getPoint();
					positionCarte = i;
				}
			}
			return positionCarte;
		}		
		
}
