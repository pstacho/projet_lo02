package j8;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Partie {
	
	private int nombreOrdinateur;
	private String variante;
	private String nomGagnant;
	private Scanner sc;
	protected LinkedList<Joueur> listeJoueur = new LinkedList<Joueur>();
	
	
	public Partie() {
		
		sc = new Scanner(System.in);
		JoueurPhysique moi= new JoueurPhysique();
		
		listeJoueur.add(moi);
		
		System.out.println("Saisissez le nombre d'ordinateurs");
		nombreOrdinateur = sc.nextInt();
		for (int i=0; i<nombreOrdinateur; i++) {
			Ordinateur ordi = new Ordinateur();
			listeJoueur.add(ordi);
		}
		System.out.println(listeJoueur);
	}
	
	public void changerVariante() {
		
	}
	
	public void mettrePause() {
		
	}
	
	
}
