package modèle;

/**
 * Classe qui représente un ordinateur qui joue une partie. Ordinateur hérite de
 * la classe Joueur. Il est caractérisé par une difficulté et une stratégie.
 * 
 * @author Stacho
 *
 */
public class Ordinateur extends Joueur {

	/**
	 * La difficulté du joueur. Normale si égale à 1. Difficile dans les autres cas.
	 */
	private int difficultee;

	/**
	 * La stratégie du joueur.
	 */
	private Strategie strategie;

	/**
	 * Constructeur de la classe Ordinateur.
	 * 
	 * @param indexBot
	 *            Le numéro de l'ordinateur.
	 * @param difficultee
	 *            La difficulté de l'ordinateur.
	 */
	public Ordinateur(int indexBot, int difficultee) {

		super();

		this.nom = "BOT" + indexBot;
		this.difficultee = difficultee;
		if (this.difficultee == 1) {
			strategie = (Strategie) new StrategieNormal();
		} else {
			strategie = (Strategie) new StrategieDifficile();
		}

	}

	/**
	 * Méthode qui permet à l'ordinateur de jouer une carte.
	 * 
	 * @param maManche
	 *            La manche en cours.
	 */
	@SuppressWarnings("deprecation")
	public void jouerCarteOrdi(Manche maManche) {

		System.out.println(this.nom + "a actuellement " + this.mainJoueur.size() + " cartes.");
		strategie.jouerCarte(this, maManche);
		if (this.mainJoueur.size() == 1) {
			new DireContreCarte(this);
		}
		System.out.println(this.nom + "a encore " + this.mainJoueur.size() + " cartes.");

		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Retourne la Stratégie du joueur {@link modele.Strategie}.
	 * 
	 * @return
	 */
	public Strategie getStrategie() {
		return strategie;
	}

	/**
	 * Met a jour la stratégie du joueur.
	 * 
	 * @param strategie
	 *            La stratgie du joueur.
	 */
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

}
