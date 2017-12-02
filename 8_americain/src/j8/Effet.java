package j8;

public interface Effet {

	public static void inverserSensJeu(Manche maManche) {
		System.out.println("Le sens de jeu est inversé");
		maManche.setSensPositif(!maManche.isSensPositif());
	}

	public static void rejouer(Manche maManche) {
		maManche.setJoueurRejouer(true);
	}
}
