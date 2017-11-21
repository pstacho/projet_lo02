package j8;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	
	protected ArrayList<Carte> mainJoueur = new ArrayList<Carte>();
	private String nom;
	private int nbCartes;
	private int point;
	
	public Joueur(String name,int nbCart,int poi) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
		this.nbCartes=nbCart;
		this.point=poi;
		System.out.println("Quel est votre prénom et Nom?");
		this.name = sc.nextLine();
	}

	public ArrayList<Carte> getMainJoueur() {
		return mainJoueur;
	}


	public void setMainJoueur(ArrayList<Carte> mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	
	
	
}
