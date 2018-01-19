package mod�le;

/**
 * L'interface Strategie.
 * 
 * @author Stacho
 *
 */
public interface Strategie {

	/**
	 * M�thode qui permet de d�finir la carte � jouer pour un ordinateur.
	 * 
	 * @param ordi
	 *            Ordinateur sur lequel est utilis� la m�thode.
	 * @param maManche
	 *            La manche en cours.
	 */
	void jouerCarte(Ordinateur ordi, Manche maManche);

}
