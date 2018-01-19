package mod�le;

import java.util.Observable;

/**
 * Classe Manche repr�sente une manche de la partie. La classe impl�mente
 * Runnable.
 * 
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class Manche extends Observable implements Runnable {

	/**
	 * Retourne le num�ro de la manche.
	 * 
	 * @return le num�ro de la manche.
	 */
	public int getNumeroManche() {
		return numeroManche;
	}

	/**
	 * Met � jour le num�ro de la manche.
	 * 
	 * @param numeroManche
	 *            Le nouveau num�ro de la manche.
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
	 * Met � jour l'indice du joueur qui est entrain de jouer son tour.
	 * 
	 * @param indiceJoueurEnCours
	 *            Le nouvel indice du joueur qui doit jouer son tour.
	 */
	public void setIndiceJoueurEnCours(int indiceJoueurEnCours) {
		this.indiceJoueurEnCours = indiceJoueurEnCours;
	}

	/**
	 * Le num�ro de la manche.
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
	 * Un boolean qui indique le sens de passage au joueur suivant. Si sensPositif �
	 * "Vrai", on suit l'ordre des num�ros de joueurs dans l'ordre croissant.
	 */
	private boolean sensPositif;
	/**
	 * Un boolean qui indique si l'effet "rejouer" a �t� activ�.
	 */
	private boolean joueurRejouer = false;
	/**
	 * Entier qui indique le nombre de carte � piocher en cas d'effet qui fait
	 * piocher.
	 */
	private int CarteAPiocherAs = 0;

	/**
	 * Retounre le nombre de cartes � piocher en cas d'effet "piocher" d'une carte
	 * As.
	 * 
	 * @return La valeur de CarteAPiocherAs.
	 */
	public int getCarteAPiocherAs() {
		return CarteAPiocherAs;
	}

	/**
	 * Met � jour la valeur de cartes � piocher en cas d'effet "piocher" par une
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
	 * Met � jour le nombre de cartes avec lesquelles on joue la manche.
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
	 * Met � jour le joueur qui joue son tour de jeu.
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
	 * Met � jour le boolean sensPositf.
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
	 * Met � jour la valeur de joueurRejouer.
	 * 
	 * @param joueurRejouer
	 *            La nouvelle valeur de jouerRejouer.
	 */
	public void setJoueurRejouer(boolean joueurRejouer) {
		this.joueurRejouer = joueurRejouer;
	}

	/**
	 * M�thode qui cr�er la variante de la partie. Retourne la variante de la
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
	 * M�thode qui lance la manche. D�termine au hasard le premier joueur � jouer.
	 * Cr�ation d'un nouveau thread et lancement du thread.
	 */
	public void lancerManche() {

		// on d�termine l'indice d'un joueur au hasard
		indiceJoueurEnCours = (int) (Math.random() * (Partie.getPartie().getNombreOrdinateur() - 0));
		// le joueur qui commence est celui dont le num�ro est �gal � l'indice joueur
		// d�termin�
		this.joueurEnCours = Partie.getPartie().getListeJoueurs().get(indiceJoueurEnCours);
		// Cr�ation d'un nouveau Thread et lancement du Thread
		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * Constructeur de la classe Manche. Cr�er la pioche, la variante de jeu et
	 * distribue les cartes aux joueurs. Cr�er ensuite le talon.
	 */
	public Manche() {

		sensPositif = true;

		System.out.println("D�but de la manche n� " + numeroManche);
		Variante maVariante = creerVariante();
		System.out.println(nombreDeCartes);
		laPioche = new Pioche(nombreDeCartes);
		maVariante.appliquerVariante(laPioche);

		laPioche.attribuerPointCarte();
		Partie.getPartie().setNombreCarteJoueur();
		laPioche.distribuer(); // distribution des cartes aux joueurs

		leTalon = new Talon(laPioche); // Cr�ation du talon
		numeroManche++;
	}

	/**
	 * M�thode pour faire jouer un tour de jeu � un joueur. S'adapte en focntion
	 * d'un joueur r�el ou d'un ordinateur. Une fois que le joueur a jou�, on
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
	 * M�thode qui d�termine le joueur suivant � jouer son tour.
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
	 * M�thode qui finit la manche. On indique le joueur qui a gagn� la manche puis
	 * on compte le nombre de points de chaque joueur.
	 */
	private void finirManche() {
		// TODO Auto-generated method stub
		System.out.println(joueurEnCours.nom + " a gagn� la manche n�" + numeroManche);
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
	 * Met � jour la pioche de la manche.
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
	 * Met � jour le talon de la manche.
	 * 
	 * @param leTalon
	 *            Le nouveau talon.
	 */
	public void setLeTalon(Talon leTalon) {
		this.leTalon = leTalon;
	}

	/**
	 * M�thode lanc� lors du d�marrage du nouveau thread de la manche.
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
