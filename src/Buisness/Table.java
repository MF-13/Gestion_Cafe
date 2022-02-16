 package Buisness;

import java.util.Vector;

import module.Produit;


public class Table {

	 private int numero;
	 private Vector<Consomation> vconsomation=new Vector<Consomation>();
	 private historique hr=new historique();
	 private StringBuffer text_=new StringBuffer();

	public void setNum(int nb)
	{
		this.numero=nb;
	}
	public int getNumero()
        {
		return numero;
        }
	
	public Vector<Consomation> getVconsomation() {
		return vconsomation;
	}
	
	public void add_ve(Consomation con_add)
	{
 	   int re=test_produit(con_add.getP());
 	   if(re!=-1) {
 		   vconsomation.get(re).setQuantite(vconsomation.get(re).getQuantite()+1);
 		   text_.delete(0, text_.length());
 	   }
 	   else
 	   {
 		 text_.delete(0, text_.length());
 		 vconsomation.add(con_add);
 	   }
 	/*
 	*/
		
	}
	public String ticket()
	{
		   for(Consomation el:vconsomation)
	 	    {
	 		  
	text_.append(el.getP().getLibelle()+"\t"+el.getQuantite()+"\t"+el.getP().getTva()+"\t"+el.prixttc()+"\n");
	 	  	  
	 	    }
		   return text_.toString();
	}
	public double TotalPrixTable()
        {
		double prix=0;
		for(Consomation el:vconsomation)
                {
			prix+=el.prixttc();
		}
		return prix;
	}

	public void clearTable() 
	{
		vconsomation.clear();
	}
	
	   public int test_produit(Produit p)
	   {
		   if(vconsomation!=null) 
		   {
	       for(int i=0;i<vconsomation.size();i++)
	       {
	    	if(vconsomation.get(i).getP().getLibelle().equals(p.getLibelle()))
	    			{
	    		return i;
	    			}
	       }
		   }
		   return -1;
	   }

}
