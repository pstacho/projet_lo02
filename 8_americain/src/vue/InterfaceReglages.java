package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.util.HashMap;
import java.awt.Font;
import javax.swing.SwingConstants;

import controleur.ControleurReglages;
import modèle.Partie;

import javax.swing.ButtonGroup;

/**
 * @author Stacho
 *
 */
public class InterfaceReglages {

	/**
	 * 
	 */
	private JFrame frame;
	/**
	 * 
	 */
	private JTextField textField;
	/**
	 * 
	 */
	private HashMap<String, JCheckBox> ordis;
	/**
	 * 
	 */
	private HashMap<String, JRadioButton> difficults;
	/**
	 * 
	 */
	private HashMap<String, JRadioButton> variantes;
	/**
	 * 
	 */
	private HashMap<String, JTextField> textFields;
	/**
	 * 
	 */
	private JButton Valider;
	/**
	 * 
	 */
	/**
	 * 
	 */
	private JRadioButton positif, negatif;
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	/**
	 * 
	 */
	private JTextField textField_1;
	/**
	 * 
	 */
	private JTextField textField_2;
	/**
	 * 
	 */
	private JTextField textField_3;
	/**
	 * 
	 */
	private JTextField textField_4;
	/**
	 * 
	 */
	private JTextField textField_5;
	/**
	 * 
	 */
	private JTextField textField_6;
	/**
	 * 
	 */
	private final ButtonGroup buttonGroup_7 = new ButtonGroup();

