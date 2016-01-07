package location.master.services;

public class Utilisateur {
	
	String login,pass,type;
	Integer id_user;
	
	public Integer getid_user() {
		return id_user;
	}

	public void setid_user(Integer id_user) {
		this.id_user = id_user;
	}
	
	public String getlogin() {
		return login;
	}

	public void setlogin(String login) {
		this.login = login;
	}
	
	public String getpass() {
		return pass;
	}

	public void setpass(String pass) {
		this.pass = pass;
	}
	
	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

}
