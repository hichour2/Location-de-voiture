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
<title>Location Auto - Facture</title>

<!-- CSS -->
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/jNice.js"></script>
<style type="text/css">
<!--
.Style3 {
	font-size: xx-large;
	color: #999999;
}
.Style4 {
	font-size: medium;
	color: #999999;
}
.Style5 {color: #333333}
-->
</style>
</head>

<body style="text-align:left;margin-left:30px;margin-right:30px;margin-top:30px">
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
                        <form id="form1" name="form1" method="post" action="ContReservation?page=/etape4">
                          <p><img src="style/img/transdmin-light.gif" style="margin-top:5px;margin-bottom:40px;margin-left:10px" />                       </p>
                          <p class="Style3">Facture N°<%=numfacture %>  </p>
                          <hr>
                          <p class="Style4">CIN : <%=cin %>                       </p>
                          <p class="Style4">Nom : <%=nom %>                       </p>
                          <p class="Style4">Prénom : <%=prenom %>                       </p>
                          <p class="Style4">Adresse : <%=adresse %>                       </p>
                          <p class="Style4">Téléphone : <%=tel %></p>
                          <hr>
                       
                          <p class="Style4">Modèle du véhicule : <%=modele %>                       </p>
                          <p class="Style4">Nombre de places : <%=nbreplace %>                       </p>
                          <p class="Style4">Cétégorie du véhicule : <%=categorie %>  </p>
                          <hr>
                            
                          <p class="Style4">Date de location : <%=datelocation %></p>
                          <p class="Style4">   
                       Date de fin de location : <%=dateretour %>                       </p>
                          <p class="Style4">Date de facturation : <%=datefacture %> </p>
                          <hr>
                              
                          <p class="Style4">Taux de remise : <%=taux %> %                       </p>
                          <p class="Style4">Prix de location : <%=prix %> Dhs                          </p>
                          <p class="Style5">&nbsp;</p>
                          <hr>
                          <p id="footer">Mini projet : Dévlopement J2EE avec le modèle MVC 3 tièrs - Réalisé par Zakaria Rachid , Nacer Ben Soussi et Aoujil Mohamed<br />ENSAT de Tanger - Master Réseaux et Systèmes<a href="http://www.perspectived.com"></a></p>
                  </form>
</body>
</html>
<script language="javascript">
window.print();
</script>