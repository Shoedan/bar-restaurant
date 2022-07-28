package ecomenzi;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ComandaMasa {
	ArrayList<Produs> Produse_comanda = new ArrayList<Produs>();
	Angajat A;
	boolean empty;
	
	ComandaMasa(){
		this.A=null;
		this.empty=true;
		Produse_comanda=null;
	}
	
	ComandaMasa(ArrayList<Produs> Meniu , Angajat B){
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Cate produse doriti sa comandati ?"));
		for (int i=0;i<aux;i++) {
			String[] options = {"SoftDrinks" , "Cafea" , "Bere" , "Cocktail" , "LongDrinks" };
			int option =  JOptionPane.showOptionDialog(null, "Categoria produsului de adaugat", "Categoria produsului de adaugat", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);
			ArrayList <String> helper = new ArrayList<String>();
			String []helper2;
			int drinks_options;
			switch (option) {
				case 0 : 
					for (int j=0;j<Meniu.size();j++)
							if (Meniu.get(j).categorie.equals(options[option])) 
								helper.add(Meniu.get(j).denumire);
					helper2= new String[helper.size()];															/// Drinks Stored
					for (int j=0;j<helper.size();j++)
						helper2[j]=helper.get(j);
					drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
							null, helper2,helper2[0]);
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
							Produse_comanda.add(Meniu.get(j));
						break;
				case 1 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
				case 2 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
				case 3 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
				case 4 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
			}
		}
		this.empty=false;
		this.A=B;
	}
	
	
	void modifica_comanda(Angajat B , ArrayList<Produs> Meniu) {
		if (this.A==B) {
			String [] options = new String[Produse_comanda.size()];
			String [] aux = {"Sterg produs" , "Adaug produs"};
			for (int i=0;i<Produse_comanda.size();i++)
				options[i]=Produse_comanda.get(i).denumire;
			int option =  JOptionPane.showOptionDialog(null, "Ce doresti sa faci ?", "Ce doresti sa faci?", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, aux, aux[0]);
			if (option==0) {
				int placeholder = JOptionPane.showOptionDialog(null, "Ce produs doresti sa stergi ?", "Ce produs doresti sa stergi ?", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null , options , options[0]);
				Produse_comanda.remove(placeholder);}
			if (option==1) 
				adauga_produs(B,Meniu);
				
			}
		else
			JOptionPane.showMessageDialog(null,"ID Chelner incorect");
		}
	
	void adauga_produs(Angajat B , ArrayList<Produs> Meniu) {														
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Cate produse doriti sa comandati ?"));
		for (int i=0;i<aux;i++) {
			String[] options = {"SoftDrinks" , "Cafea" , "Bere" , "Cocktail" , "LongDrinks" };
			int option =  JOptionPane.showOptionDialog(null, "Categoria produsului de adaugat", "Categoria produsului de adaugat", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);
			ArrayList <String> helper = new ArrayList<String>();
			String []helper2;
			int drinks_options;
			switch (option) {
				case 0 : 
					for (int j=0;j<Meniu.size();j++)
							if (Meniu.get(j).categorie.equals(options[option])) 
								helper.add(Meniu.get(j).denumire);
					helper2= new String[helper.size()];															/// Drinks Stored
					for (int j=0;j<helper.size();j++)
						helper2[j]=helper.get(j);
					drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
							null, helper2,helper2[0]);
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
							Produse_comanda.add(Meniu.get(j));
						break;
				case 1 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
				case 2 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
				case 3 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
				case 4 :
					for (int j=0;j<Meniu.size();j++)
						if (Meniu.get(j).categorie.equals(options[option])) 
							helper.add(Meniu.get(j).denumire);
				helper2= new String[helper.size()];															/// Drinks Stored
				for (int j=0;j<helper.size();j++)
					helper2[j]=helper.get(j);
				drinks_options = JOptionPane.showOptionDialog(null, "Produs de adaugat", "Produs de adaugat", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, helper2,helper2[0]);
				for (int j=0;j<Meniu.size();j++)
					if (Meniu.get(j).denumire.equals(helper2[drinks_options]))
						Produse_comanda.add(Meniu.get(j));
					break;
			}
		}

	}
	
	void schimba_mese(ComandaMasa A) {
		this.Produse_comanda=A.Produse_comanda;
		this.A=A.A;
		this.empty=A.empty;
	}
	
	void afiseaza_comanda() {
		for (int i=0;i<Produse_comanda.size();i++)
			Produse_comanda.get(i).get_produs();
	}
	
	double calculeaza_pret(Angajat B) {
		double plata=0;
		for (int i=0;i<Produse_comanda.size();i++)
			plata= plata + Produse_comanda.get(i).get_pret();
		return plata;
		}

	
	boolean get_status() {
		return this.empty;
	}
	
	void goleste_masa(Angajat B) {
		if (B==this.A) {
			this.A=null;
			Produse_comanda.clear();}
	}

}