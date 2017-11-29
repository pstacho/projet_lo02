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
	
	public void choisirCarte(Manche maManche, Talon leTalon, Pioche laPioche) {
		
		//revoir ce bloc
		
		/*for (int i=0 ; i <= mainJoueur.size(); i++ ) {
			if (carteCompatible(leTalon, mainJoueur.get(i)) == true) {
				cartesJouable.add(mainJoueur.get(i));
			}
		}*/ 
		
		System.out.println("Saisissez la carte a jouer\n");
		leTalon.afficherCarteDessus();
		int carteChoisie = sc.nextInt(); //le numero affiché par le afficher mainjoueur
		if (carteChoisie>=1 && carteChoisie <= maManche.getJoueurEnCours().mainJoueur.size()) {
			carteJouee=mainJoueur.get(carteChoisie-1); //on affecte le numero de la carte la carte correspondante.
			
		}
		else {
			choisirCarte(maManche, leTalon, laPioche);
		}
		
	}
	
	public void jouerCarte(Manche maManche, Talon leTalon, Pioche laPioche) {
		ArrayList<Carte> cartesJouables = new ArrayList<Carte>();
		choisirCarte(maManche, leTalon, laPioche);
		if (carteCompatible(leTalon,carteJouee) == true) {
			this.mainJoueur.remove(carteJouee);
			leTalon.ajouterCarte(carteJouee);
			leTalon.afficherCarteDessus();
		}
		else {
			laPioche.piocherCarte();
			mainJoueur.add(cartePioche);
			System.out.println("Vous avez pioché la carte " + laPioche.piocherCarte() +" .");	
		}
	}	
}
