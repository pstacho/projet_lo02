package modèle;

import java.util.Scanner;

import modèle.Carte;
import modèle.Partie;

/**
 * @author Stacho
 *
 */
public class JoueurPhysique extends Joueur {

	/**
	 * 
	 */
	Scanner sc = new Scanner(System.in);
	/**
	 * 
	 */
	private boolean attenteVue = true;

	/**
	 * @param nomJoueur
	 */
	public JoueurPhysique(String nomJoueur) {

		super();
		nom = nomJoueur;
		System.out.println(this.nom);
	}

	/**
	 * @param attenteVue
	 */
	public void setAttenteVue(boolean attenteVue) {
		this.attenteVue = attenteVue;
	}

	/**
	 * 
	 */
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

	/**
	 * @param maManche
	 */
	@SuppressWarnings("deprecation")
	public void jouerCarte(Manche maManche) {
		this.carte = false;
		this.contrecarte = false;
		while (attenteVue == true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setChanged();
		notifyObservers("a joué");
		this.setAttenteVue(true);
	}

	/**
	 * @param carteAPoser
	 */
	public void jouerTourG(Carte carteAPoser) {

		this.poserCarteGraphique(carteAPoser);

		setAttenteVue(false);
	}

	/**
	 * @param carteAPoser
	 */
	@SuppressWarnings("deprecation")
	public void poserCarteGraphique(Carte carteAPoser) {

		Effet.checkEffetApres(Partie.getPartie().getManche(), Partie.getPartie().getManche().getLaPioche(),
				carteAPoser);
		Partie.getPartie().getManche().getLeTalon().setCarteDessus(carteAPoser); //

		System.out.println("Vous jouez " + carteAPoser);
		this.mainJoueur.remove(carteAPoser);

		if (this.getMainJoueur().size() == 1) {
			DireCarte ditCarte = new DireCarte(this);
		}

		// On notifie l'interface que la carte a ete retiree de la main du joueur
		this.setChanged();
		this.notifyObservers("a joué");
	}
}
