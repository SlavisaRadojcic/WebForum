package beans;

import java.io.Serializable;

public class Tema implements Serializable {
int idteme;
String podforum;
String naslovteme;
String autor;
int pozitivni;
int negativni;
String tip;
String sadrzajtip;

public int getIdteme() {
	return idteme;
}
public void setIdteme(int idteme) {
	this.idteme = idteme;
}
public String getTip() {
	return tip;
}
public String getSadrzajtip() {
	return sadrzajtip;
}
public void setTip(String tip) {
	this.tip = tip;
}
public void setSadrzajtip(String sadrzajtip) {
	this.sadrzajtip = sadrzajtip;
}
public Tema() {
	
}
public Tema(int id,String tpodforum, String tnaslovteme, String tautor, String ttip, String ttipsadrzaj ) {
	idteme=id;
	podforum=tpodforum;
	naslovteme=tnaslovteme;
	autor=tautor;
	tip=ttip;
	sadrzajtip=ttipsadrzaj;
	pozitivni=0;
	negativni=0;
}
public int getPozitivni() {
	return pozitivni;
}
public int getNegativni() {
	return negativni;
}
public void setPozitivni(int pozitivni) {
	this.pozitivni = pozitivni;
}
public void setNegativni(int negativni) {
	this.negativni = negativni;
}
public String getPodforum() {
	return podforum;
}
public String getNaslovteme() {
	return naslovteme;
}
public String getAutor() {
	return autor;
}
public void setPodforum(String podforum) {
	this.podforum = podforum;
}
public void setNaslovteme(String naslovteme) {
	this.naslovteme = naslovteme;
}
public void setAutor(String autor) {
	this.autor = autor;
}

}
