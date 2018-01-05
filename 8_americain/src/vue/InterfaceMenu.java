package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Dimension;

//java - get screen size using the Toolkit class

public class InterfaceMenu {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMenu window = new InterfaceMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public InterfaceMenu() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0,screenWidth/2, screenHeight/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAmericain = new JLabel("8 AMERICAIN");
		lblAmericain.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmericain.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAmericain.setBounds(365, 81, 180, 48);
		frame.getContentPane().add(lblAmericain);
		
		JLabel lblNom = new JLabel("Maxime TRINQUARD           Paul STACHOWITCZ");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom.setBounds(238, 419, 448, 33);
		frame.getContentPane().add(lblNom);
		
		JButton btnNouvellePartie = new JButton("Nouvelle Partie");
		
		btnNouvellePartie.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNouvellePartie.setBounds(349, 218, 211, 48);
		frame.getContentPane().add(btnNouvellePartie);
		
		btnNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
			//	new InterfaceRéglages(frame);
			}
		});
	}
}
