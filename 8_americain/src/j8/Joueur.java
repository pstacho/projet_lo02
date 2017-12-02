package j8;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {

	protected ArrayList<Carte> mainJoueur;
	protected String nom;
	// private int nbCartes;
	private int score;
	private int numero;
	protected static int indiceJoueur = 0;

	public String toString() {
		return "Joueur [mainJoueur=" + mainJoueur + ", nom=" + nom + ", indiceJoueur=" + numero + "]";
	}

	// Constructeur de Joueur
	public Joueur() {
		indiceJoueur++;
		this.numero = indiceJoueur;
		score = 0;
		mainJoueur = new ArrayList<Carte>();
	}

	// Vérifie si la carte choisi par le joueur peut être poser sur le talon
	public boolean carteCompatible(Talon leTalon, Carte carte) {
		if (carte.getCouleur() == leTalon.getCarteDessus().getCouleur()
				|| carte.getValeur() == leTalon.getCarteDessus().getValeur()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void compterPoints() {
		for (int i = 0; i <= mainJoueur.size(); i++) {
			if(mainJoueur.get(i).getEffet().equals("null")) {
				 
		
			}
		}		
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

}