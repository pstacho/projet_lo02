package j8;
import java.util.Scanner;

public class Ordinateur extends Joueur {

	private Scanner sc;
	private int difficultee;
	public Ordinateur() {
		
		super();
		sc = new Scanner(System.in);
		System.out.println("Saisisez le nom de l'Ordinateur "+(indiceJoueur-1));
		nom = sc.nextLine();
		
		System.out.println("Choisisez la difficulté de l'ordinateur" + (indiceJoueur-1) + "(de 1 à 3)");
		difficultee=sc.nextInt();
	}

	public Carte ChoisirCarte() {
		Carte CarteJouee;
		return CarteJouee; //a faire pour ordinateur, normal qu'il y ai une erreur
	}
	public void JouerCarte(Carte carteJouee) {
		 //a faire pour ordinateur
	}
}
