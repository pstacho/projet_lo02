package modèle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Une classe qui représente un joueur.*
 * La classe Joueur est observable.
 * Le joueur peut être un joueur physique ou un ordinateur.
 * Un joueur est caractérisé par les informations suivantes :
 * Une main où sont contenu ses cartes
 * Un nom
 * Un score
 * Un numéro de joueur
 * Un boolean qui indique si le joueur a dit "carte"
 * Un boolean qui indique si le joueur a dit "contre-carte
 *  
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class Joueur extends Observable {

	/**
	 * La liste des cartes que le joueur a en main.
	 */
	protected ArrayList<Carte> mainJoueur;
	/**
	 * Le nom du joueur.
	 */
	protected String nom;
	/**
	 *	Le score du joueur.
	 */
	private int score;
	/**
	 * Le numéro du joueur.
	 */
	private int numero;
	/**
	 * Le boolean qui indique si le joueur a dit "carte".
	 */
	protected boolean carte;
	/**
	 * Le boolean qui indique si le joueur a dit "contre-carte".
	 */
	protected boolean contreCarte;
	/**
	 * L'indice Joueur est un compteur de la classe joueur.
	 * Il indique le nombre d'instance de la classe Joueur.
	 */
	protected static int indiceJoueur = 0;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Joueur [mainJoueur=" + mainJoueur + ", nom=" + nom + ", indiceJoueur=" + numero + "]";
	}

	/**
	 * Constructeur de la classe Joueur.
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
	 * Méthode qui vérifie si la carte en paramètre est compatible avec la carte du dessus du talon {@link Talon.carteDessus}.
	 * 
	 * @param maManche
	 * 		La manche manche en cours.
	 * @param carte
	 * 		La carte dont on souhaite vérifier la compatibilité avec la carte du talon.
	 * @return
	 * 		Un boolean à vrai si la carte est compatible.
	 */
	public boolean carteCompatible(Manche maManche, Carte carte) {

		if ((carte.getCouleur() == maManche.getLeTalon().getCarteDessus().getCouleur() || carte.isJoker() == true)
				|| carte.getValeur() == maManche.getLeTalon().getCarteDessus().getValeur()) {
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
	 * Méthode qui compte le score du joueur.
	 * Cette méthode est appelé à la fin d'une manche.
	 * Compte le score en focntion des cartes qui reste en main à la fin de la manche.
	 */
	public void compterScore() {
		Iterator<Carte> it = mainJoueur.iterator();
		while (it.hasNext()) {
			this.score = this.score + it.next().getPoint();
		}
		System.out.println(this.nom + " a " + this.score + " points.");
	}

	/**
	 * Retourne la liste des cartes dans la main du joueur.
	 * 
	 * @return Liste des cartes dans la main du joueur.
	 */
	public ArrayList<Carte> getMainJoueur() {
		return mainJoueur;
	}

	/**
	 * Met à jour la liste des cartes dans la main du joueur.
	 * 
	 * @param mainJoueur
	 * 			La nouvelle liste des cartes dans la main du joueur.
	 */
	public void setMainJoueur(ArrayList<Carte> mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	/**
	 * Retourne le nom du joueur.
	 * 
	 * @return Le nom du joueur.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Met à jour le nom du joueur.
	 * 
	 * @param nom
	 * 		Le nouveau nom du joueur.
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
	 * Retourne la valeur "True" si le joueur a dit "carte".
	 * 
	 * @return La valeur du boolean carte.
	 */
	public boolean isCarte() {
		return carte;
	}

	/**
	 * Met à jour la valeur du boolean carte.
	 * 
	 * @param carte
	 * 		La nouvelle valeur du boolean carte.
	 */
	public void setCarte(boolean carte) {
		this.carte = carte;
	}

	/**
	 * Retourne la valeur du boolean contreCarte.
	 * 
	 * @return La valeur de contreCarte
	 */
	public boolean isContrecarte() {
		return contreCarte;
	}

	/**
	 * Met à jour la valeur du boolean contreCarte.
	 * 
	 * @param contrecarte
	 * 			La nouvelle valeur de contreCarte.
	 */
	public void setContrecarte(boolean contreCarte) {
		
		this.contreCarte = contreCarte;	
		this.mainJoueur.add(Partie.getPartie().getManche().getLaPioche().piocherCarte(Partie.getPartie().getManche().getLeTalon()));
		this.setChanged();
		this.notifyObservers();
			
	}
	}
	
	
	
