package j8;

public class Manche {

	private Joueur joueurEnCours;
	private boolean sensPossitif;
	private int numeroManche = 0;
	
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
		
		Talon leTalon = new Talon(laPioche);
		leTalon.afficherCarteDessus();
				
		this.joueurEnCours = Partie.getPartie().getListeJoueur().get(1);
		this.sensPossitif = true;
		while (joueurEnCours.mainJoueur.size() != 0) {
			jouerTourDeJeu();
		}
	
	}
	
	public void jouerTourDeJeu() {
		System.out.println(joueurEnCours.getNom() + " doit jouer\n");
		if (joueurEnCours instanceof JoueurPhysique) {
			((JoueurPhysique)joueurEnCours).afficherMainJoueur();
			((JoueurPhysique)joueurEnCours).jouerCarte();
			//créer la méthode jouerCarte pour le joueur
			//J'ai déjà fait un comparateur qui vérifie si la carte est compatible avec le talon dans la classe joueur
			
		}
		else if (joueurEnCours instanceof Ordinateur) {
			((Ordinateur)joueurEnCours).ChoisirCarte();
			((Ordinateur)joueurEnCours).ChoisirCarte();
		}
		
	}
	
	

	/*public void joueurSuivant() {
		if (sensPossitif = true) {
			JoueurEnCours++;
			if (JoueurEnCours < Partie.getPartie().getNombreOrdinateur()+1) {
				JoueurEnCours=1;
			}
		
		}
		else {
			JoueurEnCours--;
			if (JoueurEnCours < 0) {
				JoueurEnCours= Partie.getPartie().getNombreOrdinateur()+1;
			
			}
		}
			
		System.out.println(JoueurEnCours);
	}*/
}
