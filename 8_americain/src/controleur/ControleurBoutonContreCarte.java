package controleur;
import modèle.Ordinateur;

import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JTextArea;
import modèle.Joueur;
import modèle.Partie;

public class ControleurBoutonContreCarte {

	public ControleurBoutonContreCarte(JButton contrecarte) {
		contrecarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Joueur> joueurs = Partie.getPartie().getListeJoueurs();
				Iterator<Joueur> it = joueurs.iterator();
				boolean trouve = false;
				Joueur next;
				do {
					next = it.next();
					if (next.getMainJoueur().size() == 1 && next instanceof Ordinateur) {
						trouve = true;
					}
				} while (it.hasNext() && !trouve);
				if (trouve && !next.isCarte()) {
					System.out.println (next.getNom()+ " est contre-carte !");
					next.setContrecarte(true);
				}
			}

		});
	}
}