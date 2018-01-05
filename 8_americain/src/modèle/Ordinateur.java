package modèle;

import java.util.Iterator;
import java.util.Scanner;

public class Ordinateur extends Joueur {

	private Scanner sc;
	private int difficultee;
	private Carte carteJouee;
	private Strategie strategie;

	public Ordinateur(int indexBot, int difficultee) {

		super();
		/*sc = new Scanner(System.in);
		System.out.println("Saisisez le nom de l'Ordinateur " + (indiceJoueur - 1));
		nom = sc.nextLine();*/
		
		this.nom = "BOT" + indexBot;
		this.difficultee = difficultee;
		if (difficultee == 1) {
			strategie = (Strategie) new StrategieNormal();
		}
			
	}

	public void jouerCarteOrdi(Manche maManche,Talon leTalon, Pioche laPioche) {
		
		
		strategie.jouerCarte(this, leTalon, laPioche, maManche);
		//boolean trouverCarte = false;
		
		
		/*int numCarteJouee;
		if (difficultee == 1) {
			
			numCarteJouee = StrategieOrdinateur.chosirCarteNormale(this, maManche);
		
		}else {
		
			numCarteJouee = 5; 
			// méthode jouer si difficultée difficile
		
		}
		
		
		if (numCarteJouee == -1) {
			
			Carte cartePioche = laPioche.piocherCarte();
			this.mainJoueur.add(cartePioche);
			System.out.println(this.nom + " pioche une carte.");
			
		} else {
			
			carteJouee = mainJoueur.get(numCarteJouee);
			Effet.checkEffetApres(maManche, laPioche, carteJouee);
			System.out.println(this.nom + " a joué la carte " + carteJouee.toString() + " .");
			leTalon.ajouterCarte(carteJouee);
			this.mainJoueur.remove(carteJouee);
		}
		Iterator<Carte> it = mainJoueur.iterator();// test pour voir la main du bot
		while ( it.hasNext()) {
			System.out.println(it.next());
		}*/
		
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
