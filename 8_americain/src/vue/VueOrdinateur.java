package vue;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import modèle.*;

/**
 * @author Stacho
 *
 */
@SuppressWarnings("deprecation")
public class VueOrdinateur extends JPanel implements Observer {
	
	/**
	 * 
	 */
	protected JLabel nomBot;
	/**
	 * 
	 */
	protected JLabel difficulteOrdi;
	/**
	 * 
	 */
	protected JLabel nombreCartes;
	

	/**
	 * @param ordi
	 */
	public VueOrdinateur(Joueur ordi) {
		this.setBorder(BorderFactory.createEmptyBorder());
		GridLayout grid=new GridLayout(0, 1);
		this.setLayout(grid);
		this.setMaximumSize(new Dimension(200, 150));
		
		if (((Ordinateur)ordi).getStrategie() instanceof StrategieNormal) {
			this.difficulteOrdi = new JLabel("Niveau : Normal");
		} else if (((Ordinateur)ordi).getStrategie() instanceof StrategieDifficile) {
			this.difficulteOrdi = new JLabel("Niveau : Difficile");

		}
		difficulteOrdi.setHorizontalAlignment(SwingConstants.CENTER);
		nomBot = new JLabel(ordi.getNom() + " ");
		nomBot.setHorizontalAlignment(SwingConstants.CENTER);
		nombreCartes = new JLabel("Nombre cartes: "+  ordi.getMainJoueur().size() );
		nombreCartes.setHorizontalAlignment(SwingConstants.CENTER);

		
		this.add(nomBot);
		this.add(nombreCartes);
		this.add(this.difficulteOrdi);

	}


	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.nombreCartes.setText("Nombre de cartes: " + ((Joueur)o).getMainJoueur().size());
		
		}
	}

