package modèle;


import java.util.Observable;


/**
 * 
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class Manche extends Observable implements Runnable {

	/**
	 * 
	 * @return
	 */
	public int getNumeroManche() {
		return numeroManche;
	}

	/**
	 * @param numeroManche
	 */
	public void setNumeroManche(int numeroManche) {
		this.numeroManche = numeroManche;
	}

	/**
	 * 
	 */
	private Joueur joueurEnCours;
	/**
	 * 
	 */
	private int indiceJoueurEnCours = 0;
	/**
	 * @return
	 */
	public int getIndiceJoueurEnCours() {
		return indiceJoueurEnCours;
	}

	/**
	 * @param indiceJoueurEnCours
	 */
	public void setIndiceJoueurEnCours(int indiceJoueurEnCours) {
		this.indiceJoueurEnCours = indiceJoueurEnCours;
	}

	/**
	 * 
	 */
	private int numeroManche = 0;
	/**
	 * 
	 */
	private Pioche laPioche;
	/**
	 * 
	 */
	private Talon leTalon;

	// effets

	/**
	 * 
	 */
	private boolean sensPositif;
	/**
	 * 
	 */
	private boolean joueurRejouer = false;
	/**
	 * 
	 */
	private int CarteAPiocherAs = 0;

	/**
	 * @return
	 */
	public int getCarteAPiocherAs() {
		return CarteAPiocherAs;
	}

	/**
	 * @param carteAPiocherAs
	 */
	public void setCarteAPiocherAs(int carteAPiocherAs) {
		CarteAPiocherAs = carteAPiocherAs;
	}

	/**
	 * 
	 */
	private int nombreDeCartes;
	
	

	/**
	 * @return
	 */
	public int getNombreDeCartes() {
		return nombreDeCartes;
	}

	/**
	 * @param nombreDeCartes
	 */
	public void setNombreDeCartes(int nombreDeCartes) {
		this.nombreDeCartes = nombreDeCartes;
	}

	/**
	 * @return
	 */
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	/**
	 * @param joueurEnCours
	 */
	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	/**
	 * @return
	 */
	public boolean isSensPositif() {
		return sensPositif;
	}

	/**
	 * @param sensPositif
	 */
	public void setSensPositif(boolean sensPositif) {
		this.sensPositif = sensPositif;
	}

	/**
	 * @return
	 */
	public boolean isjoueurRejouer() {
		return joueurRejouer;
	}

	/**
	 * @return
	 */
	public boolean isJoueurRejouer() {
		return joueurRejouer;
	}

	/**
	 * @param joueurRejouer
	 */
	public void setJoueurRejouer(boolean joueurRejouer) {
		this.joueurRejouer = joueurRejouer;
	}

	/**
	 * @return
	 */
	public Variante creerVariante() {
		Variante maVariante = new Variante();
		maVariante.setVariante(Partie.getPartie().getVariante(), this);
		return maVariante;
	}
	
	
	/**
	 * 
	 */
	public void lancerManche() {
	
		
		//leTalon.afficherCarteDessus();

		// Determine un joueurs qui commence au hasard

		indiceJoueurEnCours = (int) (Math.random() * (Partie.getPartie().getNombreOrdinateur() - 0));
		this.joueurEnCours = Partie.getPartie().getListeJoueurs().get(indiceJoueurEnCours);
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	/**
	 * 
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
		
		
	//	Variante maVariante = new Variante();
		

	//	maVariante.afficherChoixVariantes();
	//	maVariante.ChoisirVariante(this); 
		

		// test pour voir l'attribution des points aux cartes selon la variante
		/*
		 * Iterator<Carte> it = laPioche.jeuDeCartes.iterator(); while (it.hasNext()) {
		 * System.out.println(it.next().getPoint()); }
		 */
		
		// on initialise indiceJoueurEnCours a un nombre aléatoire compris entre 0 et le
		// nombre de joueur afin de determiener aléatoirement le joeur qui commence
		

	}

	/**
	 * 
	 */
	public void jouerTourDeJeu() {

		if (joueurEnCours instanceof JoueurPhysique) {
		//	System.out.println(joueurEnCours.getNom() + ", c'est à toi de jouer.\r");
		//	((JoueurPhysique) joueurEnCours).afficherMainJoueur();
		//	((JoueurPhysique) joueurEnCours).jouerCarte(this, laPioche, leTalon);
			((JoueurPhysique) joueurEnCours).jouerCarte(this);

		} else {
			System.out.println(joueurEnCours.getNom() + " joue son tour.");
			((Ordinateur) joueurEnCours).jouerCarteOrdi(this);
			System.out.println(joueurEnCours.nom + " a " + joueurEnCours.mainJoueur.size() + " carte(s) en main\r\n");
		}
	//	checkdireCarte(leTalon);
	
		setChanged();
		notifyObservers();
	}

	/**
	 * 
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
	 * 
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
		//Manche maManche = new Manche();

	}

	/**
	 * @return
	 */
	public Pioche getLaPioche() {
		return laPioche;
	}

	/**
	 * @param laPioche
	 */
	public void setLaPioche(Pioche laPioche) {
		this.laPioche = laPioche;
	}
	

	/**
	 * @return
	 */
	public Talon getLeTalon() {
		return leTalon;
	}

	/**
	 * @param leTalon
	 */
	public void setLeTalon(Talon leTalon) {
		this.leTalon = leTalon;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
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
		//	if (joueurEnCours instanceof JoueurPhysique) {
		//		new ControleurManche(laManche);	
		//	}
	
	
		}
		finirManche();
	}
}
