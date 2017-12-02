package j8;

import java.util.ArrayList;
import java.util.Scanner;

public class Variante {

	private String varianteEnCours;
	private Scanner sc;

	protected ArrayList<String> listeVariantes = new ArrayList<String>();

	public Variante() {

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

		if (varianteEnCours.equals("Minimale")) {
			changerEffet(laPioche, "Huit", "permet de changer de couleur, se pose sur n'importe quelle carte");
			changerEffet(laPioche, "Dix", "oblige a rejouer");

		} else if (varianteEnCours.equals("de Monclar")) {
			changerEffet(laPioche, "Dix", "oblige a rejouer");
			changerEffet(laPioche, "Sept", " le joueur suivant passe son tour");
			changerEffet(laPioche, "Valet", "change le sens du jeu");
			changerEffet(laPioche, "Neuf", "fait piocher une carte au joueur suivant sans recours");
			changerEffet(laPioche, "As", "fait piocher 3 cartes au joueur suivant, à moins de poser un 8 ou un As");
			changerEffet(laPioche, "Huit", "permet de changer de couleur et arrête les attaques"); // J'ai fait que 2 variables mais ca va vite, il
																	// suffit d'utiliser changerEffet
		}
	}
	

	public void changerEffet(Pioche laPioche, String valeur, String effet) { // on verifie la valeur de toute les Cartes du jeu
		for (int i = 0; i < laPioche.jeuDeCartes.size(); i++) { // Cela permet de changer de variante en cours de	Jeu			
			if (laPioche.jeuDeCartes.get(i).getValeur().equals(valeur)) { 
				laPioche.jeuDeCartes.get(i).setEffet(effet);	
			}
		}
	}
}