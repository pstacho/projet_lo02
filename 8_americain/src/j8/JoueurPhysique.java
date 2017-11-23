package j8;
import java.util.Scanner;


public class JoueurPhysique extends Joueur {
	Scanner sc = new Scanner(System.in);

	public JoueurPhysique() {
		super();
		
		System.out.println("Quel est votre prénom et Nom?");
		nom = sc.nextLine();
		
	}

	
	
	
}
