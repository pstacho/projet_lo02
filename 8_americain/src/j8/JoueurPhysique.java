package j8;
import java.util.Scanner;


public class JoueurPhysique extends Joueur {
	Scanner sc = new Scanner(System.in);

	public JoueurPhysique() {
		super();
		
		System.out.println("Quel est votre pr�nom et Nom?");
		nom = sc.nextLine();
		
	}

	
	
	
}
