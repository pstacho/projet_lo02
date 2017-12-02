package j8;

public class Carte {
	
	private String valeur;
	private String couleur;
	private int point;
	private String effet="null";
	
	
	
	public String getEffet() {
		return effet;
	}

	public void setEffet(String effet) {
		this.effet = effet;
	}

	public Carte(String val, String color) {
		this.valeur = val;
		this.couleur = color;
		// pour les points faire les variantes d'abords
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	public String toString() {
		return valeur + " de " + couleur;
	}

}

//test commit trop cool numero 2