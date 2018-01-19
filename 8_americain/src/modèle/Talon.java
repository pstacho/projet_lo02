package modèle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Classe qui représente le talon d'une manche. Le talon est caractérisé par :
 * La carte du dessus, c'est la carte visible par les joueurs Une liste de carte
 * qui représente les cartes du talon
 * 
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class Talon extends Observable {

	/**
	 * La carte du dessus du talon, celle visible par les joueurs.
	 */
	private Carte carteDessus;
	/**
	 * La liste des cartes que contient le talon.
	 */
	private LinkedList<Carte> cartesTalon;

	/**
	 * Constructeur du talon. On récupère la première carte de la pioche pour
	 * constituer le tallon.
	 * 
	 * @param pioche
	 */
	public Talon(Pioche pioche) {
		carteDessus = pioche.piocherCarte(this);
		cartesTalon = new LinkedList<Carte>();
		cartesTalon.add(carteDessus);
	}

	/**
	 * Retourne la carte du dessus.
	 * 
	 * @return La carte du dessus.
	 */
	public Carte getCarteDessus() {
		return carteDessus;
	}

	/**
	 * Met à jour la carte du dessus du talon.
	 * 
	 * @param carteDessus
	 *            La nouvelle carte du dessus.
	 */
	public void setCarteDessus(Carte carteDessus) {
		this.carteDessus = carteDessus;
	}

	/**
	 * Affiche la carte du dessus dans la console.
	 */
	public void afficherCarteDessus() {
		System.out.println("Carte du Talon : " + carteDessus.toString());
	}

	/**
	 * Méthode qui change la carte du dessus du talon par la carte qui vient d'être
	 * jouée.
	 * 
	 * @param carteJouee
	 *            La carte qui vient d'être jouée.
	 */
	public void ajouterCarte(Carte carteJouee) {
		cartesTalon.add(carteJouee);
		setCarteDessus(carteJouee);

	}

	/**
	 * Méthode qui permet de vider le talon et de remettre les cartes dans la
	 * pioche. On garde seulement la carte du dessus.
	 * 
	 * @param pioche
	 *            La pioche de la manche.
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
