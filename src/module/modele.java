package module;

import module.Patisserie;
import module.Produit;
import module.Boisson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class modele {
	//vector to store data
	private Vector<Produit> vp=new Vector<>();

	public Vector<Produit> getVp() {
		//get the product
		
		return vp;
	}
	
	public void load() throws Exception
	{
		// load the data to vector
		
		FileReader fBoi = new FileReader("C:\\Users\\lenovo\\Downloads\\Cafe\\Cafe\\src\\boisson.txt");
		FileReader fPat = new FileReader("C:\\Users\\lenovo\\Downloads\\Cafe\\Cafe\\src\\Patisserie.txt");

		BufferedReader bfBoi = new BufferedReader(fBoi);
		BufferedReader bfPat = new BufferedReader(fPat);

		String prd_b = "";
		String prd_p = "";

		while((prd_b = bfBoi.readLine()) != null && (prd_p = bfPat.readLine()) != null)
		{
			vp.add(new Boisson(prd_b.split(";")[0], Double.parseDouble(prd_b.split(";")[1]), prd_b.split(";")[2]));
			vp.add(new Patisserie(prd_p.split(";")[0], Double.parseDouble(prd_p.split(";")[1]), prd_p.split(";")[2]));
		}
		
	}

}

