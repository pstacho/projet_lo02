package j8;

import java.util.Scanner;

public abstract class Effet {

	private static Scanner sc;

	public static void checkEffetAvant(Manche maManche, Carte carteJouee) {

		if (carteJouee.getEffet().equals("permet de changer de couleur, se pose sur n'importe quelle carte")) {
			Joker(carteJouee);

		}
	}

	public static void checkEffetApres(Manche maManche, Pioche laPioche, Carte carteJouee) {

		if (carteJouee.getEffet().equals("permet de changer de couleur, se pose sur n'importe quelle carte")) {
			ChangerCouleur(carteJouee);
		} else if (carteJouee.getEffet().equals("oblige a rejouer")) {

			joueurRejouer(maManche);

		} else if (carteJouee.getEffet().equals("change le sens du jeu")) {
			changerSens(maManche);

		} else if (carteJouee.getEffet().equals("permet de changer de couleur et arrête les attaques")) {
			ChangerCouleur(carteJouee);
		} else if (carteJouee.getEffet().equals("le joueur suivant passe son tour")) {
			joueurPasseSonTour(maManche);
		} else if (carteJouee.getEffet().equals("fait piocher une carte au joueur suivant sans recours")) {
			fairePiocherCartes(maManche, laPioche, 1);
		} else if (carteJouee.getEffet().equals("fait piocher 3 cartes au joueur suivant, à moins de poser un 8 ou un As")) {
			fairePiocherCartes(maManche, laPioche, 3);
		}

	}

	public static String ChangerCouleur(Carte carteJouee) {
		sc = new Scanner(System.in);
		String[] couleur = new String[] { "Pique", "Trèfle", "Coeur", "Carreau" };
		String vraiCouleur = carteJouee.getCouleur();
		System.out.println("Choissisez la nouvelle couleur de la carte");

		for (int i = 0; i < couleur.length; i++) {
			System.out.println((i + 1) + " : " + couleur[i]);
		}
		int numCouleurProvisoire = sc.nextInt();
		String couleurProvisoire = couleur[numCouleurProvisoire - 1];
		carteJouee.setCouleur(couleurProvisoire);
		return vraiCouleur;
	}

	public static String Joker(Carte carteJouee) {
		String vraiCouleur = carteJouee.getCouleur();
		carteJouee.setCouleur("Joker");
		return vraiCouleur;
	}

	public static void joueurRejouer(Manche maManche) {
		System.out.println(maManche.getJoueurEnCours().nom + " doit rejouer");
		maManche.setJoueurRejouer(true);
	}

	public static void changerSens(Manche maManche) {
		System.out.println("Le sens de jeu change");
		maManche.setSensPositif(!maManche.isSensPositif());
	}

	public static void joueurPasseSonTour(Manche maManche) {
		maManche.joueurSuivant();
		System.out.println(maManche.getJoueurEnCours().nom + " passe son tour");
	}

	public static void fairePiocherCartes(Manche maManche, Pioche laPioche, int nombreCarteAPiocher) {
		for (int i = 0; i < nombreCarteAPiocher; i++) {
			maManche.joueurSuivant();
			System.out.println(maManche.getJoueurEnCours().nom + " doit piocher " + nombreCarteAPiocher + " carte(s)");
			Carte cartePiochee = laPioche.piocherCarte();
			Partie.getPartie().getListeJoueur().get(maManche.getIndiceJoueurEnCours() + 1).mainJoueur.add(cartePiochee);
			if (Partie.getPartie().getListeJoueur().get(maManche.getIndiceJoueurEnCours()) instanceof JoueurPhysique) {
				System.out.println("Vous avez pioché la carte " + cartePiochee.toString() + " .");
			}
			maManche.setJoueurRejouer(true); // on a sauter un tour artificiellement donc on reprend l'ordre normal
		}

	}
	/*public static void fairePiocherCartesAvecRecours(Manche maManche, Pioche laPioche, int nombreCarteAPiocher) {
		
			maManche.joueurSuivant();
			System.out.println(maManche.getJoueurEnCours().nom + " doit piocher " + nombreCarteAPiocher + " carte(s), sauf si il pose un As ou une carte qui annule les attaques");
			int CarteAPiocher=nombreCarteAPiocher;
			for (int i = 0; i < nombreCarteAPiocher; i++) {
			Carte cartePiochee = laPioche.piocherCarte();
			Partie.getPartie().getListeJoueur().get(maManche.getIndiceJoueurEnCours() + 1).mainJoueur.add(cartePiochee);
			if (Partie.getPartie().getListeJoueur().get(maManche.getIndiceJoueurEnCours()) instanceof JoueurPhysique) {
				System.out.println("Vous avez pioché la carte " + cartePiochee.toString() + " .");
			}
			maManche.setJoueurRejouer(true); // on a sauter un tour artificiellement donc on reprend l'ordre normal
		}

	}
	
	*/
}
