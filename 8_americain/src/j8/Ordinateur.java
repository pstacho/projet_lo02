package j8;

import java.util.Iterator;
import java.util.Scanner;

public class Ordinateur extends Joueur {

	private Scanner sc;
	private int difficultee;
	private Carte carteJouee;

	public Ordinateur(int indexBot, int difficultee) {

		super();
		/*sc = new Scanner(System.in);
		System.out.println("Saisisez le nom de l'Ordinateur " + (indiceJoueur - 1));
		nom = sc.nextLine();*/
		
		this.nom = "BOT" + indexBot;
		this.difficultee = difficultee;
		
			
	}

	public void jouerCarteOrdi(Talon leTalon, Pioche laPioche) {
		boolean trouverCarte = false;
		
		if (difficultee == 1) {
			Iterator<Carte> it = this.mainJoueur.iterator();
			int indexCarteJouee = -1;
			while (!trouverCarte && it.hasNext()) {
					indexCarteJouee++;
					mainJoueur.get(indexCarteJouee);
					if (carteCompatible(leTalon, mainJoueur.get(indexCarteJouee))) {
						trouverCarte = true;
				}
			}
			carteJouee = this.mainJoueur.get(indexCarteJouee);
			if (!carteCompatible(leTalon, carteJouee)) {
				Carte cartePioche = laPioche.piocherCarte();
				this.mainJoueur.add(cartePioche);
				System.out.println(this.nom + " pioche une carte.");
			} else {
				System.out.println(this.nom + " a joué la carte " + carteJouee.toString() + " .");
				leTalon.ajouterCarte(carteJouee);
				this.mainJoueur.remove(carteJouee);
			}
		}
	}
}
