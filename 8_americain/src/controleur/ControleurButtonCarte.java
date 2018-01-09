package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import modèle.Joueur;
import modèle.JoueurPhysique;
import modèle.Partie;

public class ControleurButtonCarte {
	public ControleurButtonCarte(JButton carte) {
		carte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueur j = Partie.getPartie().getListeJoueurs().get(0);
				if (j.getMainJoueur().size() == 1 && j instanceof JoueurPhysique
						&& !j.isContrecarte() && !j.isCarte()) {
					System.out.println(j.getNom()+ " dit carte !");
					j.setCarte(true);

				}
			}
			

		});
		
	}
}
