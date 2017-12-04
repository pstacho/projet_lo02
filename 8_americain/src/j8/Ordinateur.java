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

	public void jouerCarteOrdi(Manche maManche,Talon leTalon, Pioche laPioche) {
		//boolean trouverCarte = false;
		
		int numCarteJouee;
		if (difficultee == 1) {
			
			numCarteJouee = StrategieOrdinateur.chosirCarteNormale(this, maManche);
			/*Iterator<Carte> it = this.mainJoueur.iterator();
			int indexCarteJouee = -1;
			while (!trouverCarte && it.hasNext()) {
					indexCarteJouee++;
					mainJoueur.get(indexCarteJouee);
					if (carteCompatible(leTalon, mainJoueur.get(indexCarteJouee))) {
						trouverCarte = true;
				}
			}*/
		}else { numCarteJouee = 0; } // méthode jouer si difficultée difficile
		
		carteJouee = this.mainJoueur.get(numCarteJouee);
		
		Effet.checkEffetAvant(maManche, carteJouee);
		
		if (!carteCompatible(leTalon, carteJouee)) {
			Carte cartePioche = laPioche.piocherCarte();
			this.mainJoueur.add(cartePioche);
			System.out.println(this.nom + " pioche une carte.");
		} else {
			System.out.println(this.nom + " a joué la carte " + carteJouee.toString() + " .");
			
			Effet.checkEffetApres(maManche, laPioche, carteJouee);
			
			leTalon.ajouterCarte(carteJouee);
			this.mainJoueur.remove(carteJouee);
		}
	}

	public int getDifficultee() {
		return difficultee;
	}

	public void setDifficultee(int difficultee) {
		this.difficultee = difficultee;
	}

	public Carte getCarteJouee() {
		return carteJouee;
	}

	public void setCarteJouee(Carte carteJouee) {
		this.carteJouee = carteJouee;
	}
}
