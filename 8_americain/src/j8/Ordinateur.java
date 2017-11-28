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

	public void jouerCarte(Manche maManche, Talon leTalon) {
		int i=-1;
		while (!carteCompatible(leTalon,carteJouee)) {
			i++;
			carteJouee = mainJoueur.get(i);
			
		}
		leTalon.setCarteDessus(carteJouee);
		this.mainJoueur.remove(0);
		
	}
}
