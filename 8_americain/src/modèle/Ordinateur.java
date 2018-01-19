package mod�le;

/**
 * Classe qui repr�sente un ordinateur qui joue une partie. Ordinateur h�rite de
 * la classe Joueur. Il est caract�ris� par une difficult� et une strat�gie.
 * 
 * @author Stacho
 *
 */
public class Ordinateur extends Joueur {

	/**
	 * La difficult� du joueur. Normale si �gale � 1. Difficile dans les autres cas.
	 */
	private int difficultee;

	/**
	 * La strat�gie du joueur.
	 */
	private Strategie strategie;

	/**
	 * Constructeur de la classe Ordinateur.
	 * 
	 * @param indexBot
	 *            Le num�ro de l'ordinateur.
	 * @param difficultee
	 *            La difficult� de l'ordinateur.
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
	 * M�thode qui permet � l'ordinateur de jouer une carte.
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
	 * Retourne la Strat�gie du joueur {@link modele.Strategie}.
	 * 
	 * @return
	 */
	public Strategie getStrategie() {
		return strategie;
	}

	/**
	 * Met a jour la strat�gie du joueur.
	 * 
	 * @param strategie
	 *            La stratgie du joueur.
	 */
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

}
