package location.master.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.compiler.IScanner;

import location.master.requetes.Requetes;
import location.master.services.Vehicule;

public class VehiculeDispo {
	
	public List<Vehicule> Listedispo() {
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		Connection conn = null;
		Statement selectStatement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			result = selectStatement.executeQuery(Requetes.REQUETE_VEHICULES_DISPO());
			
			while (result.next()){
				Vehicule _vehi = new Vehicule();
				_vehi.setimmatricule(result.getString(1));
				_vehi.setcodecat(result.getInt(2));
				_vehi.setmodele(result.getString(3));
				_vehi.setnbreplace(result.getInt(4));
				
				vehicules.add(_vehi);
			}
		} catch (ClassNotFoundException e) {
			e.getCause();
			System.err.println("Le driver JDBC pour MYSQL est introuvable");
		} catch (SQLException e) {
			e.getCause();
			System.err
					.println("Un probleme de connexion est sourvenu, vérfier la chaine de connexion");
		}

		return vehicules;
	}

}
