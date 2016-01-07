package location.master.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import location.master.requetes.Requetes;
import location.master.services.CatClient;
import location.master.services.Utilisateur;

public class Authentification {
	
	public List<Utilisateur> utilisateurs(String login,String pass,int id_user) {
		List<Utilisateur> listeutilisateurs = new ArrayList<Utilisateur>();
		Connection conn = null;
		Statement selectStatement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			if(login==null && pass==null && id_user==0)
			{
				result = selectStatement.executeQuery(Requetes.REQUETE_INIT_CONNECT());
			}
			else if(login==null && pass==null)
			{
				result = selectStatement.executeQuery(Requetes.REQUETE_UTILISATEUR_BY_ID(id_user));
			}
			else
			{
				result = selectStatement.executeQuery(Requetes.REQUETE_UTILISATEUR(login, pass));
			}
			
			while (result.next()){
				Utilisateur _util = new Utilisateur();
				_util.setid_user(result.getInt(4));
				_util.setlogin(result.getString(1));
				_util.setpass(result.getString(2));
				_util.settype(result.getString(3));
				
				listeutilisateurs.add(_util);
			}
		} catch (ClassNotFoundException e) {
			e.getCause();
			System.err.println("Le driver JDBC pour MYSQL est introuvable");
		} catch (SQLException e) {
			e.getCause();
			System.err
					.println("Un probleme de connexion est sourvenu, vérfier la chaine de connexion");
		}

		return listeutilisateurs;
	}

}
