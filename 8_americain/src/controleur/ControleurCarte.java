package controleur;
import modèle.JoueurPhysique;
import modèle.Manche;

import java.awt.event.*;

import javax.swing.JButton;

import modèle.Carte;
import modèle.Partie;
import vue.VueTapisJeu;;

public class ControleurCarte {

	
	public ControleurCarte(Manche laManche, Carte carteAControler, JButton bouttonProchaineCarte) {
		
		bouttonProchaineCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(laManche.getJoueurEnCours() instanceof JoueurPhysique && laManche.getJoueurEnCours().carteCompatible(laManche, laManche.getLeTalon(), carteAControler)) {
					int indexCarteChoisie =laManche.getJoueurEnCours().getMainJoueur().indexOf(carteAControler);
					((JoueurPhysique)laManche.getJoueurEnCours()).jouerTourG(carteAControler);
					
				}
			}
		});
	}
}
