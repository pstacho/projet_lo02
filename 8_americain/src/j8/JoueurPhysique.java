package j8;
import java.util.ArrayList;
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
	
	public void choisirCarte(Talon leTalon, Pioche laPioche) {
	
		
		System.out.println("Saisissez la carte a jouer ou appuyer sur 0 pour piocher\n");
		leTalon.afficherCarteDessus();
		int carteChoisie = sc.nextInt(); //le numero affiché par le afficher mainjoueur
		if (carteChoisie>=1 && carteChoisie <= mainJoueur.size()) {
			carteJouee=mainJoueur.get(carteChoisie-1); //on affecte le numero de la carte la carte correspondante.
			
		}
		else if (carteChoisie > mainJoueur.size()) {
			System.out.println("Tu n'as pas autant de cartes ! Choisi une autre carte");
			choisirCarte(leTalon, laPioche);
		}
		else {
			Carte cartePioche = laPioche.piocherCarte();
			this.mainJoueur.add(cartePioche);
			System.out.println("Vous avez pioché la carte " + laPioche.piocherCarte() +" .");	
			
		}
		
	}
	
	public void jouerCarte(Talon leTalon, Pioche laPioche) {
		choisirCarte(leTalon, laPioche);
		if (carteCompatible(leTalon,carteJouee) == true) {
			this.mainJoueur.remove(carteJouee);
			leTalon.ajouterCarte(carteJouee);
			leTalon.afficherCarteDessus();
		}
		else {
			System.out.println("Tu ne peux pas jouer cette carte !");
			choisirCarte(leTalon,laPioche);
		}
	}	
}
