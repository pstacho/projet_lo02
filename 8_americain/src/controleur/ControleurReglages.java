package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modèle.Joueur;
import modèle.Ordinateur;
import modèle.Manche;
import modèle.JoueurPhysique;
import modèle.Partie;
import vue.VueTapisJeu;

/**
 * @author Stacho
 *
 */
public class ControleurReglages {

	/**
	 * @param ordis
	 * @param difficults
	 * @param variantes
	 * @param textFields
	 * @param valider
	 * @param positif
	 * @param negatif
	 * @param maPartie
	 * @param frame
	 */
	public ControleurReglages(HashMap<String, JCheckBox> ordis, HashMap<String, JRadioButton> difficults,
			HashMap<String, JRadioButton> variantes, HashMap<String, JTextField> textFields, JButton valider,
			JRadioButton positif, JRadioButton negatif, Partie maPartie, JFrame frame) {

		for (int i = 1; i <= 6; i++) {
			ordis.get("ordi" + i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for (int i = 1; i <= 6; i++) {
						difficults.get("ordi" + (i) + "n").setSelected(ordis.get("ordi" + (i)).isSelected());
					}
				}
			});
		}

		variantes.get("variante0").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField1").setText("");
				textFields.get("textField2").setText("");
				textFields.get("textField3").setText("");
				textFields.get("textField4").setText("");
				textFields.get("textField5").setText("");
				textFields.get("textField6").setText("");
			}
		});

		variantes.get("variante1").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField1")
						.setText("8: permet de changer de couleur, se pose sur n'importe quelle carte");
				textFields.get("textField2").setText("10: oblige a rejouer");
				textFields.get("textField3").setText("");
				textFields.get("textField4").setText("");
				textFields.get("textField5").setText("");
				textFields.get("textField6").setText("");
			}
		});

		variantes.get("variante2").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField6").setText("8: change de couleur, stop les attaques");
				textFields.get("textField5").setText("10: oblige a rejouer");
				textFields.get("textField3").setText("7: le joueur suivant passe son tour");
				textFields.get("textField4").setText("Valet: change le sens du jeu");
				textFields.get("textField2").setText("Neuf: fait piocher une carte au joueur suivant sans recours");
				textFields.get("textField1")
						.setText("As: fait piocher 3 cartes au joueur suivant, à moins de poser un 8 ou un As");
			}
		});

		variantes.get("variante3").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField4").setText("8: le joueur suivant passe son tour");
				textFields.get("textField2").setText("10: oblige a rejouer");
				textFields.get("textField3").setText("7: fait piocher 2 cartes au joueur suivant");
				textFields.get("textField1")
						.setText("valet: permet de changer de couleur, se pose sur n'importe quelle carte");
				textFields.get("textField5").setText("");
				textFields.get("textField6").setText("");
			}
		});

		variantes.get("variante4").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField1").setText("8: permet de changer de couleur et arrête les attaques");
				textFields.get("textField4").setText("10: oblige a rejouer");
				textFields.get("textField3").setText("7: change le sens du jeu");
				textFields.get("textField2")
						.setText("As: fait piocher 2 cartes au joueur suivant, à moins de poser un 8 ou un As");
				textFields.get("textField5").setText("");
				textFields.get("textField6").setText("");
			}
		});

		variantes.get("variante5").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField1").setText("Valet: change le sens du jeu");
				textFields.get("textField2").setText("10: oblige a rejouer");
				textFields.get("textField3").setText("7: le joueur suivant passe son tour");
				textFields.get("textField4").setText("");
				textFields.get("textField5").setText("");
				textFields.get("textField6").setText("");
			}
		});

		variantes.get("variante6").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField1").setText("8: permet de changer de couleur et arrête les attaques");
				textFields.get("textField4").setText("10: oblige a rejouer");
				textFields.get("textField3").setText("Valet: change le sens du jeu");
				textFields.get("textField2")
						.setText("As: fait piocher 2 cartes au joueur suivant, à moins de poser un 8 ou un As");
				textFields.get("textField5").setText("Dame: le joueur suivant passe son tour");
				textFields.get("textField6").setText("");
			}
		});

		variantes.get("variante7").addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFields.get("textField5").setText("8: permet de changer de couleur et arrête les attaques");
				textFields.get("textField6").setText("10: oblige a rejouer");
				textFields.get("textField3").setText("7: le joueur suivant passe son tour");
				textFields.get("textField4").setText("Valet: change le sens du jeu");
				textFields.get("textField1")
						.setText("As: fait piocher 2 cartes au joueur suivant, sauf si on pose un As, qui s'ajoute");
				textFields.get("textField2")
						.setText("Dame de Trèfle: fait piocher 3 cartes au joueur suivant sans aucun recours");
			}
		});

		valider.addActionListener(new ActionListener() {
			public final void actionPerformed(ActionEvent e) {

				System.out.println("blablacool");
				LinkedList<Joueur> listeJoueurs = new LinkedList<Joueur>();
				int modeComptage;
				String variante = "";
				if (negatif.isSelected()) {
					modeComptage = 1;
				} else {
					modeComptage = 0;
				}
				listeJoueurs.add(new JoueurPhysique(textFields.get("textField0").getText()));
				for (int i = 1; i <= 6; i++) {
					if (ordis.get("ordi" + (i)).isSelected()) {
						if (difficults.get("ordi" + (i) + "n").isSelected()) {
							listeJoueurs.add(new Ordinateur((int) i, 1));
						} else {
							listeJoueurs.add(new Ordinateur((int) i, 2));
						}
					}
				}

				// variante

				for (int i = 0; i <= 7; i++) {
					if (variantes.get("variante" + (i)).isSelected()) {
						variante = ("variante" + i);
					}
				}

				maPartie.updatePartie(modeComptage, listeJoueurs, variante);
				frame.getContentPane().removeAll();
				frame.repaint();
				System.out.println("camarche ou pas ?");
				Manche maManche = maPartie.lancerJeu();
				new VueTapisJeu(frame, maManche);

			}
		});

	}

}