package mod�le;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Une classe qui repr�sente un joueur.*
 * La classe Joueur est observable.
 * Le joueur peut �tre un joueur physique ou un ordinateur.
 * Un joueur est caract�ris� par les informations suivantes :
 * Une main o� sont contenu ses cartes
 * Un nom
 * Un score
 * Un num�ro de joueur
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
	 * Le num�ro du joueur.
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

	// V�rifie si la carte choisi par le joueur peut �tre poser sur le talon

	/**
	 * M�thode qui v�rifie si la carte en param�tre est compatible avec la carte du dessus du talon {@link Talon.carteDessus}.
	 * 
	 * @param maManche
	 * 		La manche manche en cours.
	 * @param carte
	 * 		La carte dont on souhaite v�rifier la compatibilit� avec la carte du talon.
	 * @return
	 * 		Un boolean � vrai si la carte est compatible.
	 */
	public boolean carteCompatible(Manche maManche, Carte carte) {

		if ((carte.getCouleur() == maManche.getLeTalon().getCarteDessus().getCouleur() || carte.isJoker() == true)
				|| carte.getValeur() == maManche.getLeTalon().getCarteDessus().getValeur()) {
			if (maManche.getCarteAPiocherAs() > 0) {
				if (carte.getEffet().equals("permet de changer de couleur et arr�te les attaques") || carte.getValeur()
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
	 * M�thode qui compte le score du joueur.
	 * Cette m�thode est appel� � la fin d'une manche.
	 * Compte le score en focntion des cartes qui reste en main � la fin de la manche.
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
	 * Met � jour la liste des cartes dans la main du joueur.
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
	 * Met � jour le nom du joueur.
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
	 * Met � jour la valeur du boolean carte.
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
	 * Met � jour la valeur du boolean contreCarte.
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
	
	
	
