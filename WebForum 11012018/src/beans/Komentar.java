package beans;

import java.io.Serializable;

public class Komentar implements Serializable {
String tema;
String autor;
int idkomentara;//redni brojevi pocinju od 1
int roditeljskikomentar;//ako nema, vrednst je postavjena na 0
String tekstkomentara;
int pozitivniglasovi;
int negativniglasovi;
boolean izmenjen;
boolean obrisan;

public boolean isObrisan() {
	return obrisan;
}
public void setObrisan(boolean obrisan) {
	this.obrisan = obrisan;
}
public String getTema() {
	return tema;
}
public String getAutor() {
	return autor;
}
public void setTema(String tema) {
	this.tema = tema;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public Komentar(){
	
}
public Komentar(String ktema, String kautor,int id, int rid, String tekst) {
	
	idkomentara=id;
	roditeljskikomentar=rid;
	tekstkomentara=tekst;
	pozitivniglasovi=0;
	negativniglasovi=0;
	izmenjen=false;
	obrisan=false;
	autor=kautor;
	tema=ktema;
	
}


public int getIdkomentara() {
	return idkomentara;
}
public int getRoditeljskikomentar() {
	return roditeljskikomentar;
}
public String getTekstkomentara() {
	return tekstkomentara;
}
public int getPozitivniglasovi() {
	return pozitivniglasovi;
}
public int getNegativniglasovi() {
	return negativniglasovi;
}
public boolean isIzmenjen() {
	return izmenjen;
}
public void setIdkomentara(int idkomentara) {
	this.idkomentara = idkomentara;
}
public void setRoditeljskikomentar(int roditeljskikomentar) {
	this.roditeljskikomentar = roditeljskikomentar;
}
public void setTekstkomentara(String tekstkomentara) {
	this.tekstkomentara = tekstkomentara;
}
public void setPozitivniglasovi(int pozitivniglasovi) {
	this.pozitivniglasovi = pozitivniglasovi;
}
public void setNegativniglasovi(int negativniglasovi) {
	this.negativniglasovi = negativniglasovi;
}
public void setIzmenjen(boolean izmenjen) {
	this.izmenjen = izmenjen;
}

}
