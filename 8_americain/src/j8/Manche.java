package j8;

public class Manche {

	private Joueur joueurEnCours;
	private int indiceJoueurEnCours=0; //je test avec le premier joueur
	private boolean sensPositif = true;
	private int numeroManche = 0;
	private Talon leTalon;
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}
	
	public Manche() {
		
		
		
		numeroManche++;
		
		System.out.println("Début de la manche n° " + numeroManche);
		Pioche laPioche = new Pioche();
		laPioche.distribuer();
		
		leTalon = new Talon(laPioche);
		leTalon.afficherCarteDessus();
				
		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(0);
		this.sensPossitif = true;
		while (joueurEnCours.mainJoueur.size() != 0) {
			jouerTourDeJeu();
		}
	
	}
	
	public void jouerTourDeJeu() {
		System.out.println(joueurEnCours.getNom() + " doit jouer\n");
		if (joueurEnCours instanceof JoueurPhysique) {
			((JoueurPhysique)joueurEnCours).afficherMainJoueur();
			((JoueurPhysique)joueurEnCours).jouerCarte(this, leTalon);
			//créer la méthode jouerCarte pour le joueur
			//J'ai déjà fait un comparateur qui vérifie si la carte est compatible avec le talon dans la classe joueur
			
		}
		else if (joueurEnCours instanceof Ordinateur) {
			((Ordinateur)joueurEnCours).jouerCarte(this, leTalon);
		}
		joueurSuivant();
		System.out.println(joueurEnCours);
		
	}

	public void joueurSuivant() {
		if (sensPositif = true) {
			indiceJoueurEnCours++;
			if (indiceJoueurEnCours < Partie.getPartie().getNombreOrdinateur()+1) {
				indiceJoueurEnCours=0;
			}
		
		}
		else {
			indiceJoueurEnCours--;//pour les variantes changement de sens
			if (indiceJoueurEnCours < 0) {
				indiceJoueurEnCours= Partie.getPartie().getNombreOrdinateur()+1;
			
			}
			
		}
		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(indiceJoueurEnCours);
		System.out.println(indiceJoueurEnCours);
	}
}
