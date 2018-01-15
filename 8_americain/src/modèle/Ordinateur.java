package modèle;

/**
 * @author Stacho
 *
 */
public class Ordinateur extends Joueur {

	/**
	 * 
	 */
	private int difficultee;
	/**
	 * 
	 */
	private Carte carteJouee;
	/**
	 * 
	 */
	private Strategie strategie;

	/**
	 * @param indexBot
	 * @param difficultee
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
	 * @param maManche
	 * @param leTalon
	 * @param laPioche
	 */
	@SuppressWarnings("deprecation")
	public void jouerCarteOrdi(Manche maManche, Talon leTalon, Pioche laPioche) {

		System.out.println(this.nom + "a actuellement " + this.mainJoueur.size() + " cartes.");
		strategie.jouerCarte(this, leTalon, laPioche, maManche);
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

	/**
	 * @return
	 */
	public Carte getCarteJouee() {
		return carteJouee;
	}

	/**
	 * @param carteJouee
	 */
	public void setCarteJouee(Carte carteJouee) {
		this.carteJouee = carteJouee;
	}
}
