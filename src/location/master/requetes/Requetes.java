package location.master.requetes;

import java.util.*;

public class Requetes {
	
	public static String REQUETE_CATEGORIES_VEHICULES() {
		return "SELECT * FROM categorie_vehicule";
	}
	
	public static String REQUETE_CATEGORIE_VEHICULE(int code) {
		return "SELECT * FROM categorie_vehicule where codecatvehicule='"+code+"'";
	}
	
	public static String REQUETE_MODIFER_CATEGORIE_VEHICULE(int code,String libelle,Float prix) {
		return "UPDATE location.categorie_vehicule c SET libellecatvehicule='"+libelle+"',prix='"+prix+"' where codecatvehicule='"+code+"';";
	}
	
	public static String REQUETE_SUPPRIMER_CATEGORIE_VEHICULE(int code) {
		return "DELETE FROM location.categorie_vehicule WHERE codecatvehicule='"+code+"';";
	}
	
	public static String REQUETE_NOUVELLE_CATEGORIE_VEHICULE(String libelle,Float prix) {
		return "INSERT INTO location.categorie_vehicule(libellecatvehicule,prix) VALUES('"+libelle+"','"+prix+"');";
	}

	public static String REQUETE_CATEGORIES_CLIENTS() {
		return "SELECT * FROM categorie_client";
	}
	
	public static String REQUETE_CATEGORIE_CLIENT(int code) {
		return "SELECT * FROM categorie_client where codecategorie='"+code+"'";
	}

	public static String REQUETE_MODIFER_CATEGORIE_CLIENT(int code,String libelle,Float tauxremise) {
		return "UPDATE location.categorie_client c SET libellecategorie='"+libelle+"',tauxremise='"+tauxremise+"' where codecategorie='"+code+"';";
	}
	
	public static String REQUETE_SUPPRIMER_CATEGORIE_CLIENT(int code) {
		return "DELETE FROM location.categorie_client WHERE codecategorie='"+code+"';";
	}
	public static String REQUETE_NOUVELLE_CATEGORIE_CLIENT(String libelle,Float tauxremise) {
		return "INSERT INTO location.categorie_client(libellecategorie,tauxremise) VALUES('"+libelle+"','"+tauxremise+"');";
	}
	
	public static String REQUETE_NOUVEAU_CLIENT(String cin,String nom,String prenom,String adresse,int numtel,int codecate) {
		return "INSERT INTO location.`client`(nomclient,prenomclient,adresse,numtelephone,cin,codecategorie) VALUES('"+nom+"','"+prenom+"','"+adresse+"','"+numtel+"','"+cin+"','"+codecate+"');";
	}
	
	public static String REQUETE_VEHICULES() {
		return "SELECT * FROM vehicule";
	}
	
	public static String REQUETE_VEHICULE(String immatr) {
		return "SELECT * FROM vehicule where immatriculation='"+immatr+"'";
	}
	
	public static String REQUETE_NOUVELLE_LOCATION(String cin,String immatr,Date datelocation,Date dateretour,Date datefacture,Float prix) {
		return "INSERT INTO location.location(cin,immatriculation,datelocation,dateretour,datefacturation,prixfacture) VALUES('"+cin+"','"+immatr+"','"+datelocation+"','"+dateretour+"','"+datefacture+"','"+prix+"');";
	}
	
	public static String REQUETE_NOUVEAU_VEHICULE(String immatr,int cat,String modele,int nbreplace) {
		return "INSERT INTO location.vehicule VALUES('"+immatr+"','"+cat+"','"+modele+"','"+nbreplace+"');";
	}
	
	public static String REQUETE_MODIFER_VEHICULE(String immatr1,String immatr,int cat,String modele,int nbreplace) {
		return "UPDATE location.vehicule v SET immatriculation='"+immatr+"',codecatvehicule='"+cat+"',modele='"+modele+"',nombreplace='"+nbreplace+"' where immatriculation='"+immatr1+"';";
	}
	
	public static String REQUETE_SUPPRIMER_VEHICULE(String immatr) {
		return "DELETE FROM location.vehicule where immatriculation='"+immatr+"';";
	}
	
