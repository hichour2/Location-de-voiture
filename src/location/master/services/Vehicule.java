package location.master.services;

public class Vehicule {
	
	String immatricule,modele,cat;
	int codecat,nbreplace;
	
	public String getimmatricule() {
		return immatricule;
	}

	public void setimmatricule(String immatricule) {
		this.immatricule = immatricule;
	}
	
	public String getmodele() {
		return modele;
	}

	public void setmodele(String modele) {
		this.modele = modele;
	}
	
	public Integer getcodecat() {
		return codecat;
	}

	public void setcodecat(int codecat) {
		this.codecat = codecat;
	}
	
	public Integer getnbreplace() {
		return nbreplace;
	}

	public void setnbreplace(int nbreplace) {
		this.nbreplace = nbreplace;
	}
	
	public String getcat() {
		return cat;
	}

	public void setcat(String cat) {
		this.cat = cat;
	}
	

}
