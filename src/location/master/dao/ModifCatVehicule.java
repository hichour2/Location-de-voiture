package location.master.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import location.master.requetes.*;
import location.master.services.*;

public class ModifCatVehicule {
	
	public void modifier(int code,String libelle,Float prix) {
		
		Connection conn = null;
		Statement selectStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			selectStatement.executeUpdate(Requetes.REQUETE_MODIFER_CATEGORIE_VEHICULE(code, libelle, prix));
			
			
		} catch (ClassNotFoundException e) {
			e.getCause();
			System.err.println("Le driver JDBC pour MYSQL est introuvable");
		} catch (SQLException e) {
			e.getCause();
			System.err
					.println("Un probleme de connexion est sourvenu, vérfier la chaine de connexion");
		}
}
}
