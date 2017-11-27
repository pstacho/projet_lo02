package j8;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	Partie.getPartie();
	Pioche maPioche = new Pioche();
	maPioche.distribuer();
	Partie.getPartie().lancerJeu();
	}
}