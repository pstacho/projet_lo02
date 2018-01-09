package modèle;

import java.util.ArrayList;
import java.util.Scanner;


import modèle.Carte;
import modèle.Partie;

public class JoueurPhysique extends Joueur {

	Scanner sc = new Scanner(System.in);
	private Carte carteJouee;
	private Carte cartePiochee;
	private boolean attenteVue = true;

	public JoueurPhysique(String nomJoueur) {

		super();
		nom = nomJoueur;
		System.out.println(this.nom);
	}

	public void setAttenteVue(boolean attenteVue) {
		this.attenteVue = attenteVue;
	}

	public void afficherMainJoueur() {

		for (int i = 0; i < this.mainJoueur.size(); i++) {

			if (this.mainJoueur.get(i).getEffet().equals("null")) {
				System.out.println((i + 1) + " : " + mainJoueur.get(i));
			} else {
				System.out.println(
						(i + 1) + " : " + mainJoueur.get(i) + "   effet: " + this.mainJoueur.get(i).getEffet());
			}

		}
	}

	// Ancien
	/*
	 * public void jouerCarte(Manche maManche, Pioche laPioche, Talon leTalon) {
	 * 
	 * System.out.
	 * println("Saisissez la carte a jouer ou appuyer sur 0 pour piocher\n");
	 * leTalon.afficherCarteDessus(); int carteChoisie = sc.nextInt(); // le numero
	 * affiché par le afficher mainjoueur if (carteChoisie >= 1 && carteChoisie <=
	 * mainJoueur.size()) { carteJouee = mainJoueur.get(carteChoisie - 1); // on
	 * affecte le numero de la carte la carte correspondante.
	 * 
	 * Effet.checkEffetAvant(maManche, laPioche, carteJouee); if
	 * (carteCompatible(maManche, leTalon, carteJouee) == true) {
	 * System.out.println("Vous jouez la carte " + carteJouee + " .");
	 * Effet.checkEffetApres(maManche, laPioche, carteJouee);
	 * 
	 * 
	 * this.mainJoueur.remove(carteJouee); leTalon.ajouterCarte(carteJouee);
	 * leTalon.afficherCarteDessus(); } else {
	 * System.out.println("Tu ne peux pas jouer cette carte !");
	 * jouerCarte(maManche, laPioche, leTalon); } } else if (carteChoisie >
	 * mainJoueur.size()) {
	 * System.out.println("Tu n'as pas autant de cartes ! Choisi une autre carte");
	 * jouerCarte(maManche, laPioche, leTalon);
	 * 
	 * } else if (carteChoisie == 0) { if (maManche.getCarteAPiocherAs() > 0) {
	 * Effet.piocherAS(maManche,laPioche); } else { cartePiochee =
	 * laPioche.piocherCarte(leTalon); mainJoueur.add(cartePiochee);
	 * System.out.println("Vous avez pioché la carte " + cartePiochee.toString() +
	 * " ."); }
	 * 
	 * }
	 * 
	 * }
	 */
	public void jouerCarte(Manche maManche) {
		this.carte=false;
		this.contrecarte=false;
		while (attenteVue == true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("EnAttenteChoix");
		}
		setChanged();
		notifyObservers("a joué");
		this.setAttenteVue(true);
	}

	public void jouerTourG(Carte carteAPoser) {

		// this.aDitcarte = false;
		// this.contreCarte = false;
		// this.setaChangeDeFamille(false);
		this.poserCarteGraphique(carteAPoser);

		/*
		 * // effets pour lesquels on ne doit pas changer le tour if
		 * (!this.EffetVariante.equals("doit rejouer") &&
		 * !this.EffetVariante.equals("JouerMemeCouleur") &&
		 * !this.EffetVariante.equals("Changer Famille")) { // on regarde si le fait
		 * d'avoir pose une carte permet au joueur de gagner la // manche
		 * this.EffetVariante = "Aucun"; this.changerTour(); } if
		 * (this.EffetVariante.equals("doit rejouer")) { this.EffetVariante = "Aucun"; }
		 * 
		 */
		setAttenteVue(false);
	}

	public void poserCarteGraphique(Carte carteAPoser) {

	
		Partie.getPartie().getManche().getLeTalon().setCarteDessus(carteAPoser); //
	
		System.out.println("Vous jouez " + carteAPoser);
		this.mainJoueur.remove(carteAPoser);
		
		
		
			if(	this.getMainJoueur().size() == 1) {
				DireCarte ditCarte =new DireCarte(this);
			}
		

		// On notifie l'interface que la carte a ete retiree de la main du joueur


		this.setChanged();
		this.notifyObservers("a joué");
	}
}
