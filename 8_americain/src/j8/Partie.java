package j8;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Partie {
	
	private int nombreOrdinateur;
	private int nombreCarteJoueur;
	private String variante;
	private String nomGagnant;
	private int modeComptage;
	private Scanner sc;
	protected LinkedList<Joueur> listeJoueur = new LinkedList<Joueur>();
    private static Partie instancePartie;
	
	public LinkedList<Joueur> getListeJoueur() {
		return listeJoueur;
	}

	public void setListeJoueur(LinkedList<Joueur> listeJoueur) {
		this.listeJoueur = listeJoueur;
	}

	private Partie() {
		
		sc = new Scanner(System.in);
		JoueurPhysique moi= new JoueurPhysique();
		
		listeJoueur.add(moi);
		
		System.out.println("Saisissez le nombre d'ordinateurs (différent de 0)");
		nombreOrdinateur = sc.nextInt();

		for (int i=0; i<nombreOrdinateur; i++) {
			Ordinateur ordi = new Ordinateur();
			listeJoueur.add(ordi);
		}
		System.out.println(listeJoueur);
		
		//Test qui détermine le nombre da carte par joueur en fonction du nombre de joueur
		if (nombreOrdinateur == 1) {
			nombreCarteJoueur = 10;
		}
		else if (nombreOrdinateur == 2) {
			nombreCarteJoueur = 8;
		}
		else {nombreCarteJoueur = 6;}
		
		System.out.println("\nChoissisez le mode de Comptage :");
		System.out.println("Tapez 1 pour le compte positif");
		System.out.println("Tapez 2 pour le compte négatif");
		
		modeComptage = sc.nextInt();
		
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
		Manche maManche = new Manche();
		
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

	public int getNombreCarteJoueur() {
		return nombreCarteJoueur;
	}

	public void setNombreCarteJoueur(int nombreCarteJoueur) {
		this.nombreCarteJoueur = nombreCarteJoueur;
	}
	
	
}
