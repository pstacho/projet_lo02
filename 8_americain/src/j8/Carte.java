package j8;

public class Carte {
	
	private String valeur;
	private String couleur;
	private int point;
	
	
	
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

}

//test commit trop cool