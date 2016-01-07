<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Date"%>
<%
String login=(String)session.getAttribute("login");
if(login==null)
{
getServletContext().getRequestDispatcher("/").forward(request, response);
}
%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Location Auto - Nouvelle location - Etape 4 : Facturation</title>

<!-- CSS -->
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/jNice.js"></script>
</head>

<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>Transdmin Light</span></a><!-- You can name the links with lowercase, they will be transformed to uppercase by CSS, we prefered to name them with uppercase to have the same effect with disabled stylesheet -->
        </h1>
        
<ul id="mainNav">
        	<li><a href="Controleur?page=/index.jsp">ACCUEIL</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="ContCatClient?page=/WEB-INF/admin/vehicule.jsp">ADMINISTRATION</a></li>
        	<li><a href="ContCatClient?page=/WEB-INF/location/location_en_cours.jsp" class="active">LOCATION</a></li>
        	<li><a href="ContUser?page=/WEB-INF/admin/utilisateur.jsp">UTILISATEURS</a></li>
        	<li class="logout"><a href="ContUser?page=/deconnexion">DECONNEXION</a></li>
        	<li class="logout" ><a><%=session.getAttribute("login") %> | <%=session.getAttribute("type") %></a></li>
        	
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="ContCatClient?page=/WEB-INF/location/reservation1.jsp" class="active">Nouvelle location</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/location/reservation_incomp.jsp">Liste des réservations</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/location/location_en_cours.jsp">Liste des locations</a></li>
                   		<li><a href="ContCatClient?page=/WEB-INF/location/vehicules_dispo.jsp">Véhicules disponibles</a></li>
               	  </ul>
                  <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">Location</a> &raquo; <a href="#" class="active">Nouvelle location</a>
                
                <a href="" onClick="window.open('ContReservation?page=/imprimer','_blank','toolbar=0, location=0, directories=0, status=0, scrollbars=1, resizable=0, copyhistory=0, menuBar=0, width=700, height=500');return(false)">Imprimer la facture</a>
                
                </h2>
                <div id="main">
                        <table width="200" border="1">
                          <tr>
                            <td width="199">Etape 1 : Informations du client</td>
                            <td width="172">Etape 2 : Choit du véhicule</td>
                            <td width="173"><ul>
                              <li></li>
                              <li>Etape 3 : Détail du location</li>
                            </ul>                            </td>
                            <td width="208"><strong>Etape 4 : Facturation</strong></td>
                          </tr>
                        </table>
                        <form id="form1" name="form1" method="post" action="ContReservation?page=/etape4">
                          <%String cin=(String)session.getAttribute("cin"); %>
                          <%String immatr=(String)session.getAttribute("immatr"); %>
                          <%String nom=(String)session.getAttribute("nom"); %>
                          <%String prenom=(String)session.getAttribute("prenom"); %>
                          <%String adresse=(String)session.getAttribute("adresse"); %>
                          <%int tel=(Integer)session.getAttribute("tel"); %>
                          <%float taux=(Float)session.getAttribute("taux"); %>
                          <%Date datelocation=(Date)session.getAttribute("datelocation"); %>
                          <%Date dateretour=(Date)session.getAttribute("dateretour"); %>
                          <%Date datefacture=(Date)session.getAttribute("datefacture"); %>
                          <%int numfacture=(Integer)session.getAttribute("numfacture"); %>
                          <%String modele=(String)session.getAttribute("modele"); %>
                          <%int nbreplace=(Integer)session.getAttribute("nbreplace"); %>
                          <%String categorie=(String)session.getAttribute("categorie"); %>
                          <%Float prix=(Float)session.getAttribute("prix"); %>
                          <table width="261" border="1">
                            <tr>
                              <td width="76"><div align="right"><strong>N°Facture</strong></div></td>
                              <td width="688"><%=numfacture %></td>
                            </tr>
                          </table>
                          <p>&nbsp;</p>
                          <table width="297" border="1">
                            <tr>
                              <td width="75"><div align="right"><strong>CIN</strong></div></td>
                              <td width="689"><%=cin %></td>
                            </tr>
                            <tr>
                              <td><div align="right"><strong>Nom</strong></div></td>
                              <td><%=nom %></td>
                            </tr>
                            <tr>
                              <td><div align="right"><strong>Prénom</strong></div></td>
                              <td><%=prenom %></td>
                            </tr>
                            <tr>
                              <td><div align="right"><strong>Adresse</strong></div></td>
                              <td><%=adresse %></td>
                            </tr>
                            <tr>
                              <td><div align="right"><strong>Téléphone</strong></div></td>
                              <td><%=tel %></td>
                            </tr>
                          </table>
                          <p>&nbsp;</p>
                          <table width="335" border="1">
                            <tr>
                              <td width="138"><strong>Modèle</strong></td>
                              <td width="121"><strong>Nombre de places</strong></td>
                              <td width="499"><strong>Catégorie</strong></td>
                            </tr>
                            <tr>
                              <td><%=modele %></td>
                              <td><%=nbreplace %></td>
                              <td><%=categorie %></td>
                            </tr>
                          </table>
                          <p>&nbsp;</p>
                          <table width="318" border="1">
                            <tr>
                              <td width="128"><div align="right"><strong>Date de location</strong></div></td>
                              <td width="636"><%=datelocation %></td>
                            </tr>
                            <tr>
                              <td><div align="right"><strong>Date de retour</strong></div></td>
                              <td><%=dateretour %></td>
                            </tr>
                            <tr>
                              <td><div align="right"><strong>Date de facturation</strong></div></td>
                              <td><%=datefacture %></td>
                            </tr>
                          </table>
                          <p>&nbsp;</p>
                          <table width="274" border="1">
                            <tr>
                              <td width="107"><div align="right"><strong>Taux de remise</strong></div></td>
                              <td width="657"><%=taux %> %</td>
                            </tr>
                            <tr>
                              <td width="107"><div align="right"><strong>Prix de location</strong></div></td>
                              <td width="657"><%=prix %> Dhs</td>
                            </tr>
                          </table>
                          <p>&nbsp;</p>
                          <p>
                            <label>
                            <input type="submit" name="precedent" id="precedent" value="&lt;- Détailles de location" />
                            </label>
                            <input type="submit" name="terminer" id="terminer" value="Terminer">
                          </p>
                          <p>&nbsp;</p>
                  </form>
                    </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
        <p id="footer">Mini projet : Dévlopement J2EE avec le modèle MVC 3 tièrs - Réalisé par Zakaria Rachid , Nacer Ben Soussi et Aoujil Mohamed<br />ENSAT de Tanger - Master Réseaux et Systèmes<a href="http://www.perspectived.com"></a></p>
</div>
    <!-- // #wrapper -->
</body>
</html>