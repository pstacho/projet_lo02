package modèle;
import java.util.*;

public class DireCarte extends Observable  implements Runnable {

	private Joueur j;

	public DireCarte( Joueur j) {
		this.j=j;		
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {// Temps de delais entre chaque tour
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!this.j.isCarte()) {
			System.out.println(j.getNom()+ " ContreCarte");
			this.j.setContrecarte(true);		
		}
		this.j.changed();
		this.j.notifyObservers("a joué");
		
	}

}
