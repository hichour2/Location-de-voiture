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
<title>Location Auto - Catégories des clients</title>

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
        	<li><a href="ContCatClient?page=/WEB-INF/admin/vehicule.jsp" class="active">ADMINISTRATION</a></li>
        	<li><a href="ContCatClient?page=/WEB-INF/location/location_en_cours.jsp">LOCATION</a></li>
        	<li><a href="ContUser?page=/WEB-INF/admin/utilisateur.jsp">UTILISATEURS</a></li>
        	<li class="logout"><a href="ContUser?page=/deconnexion">DECONNEXION</a></li>
        	<li class="logout" ><a><%=session.getAttribute("login") %> | <%=session.getAttribute("type") %></a></li>
        	
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="ContCatClient?page=/WEB-INF/admin/liste_clients.jsp">Liste des clients</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/admin/vehicule.jsp">Liste des véhicules</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/admin/cat_vehicule.jsp">Catégories des véhicules</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/admin/cat_client.jsp" class="active">Catégories des clients</a></li>
                   	</ul>
                  <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">ADMINISTRATION</a> &raquo; <a href="#" class="active">Catégories des clients</a></h2>
                <div id="main"> 
                        <form id="form1" name="form1" method="post" action="ContCatClient?page=/modif1">
                          <table width="280" border="1">
                            <tr>
                              <td width="36">&nbsp;</td>
                              <td width="140"><strong>Catégorie client</strong></td>
                              <td width="582"><strong>Taux de remise</strong></td>
                            </tr>
                         <%
							CatClientdao listeCat= new CatClientdao();				
						 %>

						 <%
							int i = 0;
							while (i < listeCat.categories(0).size()) {
							CatClient _Cat = new CatClient();
							_Cat = listeCat.categories(0).get(i);
						 %>    
                            <tr>
                              <td>
                                <input type='radio' name='radio' id='<%=_Cat.getcode() %>' value='<%=_Cat.getcode() %>' />
                              </td>
                              <td><%=_Cat.getlibelle() %></td>
                              <td><%=_Cat.gettauxremise() %> %</td>
                            </tr>
                            <%
							i++;
							}
							%>
                          </table>
                          <p>&nbsp;</p>
                          <p>
                            <label>
                            <input type="submit" name="nouvelle" id="nouvelle" value="Nouvelle catégorie" />
                            </label>
                            <label>
                            <input type="submit" name="modifier" id="modifier" value="Modifier" />
                            </label>
                            <label>
                            <input type="submit" name="supprimer" id="supprimer" value="Supprimer" />
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