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
import location.master.services.Reservation;

public class Reservationdao {
	
	public List<Reservation> reservations(int codereserv) {
		List<Reservation> listereserv = new ArrayList<Reservation>();
		Connection conn = null;
		Statement selectStatement = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","master");
			selectStatement = conn.createStatement();

			if(codereserv==0)
			{
			result = selectStatement.executeQuery(Requetes.REQUETE_RESERVATIONS());
			while (result.next()){
				Reservation _reserv = new Reservation();
				_reserv.setcodereserv(result.getInt(1));
				_reserv.setnom(result.getString(2));
				_reserv.setprenom(result.getString(3));
				_reserv.setdatereservation(result.getDate(4));
				_reserv.setmodele(result.getString(5));
				
				listereserv.add(_reserv);
				}
			}
			else if(codereserv==-1)
			{
				result = selectStatement.executeQuery(Requetes.REQUETE_MAX_RESERVATION());
				while (result.next()){
					Reservation _reserv = new Reservation();
					_reserv.setcodereserv(result.getInt(1));
					
					listereserv.add(_reserv);
					}
			}
			else
			{
			result = selectStatement.executeQuery(Requetes.REQUETE_RESERVATION(codereserv));
			while (result.next()){
				Reservation _reserv = new Reservation();
				_reserv.setcin(result.getString(1));
				_reserv.setnom(result.getString(2));
				_reserv.setprenom(result.getString(3));
				_reserv.setadresse(result.getString(4));
				_reserv.settel(result.getInt(5));
				_reserv.setimmatr(result.getString(6));
				_reserv.setimmatr(result.getString(7));
				_reserv.setmodele(result.getString(8));
				_reserv.setnbreplace(result.getInt(9));
				_reserv.setlibcat(result.getString(10));
				
				listereserv.add(_reserv);
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

		return listereserv;
	}

}
