package modèle;

/**
 * L'interface Strategie.
 * 
 * @author Stacho
 *
 */
public interface Strategie {

	/**
	 * Méthode qui permet de définir la carte à jouer pour un ordinateur.
	 * 
	 * @param ordi
	 *            Ordinateur sur lequel est utilisé la méthode.
	 * @param maManche
	 *            La manche en cours.
	 */
	void jouerCarte(Ordinateur ordi, Manche maManche);

}
