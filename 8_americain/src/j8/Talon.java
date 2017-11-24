package j8;

import java.util.ArrayList;

public class Talon {
	
	private Carte carteDessus;
	private ArrayList<Carte> carteDessous;

	public Talon(Pioche pioche) {
		carteDessus = pioche.piocherCarte();
		carteDessous = new ArrayList<Carte>();
		carteDessous.add(carteDessus);
	}
	

	public Carte getCarteDessus() {
		return carteDessus;
	}


	public void setCarteDessus(Carte carteDessus) {
		this.carteDessus = carteDessus;
	}


	public void afficherCarteDessus() {
		System.out.println("Carte du Talon : "+ carteDessus.toString());
	}
}
