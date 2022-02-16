package Presentation;

import Buisness.Consomation;
import Buisness.Table;
import Buisness.historique;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import module.Produit;
import module.modele;

public class vu extends JFrame {
	//interface graphique
	
	private JPanel panel_table=new JPanel(new GridLayout(1,10));
	private JPanel panel_produit=new JPanel(new GridLayout(4,4));
	private JPanel ticket=new JPanel(new BorderLayout());
	private JPanel okcan=new JPanel(new GridLayout(1,2));
	private JPanel panel_west=new JPanel();
	private JButton[] btn_pr=new JButton[12];
	private JButton[] btn_tab=new JButton[10];
	private JButton btn_ok=new JButton("OK");
	private JButton btn_cancel=new JButton("Cancel");
	private JButton btn_mod=new JButton("Show All");
	private JTextArea ticket_text=new JTextArea(60,30);
    private modele md=new modele();
    private String info ;
    private int i,nb_c=0;
    private String tabGlobal = "";
    private Table consommation_table=new Table();;
    private historique hr=new historique();

	public vu() throws Exception
	{
		System.out.println();
	
		panel_north_add();
		panel_est_add();
		panel_tick();
		setLayout(new BorderLayout());
		add(panel_table,BorderLayout.NORTH);
		add(panel_produit,BorderLayout.CENTER);
		add(ticket,BorderLayout.EAST);
		ticket_text.setEnabled(true);
 		setVisible(true);
		setSize(1500,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*affectation des serveur*/
		int lebar = this.getWidth()/2;
        int tinggi = this.getHeight()/2;
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-lebar;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-tinggi;
        setLocation(x, y);
	}
   
	public void panel_north_add()
	{
		for(i=0;i<btn_tab.length;i++)
		{
		btn_tab[i]=new JButton(""+(i+1));
		panel_table.add(btn_tab[i]);
		btn_tab[i].addActionListener(new action_btn_tab(i+1));
		}
	}
	public void panel_est_add() throws Exception
	 {
		   md.load();
		   for(i=0;i<btn_pr.length;i++)
			{
			   Icon img=new ImageIcon(md.getVp().get(i).getPath());
			  
			   btn_pr[i]=new JButton(img);
			   btn_pr[i].setEnabled(false);
			   panel_produit.add(btn_pr[i]);
			   btn_pr[i].addActionListener(new action_btn_pr(md.getVp().get(i)));
			  
			}
	 }

	public void panel_tick()
	{
		okcan.add(btn_ok); 
		okcan.add(btn_mod);
		okcan.add(btn_cancel);
		
		ticket.add(ticket_text, BorderLayout.CENTER);
		ticket.add(okcan, BorderLayout.SOUTH);
		btn_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ticket_text.setText(" ----------------Ticket imprimer----------------");	
				for(int k=0;k<btn_pr.length;k++) 
				{
					btn_pr[k].setEnabled(false);
				}
			}
		});
		btn_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				consommation_table.clearTable();
				ticket_text.setText(info);
				
			}
		});
		btn_mod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				for(Table el:hr.aff())
				{
					String hist = el.getNumero()+"-> "+el.getVconsomation();
					ticket_text.setText(hist);
					
				}
			}
		});
		ticket_text.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stu
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub


			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				ticket_text.setEnabled(true);

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ticket_text.setEnabled(false);

			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
	

   
   //////////////----------Action lisner-------------/////////
	////btn_tab
   public class action_btn_tab implements ActionListener{
       private int nb_tab;
       public action_btn_tab(int nb_tab)
       {
        this.nb_tab=nb_tab;
       }
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	tabGlobal=""+nb_tab;
        	nb_c++;
        	info="Consomation num: "+nb_c+"\n"
        	+"----------------------------------------------------------------------------------\n"
            
            +"Table num: "+nb_tab+"\n"
            +"----------------------------------------------------------------------------------\n"
            +"libelle\tQuantité\tTVA\tPrix"
            +"\n----------------------------------------------------------------------------------";
        	ticket_text.setText(info);
            for(int i=0;i<12;i++)
            {
            btn_pr[i].setEnabled(true);	
            }
          
            System.out.println(tabGlobal+"----->"+nb_tab);
          //  nb_table=new Integer(nb_tab);
              if(Integer.parseInt(tabGlobal)==nb_tab)
        		{
            	  hr.setHis(consommation_table);
            	  consommation_table.clearTable();
            	  
            	
        		}
        }  
   }
   ///btn_pr
   public class action_btn_pr implements ActionListener{
	   private Produit p;
	   StringBuffer text_=new StringBuffer();
       public action_btn_pr(Produit p)
       {
          this.p=p;
       }
       @Override
       public void actionPerformed(ActionEvent e)
       {
    	   
    	   consommation_table.setNum(Integer.parseInt(tabGlobal));
    	
    	   consommation_table.add_ve(new Consomation(p, 1));

    	  
            ticket_text.setText(info+"\n"+consommation_table.ticket()
            +"                                                                     ------------------------------"
            +"\n                                                                      TOTALE : "
            +consommation_table.TotalPrixTable()+"DH"+"\n                       "+new Date());
        
       }
       
    
  }
    

	     
}
