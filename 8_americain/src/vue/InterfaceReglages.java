package vue;

//import controleur.*;
//import main.Partie;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

//import main.Partie;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import controleur.ControleurReglages;
import modèle.Partie;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;

public class InterfaceReglages {

	private JFrame frame;
	private JTextField textField;
	private HashMap<String, JCheckBox> ordis;
	private HashMap<String,JRadioButton> difficults;
	private JButton Valider;
	private JRadioButton positif,negatif;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private JList<Object> list;
//	private Partie maPartie;

	/**
	 * Create the application.
	 */
	public InterfaceReglages(JFrame uneFrame) {
		this.frame = uneFrame;
		initialize();
		new ControleurReglages(ordis, difficults,Valider,positif,negatif,textField,Partie.getPartie(),frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(0,0,1920/2, 1080/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblB = new JLabel("8 AMERICAIN : Réglage de la Partie");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblB.setBounds(0, 13, 942, 36);
		frame.getContentPane().add(lblB);
		
		JCheckBox ordi1 = new JCheckBox("Ordi 1");
		ordi1.setEnabled(false);
		ordi1.setSelected(true);
		ordi1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi1.setBounds(118, 174, 97, 23);
		frame.getContentPane().add(ordi1);
		ordis.put("ordi1", ordi1);
		
		JRadioButton ordi1n = new JRadioButton("Normal");
		ordi1n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(ordi1n);
		ordi1n.setSelected(true);
		ordi1n.setBounds(290, 174, 109, 23);
		frame.getContentPane().add(ordi1n);
		difficults.put("ordi1", ordi1n);
		
		JRadioButton ordi1d = new JRadioButton("Difficile");
		ordi1d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(ordi1d);
		ordi1d.setBounds(401, 174, 109, 23);
		frame.getContentPane().add(ordi1d);
		difficults.put("ordi1", ordi1d);
		
		JCheckBox ordi2 = new JCheckBox("Ordi 2");
		ordi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi2.setBounds(118, 200, 97, 23);
		frame.getContentPane().add(ordi2);
		ordis.put("ordi2", ordi2);
		
		JRadioButton ordi2n = new JRadioButton("Normal");
		ordi2n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_2.add(ordi2n);
		ordi2n.setBounds(290, 200, 109, 23);
		frame.getContentPane().add(ordi2n);
		difficults.put("ordi2", ordi2n);
		
		JRadioButton ordi2d = new JRadioButton("Difficile");
		ordi2d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_2.add(ordi2d);
		ordi2d.setBounds(401, 200, 109, 23);
		frame.getContentPane().add(ordi2d);
		difficults.put("ordi2", ordi2d);
		
		JCheckBox ordi3 = new JCheckBox("Ordi 3");
		ordi3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi3.setBounds(118, 226, 97, 23);
		frame.getContentPane().add(ordi3);
		ordis.put("ordi3", ordi3);
		
		JRadioButton ordi3n = new JRadioButton("Normal");
		ordi3n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_3.add(ordi3n);
		ordi3n.setBounds(290, 226, 109, 23);
		frame.getContentPane().add(ordi3n);
		difficults.put("ordi3", ordi3n);
		
		JRadioButton ordi3d = new JRadioButton("Difficile");
		ordi3d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_3.add(ordi3d);
		ordi3d.setBounds(401, 226, 109, 23);
		frame.getContentPane().add(ordi3d);
		difficults.put("ordi3", ordi3d);
	
		JCheckBox ordi4 = new JCheckBox("Ordi 4");
		ordi4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi4.setBounds(118, 252, 97, 23);
		frame.getContentPane().add(ordi4);
		ordis.put("ordi4", ordi4);
		
		JRadioButton ordi4n = new JRadioButton("Normal");
		ordi4n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_4.add(ordi4n);
		ordi4n.setBounds(290, 252, 109, 23);
		frame.getContentPane().add(ordi4n);
		difficults.put("ordi3", ordi3n);
		
		JRadioButton ordi4d = new JRadioButton("Difficile");
		ordi4d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_4.add(ordi4d);
		ordi4d.setBounds(401, 252, 109, 23);
		frame.getContentPane().add(ordi4d);
		difficults.put("ordi4", ordi4n);
		
		JCheckBox ordi5 = new JCheckBox("Ordi 5");
		ordi5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi5.setBounds(118, 278, 97, 23);
		frame.getContentPane().add(ordi5);
		ordis.put("ordi5", ordi5);
		
		JRadioButton ordi5n = new JRadioButton("Normal");
		ordi5n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_5.add(ordi5n);
		ordi5n.setBounds(290, 278, 109, 23);
		frame.getContentPane().add(ordi5n);
		difficults.put("ordi4", ordi4d);
		
		JRadioButton ordi5d = new JRadioButton("Difficile");
		ordi5d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_5.add(ordi5d);
		ordi5d.setBounds(401, 278, 109, 23);
		frame.getContentPane().add(ordi5d);
		difficults.put("ordi5", ordi5d);
		
		JCheckBox ordi6 = new JCheckBox("Ordi 6");
		ordi6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi6.setBounds(118, 304, 97, 23);
		frame.getContentPane().add(ordi6);
		ordis.put("ordi6", ordi6);
		
		JRadioButton ordi6n = new JRadioButton("Normal");
		ordi6n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_6.add(ordi6n);
		ordi6n.setBounds(290, 304, 109, 23);
		frame.getContentPane().add(ordi6n);
		difficults.put("ordi6", ordi6n);
		
		JRadioButton ordi6d = new JRadioButton("Difficile");
		ordi6d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_6.add(ordi6d);
		ordi6d.setBounds(401, 304, 109, 23);
		frame.getContentPane().add(ordi6d);
		difficults.put("ordi6", ordi6d);
		
		JLabel lblNewLabel = new JLabel("Ordinateur(s)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(118, 144, 109, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDifficult = new JLabel("Difficult\u00E9");
		lblDifficult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDifficult.setBounds(350, 144, 99, 23);
		frame.getContentPane().add(lblDifficult);
		
		Valider = new JButton("Valider");
		Valider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Valider.setBounds(386, 422, 151, 47);
		frame.getContentPane().add(Valider);
		
		JLabel lblModeComptage = new JLabel("Comptage des points:");
		lblModeComptage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModeComptage.setBounds(242, 363, 164, 36);
		frame.getContentPane().add(lblModeComptage);
		
		negatif = new JRadioButton("N\u00E9gatif");
		negatif.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(negatif);
		negatif.setSelected(true);
		negatif.setBounds(414, 370, 109, 23);
		frame.getContentPane().add(negatif);
		
		positif = new JRadioButton("Positif");
		positif.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(positif);
		
		positif.setBounds(526, 370, 109, 23);
		frame.getContentPane().add(positif);
		
		JLabel lblVotreNom = new JLabel("Votre nom: ");
		lblVotreNom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVotreNom.setBounds(339, 84, 97, 15);
		frame.getContentPane().add(lblVotreNom);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(450, 80, 134, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		list = new JList<Object>();
		list.setFont(new Font("Dialog", Font.PLAIN, 16));
		list.setBounds(574, 173, 264, 161);
		list.setModel(new AbstractListModel<Object>() {
			String[] values = new String[] {"Variante Minimale", "Variante de Monclar", "Variante carte et maou", "Variante de man et resta", "Variante 5", "Variante Courte Amicale (32 cartes)", "Variante 7 (32 cartes)"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		frame.getContentPane().add(list);
		
		JLabel lblVariante = new JLabel("Variante");
		lblVariante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVariante.setBounds(668, 146, 72, 18);
		frame.getContentPane().add(lblVariante);
		
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}