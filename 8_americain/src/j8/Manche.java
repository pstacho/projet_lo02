package j8;

import java.util.Iterator;
import java.util.Scanner;

public class Manche {

	private Scanner sc = new Scanner(System.in);
	private Joueur joueurEnCours;
	private int indiceJoueurEnCours = 0; // je test avec le premier joueur
	private boolean PossibleDeDireCarte = true;
	public int getIndiceJoueurEnCours() {
		return indiceJoueurEnCours;
	}

	public void setIndiceJoueurEnCours(int indiceJoueurEnCours) {
		this.indiceJoueurEnCours = indiceJoueurEnCours;
	}

	private int numeroManche = 0;
	private Pioche laPioche;
	private Talon leTalon;

	// effets

	private boolean sensPositif;
	private boolean joueurRejouer = false;
	private int CarteAPiocherAs = 0;

	public int getCarteAPiocherAs() {
		return CarteAPiocherAs;
	}

	public void setCarteAPiocherAs(int carteAPiocherAs) {
		CarteAPiocherAs = carteAPiocherAs;
	}

	private boolean passerProchainTour = false;
	private boolean jeuParValeurDesactive = false;
	private boolean jeuParCouleurDesactive = false;
	private int cartesAPiocher = 0;
	private int cartesAPiocherSansRecours = 0;
	private int cartesAPiocherDansJeu = 0;

	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public boolean isSensPositif() {
		return sensPositif;
	}

	public void setSensPositif(boolean sensPositif) {
		this.sensPositif = sensPositif;
	}

	public boolean isjoueurRejouer() {
		return joueurRejouer;
	}

	public boolean isJoueurRejouer() {
		return joueurRejouer;
	}

	public void setJoueurRejouer(boolean joueurRejouer) {
		this.joueurRejouer = joueurRejouer;
	}

	public Manche() {

		numeroManche++;
		sensPositif = true;

		System.out.println("Début de la manche n° " + numeroManche);
		Variante maVariante = new Variante();
		laPioche = new Pioche();

		maVariante.afficherChoixVariantes();
		maVariante.ChoisirVariante(laPioche); // ca doit etre placé avant distruibuer, j'ai pas en fait pour que ca
												// change en jeux mais c'est possible en theorie

		// for (int i = 0; i < laPioche.jeuDeCartes.size(); i++) { // test
		// System.out.println(laPioche.jeuDeCartes.get(i).getEffet()); // test
		// } // test

		laPioche.attribuerPointCarte();

		// test pour voir l'attribution des points aux cartes selon la variante
		/*
		 * Iterator<Carte> it = laPioche.jeuDeCartes.iterator(); while (it.hasNext()) {
		 * System.out.println(it.next().getPoint()); }
		 */

		laPioche.distribuer(); // distribution des cartes aux joueurs

		leTalon = new Talon(laPioche); // Création du talon
		leTalon.afficherCarteDessus();

		// Determine un joueurs qui commence au hasard

		indiceJoueurEnCours = (int) (Math.random() * (Partie.getPartie().getNombreOrdinateur() - 0));
		// on initialise indiceJoueurEnCours a un nombre aléatoire compris entre 0 et le
		// nombre de joueur afin de determiener aléatoirement le joeur qui commence
		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(indiceJoueurEnCours);
		while (joueurEnCours.mainJoueur.size() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jouerTourDeJeu();
		}
		finirManche();

	}

	public void jouerTourDeJeu() {

		if (joueurEnCours instanceof JoueurPhysique) {
			System.out.println(joueurEnCours.getNom() + ", c'est à toi de jouer.\r");
			((JoueurPhysique) joueurEnCours).afficherMainJoueur();
			((JoueurPhysique) joueurEnCours).jouerCarte(this, laPioche, leTalon);

		} else {
			System.out.println(joueurEnCours.getNom() + " joue son tour.");
			((Ordinateur) joueurEnCours).jouerCarteOrdi(this, leTalon, laPioche);
		}
		checkdireCarte(leTalon);
		joueurSuivant();
	}

