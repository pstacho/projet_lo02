package j8;
import java.util.Scanner;

public class Ordinateur extends Joueur {

	private Scanner sc;
	private int difficultee;
	private Carte carteJouee;
	
	public Ordinateur() {
		
		super();
		sc = new Scanner(System.in);
		System.out.println("Saisisez le nom de l'Ordinateur "+(indiceJoueur-1));
		nom = sc.nextLine();
		
		System.out.println("Choisisez la difficulté de l'ordinateur" + (indiceJoueur-1) + "(de 1 à 3)");
		difficultee=sc.nextInt();
	}

	public void jouerCarte(Manche maManche, Talon leTalon, Pioche laPioche) {
		
		if (difficultee == 1) {
			int i=0;
			carteJouee = this.mainJoueur.get(i);
			while (!carteCompatible(leTalon,carteJouee)) {
				while(i <= this.mainJoueur.size()) {
					i++;
				}
			}
			carteJouee = this.mainJoueur.get(i);
			if (!carteCompatible(leTalon,carteJouee)) {
				Carte cartePioche = laPioche.piocherCarte();
				this.mainJoueur.add(cartePioche);
				System.out.println(this.nom + " pioche une carte.");
			}
			else {
				System.out.println(this.nom + "a joué la carte " + carteJouee.toString() + " .");	
				leTalon.ajouterCarte(carteJouee);
				this.mainJoueur.remove(carteJouee);
			}
		}	
	}
}
