package controleur;
import modèle.JoueurPhysique;
import modèle.Manche;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modèle.Carte;
import modèle.Effet;
import modèle.Partie;
import modèle.Pioche;
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
