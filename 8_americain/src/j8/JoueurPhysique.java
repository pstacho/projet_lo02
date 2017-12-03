package j8;

import java.util.ArrayList;
import java.util.Scanner;

public class JoueurPhysique extends Joueur {

	Scanner sc = new Scanner(System.in);
	private Carte carteJouee;
	private Carte cartePiochee;
	
	public JoueurPhysique() {

		super();
		System.out.println("Saisissez votre nom");
		nom = sc.nextLine();

	}

	public void afficherMainJoueur() {
		
		for (int i = 0; i < this.mainJoueur.size(); i++) {
			
			if (this.mainJoueur.get(i).getEffet().equals("null")) {
				System.out.println((i + 1) + " : " + mainJoueur.get(i));
			}
			else {
				System.out.println((i + 1) + " : " + mainJoueur.get(i) +"   effet: " + this.mainJoueur.get(i).getEffet());
			}
			
		}
	}

	public void jouerCarte(Pioche laPioche, Talon leTalon) {

		System.out.println("Saisissez la carte a jouer ou appuyer sur 0 pour piocher\n");
		leTalon.afficherCarteDessus();
		int carteChoisie = sc.nextInt(); // le numero affich� par le afficher mainjoueur
		if (carteChoisie >= 1 && carteChoisie <= mainJoueur.size()) {
			carteJouee = mainJoueur.get(carteChoisie - 1); // on affecte le numero de la carte la carte correspondante.
			//monEffet.checkEffet(maManche,carteJouee);
			if (carteCompatible(leTalon, carteJouee) == true) {
				this.mainJoueur.remove(carteJouee);
				leTalon.ajouterCarte(carteJouee);
				leTalon.afficherCarteDessus();
			}
			else {
				System.out.println("Tu ne peux pas jouer cette carte !");
				jouerCarte(laPioche,leTalon);
			}
		} else if (carteChoisie > mainJoueur.size()) {
			System.out.println("Tu n'as pas autant de cartes ! Choisi une autre carte");
			jouerCarte (laPioche,leTalon);
			
		} else if (carteChoisie == 0){
			cartePiochee = laPioche.piocherCarte();
			mainJoueur.add(cartePiochee);
			System.out.println("Vous avez pioch� la carte " + cartePiochee.toString() + " .");

		}

	}
}
