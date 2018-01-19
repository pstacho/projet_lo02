package mod�le;

/**
 * Classe qui repr�sente un ordinateur qui joue une partie.
 * Ordinateur h�rite de la classe Joueur.
 * 
 * @author Stacho
 *
 */
public class Ordinateur extends Joueur {

	/**
	 * La difficult� du joueur.
	 * Normale si �gale � 1.
	 * Difficile dans les autres cas.
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
	 * 		Le num�ro de l'ordinateur.
	 * @param difficultee
	 * 		La difficult� de l'ordinateur.
	 */
	public Ordinateur(int indexBot, int difficultee) {

		super();

		this.nom = "BOT" + indexBot;
		this.difficultee = difficultee;
		if (difficultee == 1) {
			strategie = (Strategie) new StrategieNormal();
		} else {
			strategie = (Strategie) new StrategieDifficile();
		}

	}

	/**
	 * M�thode qui permet � l'ordinateur de jouer une carte.
	 * 
	 * @param maManche
	 * 
	 * @param leTalon
	 * @param laPioche
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
	 * @return
	 */
	public int getDifficultee() {
		return difficultee;
	}

	/**
	 * @param difficultee
	 */
	public void setDifficultee(int difficultee) {
		this.difficultee = difficultee;
	}

	/**
	 * @return
	 */
	public Strategie getStrategie() {
		return strategie;
	}

	/**
	 * @param strategie
	 */
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

}
