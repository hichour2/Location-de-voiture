package location.master.services;

public class Client {
	
	String cin,nom,prenom,adresse;
	int codecat,numtel;
	
	public String getcin() {
		return cin;
	}

	public void setcin(String cin) {
		this.cin = cin;
	}
	
	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public String getprenom() {
		return prenom;
	}

	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getadresse() {
		return adresse;
	}

	public void setadresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Integer getcodecat() {
		return codecat;
	}

	public void setcodecat(int codecat) {
		this.codecat = codecat;
	}
	
	public Integer getnumtel() {
		return numtel;
	}

	public void setnumtel(int numtel) {
		this.numtel = numtel;
	}
	

}
