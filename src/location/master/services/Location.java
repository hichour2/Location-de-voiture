package location.master.services;

import java.util.Date;

public class Location {
	
	int tel,nbreplace,numfacture;
	String nom,prenom,modele,cin,immatr,adresse,libcat;
	Date datelocation,dateretour,datefacturation;
	Float prix;
	
	public Integer getnumfacture() {
		return numfacture;
	}

	public void setnumfacture(int numfacture) {
		this.numfacture = numfacture;
	}
	
	public Float getprix() {
		return prix;
	}

	public void setprix(Float prix) {
		this.prix = prix;
	}
	
	public Date getdatelocation() {
		return datelocation;
	}

	public void setdatelocation(Date datelocation) {
		this.datelocation = datelocation;
	}
	
	public Date getdateretour() {
		return dateretour;
	}

	public void setdateretour(Date dateretour) {
		this.dateretour = dateretour;
	}
	
	public Date getdatefacturation() {
		return datefacturation;
	}

	public void setdatefacturation(Date datefacturation) {
		this.datefacturation = datefacturation;
	}
	
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
