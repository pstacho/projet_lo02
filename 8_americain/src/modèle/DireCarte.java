package modèle;

import java.util.*;

/**
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class DireCarte extends Observable implements Runnable {

	/**
	 * 
	 */
	private Joueur joueur;

	/**
	 * @param j
	 */
	public DireCarte(Joueur j) {
		this.joueur = j;
		Thread t = new Thread(this);
		t.start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// Temps de delais entre chaque tour
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (this.joueur.isCarte()) {
			System.out.println(joueur.getNom() + " ContreCarte");
			this.joueur.setContrecarte(true);
		}
		this.joueur.changed();
		this.joueur.notifyObservers("a joué");

	}

}
