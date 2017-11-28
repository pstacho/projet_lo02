package j8;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	
	protected ArrayList<Carte> mainJoueur;
	protected String nom;
	//private int nbCartes;
	private int point;
	private int numero;
	protected static int indiceJoueur=0;
	
	
	public String toString() {
		return "Joueur [mainJoueur=" + mainJoueur + ", nom=" + nom + ", indiceJoueur=" + numero + "]";
	}

	public Joueur() {
		indiceJoueur++;
		this.numero=indiceJoueur;
		point = 0;
		mainJoueur = new ArrayList<Carte>();
	}

	public ArrayList<Carte> getMainJoueur() {
		return mainJoueur;
	}


	public void setMainJoueur(ArrayList<Carte> mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	public boolean carteCompatible(Talon leTalon, Carte carte) {
		if (carte.getCouleur() ==  leTalon.getCarteDessus().getCouleur() || carte.getValeur() == leTalon.getCarteDessus().getValeur()) {
			return true;
		}
		else {
			return false;
		}	
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

}