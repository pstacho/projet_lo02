package vue;

import java.awt.*;
import java.rmi.NotBoundException;
import java.util.Observable;
import java.util.Observer;
import modèle.Partie;
import javax.swing.*;

import modèle.*;

public class VueOrdinateur extends JPanel implements Observer {
	
	protected JLabel niveauJoueur;
	protected JLabel nombreCartes;
	protected JLabel nomJoueur;

	public VueOrdinateur(Joueur j) {
		this.setBorder(BorderFactory.createEmptyBorder());
		GridLayout grid=new GridLayout(0, 1);
		this.setLayout(grid);
		this.setMaximumSize(new Dimension(160, 140));
		if (((Ordinateur) j).getStrategie() instanceof StrategieNormal) {
			this.niveauJoueur = new JLabel("Niveau : Normal");
		} else if (((Ordinateur) j).getStrategie() instanceof StrategieDifficile) {
			this.niveauJoueur = new JLabel("Niveau : Difficile");

		}
		niveauJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		nomJoueur = new JLabel(j.getNom() + " ");
		nomJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		nombreCartes = new JLabel("Nombre de cartes: "+  j.getMainJoueur().size() );
		nombreCartes.setHorizontalAlignment(SwingConstants.CENTER);

		
		this.add(nomJoueur);
		this.add(nombreCartes);
		this.add(this.niveauJoueur);

	}


	
	@Override
	public void update(Observable o, Object arg) {
		this.nombreCartes.setText("Nombre de cartes: " + ((Joueur)o).getMainJoueur().size());
		
		}
	}

