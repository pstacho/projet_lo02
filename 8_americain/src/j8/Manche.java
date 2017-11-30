package j8;

public class Manche {

	private Joueur joueurEnCours;
	private int indiceJoueurEnCours=0; //je test avec le premier joueur
	private boolean sensPositif;
	private int numeroManche = 0;
	private Talon leTalon;
	private Pioche laPioche;
	
	
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}
	
	public Manche() {
		
		numeroManche++;
		sensPositif = true;
		
		System.out.println("Début de la manche n° " + numeroManche);
		Pioche laPioche = new Pioche();
		laPioche.distribuer();
		
		leTalon = new Talon(laPioche);
		//leTalon.afficherCarteDessus();
				
		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(0);
		while (joueurEnCours.mainJoueur.size() != 0) {
			jouerTourDeJeu();
		}
	
	}
	
	public void jouerTourDeJeu() {
		System.out.println(joueurEnCours.getNom() + " doit jouer\n");
		if (joueurEnCours instanceof JoueurPhysique) {
			((JoueurPhysique)joueurEnCours).afficherMainJoueur();
			((JoueurPhysique)joueurEnCours).jouerCarte(leTalon, laPioche);
			
		}
		else if (joueurEnCours instanceof Ordinateur) {
			((Ordinateur)joueurEnCours).jouerCarte(leTalon, laPioche);
		}
		
		if (joueurEnCours.mainJoueur.size() != 0) {
			joueurSuivant();
		}
		else {
			this.finirManche();
		}
		System.out.println(joueurEnCours);
		
	}

	private void finirManche() {
		// TODO Auto-generated method stub
		
	}

	public void joueurSuivant() {
		if (sensPositif = true) {
			indiceJoueurEnCours++;
			if (indiceJoueurEnCours > Partie.getPartie().getNombreOrdinateur()+1) {
				System.out.println(Partie.getPartie().getNombreOrdinateur()+1);
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
