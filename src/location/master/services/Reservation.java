package location.master.services;

import java.util.Date;

public class Reservation {
	
	int codereserv,tel,nbreplace;
	String nom,prenom,modele,cin,immatr,adresse,libcat;
	Date datereservation;
	
	public Integer gettel() {
		return tel;
	}

	public void settel(int tel) {
		this.tel = tel;
	}
	
	public Integer getnbreplace() {
		return nbreplace;
	}

	public void setnbreplace(int nbreplace) {
		this.nbreplace = nbreplace;
	}
	
	public String getadresse() {
		return adresse;
	}

	public void setadresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getlibcat() {
		return libcat;
	}

	public void setlibcat(String libcat) {
		this.libcat = libcat;
	}
	
	public Date getdatereservation() {
		return datereservation;
	}

	public void setdatereservation(Date datereservation) {
		this.datereservation = datereservation;
	}
	
	public String getcin() {
		return cin;
	}

	public void setcin(String cin) {
		this.cin = cin;
	}
	
	public String getimmatr() {
		return immatr;
	}

	public void setimmatr(String immatr) {
		this.immatr = immatr;
	}
	
	public Integer getcodereserv() {
		return codereserv;
	}

	public void setcodereserv(int codereserv) {
		this.codereserv = codereserv;
	}
	
	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public String getnom() {
		return nom;
	}
	
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getprenom() {
		return prenom;
	}
	
	public void setmodele(String modele) {
		this.modele = modele;
	}
	
	public String getmodele() {
		return modele;
	}

}
