package controleur;
import mod�le.JoueurPhysique;
import mod�le.Manche;

import java.awt.event.*;

import javax.swing.JButton;

import mod�le.Carte;
import mod�le.Partie;
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
