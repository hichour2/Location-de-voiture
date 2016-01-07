<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="location.master.dao.*"%>
<%@page import="location.master.services.*"%>
<%@page import="location.master.requetes.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
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
<title>Location Auto - Liste des locations</title>

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
                    	<li><a href="ContReservation?page=/nouvelle"">Nouvelle location</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/location/reservation_incomp.jsp">Liste des réservations</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/location/location_en_cours.jsp" class="active">Liste des locations</a></li>
                   		<li><a href="ContCatClient?page=/WEB-INF/location/vehicules_dispo.jsp">Véhicules disponibles</a></li>
                   	 </ul>
                  <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">Location</a> &raquo; <a href="#" class="active">Liste des locations</a></h2>
                <div id="main"> 
                        <table width="578" border="1">
                          <tr>
                            <td><strong>Nom</strong></td>
                            <td><strong>Prénom</strong></td>
                            <td><strong>Modèle</strong></td>
                            <td><strong>Catégorie</strong></td>
                            <td><strong>Date de location</strong></td>
                            <td><strong>Date de retour</strong></td>
                            <td><strong>Date de facturation</strong></td>
                            <td><strong>Prix de location (Dhs)</strong></td>
                          </tr>
                          <%
							Locationdao listelocation= new Locationdao();				
						 %>

						 <%
							int i = 0;
							while (i < listelocation.locations(null).size()) {
							Location _locat = new Location();
							_locat = listelocation.locations(null).get(i);
						 %>          
                            <tr>	
                              <td><%=_locat.getnom() %></td>	
                              <td><%=_locat.getprenom() %></td>
                              <td><%=_locat.getmodele() %></td>
                              <td><%=_locat.getlibcat() %></td>
                              <td><%=_locat.getdatelocation() %></td>
                              <td><%=_locat.getdateretour() %></td>
                              <td><%=_locat.getdatefacturation() %></td>
                              <td><%=_locat.getprix() %></td>
                            </tr>
                            <%
							i++;
							}
							%>
                        </table>
                        <h3>&nbsp;</h3>
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