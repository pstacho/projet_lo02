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
		JoueurPhysique moi = new JoueurPhysique();

		listeJoueur.add(moi);

		System.out.println("Saisissez le nombre d'ordinateurs (diff�rent de 0)");
		nombreOrdinateur = sc.nextInt();

		for (int i = 1; i <= nombreOrdinateur; i++) {
			System.out.println("Choisisez la difficult� du BOT"+ (i) + "(de 1 � 3)");
			int difficulty = sc.nextInt();
			Ordinateur ordi = new Ordinateur(i, difficulty);
			listeJoueur.add(ordi);
		}
		
		
		
		// System.out.println(listeJoueur);

		// Test qui d�termine le nombre da carte par joueur en fonction du nombre de
		// joueur
		if (nombreOrdinateur == 1) {
			nombreCarteJoueur = 10;
		} else if (nombreOrdinateur == 2) {
			nombreCarteJoueur = 8;
		} else {
			nombreCarteJoueur = 6;
		}

		System.out.println("\nChoissisez le mode de Comptage :");
		System.out.println("1 pour le compte positif");
		System.out.println("2 pour le compte n�gatif");
		modeComptage = sc.nextInt();
		while (modeComptage !=0 && modeComptage !=1) {
			System.out.println("Tu as selectionn� un mode qui n'existe pas !\n R�assaie une nouvelle fois.");
			modeComptage = sc.nextInt();
		}

	}

	/**
	 * Singleton *
	 * 
	 * @return Partie instance unique de la classe Partie
	 */
	public static Partie getPartie() {

		if (Partie.instancePartie == null) {
			Partie.instancePartie = new Partie();
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

	public void mettrePause() {

	}

	public int getNombreCarteJoueur() {
		return nombreCarteJoueur;
	}

	public void setNombreCarteJoueur(int nombreCarteJoueur) {
		this.nombreCarteJoueur = nombreCarteJoueur;
	}

	public int getModeComptage() {
		return modeComptage;
	}

	public void setModeComptage(int modeComptage) {
		this.modeComptage = modeComptage;
	}

	public static Partie getInstancePartie() {
		return instancePartie;
	}

	public static void setInstancePartie(Partie instancePartie) {
		Partie.instancePartie = instancePartie;
	}

}