	public static String REQUETE_VEHICULES_DISPO() {
		return "SELECT * FROM location.vehicule where immatriculation not in(select immatriculation FROM location.location where dateretour > CURRENT_DATE) and immatriculation not in(select immatriculation from location.reserver)";
	}
	
	public static String REQUETE_RESERVATIONS() {
		return "SELECT codereserv,nomclient,prenomclient,datereservation,modele from location.reserver r,location.client c,location.vehicule v where c.cin=r.cin and v.immatriculation=r.immatriculation ;";
	}
	
	public static String REQUETE_RESERVATION(int codereserv) {
		return "SELECT r.cin,nomclient,prenomclient,adresse,numtelephone,r.immatriculation,r.immatriculation,modele,nombreplace,libellecatvehicule from location.reserver r,location.client c,location.vehicule v,location.categorie_vehicule cv where codereserv='"+codereserv+"' and c.cin=r.cin and v.immatriculation=r.immatriculation and cv.codecatvehicule=v.codecatvehicule ;";
	}

	public static String REQUETE_MAX_RESERVATION() {
		return "SELECT MAX(codereserv) FROM `location`.`reserver`;";
	}
	
	public static String REQUETE_NOUVELLE_RESERVATION(String cin,String immatriculation) {
		return "INSERT INTO location.reserver(datereservation,cin,immatriculation) VALUES(CURRENT_DATE,'"+cin+"','"+immatriculation+"');";
	}
	
	public static String REQUETE_LOCATIONS() {
		return "SELECT nomclient,prenomclient,modele,libellecatvehicule,datelocation,dateretour,datefacturation,prixfacture from location.client c,location.vehicule v,location.location l,location.categorie_vehicule cv where c.cin=l.cin and v.immatriculation=l.immatriculation and cv.codecatvehicule=v.codecatvehicule ORDER BY numfacture DESC;";
	}
	
	public static String REQUETE_MAX_LOCATION() {
		return "SELECT MAX(numfacture) FROM `location`.`location`;";
	}
	
	public static String REQUETE_SUPPRIMER_RESERVATION(int codereserv) {
		return "DELETE FROM location.reserver where codereserv='"+codereserv+"';";
	}
	
	public static String REQUETE_CLIENTS() {
		return "SELECT * FROM client";
	}
	
	public static String REQUETE_CLIENTS(String cin) {
		return "SELECT * FROM client where cin='"+cin+"'";
	}
	
	public static String REQUETE_MODIFER_CLIENT(String cin,int codecate,String nom,String prenom,String adresse,int tel) {
		return "UPDATE client SET cin='"+cin+"',codecategorie='"+codecate+"',nomclient='"+nom+"',prenomclient='"+prenom+"',adresse='"+adresse+"',numtelephone='"+tel+"' where cin='"+cin+"';";
	}
	
	public static String REQUETE_SUPPRIMER_CLIENT(String cin) {
		return "DELETE FROM client WHERE cin='"+cin+"';";
	}
	
	public static String REQUETE_INIT_CONNECT() {
		return "select * from authentification;";
	}
	
	public static String REQUETE_UTILISATEUR(String login,String pass) {
		return "select * from authentification where login='"+login+"' and password='"+pass+"';";
	}
	
	public static String REQUETE_UTILISATEUR_BY_ID(int id_user) {
		return "select * from authentification where id_user='"+id_user+"';";
	}
	
	public static String REQUETE_AJOUT_USER(String login,String pass,String type) {
		return "INSERT INTO location.authentification(login,password,type) VALUES('"+login+"','"+pass+"','"+type+"');";
	}
	
	public static String REQUETE_MODIFER_UTILISATEUR(int id_user,String login,String pass) {
		return "UPDATE authentification SET login='"+login+"',password='"+pass+"' where id_user='"+id_user+"';";
	}
	
	public static String REQUETE_DEL_USER(int id_user) {
		return "DELETE FROM authentification where id_user='"+id_user+"';";
	}

}
