package modèle;

import java.util.Observable;

/**
 * Classe Manche représente une manche de la partie. La classe implémente
 * Runnable.
 * 
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class Manche extends Observable implements Runnable {

	/**
	 * Retourne le numéro de la manche.
	 * 
	 * @return le numéro de la manche.
	 */
	public int getNumeroManche() {
		return numeroManche;
	}

	/**
	 * Met à jour le numéro de la manche.
	 * 
	 * @param numeroManche
	 *            Le nouveau numéro de la manche.
	 */
	public void setNumeroManche(int numeroManche) {
		this.numeroManche = numeroManche;
	}

	/**
	 * Le joueurs qui est entrain de jouer son tour.
	 */
	private Joueur joueurEnCours;
	/**
	 * L'indice du joueur entrain de jouer.
	 */
	private int indiceJoueurEnCours = 0;

	/***
	 * Retourne l'indice du joueur qui joue son tour.
	 * 
	 * @return L'indice du joueur qui joue son tour.
	 */
	public int getIndiceJoueurEnCours() {
		return indiceJoueurEnCours;
	}

	/**
	 * Met à jour l'indice du joueur qui est entrain de jouer son tour.
	 * 
	 * @param indiceJoueurEnCours
	 *            Le nouvel indice du joueur qui doit jouer son tour.
	 */
	public void setIndiceJoueurEnCours(int indiceJoueurEnCours) {
		this.indiceJoueurEnCours = indiceJoueurEnCours;
	}

	/**
	 * Le numéro de la manche.
	 */
	private int numeroManche = 0;
	/**
	 * La pioche de la manche.
	 */
	private Pioche laPioche;
	/**
	 * Le talon de la manche.
	 */
	private Talon leTalon;

	/**
	 * Un boolean qui indique le sens de passage au joueur suivant. Si sensPositif à
	 * "Vrai", on suit l'ordre des numéros de joueurs dans l'ordre croissant.
	 */
	private boolean sensPositif;
	/**
	 * Un boolean qui indique si l'effet "rejouer" a été activé.
	 */
	private boolean joueurRejouer = false;
	/**
	 * Entier qui indique le nombre de carte à piocher en cas d'effet qui fait
	 * piocher.
	 */
	private int CarteAPiocherAs = 0;

	/**
	 * Retounre le nombre de cartes à piocher en cas d'effet "piocher" d'une carte
	 * As.
	 * 
	 * @return La valeur de CarteAPiocherAs.
	 */
	public int getCarteAPiocherAs() {
		return CarteAPiocherAs;
	}

	/**
	 * Met à jour la valeur de cartes à piocher en cas d'effet "piocher" par une
	 * carte As.
	 * 
	 * @param carteAPiocherAs
	 *            La nouvelle valeur de carteAPiocherAs.
	 */
	public void setCarteAPiocherAs(int carteAPiocherAs) {
		CarteAPiocherAs = carteAPiocherAs;
	}

	/**
	 * Un entier qui indique le nombre de cartes avec lesquelles on joue.
	 */
	private int nombreDeCartes;

	/**
	 * Retourne le nombre de cartes avec lesquelles on joue.
	 * 
	 * @return Le nombre cartes avec lesquelles on joue.
	 */
	public int getNombreDeCartes() {
		return nombreDeCartes;
	}

	/**
	 * Met à jour le nombre de cartes avec lesquelles on joue la manche.
	 * 
	 * @param nombreDeCartes
	 *            Le nouveau nombre de cartes avec lesquelles on joue.
	 */
	public void setNombreDeCartes(int nombreDeCartes) {
		this.nombreDeCartes = nombreDeCartes;
	}

	/**
	 * Retourne le joueur qui est entrain de jouer son tour.
	 * 
	 * @return Le joueur qui joue son tour.
	 */
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	/**
	 * Met à jour le joueur qui joue son tour de jeu.
	 * 
	 * @param joueurEnCours
	 *            Le nouveau joueur qui joue son tour.
	 */
	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	/**
	 * Retourne la valeur du boolean sensPositif
	 * 
	 * @return La valeur de sensPositif
	 */
	public boolean isSensPositif() {
		return sensPositif;
	}

	/**
	 * Met à jour le boolean sensPositf.
	 * 
	 * @param sensPositif
	 *            La nouvelle valeur de sensPositif.
	 */
	public void setSensPositif(boolean sensPositif) {
		this.sensPositif = sensPositif;
	}

	/**
	 * Retourne la valeur de jouerRejouer.
	 * 
	 * @return La valeur de jouerRejouer.
	 */
	public boolean isjoueurRejouer() {
		return joueurRejouer;
	}

	/**
	 * Retourne la valeur de jouerRejouer.
	 * 
	 * @return La valeur de jouerRejouer.
	 */
	public boolean isJoueurRejouer() {
		return joueurRejouer;
	}

	/**
	 * Met à jour la valeur de joueurRejouer.
	 * 
	 * @param joueurRejouer
	 *            La nouvelle valeur de jouerRejouer.
	 */
	public void setJoueurRejouer(boolean joueurRejouer) {
		this.joueurRejouer = joueurRejouer;
	}

	/**
	 * Méthode qui créer la variante de la partie. Retourne la variante de la
	 * partie.
	 * 
	 * @return La variante de la partie.
	 */
	public Variante creerVariante() {
		Variante maVariante = new Variante();
		maVariante.setVariante(Partie.getPartie().getVariante(), this);
		return maVariante;
	}

	/**
	 * Méthode qui lance la manche. Détermine au hasard le premier joueur à jouer.
	 * Création d'un nouveau thread et lancement du thread.
	 */
	public void lancerManche() {

		// on détermine l'indice d'un joueur au hasard
		indiceJoueurEnCours = (int) (Math.random() * (Partie.getPartie().getNombreOrdinateur() - 0));
		// le joueur qui commence est celui dont le numéro est égal à l'indice joueur
		// déterminé
		this.joueurEnCours = Partie.getPartie().getListeJoueurs().get(indiceJoueurEnCours);
		// Création d'un nouveau Thread et lancement du Thread
		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * Constructeur de la classe Manche. Créer la pioche, la variante de jeu et
	 * distribue les cartes aux joueurs. Créer ensuite le talon.
	 */
	public Manche() {

		sensPositif = true;

		System.out.println("Début de la manche n° " + numeroManche);
		Variante maVariante = creerVariante();
		System.out.println(nombreDeCartes);
		laPioche = new Pioche(nombreDeCartes);
		maVariante.appliquerVariante(laPioche);

		laPioche.attribuerPointCarte();
		Partie.getPartie().setNombreCarteJoueur();
		laPioche.distribuer(); // distribution des cartes aux joueurs

		leTalon = new Talon(laPioche); // Création du talon
		numeroManche++;
	}

	/**
	 * Méthode pour faire jouer un tour de jeu à un joueur. S'adapte en focntion
	 * d'un joueur réel ou d'un ordinateur. Une fois que le joueur a joué, on
	 * notifie tous les observateurs de la manche des changements.
	 */
	public void jouerTourDeJeu() {
		// cas pour un joueur physique
		if (joueurEnCours instanceof JoueurPhysique) {
			((JoueurPhysique) joueurEnCours).jouerCarte(this);

			// cas pour un Ordinateur
		} else {
			System.out.println(joueurEnCours.getNom() + " joue son tour.");
			((Ordinateur) joueurEnCours).jouerCarteOrdi(this);
			System.out.println(joueurEnCours.nom + " a " + joueurEnCours.mainJoueur.size() + " carte(s) en main\r\n");
		}

		setChanged();
		notifyObservers();
	}

	/**
	 * Méthode qui détermine le joueur suivant à jouer son tour.
	 */
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

		this.joueurEnCours = Partie.getPartie().getListeJoueurs().get(indiceJoueurEnCours);

	}

	/**
	 * Méthode qui finit la manche. On indique le joueur qui a gagné la manche puis
	 * on compte le nombre de points de chaque joueur.
	 */
	private void finirManche() {
		// TODO Auto-generated method stub
		System.out.println(joueurEnCours.nom + " a gagné la manche n°" + numeroManche);
		for (int i = 0; i < Partie.getPartie().getListeJoueurs().size(); i++) {
			Partie.getPartie().getListeJoueurs().get(i).compterScore();
		}
		System.out.println("Voulez-vous faire une autre manche ? ( 1 si oui | 0 si non )");

		this.setChanged();
		this.notifyObservers("fin");
		// Manche maManche = new Manche();

	}

	/**
	 * Retourne la pioche de la manche.
	 * 
	 * @return La pioche.
	 */
	public Pioche getLaPioche() {
		return laPioche;
	}

	/**
	 * Met à jour la pioche de la manche.
	 * 
	 * @param laPioche
	 *            La nouvelle pioche.
	 */
	public void setLaPioche(Pioche laPioche) {
		this.laPioche = laPioche;
	}

	/**
	 * Retourne le talon de la manche.
	 * 
	 * @return Le talon
	 */
	public Talon getLeTalon() {
		return leTalon;
	}

	/**
	 * Met à jour le talon de la manche.
	 * 
	 * @param leTalon
	 *            Le nouveau talon.
	 */
	public void setLeTalon(Talon leTalon) {
		this.leTalon = leTalon;
	}

	/**
	 * Méthode lancé lors du démarrage du nouveau thread de la manche.
	 * 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (joueurEnCours.getMainJoueur().size() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			jouerTourDeJeu();
			joueurSuivant();
		}
		finirManche();
	}
}
