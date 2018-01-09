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

import com.sun.org.apache.xpath.internal.operations.Or;

import controleur.ControleurBoutonContreCarte;
import controleur.ControleurBoutonPiocher;
import controleur.ControleurButtonCarte;
import controleur.ControleurCarte;
import controleur.ControleurManche;
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
	private JLabel talon ;
	private Manche laManche;
	private JoueurPhysique moi;
	private JButton[] cartesJoueur;
	private ControleurManche controleur;
	private JLabel[] ordis;
	private JPanel panelMain;
	private  JPanel piocheTalon;
	

	/**
	 * Create the application.
	 */
	public VueTapisJeu(JFrame frame, Manche maManche) {
		
		this.frame = frame;
		laManche=maManche;
		maManche.addObserver(this);
		System.out.println("jdelajflkejlfa");
		initialize();
		
		for (int i=0; i<=Partie.getPartie().getNombreOrdinateur(); i++) {
			Partie.getPartie().getListeJoueurs().get(i).addObserver(this);
		}

		maManche.lancerManche();
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame = new JFrame();
		frame.setTitle("8 américain");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(0, 0, 1600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container reservoir = frame.getContentPane();

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
		talon = new JLabel();
		ImageIcon carteTalon = new ImageIcon("images/cartes/" + laManche.getLeTalon().getCarteDessus().getValeur() + "_"
				+ laManche.getLeTalon().getCarteDessus().getCouleur() + ".png");
		talon.setIcon(carteTalon);
		piocheTalon.add(talon);
		frame.getContentPane().add(piocheTalon, BorderLayout.CENTER);

		ArrayList<Carte> cartesJoueurPhysique = Partie.getPartie().getListeJoueurs().get(0).getMainJoueur();

		ListIterator<Carte> parcourirCarteJoueur = cartesJoueurPhysique.listIterator();

		while (parcourirCarteJoueur.hasNext()) {
			Carte prochaineCarte = (Carte) parcourirCarteJoueur.next();
			JButton bouttonProchaineCarte = new JButton();
			ImageIcon imageCarte = new ImageIcon(
					"images/cartes/" + prochaineCarte.getValeur() + "_" + prochaineCarte.getCouleur() + ".png");
			bouttonProchaineCarte.setIcon(imageCarte);
			bouttonProchaineCarte.setMaximumSize(new Dimension(110, 270));
			new ControleurCarte(laManche, prochaineCarte, bouttonProchaineCarte);
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
		/*
		 * JLabel lblJoueurAdverse = new JLabel("Joueur Adverse");
		 * lblJoueurAdverse.setBackground(Color.RED);
		 * lblJoueurAdverse.setForeground(Color.BLACK); lblJoueurAdverse.setFont(new
		 * Font("Tahoma", Font.PLAIN, 20));
		 * frame.getContentPane().add(lblJoueurAdverse);
		 */
		
		
		//JLabel label = new JLabel(new ImageIcon("images/autres/vert.png"));
		//label.setBounds(0, 0, 1920, 1080);
		//frame.getContentPane().add(label);
		
	
		
		
		
		//this.frame.setVisible(true);
		
	}

	public void afficherCartes() {
		// moi.trierCartes();
		cartesJoueur = new JButton[moi.getMainJoueur().size()];
		for (int i = 0; i < moi.getMainJoueur().size(); i++) {
			JButton carte = new JButton(new ImageIcon("images/cartes/" + moi.getMainJoueur().get(i).getValeur() + "_"
					+ moi.getMainJoueur().get(i).getCouleur() + ".png"));
			carte.setBounds(85 * i, 400, 85, 125);
			cartesJoueur[i] = carte;
			this.frame.getContentPane().add(cartesJoueur[i]);
		}
	}

	/*
	 * public void affichageIAs() { for (int i = 0; i <
	 * (Partie.getInstance().getLesJoueurs().size()-1); i++) { JLabel ia = new
	 * JLabel(Partie.getInstance().getLesJoueurs().get(i).getNom() + ": " +
	 * Partie.getInstance().getLesJoueurs().get(i).getSesCartes().size() +
	 * " carte(s)"); ia.setFont(new Font("Tahoma", Font.BOLD, 12));
	 * ia.setBounds(125*i + i, 10, 125, 25); ias[i] = ia;
	 * this.frame.getContentPane().add(ias[i]); } }
	 */

	@Override
	public void update(Observable o, Object arg1) {

		if (o instanceof Joueur) {
			ImageIcon imageCarte = new ImageIcon(
					"images/cartes/" + laManche.getLeTalon().getCarteDessus().getValeur() + "_"
							+ laManche.getLeTalon().getCarteDessus().getCouleur() + ".png");
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
								new ControleurCarte(laManche, prochaineCarte, bouttonProchaineCarte);
								panelMain.add(bouttonProchaineCarte);
								frame.repaint();
								frame.revalidate();
							}
						}
					}
				}

		}
	}
	}}

