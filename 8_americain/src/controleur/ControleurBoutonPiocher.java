package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modèle.JoueurPhysique;
import modèle.Manche;

/**
 * @author Stacho
 *
 */
public class ControleurBoutonPiocher {

	/**
	 * @param pioche
	 * @param maManche
	 */
	public ControleurBoutonPiocher(JButton pioche, Manche maManche) {
		pioche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trouveCarte = false;
				for (int i = 0; i < maManche.getJoueurEnCours().getMainJoueur().size(); i++) {
					if (maManche.getJoueurEnCours().carteCompatible(maManche, maManche.getJoueurEnCours().getMainJoueur().get(i))) {
						trouveCarte = true;
					}
				}
				if (!trouveCarte && maManche.getJoueurEnCours() instanceof JoueurPhysique) {
					System.out.println("feiodcoijdiojediosdpoj");
					maManche.getJoueurEnCours().getMainJoueur()
							.add(maManche.getLaPioche().piocherCarte(maManche.getLeTalon()));
					((JoueurPhysique) maManche.getJoueurEnCours()).setAttenteVue(false);
				}

			}
		});
	}
}