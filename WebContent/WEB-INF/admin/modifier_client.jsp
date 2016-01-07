<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String login=(String)session.getAttribute("login");
if(login==null)
{
getServletContext().getRequestDispatcher("/").forward(request, response);
}
%>

<%@page import="location.master.dao.Clientdao"%>
<%@page import="location.master.dao.CatClientdao"%>
<%@page import="location.master.services.CatClient"%><html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Location Auto - Modifier catégorie client</title>

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
                    	 <li><a href="ContCatClient?page=/WEB-INF/admin/liste_clients.jsp" class="active">Liste des clients</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/admin/vehicule.jsp">Liste des véhicules</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/admin/cat_vehicule.jsp">Catégories des véhicules</a></li>
                    	<li><a href="ContCatClient?page=/WEB-INF/admin/cat_client.jsp">Catégories des clients</a></li>
                   	</ul>
                  <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">ADMINISTRATION</a> &raquo; <a href="#" class="active">Modifier les informations d'un client</a></h2>
<div id="main">
                        <form id="form1" name="form1" method="post" action="ContClient">
                          <%
                          String cin=(String)request.getAttribute("cin");
                          Clientdao client=new Clientdao();
                          %>
                          <table width="200" border="1">
                            <tr>
                              <td width="132"><div align="right">
                                CIN</div></td>
                              <td width="632"><input type="text" name="cin" id="cin" value=<%=client.clients(cin).get(0).getcin() %> /></td>
                            </tr>
                            <tr>
                              <td><div align="right">Catégorie</div></td>
                              <td>
                              <select name="cat" id="cat">
                                <%
                                	CatClientdao listeCat = new CatClientdao();
                                %>
                                <%
                                	int i = 0;
                                	while (i < listeCat.categories(0).size()) {
                                		CatClient _Cat = new CatClient();
                                		_Cat = listeCat.categories(0).get(i);
                                %>
                                <option value='<%=_Cat.getcode()%>'
                                                   <%String cat;
										if (_Cat.getcode() == client.clients(cin).get(0).getcodecat()) {%>
                                                	   <%="selected='selected'"%>
                                                    <%}%>
                                                	    > <%=_Cat.getlibelle()%></option>
                                <%
                                	i++;
                                	}
                                %>
                              </select>
                              </td>
                            </tr>
                            <tr>
                              <td><div align="right">Nom</div></td>
                              <td><input type="text" name="nom" id="nom" value=<%=client.clients(cin).get(0).getnom() %> /></td>
                            </tr>
                            <tr>
                              <td><div align="right">Prénom</div></td>
                              <td><input type="text" name="prenom" id="prenom" value=<%=client.clients(cin).get(0).getprenom() %> /></td>
                            </tr>
                            <tr>
                              <td><div align="right">Adresse</div></td>
                              <td><input type="text" name="adresse" id="adresse" value=<%=client.clients(cin).get(0).getadresse() %> /></td>
                            </tr>
                            <tr>
                              <td><div align="right">N° de téléphone</div></td>
                              <td><input type="text" name="tel" id="tel" value=<%=client.clients(cin).get(0).getnumtel() %> /></td>
                            </tr>
                          </table>
                          <p>&nbsp;</p>
                          <p>
                            <label>
                            <input type="submit" name="valider" id="valider" value="Valider" />
                            </label>
                            <label>
                            <input type="submit" name="annuler" id="annuler" value="Annuler" />
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