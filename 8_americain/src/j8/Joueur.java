package j8;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	
	protected ArrayList<Carte> mainJoueur;
	protected String nom;
	//private int nbCartes;
	//private int point;
	private int numero;
	protected static int indiceJoueur=0;
	
	@Override
	public String toString() {
		return "Joueur [mainJoueur=" + mainJoueur + ", nom=" + nom + ", indiceJoueur=" + numero + "]";
	}

	public Joueur() {
		
		indiceJoueur++;
		this.numero=indiceJoueur;
		mainJoueur = new ArrayList<Carte>();
	}

	public ArrayList<Carte> getMainJoueur() {
		return mainJoueur;
	}


	public void setMainJoueur(ArrayList<Carte> mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	
}