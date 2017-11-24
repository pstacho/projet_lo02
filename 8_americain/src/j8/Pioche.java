package j8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

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
		
/*		 for(int i = 0; i < jeuDeCartes.size(); i++)
		{
		  System.out.println(jeuDeCartes.get(i));
		 
			k++;
			
		}
		System.out.println(k);
		*/
	}

	
	
	
	
	public void melanger() {
		Collections.shuffle(jeuDeCartes);
	
		}
	
	public void distribuer() {
	
		for(int i = 0; i <8 ; i++) {
			for(int j=0; j < (Partie.getPartie().getNombreOrdinateur()+1); j++) {
		
			Partie.getPartie().listeJoueur.get(j).mainJoueur.add(this.jeuDeCartes.get(0));
			//System.out.println(Partie.getPartie().listeJoueur.get(j).mainJoueur);
			jeuDeCartes.remove(0);
			}
	
		}
	}

	public Carte piocherCarte() {
		Carte cartePioche = jeuDeCartes.get(0);
		jeuDeCartes.remove(0);
		return cartePioche;
	}
	

	
}

