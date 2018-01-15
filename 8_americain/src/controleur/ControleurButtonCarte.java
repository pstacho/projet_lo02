package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import mod�le.Joueur;
import mod�le.JoueurPhysique;
import mod�le.Partie;

/**
 * @author Stacho
 *
 */
public class ControleurButtonCarte {
	/**
	 * @param carte
	 */
	public ControleurButtonCarte(JButton carte) {
		carte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueur j = Partie.getPartie().getListeJoueurs().get(0);
				if (j.getMainJoueur().size() == 1 && j instanceof JoueurPhysique && !j.isContrecarte()
						&& !j.isCarte()) {
					System.out.println(j.getNom() + " dit carte !");
					j.setCarte(true);

				}
			}

		});

	}
}
