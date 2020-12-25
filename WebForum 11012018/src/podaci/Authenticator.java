package podaci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import beans.Tema;
import beans.User;

public class Authenticator {
	public static User Provera(String ime, String sifra,ArrayList<User> korisnici) {
		//ArrayList<User> korisnici=new ArrayList<User>();
		//korisnici.add(new User("Pera","123","Pera","Perić","064123456","pera.peric@gmail.com"));
		//korisnici.add(new User("Mima","234","Mirjana","Marić","062234567","mirjana.maric@gmail.com"));
		//korisnici.add(new User("Lepa","456","Dragana","Popović","062765346","lepa@gmail.com"));
		//korisnici.add(new User("Sima","789","Simeun","Pavić","069345678","Sima023@gmail.com"));
		User u=new User();
		boolean nadjen=false;
		int j=0;
		while(!nadjen && j<korisnici.size() ) {
			if (korisnici.get(j).getPassword().equals(sifra) && korisnici.get(j).getUsername().equals(ime)) {
				nadjen=true;
				u=korisnici.get(j);
			}
			j++;
		}
		return u;
	}
	public static boolean registracijaProvera(User u, ArrayList<User> spisak) {
		boolean postoji=false;
		int i=0;
		while(!postoji && i<spisak.size()) {
			if(spisak.get(i).getUsername().equalsIgnoreCase(u.getUsername())) {
				postoji=true;
			}
			i++;
		}
		
		return postoji;
	}
	
	public static ArrayList<User> spisakKorisnika(){
		ArrayList<User> spisak=new ArrayList<User>();
		
		
		try {
			
			FileInputStream fi = new FileInputStream(new File("c:/new/korisnici.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

					
			User tp=(User) oi.readObject();
			while(!tp.getIme().equalsIgnoreCase("kraj")) {
				spisak.add(tp);
				System.out.println(tp.getIme());
				tp=(User) oi.readObject();
				
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
	public static boolean sacuvajKorisnikaPocetak() {
		User u1=new User("Pera","123","Pera","Perić","064123456","pera.peric@gmail.com");
		User u2=new User("Mima","234","Mirjana","Marić","062234567","mirjana.maric@gmail.com");
		User uk=new User("kraj","kraj","kraj","kraj","kraj","kraj");
		u2.setUloga("administrator");
		try {
			FileOutputStream f = new FileOutputStream(new File("c:/new/korisnici.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(u1);
			o.writeObject(u2);
			o.writeObject(uk);

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
	public static boolean sacuvajKorisnika(User u,ArrayList<User> lista) {
		User uk=new User("kraj","kraj","kraj","kraj","kraj","kraj");
		lista.add(u);
		lista.add(uk);
		try {
			FileOutputStream f = new FileOutputStream(new File("c:/new/korisnici.txt"));
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
	public static ArrayList<User> admin(String x, ArrayList<User> spisak) {
		
		int i=0;
		while (i<spisak.size()) {
			if(spisak.get(i).getUsername().equalsIgnoreCase(x)) {
				spisak.get(i).setUloga("administrator");
			}
			i++;
		}
		return spisak;
		
	}
	public static boolean sacuvajIzmene(ArrayList<User> lista) {
		User uk=new User("kraj","kraj","kraj","kraj","kraj","kraj");
	 	lista.add(uk);
		try {
			FileOutputStream f = new FileOutputStream(new File("c:/new/korisnici.txt"));
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
}
