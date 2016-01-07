package location.master.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import location.master.requetes.Requetes;
import location.master.services.*;

public class Locationdao {
	
	public List<Location> locations(String max) {
		List<Location> listelocation = new ArrayList<Location>();
		Connection conn = null;
		Statement selectStatement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			if(max==null)
			{
			result = selectStatement.executeQuery(Requetes.REQUETE_LOCATIONS());
			while (result.next()){
				Location _locat= new Location();
				_locat.setnom(result.getString(1));
				_locat.setprenom(result.getString(2));
				_locat.setmodele(result.getString(3));
				_locat.setlibcat(result.getString(4));
				_locat.setdatelocation(result.getDate(5));
				_locat.setdateretour(result.getDate(6));
				_locat.setdatefacturation(result.getDate(7));
				_locat.setprix(result.getFloat(8));
				
				
				listelocation.add(_locat);
			}
			}
			else
			{
				result = selectStatement.executeQuery(Requetes.REQUETE_MAX_LOCATION());
				while (result.next()){
					Location _locat= new Location();
					_locat.setnumfacture(result.getInt(1));
					
					
					listelocation.add(_locat);
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			e.getCause();
			System.err.println("Le driver JDBC pour MYSQL est introuvable");
		} catch (SQLException e) {
			e.getCause();
			System.err
					.println("Un probleme de connexion est sourvenu, vérfier la chaine de connexion");
		}

		return listelocation;
	}

}