	/**
	 * Create the application.
	 */
	/**
	 * @param uneFrame
	 */
	public InterfaceReglages(JFrame uneFrame) {
		this.frame = uneFrame;
		ordis = new HashMap<String, JCheckBox>();
		difficults = new HashMap<String, JRadioButton>();
		variantes = new HashMap<String, JRadioButton>();
		textFields = new HashMap<String, JTextField>();
		initialize();
		new ControleurReglages(ordis, difficults, variantes, textFields, Valider, positif, negatif, Partie.getPartie(),
				frame);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		// commenter cette ligne lorsque l'on run
		// on en a besoin pour acceder au design
		// frame = new JFrame();
		frame.setBounds(0, 0, 1920 / 2, 1080 / 2);
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
		ordi1.setBounds(66, 174, 97, 23);
		frame.getContentPane().add(ordi1);
		ordis.put("ordi1", ordi1);

		JRadioButton ordi1n = new JRadioButton("Normal");
		ordi1n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(ordi1n);
		ordi1n.setSelected(true);
		ordi1n.setBounds(210, 174, 109, 23);
		frame.getContentPane().add(ordi1n);
		difficults.put("ordi1n", ordi1n);

		JRadioButton ordi1d = new JRadioButton("Difficile");
		ordi1d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(ordi1d);
		ordi1d.setBounds(321, 174, 109, 23);
		frame.getContentPane().add(ordi1d);
		difficults.put("ordi1d", ordi1d);

		JCheckBox ordi2 = new JCheckBox("Ordi 2");
		ordi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi2.setBounds(66, 200, 97, 23);
		frame.getContentPane().add(ordi2);
		ordis.put("ordi2", ordi2);

		JRadioButton ordi2n = new JRadioButton("Normal");
		ordi2n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_2.add(ordi2n);
		ordi2n.setBounds(210, 200, 109, 23);
		frame.getContentPane().add(ordi2n);
		difficults.put("ordi2n", ordi2n);

		JRadioButton ordi2d = new JRadioButton("Difficile");
		ordi2d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_2.add(ordi2d);
		ordi2d.setBounds(321, 200, 109, 23);
		frame.getContentPane().add(ordi2d);
		difficults.put("ordi2d", ordi2d);

		JCheckBox ordi3 = new JCheckBox("Ordi 3");
		ordi3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi3.setBounds(66, 226, 97, 23);
		frame.getContentPane().add(ordi3);
		ordis.put("ordi3", ordi3);

		JRadioButton ordi3n = new JRadioButton("Normal");
		ordi3n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_3.add(ordi3n);
		ordi3n.setBounds(210, 226, 109, 23);
		frame.getContentPane().add(ordi3n);
		difficults.put("ordi3n", ordi3n);

		JRadioButton ordi3d = new JRadioButton("Difficile");
		ordi3d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_3.add(ordi3d);
		ordi3d.setBounds(321, 226, 109, 23);
		frame.getContentPane().add(ordi3d);
		difficults.put("ordi3d", ordi3d);

		JCheckBox ordi4 = new JCheckBox("Ordi 4");
		ordi4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi4.setBounds(66, 252, 97, 23);
		frame.getContentPane().add(ordi4);
		ordis.put("ordi4", ordi4);

		JRadioButton ordi4n = new JRadioButton("Normal");
		ordi4n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_4.add(ordi4n);
		ordi4n.setBounds(210, 252, 109, 23);
		frame.getContentPane().add(ordi4n);
		difficults.put("ordi4n", ordi4n);

		JRadioButton ordi4d = new JRadioButton("Difficile");
		ordi4d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_4.add(ordi4d);
		ordi4d.setBounds(321, 252, 109, 23);
		frame.getContentPane().add(ordi4d);
		difficults.put("ordi4d", ordi4d);

		JCheckBox ordi5 = new JCheckBox("Ordi 5");
		ordi5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi5.setBounds(66, 278, 97, 23);
		frame.getContentPane().add(ordi5);
		ordis.put("ordi5", ordi5);

		JRadioButton ordi5n = new JRadioButton("Normal");
		ordi5n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_5.add(ordi5n);
		ordi5n.setBounds(210, 278, 109, 23);
		frame.getContentPane().add(ordi5n);
		difficults.put("ordi5n", ordi5n);

		JRadioButton ordi5d = new JRadioButton("Difficile");
		ordi5d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_5.add(ordi5d);
		ordi5d.setBounds(321, 278, 109, 23);
		frame.getContentPane().add(ordi5d);
		difficults.put("ordi5d", ordi5d);

		JCheckBox ordi6 = new JCheckBox("Ordi 6");
		ordi6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordi6.setBounds(66, 304, 97, 23);
		frame.getContentPane().add(ordi6);
		ordis.put("ordi6", ordi6);

		JRadioButton ordi6n = new JRadioButton("Normal");
		ordi6n.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_6.add(ordi6n);
		ordi6n.setBounds(210, 304, 109, 23);
		frame.getContentPane().add(ordi6n);
		difficults.put("ordi6n", ordi6n);

		JRadioButton ordi6d = new JRadioButton("Difficile");
		ordi6d.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_6.add(ordi6d);
		ordi6d.setBounds(321, 304, 109, 23);
		frame.getContentPane().add(ordi6d);
		difficults.put("ordi6d", ordi6d);

		JLabel lblNewLabel = new JLabel("Ordinateur(s)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(66, 144, 109, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblDifficult = new JLabel("Difficult\u00E9");
		lblDifficult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDifficult.setBounds(270, 144, 99, 23);
		frame.getContentPane().add(lblDifficult);

		JRadioButton rdbtnAucunEffet = new JRadioButton("Aucun effet");
		buttonGroup_7.add(rdbtnAucunEffet);
		rdbtnAucunEffet.setSelected(true);
		rdbtnAucunEffet.setBounds(434, 121, 97, 25);
		frame.getContentPane().add(rdbtnAucunEffet);
		variantes.put("variante0", rdbtnAucunEffet);

		JRadioButton rdbtnMinimale = new JRadioButton("Minimale");
		buttonGroup_7.add(rdbtnMinimale);
		rdbtnMinimale.setBounds(434, 151, 79, 25);
		frame.getContentPane().add(rdbtnMinimale);
		variantes.put("variante1", rdbtnMinimale);

		JRadioButton rdbtnMonclar = new JRadioButton("Monclar");
		buttonGroup_7.add(rdbtnMonclar);
		rdbtnMonclar.setBounds(648, 121, 79, 25);
		frame.getContentPane().add(rdbtnMonclar);
		variantes.put("variante2", rdbtnMonclar);

		JRadioButton rdbtnCarteEtMaou = new JRadioButton("Carte et maou");
		buttonGroup_7.add(rdbtnCarteEtMaou);
		rdbtnCarteEtMaou.setBounds(535, 122, 118, 25);
		frame.getContentPane().add(rdbtnCarteEtMaou);
		variantes.put("variante3", rdbtnCarteEtMaou);

		JRadioButton rdbtnVariante = new JRadioButton("Variante 5");
		buttonGroup_7.add(rdbtnVariante);
		rdbtnVariante.setBounds(648, 151, 87, 25);
		frame.getContentPane().add(rdbtnVariante);
		variantes.put("variante4", rdbtnVariante);

		JRadioButton rdbtnManEtResta = new JRadioButton("Man et resta");
		buttonGroup_7.add(rdbtnManEtResta);
		rdbtnManEtResta.setBounds(535, 152, 114, 25);
		frame.getContentPane().add(rdbtnManEtResta);
		variantes.put("variante5", rdbtnManEtResta);

		JRadioButton rdbtnCourteAmicale = new JRadioButton("Courte Amicale (32 cartes)");
		buttonGroup_7.add(rdbtnCourteAmicale);
		rdbtnCourteAmicale.setBounds(739, 122, 183, 25);
		frame.getContentPane().add(rdbtnCourteAmicale);
		variantes.put("variante6", rdbtnCourteAmicale);

		JRadioButton rdbtnVariante_1 = new JRadioButton("Variante 7 (32 cartes)");
		buttonGroup_7.add(rdbtnVariante_1);
		rdbtnVariante_1.setBounds(739, 152, 154, 25);
		frame.getContentPane().add(rdbtnVariante_1);
		variantes.put("variante7", rdbtnVariante_1);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(452, 252, 470, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textFields.put("textField1", textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(452, 289, 470, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textFields.put("textField2", textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(452, 327, 226, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textFields.put("textField3", textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(696, 327, 226, 25);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textFields.put("textField4", textField_4);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(452, 364, 226, 25);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textFields.put("textField5", textField_5);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(696, 365, 226, 25);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		textFields.put("textField6", textField_6);

		JLabel lblEffetsDeLa = new JLabel("Effets de la variante");
		lblEffetsDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEffetsDeLa.setBounds(584, 201, 170, 19);
		frame.getContentPane().add(lblEffetsDeLa);

		Valider = new JButton("Valider");
		Valider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Valider.setBounds(386, 422, 151, 47);
		frame.getContentPane().add(Valider);

		JLabel lblModeComptage = new JLabel("Comptage des points:");
		lblModeComptage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModeComptage.setBounds(66, 357, 164, 36);
		frame.getContentPane().add(lblModeComptage);

		negatif = new JRadioButton("N\u00E9gatif");
		negatif.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(negatif);
		negatif.setSelected(true);
		negatif.setBounds(238, 364, 109, 23);
		frame.getContentPane().add(negatif);

		positif = new JRadioButton("Positif");
		positif.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(positif);

		positif.setBounds(350, 364, 109, 23);
		frame.getContentPane().add(positif);

		JLabel lblVotreNom = new JLabel("Votre nom: ");
		lblVotreNom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVotreNom.setBounds(111, 85, 97, 15);
		frame.getContentPane().add(lblVotreNom);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(222, 81, 134, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textFields.put("textField0", textField);

		JLabel lblVariante = new JLabel("Variante");
		lblVariante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVariante.setBounds(702, 83, 72, 18);
		frame.getContentPane().add(lblVariante);

	}

	/**
	 * @return
	 */
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}