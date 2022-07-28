package ecomenzi;

import javax.swing.JOptionPane;


public class Angajat {
	String Nume;
	String Prenume;										
	int id;								/// pentru comenzile la masa
	boolean functie;
	
	Angajat(String p , String n , int i , boolean fct){
		this.Nume=n;
		this.Prenume=p;
		this.id=i;
		this.functie=fct;
	}
	
	Angajat(){
		this.Nume = JOptionPane.showInputDialog("Nume Angajat : ");
		this.Prenume = JOptionPane.showInputDialog("Prenume Angajat");
		this.id = Integer.parseInt(JOptionPane.showInputDialog("Angajat id :"));
		String [] options = {"Administrator" , "Chelner"};
		int option =  JOptionPane.showOptionDialog(null, "Ce functie are angajatul", "Ce functie are angajatul", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		if (option == 0)
			this.functie=true;
		else 
			this.functie=false;
		}
	
	public void modify_functie(Angajat A) {
		if (this.functie) {
			String [] options = {"Administrator" , "Chelner"};
			int option =  JOptionPane.showOptionDialog(null, "Ce functie are angajatul", "Ce functie are angajatul", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
			if (option == 0)
				A.functie=true;
			else 
				A.functie=false;}
	}
	
	public void modify_id (Angajat A) {
		if (this.functie)
			A.id = Integer.parseInt(JOptionPane.showInputDialog("Introduceti id-ul nou : "));
	}
	public void modify_name(Angajat A) {
		if (this.functie)
			A.Nume = JOptionPane.showInputDialog("Introduceti numele nou : ");
	}
	
	public void modify_given_name(Angajat A) {
		if (this.functie)
			A.Prenume = JOptionPane.showInputDialog("Introducecti prenumele nou : ");
	}
	
	
	public void display (Angajat A) {
		if (this.functie) {
			System.out.println("Nume : " + A.Nume);
			System.out.println("Prenume : " + A.Prenume);
			System.out.println("Id angajat : " + A.id);
		}
	}
	
	public void display_self() {
		System.out.println("Nume : " + this.Nume);
		System.out.println("Prenume : " + this.Prenume);
		System.out.println("Id angajat : " + this.id);
	}
	
	public Angajat get_self() {return this;}

@Override
	public String toString() {
		String aux = this.Nume + " " + this.Prenume + " ";
		if (this.functie)
			aux+="Administrator";
		else
			aux+="Chelner";
		aux+=" ID : " + this.id;
		return aux;
}

}
