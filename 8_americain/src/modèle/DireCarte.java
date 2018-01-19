package modèle;

import java.util.*;

/**
 * Classe qui représente un "Dire Carte". Lorsqu'un instance de cette classe est
 * créée, un nouveau thread se lance et applique les opérations à effectuer.
 * 
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class DireCarte extends Observable implements Runnable {

	/**
	 * Le joueur qui a dit "carte".
	 */
	private Joueur joueur;

	/**
	 * Constructeur de DireCarte. On créée un nouveau thread et on le lance.
	 * 
	 * @param j
	 *            Le joueur qui dit "carte".
	 */
	public DireCarte(Joueur j) {
		this.joueur = j;
		Thread t = new Thread(this);
		t.start();
	}

	/*
	 * (non-Javadoc)
	 * 
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
