package podaci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import beans.Komentar;
import beans.Podforum;
import beans.User;

public class Podforumi {
public static ArrayList<Podforum> listapodforuma(){
	//ArrayList<Podforum> spisak=new ArrayList<Podforum>();
	ArrayList<Podforum> lista=new ArrayList<Podforum>();
	try {
		//citanje objekat iz fajla i stavljanje u listu
		FileInputStream fi = new FileInputStream(new File("/c:/new/mojipodforumi.txt"));
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		
		
		Podforum pr1 = (Podforum) oi.readObject();
		
		
		while(!pr1.getNaziv().equalsIgnoreCase("kraj")) {
			lista.add(pr1);
		
			pr1 = (Podforum) oi.readObject();
			
		}
		
		
		oi.close();
		fi.close();
		return lista;
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
		return lista;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
		return lista;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return lista;
	}
	

	/*spisak.add(new Podforum("Servleti","Cemu sluze i kako funkcionisu","java.jpg","Pera"));
	spisak.add(new Podforum("JSP","Java Server Pages","java1.jpg","Lepa"));
	spisak.add(new Podforum("Responisve","kako postici responsive dizajn web stranica","html5.jpg","Lepa"));*/
	
	
}
public static boolean sacuvajPodforumPocetak() {
	Podforum p1=new Podforum(1,"java","sve o javi","ikonica.png","Mila");
	Podforum p2=new Podforum(2,"Servleti","Cemu sluze i kako funkcionisu","java.jpg","Mila");
	Podforum pk=new Podforum(0,"kraj","kraj","kraj","kraj");
	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/mojipodforumi.txt"));
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

	
}
public static boolean sacuvajPodforum(Podforum p,ArrayList<Podforum>lista) {
	Podforum pk=new Podforum(0,"kraj","kraj","kraj","kraj");
	lista.add(p);
	lista.add(pk);
	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/mojipodforumi.txt"));
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
public static boolean podforumProvera(Podforum u, ArrayList<Podforum> spisak) {
	boolean postoji=false;
	int i=0;
	while(!postoji && i<spisak.size()) {
		if(spisak.get(i).getNaziv().equalsIgnoreCase(u.getNaziv())) {
			postoji=true;
		}
		i++;
	}
	
	return postoji;
}
public static boolean sacuvajSpisakPodforum(ArrayList<Podforum>lista) {
	Podforum pk=new Podforum(0,"kraj","kraj","kraj","kraj");
	lista.add(pk);
	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/mojipodforumi.txt"));
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

public static int maxid(ArrayList<Podforum> spisak) {
	int max=spisak.get(0).getIdpodforuma();
	for(int i=0; i<spisak.size();i++) {
		if (spisak.get(i).getIdpodforuma()>max) {
			max=spisak.get(i).getIdpodforuma();
		}
	}
	
	return max;
	
}

}


