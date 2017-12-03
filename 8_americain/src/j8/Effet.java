package j8;

import java.util.Scanner;

public abstract class Effet {

	private static Scanner sc;

	public static void checkEffet(Manche maManche, Carte carteJouee) {
		
		if (carteJouee.getEffet().equals("permet de changer de couleur, se pose sur n'importe quelle carte")) {
				ChangerCouleur(carteJouee);
				Joker(carteJouee);
				
		} else if (carteJouee.getEffet().equals("oblige a rejouer")) {
			joueurRejouer(maManche);

		} else if (carteJouee.getEffet().equals("change le sens du jeu")) {
			changerSens(maManche);

		}
	}

	public static String ChangerCouleur(Carte carteJouee) {
		sc = new Scanner(System.in);
		String vraiCouleur = carteJouee.getCouleur();
		System.out.println("Choissisez la nouvelle couleur de la carte");
		System.out.println("\n 1: Pique");
		System.out.println("\n 2: Trèfle");
		System.out.println("\n 3: Coeur");
		System.out.println("\n 4: Carreau");
		String couleurProvisoire = sc.nextLine();
		carteJouee.setCouleur(couleurProvisoire);
		return vraiCouleur;
	}

	public static String Joker(Carte carteJouee) {
		String vraiCouleur = carteJouee.getCouleur();
		carteJouee.setCouleur("Joker");
		return vraiCouleur;
	}

	public static void joueurRejouer(Manche maManche) {
		System.out.println("Vous devez rejouer");
		maManche.setJoueurRejouer(true);
	}

	public static void changerSens(Manche maManche) {
		System.out.println("Le sens de jeu change");
		maManche.setSensPositif(!maManche.isSensPositif());
	}
}
