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
	private Scanner s;
	protected LinkedList<Joueur> listeJoueur = new LinkedList<Joueur>();
    private static Partie instancePartie;
	
	public LinkedList<Joueur> getListeJoueur() {
		return listeJoueur;
	}

	public void setListeJoueur(LinkedList<Joueur> listeJoueur) {
		this.listeJoueur = listeJoueur;
	}

	private Partie() {
		
		s = new Scanner(System.in);
		JoueurPhysique moi= new JoueurPhysique();
		
		listeJoueur.add(moi);
		
		System.out.println("Saisissez le nombre d'ordinateurs");
		nombreOrdinateur = s.nextInt();
		for (int i=0; i<nombreOrdinateur; i++) {
			Ordinateur ordi = new Ordinateur();
			listeJoueur.add(ordi);
		}
		System.out.println(listeJoueur);
		
		
	}
	
	/** Singleton 
	* *
	* 
	* @return Partie instance unique de la classe Partie
	*/
	public static Partie getPartie() {

	if (Partie.instancePartie==null)
	{
	Partie.instancePartie= new Partie();
	}
		return Partie.instancePartie; 
	}
	
	
	public void lancerJeu() {
		Manche manche = new Manche();
		
	}
	
	public int getNombreOrdinateur() {
		return nombreOrdinateur;
	}

	public void setNombreOrdinateur(int nombreOrdinateur) {
		this.nombreOrdinateur = nombreOrdinateur;
	}

	public void changerVariante() {
		
	}
	
	public void mettrePause() {
		
	}
	
	
}
