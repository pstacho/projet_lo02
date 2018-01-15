package modèle;

import modèle.Joueur;

import java.util.LinkedList;

/**
 * @author Stacho
 *
 */
public class Partie {

	/**
	 * 
	 */
	private int nombreOrdinateur;
	/**
	 * 
	 */
	private int nombreCarteJoueur;
	/**
	 * 
	 */
	private String variante;
	/**
	 * 
	 */
	private int modeComptage;
	/**
	 * 
	 */
	protected LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();
	/**
	 * 
	 */
	private Manche Manche;

	/**
	 * @return
	 */
	public LinkedList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	/**
	 * @param listeJoueurs
	 */
	public void setListeJoueurs(LinkedList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	/**
	 * 
	 */
	private Partie() {
		System.out.println("testcool");
	}

	/**
	 * @return
	 */
	public static Partie getPartie() {
		return maPartie;
	}

	/**
	 * 
	 */
	private static Partie maPartie = new Partie();

	/**
	 * @return
	 */
	public Manche lancerJeu() {

		Manche maManche = new Manche();
		Manche = maManche;
		return maManche;
	}

	/**
	 * @return
	 */
	public Manche getManche() {
		return Manche;
	}

	/**
	 * @return
	 */
	public int getNombreOrdinateur() {
		return nombreOrdinateur;
	}

	/**
	 * @return
	 */
	public int getNombreCarteJoueur() {
		return nombreCarteJoueur;
	}

	/**
	 * 
	 */
	public void setNombreCarteJoueur() {
		System.out.println("il y a" + nombreOrdinateur + "ordis");
		if (nombreOrdinateur == 1) {
			nombreCarteJoueur = 10;
		} else if (nombreOrdinateur == 2) {
			nombreCarteJoueur = 8;
		} else {
			nombreCarteJoueur = 6;
		}
	}

	/**
	 * @return
	 */
	public int getModeComptage() {
		return modeComptage;
	}

	/**
	 * @param modeComptage
	 * @param listeJoueurs
	 * @param variante
	 */
	public void updatePartie(int modeComptage, LinkedList<Joueur> listeJoueurs, String variante) {
		this.listeJoueurs = listeJoueurs;
		this.nombreOrdinateur = listeJoueurs.size() - 1;
		this.modeComptage = modeComptage;
		this.variante = variante;
		System.out.println("Variante : " + this.variante);
		System.out.println("Mode comptage:" + this.modeComptage);
		System.out.println("nb joueurs fdp" + listeJoueurs);
	}

	/**
	 * @return
	 */
	public String getVariante() {
		return variante;
	}

}
