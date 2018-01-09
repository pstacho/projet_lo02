package vue;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.*;

import modèle.Partie;

import java.awt.Font;
import java.awt.Color;

public class VueTapisJeu {

	private JFrame frame;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueTapisJeu window = new VueTapisJeu();
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
	public VueTapisJeu(JFrame uneFrame) {
		this.frame = frame;
		initialize();
		System.out.println("jdelajflkejlfa");
		Partie.getPartie().lancerJeu();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("8 américain");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Container reservoir = frame.getContentPane();	
		
		JButton btnPiocher = new JButton("Piocher");
		btnPiocher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPiocher.setBounds(10, 204, 157, 51);
		frame.getContentPane().add(btnPiocher);
		
		JButton btnDireCarte = new JButton("Dire Carte");
		btnDireCarte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDireCarte.setBounds(10, 265, 157, 51);
		reservoir.add(btnDireCarte);
		
		JButton btnContreCarte = new JButton("Contre Carte");
		btnContreCarte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnContreCarte.setBounds(10, 326, 157, 51);
		frame.getContentPane().add(btnContreCarte);
		
		JLabel lblJoueurAdverse = new JLabel("Joueur Adverse");
		lblJoueurAdverse.setBackground(Color.RED);
		lblJoueurAdverse.setForeground(Color.BLACK);
		lblJoueurAdverse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoueurAdverse.setBounds(10, 10, 141, 39);
		frame.getContentPane().add(lblJoueurAdverse);
		
		JLabel carteTalon = new JLabel("Talon");
		carteTalon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		carteTalon.setBounds(540, 303, 192, 214);
		frame.getContentPane().add(carteTalon);
		
		JLabel label = new JLabel(new ImageIcon("images/autres/vert.png"));
		label.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(label);
		
		//this.frame.setVisible(true);
		

	}
}
