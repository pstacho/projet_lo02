package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modèle.Manche;
import modèle.Partie;

public class VueNouvelleManche {

	private JFrame frame;
	private Manche laManche;

	/**
	 * Create the application.
	 */
	public VueNouvelleManche(JFrame aframe, Manche maManche) {
		laManche = maManche;
		frame = aframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		//frame = new JFrame();
		frame.setBounds(0, 0, 1920 / 2, 1080 / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().removeAll();

		
		
		
		JLabel label = new JLabel(laManche.getJoueurEnCours().getNom() + " à gagné la Manche " + laManche.getNumeroManche());
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(label, BorderLayout.NORTH);
		
		JButton btnNouvelleManche = new JButton("Nouvelle Manche");
		btnNouvelleManche.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnNouvelleManche, BorderLayout.SOUTH);
		btnNouvelleManche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				new InterfaceReglages(frame);
			}
		});
		btnNouvelleManche.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnNouvelleManche, BorderLayout.SOUTH);
		
		
		
		for (int i = 0; i < Partie.getPartie().getListeJoueurs().size(); i++) {
			Partie.getPartie().getListeJoueurs().get(i).compterPoints();
		}
	}
}
