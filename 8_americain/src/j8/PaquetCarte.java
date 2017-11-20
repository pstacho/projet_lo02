package j8;
import java.util.ArrayList;
//création du paquet de carte
public class PaquetCarte {
	
	protected ArrayList<Carte> jeuDeCartes = new ArrayList<Carte>();	

	public PaquetCarte() {
		// TODO Auto-generated constructor stub
		
		String[] couleur = new String[] {"Pic","Trèfle","Coeur","Carreau"};
		String[] valeur = new String[] {"Deux","Trois","Quatre","Cinq","Six","Sept","Huit","Neuf","Dix","Valet","Dame","Roi","As"};
		
		for(int i=0; i<couleur.length; i++) {
			for (int j=0; j<valeur.length-1; j++) {
				Carte carte = new Carte(couleur[i],valeur[j]);
				this.jeuDeCartes.add(carte);
				System.out.println(this);
				}
			}
			
	}

		
	

}
