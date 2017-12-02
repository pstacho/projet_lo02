package j8;

import java.util.Iterator;

public class Manche {

	private Joueur joueurEnCours;
	private int indiceJoueurEnCours = 0; // je test avec le premier joueur
	private int numeroManche = 0;
	private Talon leTalon;
	private Pioche laPioche;

	// effets

	private boolean sensPositif = true;
	private boolean joueurRejouer = false;

	private boolean passerProchainTour = false;
	private boolean jeuParValeurDesactive = false;
	private boolean jeuParCouleurDesactive = false;
	private int cartesAPiocher = 0;
	private int cartesAPiocherSansRecours = 0;
	private int cartesAPiocherDansJeu = 0;

	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public boolean isSensPositif() {
		return sensPositif;
	}

	public void setSensPositif(boolean sensPositif) {
		this.sensPositif = sensPositif;
	}

	public boolean isjoueurRejouer() {
		return joueurRejouer;
	}

	public boolean isJoueurRejouer() {
		return joueurRejouer;
	}

	public void setJoueurRejouer(boolean joueurRejouer) {
		this.joueurRejouer = joueurRejouer;
	}

	public Manche() {

		numeroManche++;
		sensPositif = true;

		System.out.println("Début de la manche n° " + numeroManche);
		Variante maVariante = new Variante();
		Pioche laPioche = new Pioche();

		maVariante.afficherChoixVariantes();
		maVariante.ChoisirVariante(laPioche); // ca doit etre placé avant distruibuer, j'ai pas en fait pour que ca
												// change en jeux mais c'est possible en theorie

		// for (int i = 0; i < laPioche.jeuDeCartes.size(); i++) { // test
		// System.out.println(laPioche.jeuDeCartes.get(i).getEffet()); // test
		// } // test

		laPioche.distribuer();

		leTalon = new Talon(laPioche);
		leTalon.afficherCarteDessus();

		indiceJoueurEnCours = (int) (Math.random() * (Partie.getPartie().getNombreOrdinateur() - 0));
		// on initialise indiceJoueurEnCours a un nombre aléatoire compris entre 0 et le
		// nombre de joueur afin de determiener aléatoirement le joeur qui commence
		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(indiceJoueurEnCours);
		while (joueurEnCours.mainJoueur.size() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jouerTourDeJeu();
		}
		finirManche();

	}

	public void jouerTourDeJeu() {

		if (joueurEnCours instanceof JoueurPhysique) {
			System.out.println(joueurEnCours.getNom() + ", c'est à toi de jouer.\r");
			((JoueurPhysique) joueurEnCours).afficherMainJoueur();
			((JoueurPhysique) joueurEnCours).jouerCarte(leTalon, laPioche);

		} else {
			System.out.println(joueurEnCours.getNom() + " joue son tour.");
			((Ordinateur) joueurEnCours).jouerCarteOrdi(leTalon, laPioche);
		}
		joueurSuivant();
	}

	private void finirManche() {
		// TODO Auto-generated method stub

	}

	public void joueurSuivant() {
		if (joueurRejouer == false) {
			if (sensPositif = true) {
				indiceJoueurEnCours++;
				/*
				 * Iterator<Joueur> itJ = Partie.getPartie().listeJoueur.iterator(); if
				 * (itJ.hasNext()) {
				 */
				if (indiceJoueurEnCours >= Partie.getPartie().getNombreOrdinateur() + 1) {
					indiceJoueurEnCours = 0;
				}

			} else {
				indiceJoueurEnCours--;// pour les variantes changement de sens
				if (indiceJoueurEnCours < 0) {
					indiceJoueurEnCours = Partie.getPartie().getNombreOrdinateur() + 1;

				}

			}
		}

		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(indiceJoueurEnCours);

	}
}
