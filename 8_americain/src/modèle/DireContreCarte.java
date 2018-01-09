package modèle;
import modèle.Joueur;

import java.util.Observable;


public class DireContreCarte extends Observable implements Runnable {

	private Joueur j;

	public DireContreCarte(Joueur j) {
		this.j= j;
		Thread t = new Thread(this);
		t.start();
	}

	
	
	public void run() {
		try {// Temps de delais entre chaque tour
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!this.j.isContrecarte() && this.j.getMainJoueur().size() == 1 && !j.isCarte()) {
			System.out.println(j.getNom()+ " dit carte");
			this.j.setCarte(true);
		}
	}	

}
