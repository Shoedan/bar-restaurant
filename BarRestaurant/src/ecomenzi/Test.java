package ecomenzi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void Initialization(ArrayList <Angajat> ListaAngajati , ArrayList <Produs> Meniu , ArrayList <ComandaMasa> Mese) throws NumberFormatException, IOException {
		BufferedReader buf=new BufferedReader(new FileReader("Angajati.txt"));
	    String line;
	    while ((line=buf.readLine()) !=null) {
	    	String []aux = line.split(" ");
	    	ListaAngajati.add(new Angajat(aux[0] , aux[1], Integer.parseInt(aux[2]),Boolean.parseBoolean(aux[3])));}
	    buf.close();
	    buf=new BufferedReader(new FileReader("Meniu.txt"));
	    while ((line=buf.readLine()) !=null) {
	    	String []aux = line.split(" ");
	    	Meniu.add(new Produs(aux[0] , Integer.parseInt(aux[1]) , aux[2] , Double.parseDouble(aux[3]) , aux[4]));}
	    buf.close();
	    buf = new BufferedReader(new FileReader("NrDeMese.txt"));
	    line=buf.readLine();
	    for (int i=0;i<Integer.parseInt(line);i++)
	    	Mese.add(new ComandaMasa());
	    buf.close();
	}
	
	public static void print_angajati(ArrayList <Angajat> Angajati) {						/// Debug 
		for (int i=0;i<Angajati.size();i++)
			Angajati.get(i).display_self();
	}
	
	public static void print_meniu(ArrayList <Produs> Meniu) {								/// Debug 
		for (int i=0;i<Meniu.size();i++)
			Meniu.get(i).get_produs();
	}
	
	public static void print_empty_mese(ArrayList <ComandaMasa> Mese) {					/// Debug
		for (int i=0;i<Mese.size();i++)
			System.out.println(Mese.get(i).empty);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList <Angajat> ListaAngajati = new ArrayList<Angajat>();
		ArrayList <Produs> Meniu = new ArrayList<Produs>();
		ArrayList <ComandaMasa> Mese = new ArrayList<ComandaMasa>();
		Initialization(ListaAngajati,Meniu,Mese);											/// Initializare din fisier 
		Menu.set_LA(ListaAngajati);
		Menu.set_M(Meniu);
		Menu.set_masa(Mese);
		Menu.login_frame_create();
		
		
			
		
	    
	    
		

	}

}
