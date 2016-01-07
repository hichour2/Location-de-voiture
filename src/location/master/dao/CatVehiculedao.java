package location.master.dao;

import location.master.services.*;
import location.master.requetes.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatVehiculedao {
	
	public List<CatVehicule> categories(int code) {
		List<CatVehicule> listeCategories = new ArrayList<CatVehicule>();
		Connection conn = null;
		Statement selectStatement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			if(code==0)
			{
				result = selectStatement.executeQuery(Requetes.REQUETE_CATEGORIES_VEHICULES());
			}
			else
			{
				result = selectStatement.executeQuery(Requetes.REQUETE_CATEGORIE_VEHICULE(code));
			}
			
			
			while (result.next()){
				CatVehicule _cat = new CatVehicule();
				_cat.setcode(result.getInt(1));
				_cat.setlibelle(result.getString(2));
				_cat.setprix(result.getFloat(3));
				
				listeCategories.add(_cat);
			}
		} catch (ClassNotFoundException e) {
			e.getCause();
			System.err.println("Le driver JDBC pour MYSQL est introuvable");
		} catch (SQLException e) {
			e.getCause();
			System.err
					.println("Un probleme de connexion est sourvenu, vérfier la chaine de connexion");
		}

		return listeCategories;
	}

}
