package modèle;

/**
 * Une classe qui représente une carte.
 * 
 * Une carte est caractérisé par les informations suivantes :
 * Une valeur
 * Une couleur
 * Un nombre point qui sert à compter les points du joueur.
 * Un effet qui peut être nulle.
 * @author Stacho
 *
 */
public class Carte {
	
	/**
	 * La valeur de la carte.
	 */
	private String valeur;
	/**
	 * La couleur de la carte.
	 */
	private String couleur;
	/**
	 * Le nombre de point que vaut la carte.
	 */
	private int point;
	/**
	 * L'effet de la carte.
	 */
	private String effet="null";
	/**
	 * 
	 */
	private boolean Joker=false;
	/**
	 * La couleur de la carte lorsqu'elle est instanciée.
	 */
	private String vraiCouleur;
	/**
	 * Retourne la couleur d'origine de la carte.
	 * 
	 * @return La couleur d'origine de la carte.
	 */
	public String getVraiCouleur() {
		return vraiCouleur;
	}

	/**
	 * Met à jour la couleur de la carte.
	 * 
	 * @param vraiCouleur
	 * 					La nouvelle couleur de la carte.
	 */
	public void setVraiCouleur(String vraiCouleur) {
		this.vraiCouleur = vraiCouleur;
	}

	/**
	 * Retourne l'effet de la carte.
	 * 
	 * @return L'effet de la carte.
	 */
	public String getEffet() {
		return effet;
	}

	/**
	 * Retourne vrai si la carte est un joker.
	 * 
	 * @return Un boolean pour savoir si la carte est un joker.
	 */
	public boolean isJoker() {
		return Joker;
	}

	/**
	 * Met a jour la condition de carte joker.
	 * 
	 * @param joker
	 * 			La nouvelle valeur de joker.
	 */
	public void setJoker(boolean joker) {
		Joker = joker;
	}

	/**
	 * Met à jour l'effet de la carte.
	 * 
	 * @param effet
	 * 			Le nouvel effet de la carte.
	 */
	public void setEffet(String effet) {
		this.effet = effet;
	}

	/**
	 * Constructeur Carte.
	 * 
	 * @param val
	 * 		La valeur de la carte.
	 * @param color
	 * 		La couleur de la carte.
	 * @param point
	 * 		La valeur de point de la carte.
	 */
	public Carte(String val, String color, int point) {
		this.valeur = val;
		this.couleur = color;
		this.point = point;
		// pour les points faire les variantes d'abords
	}

	/**
	 * Retourne la valeur de la carte.
	 * 
	 * @return La valeur de la carte.
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Met à jour la valeur de la carte.
	 * 
	 * @param valeur
	 * 			La nouvelle valeur de la carte.
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * Retourne la couleur de la carte.
	 * 
	 * @return La couleur de la carte.
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * Met à jour la couleur de la carte.
	 * 
	 * @param couleur
	 * 			La nouvelle couleur de la carte.
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * Retourne le nombre de points de la carte.
	 * 
	 * @return Le nombre de points de la carte.
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * Met à jour le nombre de points de la carte.
	 * 
	 * @param point
	 * 			Le nouveau nombre de point de la carte.
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return valeur + " de " + couleur;
	}

}
