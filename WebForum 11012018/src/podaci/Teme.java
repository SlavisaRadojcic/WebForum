package podaci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import beans.Podforum;
import beans.Tema;
import beans.User;

public class Teme  {
public static ArrayList<Tema> spisakTema(){
	ArrayList<Tema> spisak=new ArrayList<Tema>();
	/*spisak.add(new Tema("Servleti", "Kako funkcionisu servleti","Pera"));
	spisak.add(new Tema("Servleti", "primer Login servleta","Lepa"));
	spisak.add(new Tema("Responisve","Sta je responsiv web dizjan?","Pera"));
	spisak.add(new Tema("Responisve","Viewport tag","Mima"));
	spisak.add(new Tema("Responisve","Media Queries","Mima"));
	spisak.add(new Tema("Servleti","Servlet Kontejner","Lepa"));
	spisak.add(new Tema("Responisve","Responsiv web dizjan- rad sa slikama","Lepa"));*/
	try {
		
					FileInputStream fi = new FileInputStream(new File("c:/new/teme.txt"));
					ObjectInputStream oi = new ObjectInputStream(fi);

					// Read objects
					
					
				/*	Tema pr1 = (Tema) oi.readObject();
					Tema pr2 = (Tema) oi.readObject();
				spisak.add(pr1);
				spisak.add(pr2);*/
					
					
					Tema tp=(Tema) oi.readObject();
					while(!tp.getNaslovteme().equalsIgnoreCase("kraj")) {
						spisak.add(tp);
						System.out.println(tp.getNaslovteme());
						tp=(Tema) oi.readObject();
					}
					
					/*Tema pr3 = (Tema) oi.readObject();
					 * while(!pr3.getNaslovteme().equalsIgnoreCase("kraj")) {
						spisak.add(pr3);
						pr3 = (Tema) oi.readObject();
					}*/
					
					oi.close();
					fi.close();
					return spisak;

				} catch (FileNotFoundException e) {
					System.out.println("File not found");
					return spisak;
				} catch (IOException e) {
					System.out.println("Error initializing stream");
					return spisak;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();	
					return spisak;}

	
	
}
public static boolean sacuvajTemuPocetak() {
	
	Tema p1=new Tema(1,"Servleti", "Kako funkcionisu servleti","Pera","tekst","servleti su deo java web dinamickih aplikacija");
	Tema p2=new Tema(2,"Servleti", "primer Login servleta","Mima","link","https://www.javatpoint.com/example-of-login-form-in-servlet");
	Tema pk=new Tema(0,"kraj","kraj","kraj","kraj","kraj");
	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/teme.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		o.writeObject(p1);
		o.writeObject(p2);
		o.writeObject(pk);

		o.close();
		f.close();

		
		return true;

	} catch (FileNotFoundException e) {
		
		System.out.println("File not found");
		return false;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
		return false;
	}

	
	
	//return true;
}
public static boolean sacuvajTemu(Tema t, ArrayList<Tema> lista) {
	 Tema pk=new Tema(0,"kraj","kraj","kraj","kraj","kraj");
	 
		lista.add(t);
		lista.add(pk);
	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/teme.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		int i=0;
		while(i<lista.size()) {
			o.writeObject(lista.get(i));
			i++;
		}
		
	
		
		
		o.close();
		f.close();

		
		return true;

	} catch (FileNotFoundException e) {
		
		System.out.println("File not found");
		return false;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
		return false;
	}
	
	
}
public static boolean sacuvajSpisak(ArrayList<Tema> lista) {
	 Tema pk=new Tema(0,"kraj","kraj","kraj","kraj","kraj");
	 
		
		lista.add(pk);
	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/teme.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		int i=0;
		while(i<lista.size()) {
			o.writeObject(lista.get(i));
			i++;
		}
		
	
		
		
		o.close();
		f.close();

		
		return true;

	} catch (FileNotFoundException e) {
		
		System.out.println("File not found");
		return false;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
		return false;
	}
	
	
}

public static boolean temeProvera(Tema u, ArrayList<Tema> spisak) {
	boolean postoji=false;
	int i=0;
	while(!postoji && i<spisak.size()) {
		if(spisak.get(i).getNaslovteme().equalsIgnoreCase(u.getNaslovteme())) {
			postoji=true;
		}
		i++;
	}
	
	return postoji;
}

public static int maxid(ArrayList<Tema> spisak) {
	int max=spisak.get(0).getIdteme();
	for(int i=0; i<spisak.size();i++) {
		if (spisak.get(i).getIdteme()>max) {
			max=spisak.get(i).getIdteme();
		}
	}
	
	return max;
	
}

}
