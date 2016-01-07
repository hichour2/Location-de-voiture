package location.master.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import location.master.requetes.Requetes;

public class ModifVehicule {
	
public void modifier(String immatr1,String immatr,int cat,String modele,int nbreplace) {
		
		Connection conn = null;
		Statement selectStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			selectStatement.executeUpdate(Requetes.REQUETE_MODIFER_VEHICULE(immatr1,immatr, cat, modele, nbreplace));
			
			
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