	public void joueurSuivant() {
		if (joueurRejouer == false) {
			if (sensPositif == true) {
				indiceJoueurEnCours++;
				if (indiceJoueurEnCours >= Partie.getPartie().getNombreOrdinateur() + 1) {
					indiceJoueurEnCours = 0;

				}

			} else {
				indiceJoueurEnCours--;// pour les variantes changement de sens
				if (indiceJoueurEnCours < 0) {
					indiceJoueurEnCours = Partie.getPartie().getNombreOrdinateur();

				}

			}
		} else {
			joueurRejouer = false;
		}

		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(indiceJoueurEnCours);

	}

	public void checkdireCarte(Talon leTalon) {
		if (joueurEnCours.mainJoueur.size() == 1) {
			if (joueurEnCours instanceof JoueurPhysique) {
				System.out.println("ecrirez 'carte'");
				String Carte = sc.nextLine();
				if (Carte.equals("carte")) {
					System.out.println("vous avez dit carte, vous ne piocher pas de carte");
				}
				else {
					Carte cartePiochee = laPioche.piocherCarte(leTalon);
					joueurEnCours.mainJoueur.add(cartePiochee);
					System.out.println("Vous avez pioché la carte " + cartePiochee.toString() + " , car vous n'avez pas dit carte.");
				}
				
			} else if (joueurEnCours instanceof Ordinateur) {
				int indiceDireCarte = (int) (Math.random() * (5 - 0));
				if (indiceDireCarte != 0) {
					System.out.println(joueurEnCours.nom + " dit carte, il ne doit pas piocher");
				}
				else {
					Carte cartePiochee = laPioche.piocherCarte(leTalon);
					joueurEnCours.mainJoueur.add(cartePiochee);
					System.out.println(joueurEnCours.nom + " pioche une carte car il n'a pas dit carte");
				}
			}
		}
	}
/*
	public void contreCarte() {
		if (joueurEnCours.mainJoueur.size() == 1) {
			if (joueurEnCours instanceof JoueurPhysique) {
				System.out.println("vous avez 5 secondes pour ecrire 'carte'");
				String Carte = sc.nextLine();
				if (Carte.equals("carte")) {
					System.out.println("vous avez dit carte, vous ne piocher pas de carte");
				}
				else {
					Carte cartePiochee = laPioche.piocherCarte(leTalon);
					joueurEnCours.mainJoueur.add(cartePiochee);
				}
				
			} else if (joueurEnCours instanceof Ordinateur) {
				int indiceDireCarte = (int) (Math.random() * (1 - 0));
				if (indiceDireCarte == 1) {
					System.out.println(Partie.getPartie().listeJoueur
							.get((int)Math.random() * (Partie.getPartie().getNombreOrdinateur() + 1 - 1))
							+ "Dit carte, il ne doit pas piocher");
				}
			}
		}
	}
*/
	private void finirManche() {
		// TODO Auto-generated method stub
		if (Partie.getPartie().getModeComptage() == 1) {
			System.out.println(joueurEnCours.nom + " a gagné la manche n°" + numeroManche);
			for (int i = 0; i < Partie.getPartie().getListeJoueur().size(); i++) {
				Partie.getPartie().getListeJoueur().get(i).compterPoints();
			}
		}
		System.out.println("Voulez-vous faire une autre manche ? ( 1 si oui | 0 si non )");
		Manche maManche = new Manche();

	}

	public Pioche getLaPioche() {
		return laPioche;
	}

	public void setLaPioche(Pioche laPioche) {
		this.laPioche = laPioche;
	}

	public Talon getLeTalon() {
		return leTalon;
	}

	public void setLeTalon(Talon leTalon) {
		this.leTalon = leTalon;
	}
}
