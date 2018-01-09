package modèle;

import java.util.Scanner;

import modèle.Joueur;

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
	protected LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();
	private Manche Manche;

	public LinkedList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(LinkedList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	/*
	private Partie() throws InvalidDifficulteeOrdi {

		
		
		sc = new Scanner(System.in);
		JoueurPhysique moi = new JoueurPhysique();
		listeJoueurs.add(moi);

		System.out.println("Saisissez le nombre d'ordinateurs (différent de 0)");
		nombreOrdinateur = sc.nextInt();

		for (int i = 1; i <= nombreOrdinateur; i++) {
			System.out.println("Choisisez la difficulté du BOT"+ (i) + "\n1 : Normal\n2 : Difficile");
			int difficulty = sc.nextInt();
			if (difficulty != 1 && difficulty !=2) {
				InvalidDifficulteeOrdi ido = new InvalidDifficulteeOrdi("Cette difficultée n'existe pas !");
				throw ido;
			}
			Ordinateur ordi = new Ordinateur(i, difficulty);
			listeJoueurs.add(ordi);
		}

		// Test qui détermine le nombre da carte par joueur en fonction du nombre de
		// joueur
		

		modeComptage = 1;
		
	// A implémenter lorque le comptage positif sera prêt
		
		/*System.out.println("\nChoissisez le mode de Comptage :");
		System.out.println("1 pour le compte positif");
		System.out.println("2 pour le compte négatif");
		modeComptage = sc.nextInt();
		while (modeComptage !=0 && modeComptage !=1) {
			System.out.println("Tu as selectionné un mode qui n'existe pas !\n Réassaie une nouvelle fois.");
			modeComptage = sc.nextInt();
		}
		

	}

	
	*/
	
	
	/**
	 * Singleton *
	 * 
	 * @return Partie instance unique de la classe Partie
	 */
	/*
	public static Partie getPartie() {

		if (Partie.instancePartie == null) {
			try {
				Partie.instancePartie = new Partie();
			} catch (InvalidDifficulteeOrdi e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Partie.instancePartie;
	}
	
	*/
	private Partie() {
System.out.println("testcool");
	}
	
	
	public static Partie getPartie() {
		return maPartie;
	}

	private static Partie maPartie = new Partie();
	
	public Manche lancerJeu() {
		
		Manche maManche = new Manche();
		Manche=maManche;
		return maManche;
	}

	

	public Manche getManche() {
		return Manche;
	}

	public void setLaManche(Manche laManche) {
		this.Manche = Manche;
	}

	public int getNombreOrdinateur() {
		return nombreOrdinateur;
	}


	public int getNombreCarteJoueur() {
		return nombreCarteJoueur;
	}

	public void setNombreCarteJoueur() {
		System.out.println("il y a" + nombreOrdinateur +"ordis");
		if (nombreOrdinateur == 1) {
			nombreCarteJoueur = 10;
		} else if (nombreOrdinateur == 2) {
			nombreCarteJoueur = 8;
		} else {
			nombreCarteJoueur = 6;
		}
		this.nombreCarteJoueur = nombreCarteJoueur;
	}

	public int getModeComptage() {
		return modeComptage;
	}

	public void updatePartie(int modeComptage, LinkedList<Joueur> listeJoueurs, String variante) {
		this.listeJoueurs = listeJoueurs;
		this.nombreOrdinateur = listeJoueurs.size()-1;
		this.modeComptage = modeComptage;
		this.variante = variante;
		System.out.println("Variante : " + this.variante);
		System.out.println("Mode comptage:" + this.modeComptage);
		System.out.println("nb joueurs fdp" + listeJoueurs);
	}

	public String getVariante() {
		return variante;
	}

	

}
