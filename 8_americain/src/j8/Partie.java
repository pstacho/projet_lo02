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

	private Partie() throws InvalidDifficulteeOrdi {

		sc = new Scanner(System.in);
		JoueurPhysique moi = new JoueurPhysique();

		listeJoueur.add(moi);

		System.out.println("Saisissez le nombre d'ordinateurs (différent de 0)");
		nombreOrdinateur = sc.nextInt();

		for (int i = 1; i <= nombreOrdinateur; i++) {
			System.out.println("Choisisez la difficulté du BOT"+ (i) + "\n1 : Normal\n2 : Difficile");
			int difficulty = sc.nextInt();
			if (difficulty != 1 || difficulty !=2) {
				InvalidDifficulteeOrdi ido = new InvalidDifficulteeOrdi("Cette difficultée n'existe pas !");
				throw ido;
			}
			Ordinateur ordi = new Ordinateur(i, difficulty);
			listeJoueur.add(ordi);
		}

		// Test qui détermine le nombre da carte par joueur en fonction du nombre de
		// joueur
		if (nombreOrdinateur == 1) {
			nombreCarteJoueur = 10;
		} else if (nombreOrdinateur == 2) {
			nombreCarteJoueur = 8;
		} else {
			nombreCarteJoueur = 6;
		}

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
		*/

	}

	/**
	 * Singleton *
	 * 
	 * @return Partie instance unique de la classe Partie
	 */
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
