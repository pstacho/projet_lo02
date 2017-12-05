package j8;

import java.util.Iterator;
import java.util.LinkedList;

public class Talon {

	private Carte carteDessus;
	private LinkedList<Carte> cartesTalon;

	public Talon(Pioche pioche) {
		carteDessus = pioche.piocherCarte(this);
		cartesTalon = new LinkedList<Carte>();
		cartesTalon.add(carteDessus);
	}

	public Carte getCarteDessus() {
		return carteDessus;
	}

	public void setCarteDessus(Carte carteDessus) {
		this.carteDessus = carteDessus;
	}

	// Affiche la carte sur le dessu du Talon
	public void afficherCarteDessus() {
		System.out.println("Carte du Talon : " + carteDessus.toString());
	}

	// Change la carte du dessus du talon
	public void ajouterCarte(Carte carteJouee) {
		cartesTalon.add(carteJouee);
		setCarteDessus(carteJouee);

	}
	
	public void remettreCartePioche(Pioche pioche) {
		Iterator<Carte> itCartesTalon = cartesTalon.iterator();
		while (itCartesTalon.hasNext()) {
			pioche.jeuDeCartes.addFirst(itCartesTalon.next());
		}
		cartesTalon.clear();
	}
}
