package module;

import module.Produit;

public class Boisson extends Produit {
	//class Boisson herite de Produit

	
	public Boisson(String liblle,double prix,String path) {
		super(liblle,prix,path,0.15);
		
	}

}
