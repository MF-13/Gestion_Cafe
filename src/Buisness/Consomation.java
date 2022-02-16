package Buisness;

import java.text.DecimalFormat;

import module.Produit;

// class consomation
public class Consomation {
	
	private Produit p;
	private int quantite;
	private DecimalFormat f = new DecimalFormat();
	
	
	public Consomation(Produit p, int quantite)
        {
		super();
		this.p = p;
		this.quantite = quantite;
		
	}
	public Produit getP()
        {
		return p;
	}
	
	public int getQuantite()
        {
		return quantite;
	}
	public void setQuantite(int quantite)
        {
		this.quantite = quantite;
	}
	public double prixttc()
        {
		return Math.round(p.getPrix()*quantite*(1+p.getTva()));
	}
	public String toString() {
		return "Consomation (p=" + p + "), [quantite=" + quantite + "]";
	}
	
}
