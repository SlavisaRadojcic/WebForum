package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	String ime;
	String prezime;
	String uloga;
	String telefon;
	String email;
	String datumregistracije;
	Calendar datum;
	ArrayList<String> sacuvaneteme=new ArrayList<String>();
	ArrayList<String> sacuvanipodforumi=new ArrayList<String>();
	ArrayList<String> sacuvanikomentari=new ArrayList<String>(); 
	ArrayList<Integer> pozitivniteme=new ArrayList<Integer>();
	ArrayList<Integer> negativniteme=new ArrayList<Integer>();
	ArrayList<Integer> pozitivnikomentari=new ArrayList<Integer>();
	ArrayList<Integer> negativnikomentari=new ArrayList<Integer>();
	public ArrayList<String> getSacuvanikomentari() {
		return sacuvanikomentari;
	}
	public ArrayList<Integer> getPozitivniteme() {
		return pozitivniteme;
	}
	public ArrayList<Integer> getNegativniteme() {
		return negativniteme;
	}
	public ArrayList<Integer> getPozitivnikomentari() {
		return pozitivnikomentari;
	}
	public ArrayList<Integer> getNegativnikomentari() {
		return negativnikomentari;
	}
	public void setPozitivnikomentari(ArrayList<Integer> pozitivnikomentari) {
		this.pozitivnikomentari = pozitivnikomentari;
	}
	public void setNegativnikomentari(ArrayList<Integer> negativnikomentari) {
		this.negativnikomentari = negativnikomentari;
	}
	public void setPozitivniteme(ArrayList<Integer> pozitivniglasovi) {
		this.pozitivniteme = pozitivniglasovi;
	}
	public void setNegativniteme(ArrayList<Integer> negativniglasovi) {
		this.negativniteme = negativniglasovi;
	}
	public void setSacuvanikomentari(ArrayList<String> sacuvanikomentari) {
		this.sacuvanikomentari = sacuvanikomentari;
	}
	public ArrayList<String> getSacuvanipodforumi() {
		return sacuvanipodforumi;
	}
	public void setSacuvanipodforumi(ArrayList<String> sacuvanipodforumi) {
		this.sacuvanipodforumi = sacuvanipodforumi;
	}
	public ArrayList<String> getSacuvaneteme() {
		return sacuvaneteme;
	}
	public void setSacuvaneteme(ArrayList<String> sacuvaneteme) {
		this.sacuvaneteme = sacuvaneteme;
	}
	public User() {
		uloga="korisnik";
		datum = Calendar.getInstance();
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    datumregistracije=sdf.format(datum.getTime());
	    		
	}
	public User(String kime, String sifra, String mojeime, String mojeprezime,String mojtelefon, String mojemail ) {
		username=kime;
		password=sifra;
		ime=mojeime;
		prezime=mojeprezime;
		uloga="korisnik";
		telefon=mojtelefon;
		email=mojemail;
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		datum = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	     datumregistracije=sdf.format(datum.getTime());
	     sacuvaneteme=new ArrayList<String>();
	     sacuvanipodforumi=new ArrayList<String>();
	     sacuvanikomentari=new ArrayList<String>();
	     negativniteme=new ArrayList<Integer>();
	     pozitivniteme=new ArrayList<Integer>();
	     negativnikomentari=new ArrayList<Integer>();
	     pozitivnikomentari=new ArrayList<Integer>();
	}
	public String getUloga() {
		return uloga;
	}
	public String getDatumregistracije() {
		return datumregistracije;
	}
	public String mojdatum() {
		String d;
		d="danas";
		
		//Calendar cal = Calendar.getInstance();
       // DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        d=sdf.format(datum.getTime());
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//d=dateFormat.format(datum).toString();
		return d;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	public void setDatumregistracije(String datumregistracije) {
		this.datumregistracije = datumregistracije;
	}
	public String getUsername() {
		return username;
	}
	public String getIme() {
		return ime;
	}
	public String getPassword() {
		return password;
	}
	public String getPrezime() {
		return prezime;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setIme(String ime) {
		this.ime=ime;
	}
	public void setPrezime(String prezime) {
		this.prezime=prezime;
	}
	public void setTelefon(String telefon) {
		this.telefon=telefon;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
}
