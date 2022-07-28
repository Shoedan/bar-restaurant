package ecomenzi;

import javax.swing.JOptionPane;

public class Produs {
	String denumire;
	int cantitate; 							
	String unitate_de_masura;
	double pret;
	String categorie;
	
	/* Soft Drinks / Cafea / Bere / Cocktails / Long Drinks */
	
	Produs(String den , int cant , String unitate , double pret , String cat){
		this.denumire=den;
		this.cantitate=cant;
		this.unitate_de_masura=unitate;
		this.pret=pret;
		this.categorie=cat;
	}
	
	Produs(){
		this.denumire = JOptionPane.showInputDialog("Denumire : ");
		this.cantitate = Integer.parseInt(JOptionPane.showInputDialog("Cantitate : "));
		this.unitate_de_masura = JOptionPane.showInputDialog("Unitate de Masura : ");
		this.pret = Double.parseDouble(JOptionPane.showInputDialog("Pret : "));
		String[] options = {"SoftDrinks" , "Cafea" , "Bere" , "Cocktail" , "LongDrinks"};
		int option =  JOptionPane.showOptionDialog(null, "Categorie", "Categorie", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		this.categorie=options[option];	
	}
	
	void get_produs() {
		System.out.println("Nume : " + this.denumire);
		System.out.println("Cantitate : " + this.cantitate);
		System.out.println("Unitate de masura : " + this.unitate_de_masura);
		System.out.println("Pret : " + this.pret);
		System.out.println("Categorie : " + this.categorie);
		
	}
	
	@Override
	public String toString() {
	    return denumire + " " + Integer.toString(cantitate) + " " + unitate_de_masura + " " + Double.toString(pret) + " lei " + categorie;
	}
	
	double get_pret() {
		return this.pret;
	}
	
	public void modify_denumire(Angajat A) {
		if (A.functie)
			this.denumire = JOptionPane.showInputDialog("Introduceti un nume nou ");
	}
	
	public void modify_cantitate(Angajat A) {
		if (A.functie)
			this.cantitate = Integer.parseInt(JOptionPane.showInputDialog("Introduceti cantitatea : "));
	}
	
	public void modify_unit (Angajat A) {
		if (A.functie)
			this.unitate_de_masura = JOptionPane.showInputDialog("Introduceti unitatea de masura ");
	}
	
	public void modify_pret(Angajat A) {
		if (A.functie)
			this.pret = Double.parseDouble(JOptionPane.showInputDialog("Introduceti pretul nou"));
	}
	
	public void modify_categorie(Angajat A) {
		if (A.functie) {
		String[] options = {"Soft Drinks" , "Cafea" , "Bere" , "Cocktail" , "Alcoholic Beverages"};
		int option =  JOptionPane.showOptionDialog(null, "Introduceti noua categorie", "Introduceti noua categorie", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		this.categorie=options[option];
	}}

}

