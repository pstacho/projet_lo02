package controleur;

import modèle.JoueurPhysique;
import modèle.Manche;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JTextField;

import modèle.Carte;
import modèle.Effet;

/**
 * @author Stacho
 *
 */
public class ControleurCarte {

	/**
	 * @param laManche
	 * @param carteAControler
	 * @param bouttonProchaineCarte
	 * @param effet
	 */
	public ControleurCarte(Manche laManche, Carte carteAControler, JButton bouttonProchaineCarte, JTextField effet) {

		bouttonProchaineCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effet.checkEffetAvant(carteAControler);
				if (laManche.getJoueurEnCours() instanceof JoueurPhysique && laManche.getJoueurEnCours()
						.carteCompatible(laManche, carteAControler)) {
					((JoueurPhysique) laManche.getJoueurEnCours()).jouerTourG(carteAControler);

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
