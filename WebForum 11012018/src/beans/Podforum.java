package beans;

import java.io.Serializable;

public class Podforum implements Serializable {
	int idpodforuma;
	
	String naziv;
	String opis;
	String ikonica;
	String odgovornimoderator;
	public Podforum() {
		
	}
	public Podforum(int id,String pnaziv, String popis, String pikonica, String podgovornimoderator) {
		idpodforuma=id;
		naziv=pnaziv; 
		opis=popis;
		ikonica=pikonica;
		odgovornimoderator=podgovornimoderator;
	}
	public int getIdpodforuma() {
		return idpodforuma;
	}
	public void setIdpodforuma(int idpodforuma) {
		this.idpodforuma = idpodforuma;
	}
	public String getNaziv() {
		return naziv;
	}
	public String getOpis() {
		return opis;
	}
	public String getIkonica() {
		return ikonica;
	}
	public String getOdgovornimoderator() {
		return odgovornimoderator;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public void setIkonica(String ikonica) {
		this.ikonica = ikonica;
	}
	public void setOdgovornimoderator(String odgovornimoderator) {
		this.odgovornimoderator = odgovornimoderator;
	}
	public String toString() {
		return naziv+ " , "+opis;
	}
	
	
}
