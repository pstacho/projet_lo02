package modèle;

import modèle.Joueur;

import java.util.Observable;

/**
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class DireContreCarte extends Observable implements Runnable {

	/**
	 * 
	 */
	private Joueur joueur;

	/**
	 * @param j
	 */
	public DireContreCarte(Joueur j) {
		this.joueur = j;
		Thread t = new Thread(this);
		t.start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {// Temps de delais entre chaque tour
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!this.joueur.isContrecarte() && this.joueur.getMainJoueur().size() == 1 && !joueur.isCarte()) {
			System.out.println(joueur.getNom() + " dit carte");
			this.joueur.setCarte(true);
		}
	}

}
