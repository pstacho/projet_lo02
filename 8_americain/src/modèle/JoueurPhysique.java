package mod�le;

import mod�le.Carte;
import mod�le.Partie;

/**
 * Classe qui repr�sente le joueur r�el qui joue. JoueurPhysique h�rite de la
 * classe Joueur. Un joueur physique est �galement caract�ris� par : Un boolean
 * attenteVue
 * 
 * @author Stacho
 *
 */
public class JoueurPhysique extends Joueur {

	/**
	 * Le boolean attenteVue.
	 */
	private boolean attenteVue = true;

	/**
	 * Constructeur de JoueurPhysique.
	 * 
	 * @param nomJoueur
	 *            Le nom du joueur.
	 */
	public JoueurPhysique(String nomJoueur) {

		super();
		nom = nomJoueur;
		System.out.println(this.nom);
	}

	/**
	 * Met � jour la valeur de attenteVue.
	 * 
	 * @param attenteVue
	 *            La nouvelle valeur de attenteVue.
	 */
	public void setAttenteVue(boolean attenteVue) {
		this.attenteVue = attenteVue;
	}

	/**
	 * M�thode qui affiche la main du joueur dans la console.
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
	 * M�thode qui permet au joueur physique de jouer une carte.
	 * 
	 * @param maManche
	 *            La manche en cours.
	 */
	@SuppressWarnings("deprecation")
	public void jouerCarte(Manche maManche) {
		this.carte = false;
		this.contreCarte = false;
		while (attenteVue == true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setChanged();
		notifyObservers("a jou�");
		this.setAttenteVue(true);
	}

	/**
	 * 
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

		Effet.checkEffetApres(Partie.getPartie().getManche(), carteAPoser);
		Partie.getPartie().getManche().getLeTalon().setCarteDessus(carteAPoser); //

		System.out.println("Vous jouez " + carteAPoser);
		this.mainJoueur.remove(carteAPoser);

		if (this.getMainJoueur().size() == 1) {
			new DireCarte(this);
		}

		// On notifie l'interface que la carte a ete retiree de la main du joueur
		this.setChanged();
		this.notifyObservers("a jou�");
	}
}
