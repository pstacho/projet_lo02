package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mod�le.JoueurPhysique;
import mod�le.Manche;

public class ControleurBoutonPiocher {

	public ControleurBoutonPiocher(JButton pioche, Manche maManche)
	{
		pioche.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean trouveCarte=false;
				for (int i=0; i<maManche.getJoueurEnCours().getMainJoueur().size(); i++) {
					if (maManche.getJoueurEnCours().carteCompatible(maManche, maManche.getLeTalon(), maManche.getJoueurEnCours().getMainJoueur().get(i))){
						trouveCarte=true;
					}
				}
				if(!trouveCarte && maManche.getJoueurEnCours() instanceof JoueurPhysique) {
					System.out.println("feiodcoijdiojediosdpoj");
					maManche.getJoueurEnCours().getMainJoueur().add(maManche.getLaPioche().piocherCarte(maManche.getLeTalon()));
					((JoueurPhysique) maManche.getJoueurEnCours()).setAttenteVue(false);
				}
				

	}
		});
}
}