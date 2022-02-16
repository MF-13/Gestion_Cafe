package module;

import module.Produit;

public class Patisserie extends Produit {
	//class Patisserie herite de Produit

	public Patisserie( String liblle,double prix,String path) {
		super(liblle,prix,path,0.3);
	}
}
