package location.master.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import location.master.requetes.Requetes;
import location.master.services.Client;
import location.master.services.Location;

public class Clientdao {
	
	public List<Client> clients(String cin) {
		List<Client> listeclients = new ArrayList<Client>();
		Connection conn = null;
		Statement selectStatement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			if(cin==null)
			{
			result = selectStatement.executeQuery(Requetes.REQUETE_CLIENTS());	
			}
			else
			{
			result = selectStatement.executeQuery(Requetes.REQUETE_CLIENTS(cin));
			}
			
			while (result.next()){
				Client _client= new Client();
				_client.setcin(result.getString(1));
				_client.setnom(result.getString(3));
				_client.setprenom(result.getString(4));
				_client.setadresse(result.getString(5));
				_client.setnumtel(result.getInt(6));
				_client.setcodecat(result.getInt(2));
				
				listeclients.add(_client);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.getCause();
			System.err.println("Le driver JDBC pour MYSQL est introuvable");
		} catch (SQLException e) {
			e.getCause();
			System.err
					.println("Un probleme de connexion est sourvenu, vérfier la chaine de connexion");
		}

		return listeclients;
	}

}
