package mod�le;

import mod�le.Joueur;

import java.util.LinkedList;

/**
 * Classe qui repr�sente une partie de jeu de 8 am�ricains. Cette classe est un
 * Singleton, une seule instance peut �tre cr�er. La partie est caract�ris� par
 * : Un nombre d'ordinateur qui sont les adversaires du joueur physique. Un
 * nombre de carte par joueur au d�but de la partie. Une variante qui d�termine
 * les effets des cartes.
 * 
 * 
 * @author Stacho
 *
 */
public class Partie {

	/**
	 * Le nombre d'ordinateur dans la partie.
	 */
	private int nombreOrdinateur;
	/**
	 * Le nombre de carte par joueur au lancement de la partie.
	 */
	private int nombreCarteJoueur;
	/**
	 * La variante de la partie qui d�termine les effets de cartes.
	 */
	private String variante;
	/**
	 * Le mode de comptage du score des joueurs.
	 */
	private int modeComptage;
	/**
	 * La liste des joueurs de la partie. Elle comprend aussi bien le joueur
	 * physique que les ordinateurs.
	 */
	protected LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();
	/**
	 * La manche de la partie.
	 */
	private Manche Manche;

	/**
	 * Retourne la liste des joueurs de la partie.
	 * 
	 * @return La liste des joueurs.
	 */
	public LinkedList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	/**
	 * Constructeur par d�faut de la classe Partie.
	 */
	private Partie() {
	}

	/**
	 * M�thode statique qui permet de r�cup�rer l'instance de la partie.
	 * 
	 * @return
	 */
	public static Partie getPartie() {
		return maPartie;
	}

	/**
	 * L'instance de la partie.
	 */
	private static Partie maPartie = new Partie();

	/**
	 * M�thode qui d�bute une manche de la partie. Cr�er une nouvelle manche et la
	 * retourne.
	 * 
	 * @return La manche de la partie.
	 */
	public Manche lancerJeu() {

		Manche maManche = new Manche();
		Manche = maManche;
		return maManche;
	}

	/**
	 * Retourne la manche en cours de la partie.
	 * 
	 * @return La manche en cours.
	 */
	public Manche getManche() {
		return Manche;
	}

	/**
	 * Retourne le nombre d'ordinateur dans la partie.
	 * 
	 * @return Le nombre d'ordinateur de la partie.
	 */
	public int getNombreOrdinateur() {
		return nombreOrdinateur;
	}

	/**
	 * Retourne le nombre de carte des joueurs en d�but de partie.
	 * 
	 * @return Le nombre de carte initiale dans la main des joueurs.
	 */
	public int getNombreCarteJoueur() {
		return nombreCarteJoueur;
	}

	/**
	 * M�thode qui d�termine le nombre de carte initiale dans la main des joueurs en
	 * d�but de partie. Ce nombre est d�termin� en focntion du nombre d'ordinateur
	 * dans la partie.
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
	 * Retourne le mode de comptage du score des joueurs.
	 * 
	 * @return Le mode de comptage des scores.
	 */
	public int getModeComptage() {
		return modeComptage;
	}

	/**
	 * Met � jour les attributs de la partie en fonction des r�glages choisies par
	 * le joueur.
	 * 
	 * @param modeComptage
	 *            Le mode de comptage choisi par le joueur.
	 * @param listeJoueurs
	 *            La liste des joueurs en fonction du nombre d'ordinateur.
	 * @param variante
	 *            La variante choisie par le joueur.
	 */
	public void updatePartie(int modeComptage, LinkedList<Joueur> listeJoueurs, String variante) {
		this.listeJoueurs = listeJoueurs;
		this.nombreOrdinateur = listeJoueurs.size() - 1;
		this.modeComptage = modeComptage;
		this.variante = variante;
		System.out.println("Variante : " + this.variante);
		System.out.println("Mode comptage:" + this.modeComptage);
		System.out.println("nb joueurs" + listeJoueurs);
	}

	/**
	 * Retourne la valeur de la variante de la partie.
	 * 
	 * @return La variante de la partie.
	 */
	public String getVariante() {
		return variante;
	}

}
