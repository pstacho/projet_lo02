package j8;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Partie {
	
	private int nbreOrdinateur;
	private String variante;
	private String nomGagnant;
	private Scanner sc;
	protected ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	
	
	public Partie() {
		
		sc = new Scanner(System.in);
		
		System.out.println("Nombre d'Ordinateurs?");
		nbreOrdinateur = sc.nextLine();
	
		System.out.println("Choisisez la difficult� des Ordinateurs (de 1 � 3)");
		nbreOrdinateur = nbreJ;
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void changerVariante() {
		
	}
	
	public void mettrePause() {
		
	}
	
	public void addOrdinateur() {
		nbreOrdinateur++;
	}
	
}
