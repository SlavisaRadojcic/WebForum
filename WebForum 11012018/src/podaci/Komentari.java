package podaci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import beans.Komentar;


public class Komentari {
public static ArrayList<Komentar>spisakKomentara(){
	ArrayList<Komentar> spisak=new ArrayList<Komentar>();
	//spisak.add(new Komentar("Kako funkcionisu servleti","Lepa",1,0,"Java Veb Servleti su klase napisane u programskom jeziku Java. ",3,0));
	//spisak.add(new Komentar("Kako funkcionisu servleti","Pera",2,0,"Servleti implementiraju implementiraju javax.servlet.Servlet interfejs",1,0));
	//spisak.add(new Komentar("Kako funkcionisu servleti","Pera",3,0,"Servleti komunicirati sa klijentima korišćenjem protokola kao što su naprimer HTTP",1,1));
	//spisak.add(new Komentar("Kako funkcionisu servleti","Pera",4,1,"posebno su interesantni HttpServleti",0,0));
	//spisak.add(new Komentar("Sta je responsiv web dizjan?", "Mima",5,0,"Prilagođavanje sadrzaja web sajta određenoj platformi (kopjuter, tablet, mobilni telefon…) je Responsive Web Design",5,0));
	//spisak.add(new Komentar("Sta je responsiv web dizjan?", "Lepa",6,0,"Primenom media upita je moguce lako utvrditi dimenzije uredjaja i primeniti odgovarajucis stil",0,0));
	
	try {
		
		FileInputStream fi = new FileInputStream(new File("c:/new/komentari.txt"));
		ObjectInputStream oi = new ObjectInputStream(fi);

	
		
		
		Komentar tp=(Komentar) oi.readObject();
		while(!tp.getTekstkomentara().equalsIgnoreCase("kraj")) {
			spisak.add(tp);
			System.out.println(tp.getTekstkomentara());
			tp=(Komentar) oi.readObject();
		}
		
		
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

public static boolean sacuvajKomentarPocetak() {
	
	Komentar p1=new Komentar("Kako funkcionisu servleti","Mima",1,0,"Java Veb Servleti su klase napisane u programskom jeziku Java. ");
	Komentar p2=new Komentar("Kako funkcionisu servleti","Pera",2,0,"Servleti implementiraju implementiraju javax.servlet.Servlet interfejs");
	Komentar pk=new Komentar("kraj","kraj",0,0,"kraj");

	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/komentari.txt"));
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

public static boolean sacuvajKomentare(ArrayList<Komentar> lista) {
	
	
	Komentar pk=new Komentar("kraj","kraj",0,0,"kraj");
	lista.add(pk);
	try {
		FileOutputStream f = new FileOutputStream(new File("c:/new/komentari.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
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
public static int maxid(ArrayList<Komentar> spisak) {
	int max=spisak.get(0).getIdkomentara();
	for(int i=0; i<spisak.size();i++) {
		if (spisak.get(i).getIdkomentara()>max) {
			max=spisak.get(i).getIdkomentara();
		}
	}
	
	return max;
	
}

}
