package controleur;
import mod�le.JoueurPhysique;
import mod�le.Manche;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mod�le.Carte;
import mod�le.Effet;
import mod�le.Partie;
import mod�le.Pioche;
import vue.VueTapisJeu;;

public class ControleurCarte {

	
	public ControleurCarte(Manche laManche, Carte carteAControler, JButton bouttonProchaineCarte, JTextField effet) {
		
		bouttonProchaineCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effet.checkEffetAvant(laManche, laManche.getLaPioche(), carteAControler);
				if(laManche.getJoueurEnCours() instanceof JoueurPhysique && laManche.getJoueurEnCours().carteCompatible(laManche, laManche.getLeTalon(), carteAControler)) {
					((JoueurPhysique)laManche.getJoueurEnCours()).jouerTourG(carteAControler);
					
				}
			}
		});
		
		bouttonProchaineCarte.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent arg0) {
				effet.setText(carteAControler.getEffet());
			}
		});
	}
}
