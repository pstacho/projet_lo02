package j8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//création du paquet de carte
public class Pioche {
	
	protected ArrayList<Carte> jeuDeCartes = new ArrayList<Carte>();	

	public Pioche() {
		// TODO Auto-generated constructor stub
		
		String[] couleur = new String[] {"Pique","Trèfle","Coeur","Carreau"};
		String[] valeur = new String[] {"Deux","Trois","Quatre","Cinq","Six","Sept","Huit","Neuf","Dix","Valet","Dame","Roi","As"};
		
		for(int i=0; i<couleur.length; i++) {
			for (int j=0; j<valeur.length; j++) {
				Carte carte = new Carte(couleur[i],valeur[j]);
				this.jeuDeCartes.add(carte);
				
				
				}
			}
		
		Collections.shuffle(jeuDeCartes);
		 int k=0;
		for(int i = 0; i < jeuDeCartes.size(); i++)
		{
		  System.out.println(jeuDeCartes.get(i));
		 
			k++;
			
		}
		System.out.println(k);
	}

	public void melanger() {
		Collections.shuffle(jeuDeCartes);
	
		}
	
	public void distribuer() {
	
		for(int i = 0; i <8 ; i++)
		{
			//Joueur.getMainJoueur().add(this.JeuDeCartes.get(i));

		}
		
	}

	
	

	
}

