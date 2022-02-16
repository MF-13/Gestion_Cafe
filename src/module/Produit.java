package module;

public class Produit {
	private String libelle;
	private double prix;
	private double tva;
	private String path;

	public Produit(String liblle,double prix,String path,double tva) {
		this.prix = prix;
		this.libelle = liblle;
		this.path=path;
		this.tva=tva;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	@Override
	public String toString() {
		return "Produit [libelle=" + libelle + ", prix=" + prix + ", tva=" + tva + ""+"]\n";
	}
	

}
