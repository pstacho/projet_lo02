package modèle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

/**
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class Talon extends Observable {

	/**
	 * 
	 */
	private Carte carteDessus;
	/**
	 * 
	 */
	private LinkedList<Carte> cartesTalon;

	/**
	 * @param pioche
	 */
	public Talon(Pioche pioche) {
		carteDessus = pioche.piocherCarte(this);
		cartesTalon = new LinkedList<Carte>();
		cartesTalon.add(carteDessus);
	}

	/**
	 * @return
	 */
	public Carte getCarteDessus() {
		return carteDessus;
	}

	/**
	 * @param carteDessus
	 */
	public void setCarteDessus(Carte carteDessus) {
		this.carteDessus = carteDessus;
	}

	// Affiche la carte sur le dessu du Talon
	/**
	 * 
	 */
	public void afficherCarteDessus() {
		System.out.println("Carte du Talon : " + carteDessus.toString());
	}

	// Change la carte du dessus du talon
	/**
	 * @param carteJouee
	 */
	public void ajouterCarte(Carte carteJouee) {
		cartesTalon.add(carteJouee);
		setCarteDessus(carteJouee);

	}

	/**
	 * @param pioche
	 */
	public void remettreCartePioche(Pioche pioche) {

		Iterator<Carte> itCartesTalon = cartesTalon.iterator();
		while (itCartesTalon.hasNext()) {

			// dans le cas des effets qui permettent de changer la couleur d'une carte, on
			// remet sa vraie couleur a la carte
			if (cartesTalon.getFirst().isJoker() == true) {
				cartesTalon.getFirst().setCouleur(cartesTalon.getFirst().getVraiCouleur());
			}

			pioche.jeuDeCartes.addFirst(itCartesTalon.next());
		}
		cartesTalon.clear();
	}
}
