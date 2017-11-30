package j8;

import java.util.ArrayList;
import java.util.Scanner;

public class Variante {

	private String varianteEnCours;
	private Scanner sc;

	protected ArrayList<String> listeVariantes = new ArrayList<String>();

	public Variante() {

		
		String varianteEnCours = null;
		String[] nomVariante = new String[] { "Minimale", "de Monclar", "1", "carte et maou", "des Ulis", "4", "5", "6",
				"7 (32 cartes)", "Courte Amicale", "man et resta", "Jules", "Paradox Hech", "de l'us17",
				"par stratégie", "Rosa l'injuste" };
		for (int i = 0; i < nomVariante.length; i++) {
			String variante = new String(nomVariante[i]);
			this.listeVariantes.add(variante);
		}
	}

	public void afficherChoixVariantes() {
		System.out.println("\nChoissisez votre Variante");
		for (int i = 0; i < this.listeVariantes.size(); i++) {
			System.out.println((i + 1) + " : Variante " + listeVariantes.get(i));

		}
	}

	public void ChoisirVariante(Pioche laPioche) {
		sc = new Scanner(System.in);
		int indiceVarianteEnCours = (sc.nextInt() - 1);
		varianteEnCours = listeVariantes.get(indiceVarianteEnCours);
		System.out.println(indiceVarianteEnCours); // test
		System.out.println(varianteEnCours); // test

		if (varianteEnCours.equals("Minimale")) { // == ne marche pas toujours avec des strings c'est chelou.
			changerEffet(laPioche, "Huit", "changerCouleurJoker");
			changerEffet(laPioche, "Dix", "obligeaRejouer");
			System.out.println("coucou");

		} else if (varianteEnCours.equals("de Monclar")) {
			changerEffet(laPioche, "Dix", "obligeaRejouer");
			changerEffet(laPioche, "Sept", "passerTour");
			changerEffet(laPioche, "Valet", "changerSens");
			changerEffet(laPioche, "Neuf", "fairePiocher");
			changerEffet(laPioche, "As", "fairePiocherMonclar");
			changerEffet(laPioche, "Huit", "changerCouleurMonclar"); // J'ai fait que 2 variables mais ca va vite, il
																	// suffit d'utiliser changerEffet
		}
	}

	public void changerEffet(Pioche laPioche, String valeur, String effet) { // on verifie la valeur de toute les Cartes du jeu
		for (int i = 0; i < laPioche.jeuDeCartes.size(); i++) { // Cela permet de changer de variante en cours de	Jeu			
			if (laPioche.jeuDeCartes.get(i).getValeur().equals(valeur)) { 	//j'ai perdu 1h parce que l'égalité marchait pas ici
				laPioche.jeuDeCartes.get(i).setEffet(effet);	// parce que les valeurs des cartes sont en lettre et pas en chiffre... DIX != 10
				System.out.println("si y'a 8 fois ca pour minimal c'est bon");
			}
		}
	}
}