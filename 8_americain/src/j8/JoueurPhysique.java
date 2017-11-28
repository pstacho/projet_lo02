package j8;
import java.util.Scanner;


public class JoueurPhysique extends Joueur {
	
	Scanner sc = new Scanner(System.in);
	private Carte carteJouee;

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
	
	public void choisirCarte(Manche maManche) {
		System.out.println("Saisissez la carte a jouer");
		int carteChoisie = sc.nextInt(); //le numero affiché par le afficher mainjoueur
		if (carteChoisie>=1 && carteChoisie <= maManche.getJoueurEnCours().mainJoueur.size()) {
			carteJouee=mainJoueur.get(carteChoisie-1); //on affecte le numero de la carte la carte correspondante.
			
		}
		else {
			choisirCarte(maManche);
		}
	}
	
	public void jouerCarte(Manche maManche, Talon leTalon) {
		choisirCarte(maManche);
		if (carteCompatible(leTalon,carteJouee) == true) {
			leTalon.setCarteDessus(carteJouee);
			this.mainJoueur.remove(0);
		}
	}
	
	
	
}
