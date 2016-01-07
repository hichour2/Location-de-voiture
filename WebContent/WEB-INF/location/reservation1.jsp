<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="location.master.dao.CatClientdao"%>
<%@page import="location.master.services.CatClient"%><%
String login=(String)session.getAttribute("login");
if(login==null)
{
getServletContext().getRequestDispatcher("/").forward(request, response);
}
%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Location Auto - Nouvelle location - Etape 1 : Informations du client</title>

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
                            <td width="199"><strong>Etape 1 : Informations du client</strong></td>
                            <td width="172">Etape 2 : Choit du véhicule</td>
                            <td width="173"><ul>
                              <li></li>
                              <li>Etape 3 : Détail du location</li>
                            </ul>                            </td>
                            <td width="208">Etape 4 : Facturation</td>
                          </tr>
                        </table>
                  <form id="form1" name="form1" method="post" action="ContReservation?page=/etape1">
                    <table width="200" border="1">
                            <tr>
                              <td width="98"><div align="right">
                                <%
                                	String nom;
                                	String prenom;
                                	String adresse;
                                	int tel, codecate;
                                %>
                                <%
                                	String cin = (String) session.getAttribute("cin");
                                	if (cin == null) {
                                		cin = "";
                                		nom = "";
                                		prenom = "";
                                		adresse = "";
                                		tel = 0;
                                		codecate = 0;
                                	} else {
                                		nom = (String) session.getAttribute("prenom");
                                		prenom = (String) session.getAttribute("prenom");
                                		adresse = (String) session.getAttribute("adresse");
                                		tel = (Integer) session.getAttribute("tel");
                                		codecate = (Integer) session.getAttribute("codecate");
                                	}
                                %>
                                CIN</div></td>
                              <td width="160"><input type="text" name="cin" id="cin" value=<%=cin%> /></td>
                              <td width="500"><input type="submit" name="ok" id="ok" value="Rechercher" /></td>
                      </tr>
                            <tr>
                              <td><div align="right">Nom</div></td>
                              <td><input type="text" name="nom" id="nom" value=<%=nom%> /></td>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td><div align="right">Prénom</div></td>
                              <td><input type="text" name="prenom" id="prenom" value=<%=prenom%> /></td>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td><div align="right">Adresse</div></td>
                              <td><input type="text" name="adresse" id="adresse" value=<%=adresse%> /></td>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td><div align="right">Téléphone</div></td>
                              <td><input type="text" name="tel" id="tel" value=<%=tel%> /></td>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                            <td>
                            <div align="right">Catégorie</div>
                            </td>
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
										if (_Cat.getcode() == codecate) {%>
                                                	   <%="selected='selected'"%>
                                                    <%}%>
                                                	    > <%=_Cat.getlibelle()%></option>
                                <%
                                	i++;
                                	}
                                %>
                              </select>
							</td>
                            <td>
                            </td>
                            </tr>
                          </table>
              <p>
                            <label></label>
                          </p>
              <p>&nbsp;</p>
  <p>
                            <label>
                            <input type="submit" name="suivant" id="suivant" value="Choit du véhicule -&gt;" />
                            </label>
                            </p>
  <p>&nbsp;</p>
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