package vue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.*;

import controleur.ControleurBoutonContreCarte;
import controleur.ControleurBoutonPiocher;
import controleur.ControleurButtonCarte;
import controleur.ControleurCarte;
import modèle.Joueur;
import modèle.Ordinateur;
import modèle.JoueurPhysique;
import modèle.Manche;
import modèle.Partie;
import modèle.Carte;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class VueTapisJeu implements Observer {
	private ArrayList<VueOrdinateur> vueOrdi;
	private JFrame frame;
	private JLabel talon;
	private Manche laManche;

	private JPanel panelMain;
	private JPanel piocheTalon;
	private JTextField effet;

	/**
	 * Create the application.
	 */
	public VueTapisJeu(JFrame frame, Manche maManche) {

		this.frame = frame;
		laManche = maManche;
		maManche.addObserver(this);
		System.out.println("jdelajflkejlfa");
		initialize();

		for (int i = 0; i <= Partie.getPartie().getNombreOrdinateur(); i++) {
			Partie.getPartie().getListeJoueurs().get(i).addObserver(this);
		}

		maManche.lancerManche();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(0, 0, 1600, 600);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new BorderLayout());
		panelMain = new JPanel();
		frame.getContentPane().add(panelMain, BorderLayout.SOUTH);
		GridLayout grid = new GridLayout();
		panelMain.setLayout(grid);

		piocheTalon = new JPanel();

		JButton pioche = new JButton();
		new ControleurBoutonPiocher(pioche, laManche);
		ImageIcon dosCarte = new ImageIcon("images/cartes/dos_carte.png");
		pioche.setIcon(dosCarte);

		piocheTalon.add(pioche);
		effet = new JTextField("");
		//effet.setEditable(false);
		effet.setBounds(700, 300, 400, 30);
		frame.getContentPane().add(effet);
		
		talon = new JLabel();
		ImageIcon carteTalon = new ImageIcon("images/cartes/" + laManche.getLeTalon().getCarteDessus().getValeur() + "_"
				+ laManche.getLeTalon().getCarteDessus().getCouleur() + ".png");
		talon.setIcon(carteTalon);
		piocheTalon.add(talon);
		frame.getContentPane().add(piocheTalon, BorderLayout.CENTER);

		
		//frame.getContentPane().add(effet, BorderLayout.SOUTH);
		
		// lblVert = new JLabel(new ImageIcon("images/autres/vert.png"));
		// lblVert.setBounds(0, 0, 1920, 1080);
		// frame.getContentPane().add(lblVert);

		ArrayList<Carte> cartesJoueurPhysique = Partie.getPartie().getListeJoueurs().get(0).getMainJoueur();

		ListIterator<Carte> parcourirCarteJoueur = cartesJoueurPhysique.listIterator();

		while (parcourirCarteJoueur.hasNext()) {
			Carte prochaineCarte = (Carte) parcourirCarteJoueur.next();
			JButton bouttonProchaineCarte = new JButton();
			ImageIcon imageCarte = new ImageIcon(
					"images/cartes/" + prochaineCarte.getValeur() + "_" + prochaineCarte.getCouleur() + ".png");
			bouttonProchaineCarte.setIcon(imageCarte);
			bouttonProchaineCarte.setMaximumSize(new Dimension(110, 270));
			new ControleurCarte(laManche, prochaineCarte, bouttonProchaineCarte, effet);
			panelMain.add(bouttonProchaineCarte);
		}

		JPanel panelOrdi = new JPanel();
		GridLayout grid1 = new GridLayout();
		grid1.setVgap(5);
		panelOrdi.setLayout(grid1);
		frame.getContentPane().add(panelOrdi, BorderLayout.NORTH);
		this.vueOrdi = new ArrayList<VueOrdinateur>();

		for (int i = 1; i < Partie.getPartie().getListeJoueurs().size(); i++) {
			this.vueOrdi.add(new VueOrdinateur(Partie.getPartie().getListeJoueurs().get(i)));
			panelOrdi.add(vueOrdi.get(i - 1));
		}

		JPanel panelbtnaction = new JPanel();
		panelbtnaction.setLayout(new GridLayout(0, 1));
		JButton btnDireCarte = new JButton("Dire Carte");
		btnDireCarte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelbtnaction.add(btnDireCarte);
		new ControleurButtonCarte(btnDireCarte);

		JButton btnContreCarte = new JButton("Contre Carte");
		btnContreCarte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelbtnaction.add(btnContreCarte);
		new ControleurBoutonContreCarte(btnContreCarte);
		frame.getContentPane().add(panelbtnaction, BorderLayout.WEST);


	}

	@Override
	public void update(Observable o, Object arg1) {

		if (o instanceof Joueur) {
			ImageIcon imageCarte = new ImageIcon("images/cartes/" + laManche.getLeTalon().getCarteDessus().getValeur()
					+ "_" + laManche.getLeTalon().getCarteDessus().getCouleur() + ".png");
			this.talon.setIcon(imageCarte);
			if (o instanceof Ordinateur) {
				int index = Partie.getPartie().getListeJoueurs().indexOf(o);
				this.vueOrdi.get(index - 1).update(o, arg1);
				frame.repaint();
				frame.revalidate();
			} else if (o instanceof JoueurPhysique) {

				if (o instanceof JoueurPhysique) {
					if (arg1 != null) {
						if (arg1.equals("a joué")) {
							/**
							 * Redefinir les cartes visibles en main en fonction du tour qu'a jouÃ© le
							 * joueur.
							 */
							panelMain.removeAll();
							ArrayList<Carte> cartesJoueurPhysique = Partie.getPartie().getListeJoueurs().get(0)
									.getMainJoueur();
							ListIterator<Carte> parcourirCarteJoueur = cartesJoueurPhysique.listIterator();

							while (parcourirCarteJoueur.hasNext()) {
								Carte prochaineCarte = (Carte) parcourirCarteJoueur.next();
								JButton bouttonProchaineCarte = new JButton();
								ImageIcon imageCarte2 = new ImageIcon("images/cartes/" + prochaineCarte.getValeur()
										+ "_" + prochaineCarte.getCouleur() + ".png");
								bouttonProchaineCarte.setIcon(imageCarte2);
								bouttonProchaineCarte.setMaximumSize(new Dimension(110, 270));
								new ControleurCarte(laManche, prochaineCarte, bouttonProchaineCarte, effet);
								panelMain.add(bouttonProchaineCarte);
								frame.repaint();
								frame.revalidate();
							}
						}
					}
				}

			}

		} else if (o instanceof Manche) {
			if (arg1 != null) {
				frame.getContentPane().removeAll();
				frame.repaint();
				new VueNouvelleManche(frame, laManche);
			}

		}
	}
}
