<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="location.master.dao.*"%>
<%@page import="location.master.services.*"%>
<%@page import="location.master.requetes.*"%>
<%@page import="java.util.ArrayList"%>
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
<title>Location Auto - Nouvelle location - Etape 2 : Choit du véhiculz</title>

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
                <h2><a href="#">Location</a> &raquo; <a href="#" class="active">Nouvelle location</a></h2>
                <div id="main">
                        <table width="200" border="1">
                          <tr>
                            <td width="199">Etape 1 : Informations du client</td>
                            <td width="172"><strong>Etape 2 : Choit du véhicule</strong></td>
                            <td width="173"><ul>
                              <li></li>
                              <li>Etape 3 : Détail du location</li>
                            </ul>                            </td>
                            <td width="208">Etape 4 : Facturation</td>
                          </tr>
                  </table>
<form id="form1" name="form1" method="post" action="ContReservation?page=/etape2">
                          <table width="459" border="1">
                            <tr>
                              <td width="36">&nbsp;</td>
                              <td width="155"><strong>Modèle</strong></td>
                              <td width="168"><strong>Nombre de places</strong></td>
                              <td width="393"><strong>Catégorie</strong></td>
                            </tr>
                            <%
                            VehiculeDispo vehicules= new VehiculeDispo();				
							%>

							<%
							int i = 0;
							while (i < vehicules.Listedispo().size()) {
							Vehicule _vehi = new Vehicule();
							_vehi = vehicules.Listedispo().get(i);
							%>          
                            <tr>
                              <td>
                                <input type='radio' name='radio' id='<%=_vehi.getimmatricule() %>' value='<%=_vehi.getimmatricule() %>' />
                              </td>
                              <td><%=_vehi.getmodele() %></td>
                              <td><%=_vehi.getnbreplace() %></td>
                              <td>
                              <%
                              CatVehiculedao modele=new CatVehiculedao();
                              String _modele=modele.categories(_vehi.getcodecat()).get(0).getlibelle();
                              %>
                              <%=_modele %></td>
                            </tr>
                            <%
		i++;
			}
		%>
                          </table>
                          <p>&nbsp;</p>
                          <p>
                            <label>
                            <input type="submit" name="precedent" id="precedent" value="&lt;- Information client" />
                            </label>
                            <label>
                            <input type="submit" name="terminer" id="terminer" value="Terminer" />
                            </label>
                            <label>
                            <input type="submit" name="suivant" id="suivant" value="Continuer -&gt;" />
                            </label>
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