package j8;

import java.util.Scanner;

public abstract class Effet {

	private static Scanner sc;

	public static void checkEffetApres(Manche maManche, Pioche laPioche, Carte carteJouee) {

		if (carteJouee.getEffet().equals("permet de changer de couleur, se pose sur n'importe quelle carte")) {
			Joker(carteJouee);
			ChangerCouleur(maManche, carteJouee);
		} else if (carteJouee.getEffet().equals("oblige a rejouer")) {
			joueurRejouer(maManche);
		} else if (carteJouee.getEffet().equals("change le sens du jeu")) {
			changerSens(maManche);
		} else if (carteJouee.getEffet().equals("permet de changer de couleur et arr�te les attaques")) {
			ChangerCouleur(maManche, carteJouee);
			gererAttaque(maManche, laPioche, carteJouee, 3);

		} else if (carteJouee.getEffet().equals("le joueur suivant passe son tour")) {
			joueurPasseSonTour(maManche);
		} else if (carteJouee.getEffet().equals("fait piocher une carte au joueur suivant sans recours")) {
			fairePiocherCartes(maManche, laPioche, 1);
		} else if (carteJouee.getEffet()
				.equals("fait piocher 3 cartes au joueur suivant, � moins de poser un 8 ou un As")) {
			gererAttaque(maManche, laPioche, carteJouee, 3);
		}

	}

	public static String ChangerCouleur(Manche maManche, Carte carteJouee) {
		sc = new Scanner(System.in);
		String[] couleur = new String[] { "Pique", "Tr�fle", "Coeur", "Carreau" };
		String vraiCouleur = carteJouee.getCouleur();

		if (Partie.getPartie().getListeJoueur().get(maManche.getIndiceJoueurEnCours()) instanceof JoueurPhysique) {

			System.out.println("Choissisez la nouvelle couleur de la carte");

			for (int i = 0; i < couleur.length; i++) {
				System.out.println((i + 1) + " : " + couleur[i]);

			}
			int numCouleurProvisoire = sc.nextInt();
			String couleurProvisoire = couleur[numCouleurProvisoire - 1];
			carteJouee.setCouleur(couleurProvisoire);
		} else if (Partie.getPartie().getListeJoueur()
				.get(maManche.getIndiceJoueurEnCours()) instanceof JoueurPhysique) {
			int numCouleurProvisoire = (int) (Math.random() * (3 - 0));
			String couleurProvisoire = couleur[numCouleurProvisoire];
			System.out.println("la nouvelle couleur de la carte est: " + couleurProvisoire);
			carteJouee.setCouleur(couleurProvisoire);
		}

		return vraiCouleur;
	}

	public static void Joker(Carte carteJouee) {
		carteJouee.setJoker(true);
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
		maManche.joueurSuivant();
		System.out.println(maManche.getJoueurEnCours().nom + " doit piocher " + nombreCarteAPiocher + " carte(s)");
		for (int i = 0; i < nombreCarteAPiocher; i++) {
			Carte cartePiochee = laPioche.piocherCarte(maManche.getLeTalon());
			maManche.getJoueurEnCours().mainJoueur.add(cartePiochee);
			if (Partie.getPartie().getListeJoueur().get(maManche.getIndiceJoueurEnCours()) instanceof JoueurPhysique) {
				System.out.println("Vous avez pioch� la carte " + cartePiochee.toString() + " .");
			}
			maManche.setJoueurRejouer(true); // on a sauter un tour artificiellement donc on reprend l'ordre normal
		}

	}

	public static void fairePiocherCartesAvecRecours(Manche maManche, Pioche laPioche, int nombreCarteAPiocher) {

		maManche.joueurSuivant();
		maManche.setCarteAPiocherAs(nombreCarteAPiocher + maManche.getCarteAPiocherAs());
		System.out.println(
				maManche.getJoueurEnCours().nom + " doit piocher " + maManche.getCarteAPiocherAs()
						+ " carte(s), sauf si il pose un As ou une carte qui annule les attaques");
		maManche.setJoueurRejouer(true);
	}

	public static void gererAttaque(Manche maManche, Pioche laPioche, Carte carteJouee, int nombreCarteAPiocher) {
		if (carteJouee.getEffet().equals("fait piocher 3 cartes au joueur suivant, � moins de poser un 8 ou un As")) {
			fairePiocherCartesAvecRecours(maManche, laPioche, nombreCarteAPiocher);
		} else if (carteJouee.getEffet().equals("permet de changer de couleur et arr�te les attaques")) {
			bloquerAttaque(maManche);

		} 
	}

	public static void bloquerAttaque(Manche maManche) {
		
		if (maManche.getCarteAPiocherAs()>0) {
			maManche.setCarteAPiocherAs(0);
			System.out.println(maManche.getJoueurEnCours().nom+ " bloque l'attaque!");
		}
		
	}
	public static void piocherAS(Manche maManche, Pioche laPioche) {
		
		System.out.println(maManche.getJoueurEnCours().nom + " doit piocher " + maManche.getCarteAPiocherAs() + " carte(s)");
		for (int i = 0; i < maManche.getCarteAPiocherAs(); i++) {
			Carte cartePiochee = laPioche.piocherCarte(maManche.getLeTalon());
			maManche.getJoueurEnCours().mainJoueur.add(cartePiochee);
			if (Partie.getPartie().getListeJoueur().get(maManche.getIndiceJoueurEnCours()) instanceof JoueurPhysique) {
				System.out.println("Vous avez pioch� la carte " + cartePiochee.toString() + " .");
			}
	}
		maManche.setCarteAPiocherAs(0);
}
}
