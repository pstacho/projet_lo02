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
	
	public void jouerCarte() {
		
	}
	
	
	
}
