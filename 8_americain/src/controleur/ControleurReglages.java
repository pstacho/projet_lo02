package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modèle.Joueur;
import modèle.Ordinateur;
import modèle.Manche;
import modèle.JoueurPhysique;
import modèle.Partie;
import modèle.Variante;

public class ControleurReglages {

	public ControleurReglages(HashMap<String, JCheckBox> ordis, HashMap<String, JRadioButton> difficults,
			JButton valider, JRadioButton positif, JRadioButton negatif, JTextField textField, Partie maPartie,
			JList<Object> list, JFrame frame) {

		/*
		 * for (int i = 1; i <= 6; i++) { int indice = i; ordis.get("ordi" +
		 * i).addActionListener(new ActionListener() { public final void
		 * actionPerformed(ActionEvent e) { System.out.println("ALIBABA");
		 * difficults.get("ordi" + indice + "n").setSelected(ordis.get("ordi" +
		 * indice).isSelected()); } }); } ;
		 */

		
		
		valider.addActionListener(new ActionListener() {

			public final void actionPerformed(ActionEvent e) {
				
	
				System.out.println("blablacool");
				LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();
				int modeComptage;
				if (negatif.isSelected()) {
					modeComptage = 1;
				} else {
					modeComptage = 0;
				}

				for (int i = 1; i <= 6; i++) {
					if (ordis.get("ordi" + (i)).isSelected()) {
						if (difficults.get("ordi" + (i) + "n").isSelected()) {
							listeJoueurs.add(new Ordinateur((int) i, 1));
						} else {
							listeJoueurs.add(new Ordinateur((int) i, 2));
						}
					}
				}
			

				listeJoueurs.add(new JoueurPhysique(textField.getText()));
				maPartie.updatePartie(modeComptage, listeJoueurs);
				Manche maManche = maPartie.lancerJeu();
				frame.getContentPane().removeAll();
				frame.repaint();
				// new InterfaceManche(frame, maManche);
			}
		});

		
	}

}