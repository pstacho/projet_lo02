package modèle;

/**
 * @author Stacho
 *
 */
public interface Strategie {
	
	/**
	 * @param ordi
	 * @param leTalon
	 * @param laPioche
	 * @param maManche
	 */
	void jouerCarte(Ordinateur ordi, Talon leTalon, Pioche laPioche, Manche maManche);

}
