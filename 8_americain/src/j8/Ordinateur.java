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
		
		System.out.println("Choisisez la difficult� des Ordinateurs (de 1 � 3)");
		difficultee=sc.nextInt();
	}

}