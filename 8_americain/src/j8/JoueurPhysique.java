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
	
	public void choisirCarte(Manche maManche, Talon leTalon) {
		System.out.println("Saisissez la carte a jouer\n");
		leTalon.afficherCarteDessus();
		int carteChoisie = sc.nextInt(); //le numero affiché par le afficher mainjoueur
		if (carteChoisie>=1 && carteChoisie <= maManche.getJoueurEnCours().mainJoueur.size()) {
			carteJouee=mainJoueur.get(carteChoisie-1); //on affecte le numero de la carte la carte correspondante.
			
		}
		else {
			choisirCarte(maManche, leTalon);
		}
		
		// dire de piocher une carte si aucune carte compatible
		
	}
	
	public void jouerCarte(Manche maManche, Talon leTalon, Pioche laPioche) {
		choisirCarte(maManche, leTalon);
		if (carteCompatible(leTalon,carteJouee) == true) {
			this.mainJoueur.remove(carteJouee);
			leTalon.ajouterCarte(carteJouee);
			leTalon.afficherCarteDessus();
		}
	}
	
	
	
}
