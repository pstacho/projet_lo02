package j8;
import java.util.Scanner;


public class JoueurPhysique extends Joueur {
	
	Scanner sc = new Scanner(System.in);

	public JoueurPhysique() {
		
		super();
		System.out.println("Saisissez votre nom");
		nom = sc.nextLine();
		
	}
	
	public void afficherMainJoueur() {
		for (int i=0; i < this.mainJoueur.size(); i++ ) {
			System.out.println((i+1)+ " : " + mainJoueur.get(i));
		}
	}	
	
	public Carte choisirCarte() {
		System.out.println("Saisissez la carte a jouer");
		int carteChoisie = sc.nextInt(); //le numero affiché par le afficher mainjoueur
		if (carteChoisie>=1 && carteChoisie <= maManche.getJoueurEnCours().mainJoueur.size()) {
			Carte carteJouee=mainJoueur.get(carteChoisie-1); //on affecte le numero de la carte la carte correspondante.
			return carteJouee;
		}
		else {
			System.out.println("Saisissez la carte a jouer");
		}
	}
	
	public void jouerCarte() {
		Carte carteJouee = this.choisirCarte();
		if (Joueur.carteCompatible(leTalon,carteJouee) == true) {
			Talon.setCarteDessus(carteJouee);
		}
	}
	
	
	
}
