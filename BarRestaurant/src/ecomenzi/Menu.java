package ecomenzi;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Menu {
	private static ArrayList <Angajat> ListaAngajati = new ArrayList<Angajat>();
	private static ArrayList <Produs> Meniu = new ArrayList<Produs>();
	private static ArrayList <ComandaMasa> Mese = new ArrayList<ComandaMasa>();
	
	public static void set_LA(ArrayList <Angajat> LA) {
		ListaAngajati = LA;
	}
	
	public static void set_M(ArrayList <Produs> M) {
		Meniu = M;
	}
	
	public static void set_masa(ArrayList <ComandaMasa> Me) {
		Mese=Me;
	}
	
	public static ArrayList<Angajat> get_LA(){
		return ListaAngajati;
	}
	
	public static ArrayList<Produs> get_M(){
		return Meniu;
	}
	
	public static ArrayList<ComandaMasa> get_Me(){
		return Mese;
	}
	
	public static void login_frame_create() {						/// LogIn Frame
		JFrame f=new JFrame("LogIn");
		final JLabel label = new JLabel();            
	     label.setBounds(20,150, 200,50);
	     final JPasswordField value = new JPasswordField();   
	     value.setBounds(100,75,100,30);   
	     JLabel l2=new JLabel("Password:");    
	     l2.setBounds(20,75, 80,30);    
	     JButton b = new JButton("Login");  
	     b.setBounds(100,120, 80,30);       
	     f.add(value); f.add(label);f.add(l2); f.add(b); 
	     f.setSize(300,300);    
	     f.setLayout(null); 
	     f.setLocationRelativeTo(null);
	     f.setVisible(true);
	     b.addActionListener(new ActionListener() { 
	    	 		@Override
	                public void actionPerformed(ActionEvent e) {       
	                   String data ;  
	                   data = new String(value.getPassword());
	                   boolean ok=false;
					for (int i=0;i<ListaAngajati.size();i++)
	                	   if (ListaAngajati.get(i).id==Integer.parseInt(data)) {
	                		   	options_menu(ListaAngajati.get(i));
	                		   	f.dispose();}
						if (!ok)
							label.setText("Wrong Passowrd");
	                }
	             });
	}
	
	public static void options_menu(Angajat A) {				/// Options Menu
		JFrame f=new JFrame("Alegeti optiunea");
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel();
		final JLabel message = new JLabel();
		JLabel l1 = new JLabel ("Alege optiunea");
		JButton b1 = new JButton("Modifica lista de Angajati");
		JButton b2 = new JButton ("Printeaza lista de angajati");
		JButton b3 = new JButton("Modifica Meniu");
		JButton b4 = new JButton("Printeazaz Meniu");
		JButton b5 = new JButton("Vizualizeaza Mese");
		JButton b6 = new JButton("Logout");
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		p.add(l1);p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);p.add(message);
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
	    f.getContentPane().add(p);
	    f.setSize(300, 200);
	    f.setVisible(true);
	    b6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		login_frame_create();
	    		f.dispose();
	    		
	    	}
	    });
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (!A.functie)
	    			message.setText("Nu esti autorizat");
	    		else {
	    			Modifica_Angajat(A);
	    			f.dispose();}
	    			
	    	}
	    });
	    b2.addActionListener(new ActionListener() {										
	    	public void actionPerformed(ActionEvent e) {
	    		if (!A.functie)
	    			message.setText("Nu esti autorizat");
	    		else
	    			{JOptionPane.showMessageDialog(null,ListaAngajati.toArray());
	    			print_angajati();
	    			f.dispose();
	    			options_menu(A);}
	    	}
	    });
	    
	    b3.addActionListener(new ActionListener() {										
	    	public void actionPerformed(ActionEvent e) {
	    		if (!A.functie)
	    			message.setText("Nu esti autorizat");
	    		else
	    			{Modifica_Meniu(A);
	    			f.dispose();}
	    		
	    	}
	    });
	    
	    b4.addActionListener(new ActionListener() {										
	    	public void actionPerformed(ActionEvent e) {
	    		if (!A.functie)
	    			message.setText("Nu esti autorizat");
	    		else
	    			{JOptionPane.showMessageDialog(null, Meniu.toArray());
	    			print_meniu();
	    			f.dispose();
	    			options_menu(A);}
	    	}
	    });
	    
	    b5.addActionListener(new ActionListener() {										
	    	public void actionPerformed(ActionEvent e) {
	    		meniu_mese(A);
	    		f.dispose();
	    	}
	    });
	    
		
		
	}
	
	public static void Modifica_Angajat(Angajat A) {
		JFrame f=new JFrame("Alegeti optiunea");
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel();
		final JLabel message = new JLabel();
		JLabel l1 = new JLabel ("Alege optiunea");
		JButton b1 = new JButton("Adauga angajat");
		JButton b2 = new JButton("Sterge Angajat");
		JButton b3 = new JButton("Modifica datele unui angajat");
		JButton b4 = new JButton("Back");
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		p.add(l1);p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(message);
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
	    f.getContentPane().add(p);
	    f.setSize(300, 150);
	    f.setVisible(true);
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ListaAngajati.add(new Angajat());
	    		options_menu(A);
	    		f.dispose();	    			
	    	}
	    });
	    b2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String aux = JOptionPane.showInputDialog("Introduceti id-ul Angajatului pe care doriti sa il stergeti : ");
	    		for (int i=0;i<ListaAngajati.size();i++)
	    			if (ListaAngajati.get(i).id == Integer.parseInt(aux)) {
	    				ListaAngajati.remove(i);
	    				options_menu(A);
	    				f.dispose();}
	    			else
	    				message.setText("ID gresit");					
	    	}
	    });
	    b3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String aux = JOptionPane.showInputDialog("Introduceti id-ul Angajatului ale carui date doriti sa le modificati :");
	    		for (int i=0;i<ListaAngajati.size();i++)
	    			if (ListaAngajati.get(i).id == Integer.parseInt(aux)) {
	    				String [] options = {"Numele" , "Prenumele" , "Functia" , "ID-ul"};
	    				int option =  JOptionPane.showOptionDialog(null, "Ce doresti sa modifici", "Ce doresti sa modifici?", 
	    						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	    						null, options, options[0]);
	    				switch(option) {
	    					case 0 : A.modify_name(ListaAngajati.get(i));break;
	    					case 1 : A.modify_given_name(ListaAngajati.get(i));break;
	    					case 2 : A.modify_functie(ListaAngajati.get(i));break;
	    					case 3 : A.modify_id(ListaAngajati.get(i));break;
	    				}
	    				options_menu(A);
	    				f.dispose();}
	    			else
	    				message.setText("ID gresit");
	    	}
	    });
	    b4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		options_menu(A);
	    		f.dispose();	    			
	    	}
	    });
		
	}
	
	public static void Modifica_Meniu(Angajat A) {
		JFrame f=new JFrame("Alegeti optiunea");
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel();
		final JLabel message = new JLabel();
		JLabel l1 = new JLabel ("Alege optiunea");
		JButton b1 = new JButton("Adauga produs");
		JButton b2 = new JButton("Sterge produs");
		JButton b3 = new JButton("Modifica datele unui produs");
		JButton b4 = new JButton("Back");
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		p.add(l1);p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(message);
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
	    f.getContentPane().add(p);
	    f.setSize(300, 150);
	    f.setVisible(true);
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Meniu.add(new Produs());
	    		options_menu(A);
	    		f.dispose();	    			
	    	}
	    });
	    b3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String aux = JOptionPane.showInputDialog("Introduceti numele produsului pe care doriti sa il modificati(case sensitive) :  ");
	    		for (int i=0;i<Meniu.size();i++)
	    			if (Meniu.get(i).denumire.equals(aux)) {
	    				String [] options = {"Denumire" , "Cantitate" , "Unitate de masura" , "Pret" , "Categorie" };
	    				int option =  JOptionPane.showOptionDialog(null, "Ce doresti sa modifici", "Ce doresti sa modifici?", 
	    						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	    						null, options, options[0]);
	    				switch(option) {
    					case 0 : Meniu.get(i).modify_denumire(A);break;
    					case 1 : Meniu.get(i).modify_cantitate(A);break;
    					case 2 : Meniu.get(i).modify_unit(A);break;
    					case 3 : Meniu.get(i).modify_pret(A);break;
    					case 4 : Meniu.get(i).modify_categorie(A);break;
    				}}
	    			else
	    				message.setText("Denumire gresita");	    			
	    	}
	    });
	    b2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String aux = JOptionPane.showInputDialog("Introduceti numele produsului pe care doriti sa il stergeti (case sensitive):  ");
	    		for (int i=0;i<Meniu.size();i++)
	    			if (Meniu.get(i).denumire.equals(aux)) {
	    				Meniu.remove(i);
	    				options_menu(A);
	    				f.dispose();}
	    			else
	    				message.setText("Denumire gresita");	    			
	    	}
	    });
	    b4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		options_menu(A);
	    		f.dispose();	    			
	    	}
	    });
	}
	
	public static void meniu_mese(Angajat A) {
		JFrame f=new JFrame("Alegeti Masa");
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel();
		final JLabel message = new JLabel();
		JLabel l1 = new JLabel ("Alege Masa");
		JButton back = new JButton("Back");
		p.add(l1);
		ArrayList <JButton> _mese = new ArrayList <JButton>();
		for (int i=0;i<Mese.size();i++)
			_mese.add(new JButton("Masa " + i));
		for (int i=0;i<Mese.size();i++)
			p.add(_mese.get(i));
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
	    f.getContentPane().add(p);p.add(back);p.add(message);
	    f.setSize(300, 300);
	    f.setVisible(true);
	    for (int i=0;i<_mese.size();i++) {
	    	_mese.get(i).addActionListener(new ActionListener() {									/// Continue
		    	public void actionPerformed(ActionEvent e) {
		    		String [] splitter = e.getActionCommand().split(" ");
		    		meniu_masa(A,Integer.parseInt(splitter[1]));
		    		f.dispose();
		    			
		    	}
		    });
	    }
	    back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		options_menu(A);
	    		f.dispose();
	    	}
	    });
	}
	
	public static void meniu_masa(Angajat A ,int index_masa) {
		JFrame f=new JFrame("Alegeti optiunea");
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel();
		final JLabel message = new JLabel();
		JLabel l1 = new JLabel ("Alege optiunea");
		JButton b1 = new JButton("Comanda");
		JButton b2 = new JButton("Modifica Comanda");
		JButton b4 = new JButton("Calculeaza nota de plata");
		JButton b5 = new JButton("Muta masa");
		JButton b6 = new JButton("Elibereaza Masa");
		JButton b7 = new JButton("Back");
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		p.add(l1);p.add(b1);p.add(b2);p.add(b4);p.add(b5);p.add(b6);p.add(b7);p.add(message);
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
	    f.getContentPane().add(p);
	    f.setSize(300, 200);
	    f.setVisible(true);
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (Mese.get(index_masa).empty) {
	    			Mese.add(index_masa, new ComandaMasa(Meniu,A));
	    			print_masa(index_masa);
	    			f.dispose();
	    			options_menu(A);}
	    		else
	    			message.setText("Masa nu este goala");
	    	}
	    });
	    b2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (!Mese.get(index_masa).empty) {
	    			Mese.get(index_masa).modifica_comanda(A, Meniu);
	    			print_masa(index_masa);
	    			f.dispose();
	    			options_menu(A);}
	    		else
	    			message.setText("Masa este goala");
	    	}
	    });
	    b4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (!Mese.get(index_masa).empty) {
	    			double nota_de_plata = Mese.get(index_masa).calculeaza_pret(A);
	    			JOptionPane.showMessageDialog(null, "Nota de plata pentru masa " + index_masa + "(in momentul acesta) este : " + nota_de_plata + " lei ");
	    			f.dispose();
	    		    JOptionPane.showMessageDialog(null,Mese.get(index_masa).Produse_comanda.toArray());
	    			options_menu(A);
	    		}
	    		else
	    			message.setText("Masa este goala");
	    	}
	    });
	    b5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String aux = JOptionPane.showInputDialog("Cu ce masa doresti sa schimbi ?");
	    		ComandaMasa masa_aux = new ComandaMasa();
	    		masa_aux.schimba_mese(Mese.get(index_masa));																/// Swap is not a thing in java no ?
	    		Mese.get(index_masa).schimba_mese(Mese.get(Integer.parseInt(aux)));
	    		Mese.get(Integer.parseInt(aux)).schimba_mese(masa_aux);
	    		f.dispose();
	    		options_menu(A);	
	    	}
	    });
	    b6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Mese.get(index_masa).goleste_masa(A);
	    		f.dispose();
	    		options_menu(A);
	    	}
	    });
	    b7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		meniu_mese(A);
	    		f.dispose();
	    	}
	    });
		
	}
	
	public static void print_angajati() {
		for (int i=0;i<ListaAngajati.size();i++)
			ListaAngajati.get(i).display_self();
	}
	
	public static void print_meniu() {
		for (int i=0;i<Meniu.size();i++)
			Meniu.get(i).get_produs();
	}
	
	public static void print_mese() {
		for (int i=0;i<Mese.size();i++)
			if (!Mese.get(i).empty) {
				System.out.println("Masa " + i);
				System.out.println();
				Mese.get(i).afiseaza_comanda();}
	}
	
	public static void print_masa (int index){
		System.out.println("Masa " + index );
		System.out.println();
		Mese.get(index).afiseaza_comanda();
	}
	

}
