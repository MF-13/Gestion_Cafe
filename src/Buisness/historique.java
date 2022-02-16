package Buisness;

import java.util.Vector;

public class historique {

	private Vector<Table> his=new Vector<Table>();


public Vector<Consomation> getHis(int nb_tab)
{
	for(Table el:his)
	{
		if(el.getNumero()==nb_tab)
		{
			return el.getVconsomation();
		}
	}
	
	return null;
}
public boolean exite_deja()
{
	for(Table el:his)
	{
		
	}
	return false;
}


public Vector<Table> aff()
{
	return his;
}

public void setHis(Table tb)
{
	his.add(tb);
}

public void supp(int nb)
{
	for(int i=0;i<his.size();i++)
	{
		if(his.get(i).getNumero()==nb)
		{
			his.remove(i);
			break;
		}
	}
}
public int test_table(int nb)
{
	   if(his!=null) 
	   {
    for(int i=0;i<his.size();i++)
    {
 	if(his.get(i).getNumero()==(nb))
 			{
 		return i;
 			}
    }
	   }
	   return -1;
}

}
