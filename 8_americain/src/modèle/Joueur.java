package modèle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class Joueur extends Observable {

	/**
	 * 
	 */
	protected ArrayList<Carte> mainJoueur;
	/**
	 * 
	 */
	protected String nom;
	/**
	 * 
	 */
	private int score;
	/**
	 * 
	 */
	private int numero;
	/**
	 * 
	 */
	protected boolean carte;
	/**
	 * 
	 */
	protected boolean contrecarte;
	/**
	 * 
	 */
	protected static int indiceJoueur = 0;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Joueur [mainJoueur=" + mainJoueur + ", nom=" + nom + ", indiceJoueur=" + numero + "]";
	}

	// Constructeur de Joueur
	/**
	 * 
	 */
	public Joueur() {
		indiceJoueur++;
		this.numero = indiceJoueur;
		score = 0;
		mainJoueur = new ArrayList<Carte>();
	}

	// Vérifie si la carte choisi par le joueur peut être poser sur le talon

	/**
	 * @param maManche
	 * @param leTalon
	 * @param carte
	 * @return
	 */
	public boolean carteCompatible(Manche maManche, Talon leTalon, Carte carte) {

		if ((carte.getCouleur() == leTalon.getCarteDessus().getCouleur() || carte.isJoker() == true)
				|| carte.getValeur() == leTalon.getCarteDessus().getValeur()) {
			if (maManche.getCarteAPiocherAs() > 0) {
				if (carte.getEffet().equals("permet de changer de couleur et arrête les attaques") || carte.getValeur()
						.equals("As")) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	/**
	 * 
	 */
	public void compterPoints() {
		Iterator<Carte> it = mainJoueur.iterator();
		while (it.hasNext()) {
			this.score = this.score + it.next().getPoint();
		}
		System.out.println(this.nom + " a " + this.score + " points.");
	}

	/**
	 * @return
	 */
	public ArrayList<Carte> getMainJoueur() {
		return mainJoueur;
	}

	/**
	 * @param mainJoueur
	 */
	public void setMainJoueur(ArrayList<Carte> mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 */
	public void changed()
	{
		this.setChanged();
	}

	/**
	 * @return
	 */
	public boolean isCarte() {
		return carte;
	}

	/**
	 * @param carte
	 */
	public void setCarte(boolean carte) {
		this.carte = carte;
	}

	/**
	 * @return
	 */
	public boolean isContrecarte() {
		return contrecarte;
	}

	/**
	 * @param contrecarte
	 */
	public void setContrecarte(boolean contrecarte) {
		
		this.contrecarte = contrecarte;	
		this.mainJoueur.add(Partie.getPartie().getManche().getLaPioche().piocherCarte(Partie.getPartie().getManche().getLeTalon()));
		this.setChanged();
		this.notifyObservers();
			
	}
	}
	
	
	
