package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controleur.ControleurManche;
import modèle.*;


@SuppressWarnings("deprecation")
public class InterfaceManche implements Observer{

	private JFrame frame;
	private JButton boutonPiocher;
	private Manche manche;
	private static byte nbManche;
	private JoueurPhysique joueur;
	private Talon laTalon;
	private JButton[] cartesJ;
	private JLabel carteV,tourDe;
	private ControleurManche controleur;
	private JLabel[] bots;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceManche window = new InterfaceManche();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	//public InterfaceManche() {
		//Partie.getPartie().lancerJeu();
		//initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		boutonPiocher = new JButton("Piocher");
		boutonPiocher.setBounds(31, 49, 85, 21);
		frame.getContentPane().add(boutonPiocher);
		
		JLabel lblMancheN = new JLabel("MANCHE n\u00B0");
		lblMancheN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMancheN.setBounds(31, 165, 128, 25);
		frame.getContentPane().add(lblMancheN);
		
		JLabel lblCarteDuTalon = new JLabel("Carte du talon");
		lblCarteDuTalon.setBounds(247, 88, 150, 24);
		lblCarteDuTalon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblCarteDuTalon);
		
		
		
		
	}

	public void affichageCartes() {
		cartesJ = new JButton[joueur.getMainJoueur().size()];
		for (int i = 0; i < joueur.getMainJoueur().size(); i++) {
			JButton carte = new JButton(new ImageIcon("cartes/"+joueur.getMainJoueur().get(i).getValeur().toLowerCase()+"_"+joueur.getMainJoueur().get(i).getCouleur().toLowerCase()+".png"));
			carte.setBounds(i+85*i, 400, 85, 125);
			cartesJ[i] = carte;
			this.frame.getContentPane().add(cartesJ[i]);
		}
	}
	
	public void affichageBot() {
		for (int i = 0; i < (Partie.getPartie().getListeJoueurs().size()-1); i++) {
			JLabel bot = new JLabel(Partie.getPartie().getListeJoueurs().get(i).getNom() + ": " + Partie.getPartie().getListeJoueurs().get(i).getMainJoueur().size() + " carte(s)");
			bot.setFont(new Font("Tahoma", Font.BOLD, 12));
			bot.setBounds(125*i + i, 10, 125, 25);
			bots[i] = bot;
			this.frame.getContentPane().add(bots[i]);
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	// classe pour tester
	public static void main(String[] args) {
		InterfaceManche test = new InterfaceManche();
		test.frame.setVisible(true);
		JButton carte = new JButton(new ImageIcon("Valet_Pique.png"));
		test.frame.getContentPane().add(carte, BorderLayout.CENTER);
	}
}
