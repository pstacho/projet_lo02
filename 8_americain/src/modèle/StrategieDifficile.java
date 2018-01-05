package modèle;

import java.util.ArrayList;
import java.util.Iterator;

public class StrategieDifficile implements Strategie {
	
	public void jouerCarte(Ordinateur ordi, Talon leTalon, Pioche laPioche, Manche maManche) {
		// TODO Auto-generated method stub
		
		ArrayList<Carte> carteJouable = new ArrayList<Carte>();
		Iterator<Carte> itMainOrdi = ordi.mainJoueur.iterator();
		while (itMainOrdi.hasNext()) {
			if(! itMainOrdi.next().getEffet().equals("null")) {
				carteJouable.add(itMainOrdi.next());
			}
		}
		
		if (! carteJouable.isEmpty()) {
	//		Carte carteJouee = carteJouable.get(Math.random());
		}
		
	}

}
