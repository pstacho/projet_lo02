package j8;

public class Manche {

	private int JoueurEnCours;
	private boolean sensPossitif;
	
	public Manche() {
		super();
		this.JoueurEnCours = 1;
		this.sensPossitif = true;
	}
	
	public void joueurSuivant() {
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
	}
}
